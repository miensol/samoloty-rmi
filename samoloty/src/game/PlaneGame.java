/**
 * 
 */
package game;

import java.awt.Event;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.Map.Entry;


import common.BasePlane;
import common.BaseWeapon;
import common.Gaming;
import common.Piloting;
import common.Player;
import common.Playing;
import java.lang.Math;

import animate.AnimationCanvas;;

/**
 * @author Piotr
 * 
 */
public class PlaneGame extends Game implements Gaming,
		Iterable<Map.Entry<String, Playing>>,
		Runnable {
	/**
	 * Contains an interface to this games
	 */
	protected Map<String, Playing> players;
	protected Vector<BaseWeapon> bullets;
	protected String url;
	protected String name = "PlaneGame";
	protected Thread actions;
	private volatile boolean  stopped = true;
	protected boolean waitForPlayers = true;
	public PlaneGame(String nick) throws RemoteException {

		super(nick);

		this.url = Game.URL_BASE + "/PlaneGame";

		// should it be placed in Game ?
		this.registry.rebind(this.name, this);

		// map with game players
		this.players = Collections
				.synchronizedMap(new HashMap<String, Playing>());
		
		this.bullets = new Vector<BaseWeapon>();
	}

	
	public Iterator<Entry<String, Playing>> iterator() {
		return this.players.entrySet().iterator();
	}
	

	
	public void start() throws RemoteException {
		// TODO Auto-generated method stub
		this.waitForPlayers = false;
		if( this.actions !=null && this.actions.isAlive() )
			throw new RemoteException("Gra zostala juz rozpoczeta");
		this.stopped = false;
		this.actions = new Thread(this);
		this.actions.setPriority(Thread.MIN_PRIORITY);
		this.actions.start();
		System.out.println("Game started");
		
		
	}

	
	public void stop() throws RemoteException {
		// TODO Auto-generated method stub
		this.stopped = true;
		//this.actinos.interrupt();
		//this.unbindAll();
		System.out.println("Game stopped");
		this.waitForPlayers = true;
		this.actions = null;
	}


	public Gaming getGame(String url) throws RemoteException {
		// TODO Auto-generated method stub
		return this;
	}

	/**
	 * Returns Player if player with nick exists otherwise null
	 */
	
	public Playing getPlayer(String nick) throws RemoteException {
		return this.players.get(nick);
	}

	/**
	 * If possible use
	 * 
	 * @see {@link PlaneGame} getPlayer(String nick)
	 * @param player
	 * @return Player if found
	 * @throws RemoteException
	 */
	public Playing getPlayer(Player player) throws RemoteException {
		return this.players.get(player);
	}

	/**
	 * Removes player from game
	 * 
	 * @param player
	 *            to remove
	 * @return removed player or null if such didn't exist
	 * @throws RemoteException
	 */
	public Playing removePlayer(Player player) throws RemoteException {
		System.out.println("Player " + player.getNick() + " quited the game!");
		this.unbindPlayer(nick);
		return this.players.remove(player.getNick());
	}

	/**
	 * Removes player from game
	 * 
	 * @param nick
	 *            of player to remove from game
	 * @return removed player or null if such didn't exist
	 * @throws RemoteException
	 */
	public Playing removePlayer(String nick) throws RemoteException {
		System.out.println("Player " + nick + " quited the game!");
		this.unbindPlayer(nick);
		return this.players.remove(nick);
	}

	private void unbindPlayer(String nick) throws RemoteException {
		try {
			this.registry.unbind(nick + "/plane");
			this.registry.unbind(nick);
		} catch (NotBoundException e) {
			System.err.println("Error while unbind player " + nick);
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (AccessException e) {
			System.err.println("Error while unbind player " + nick);
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public int getPlayerCount() throws RemoteException {
		return this.players.size();
	}


	public Playing join(String nick) throws RemoteException {
		if (nick == null || this.players.containsKey(nick))
			throw new RemoteException("Player with nick " + nick
					+ " already exists");
		if( !this.isWaitForPlayers() )
			throw new RemoteException("Trying to join to already started game!");
		
		Player newPlayer = new Player(nick, this);

		this.registry.rebind(nick, newPlayer);
		// as for now adding plane is here, I guess it should be placed in
		// Player constructor
		this.registry.rebind(nick + "/plane", newPlayer.getPlane());
		System.out.println("Player " + nick + " joined the game!");
		Piloting plane = newPlayer.getPlane();
		plane.setX((short)100);
		plane.setY((short)((getPlayerCount())*200));
		plane.setSpeedX((short)(BasePlane.getMaxSpeed()/2 +1));
		plane.setSpeedY((short)0);
		plane.setAngle(0F);
		return this.players.put(nick, newPlayer);
		
	}

	@Override
	public String toString() {
		return "PlaneGame adress: " + this.url + " Owner: " + this.nick;
	}

	public void moveAll() throws RemoteException {
		//System.out.println("Jestem w moveAll!");
		for(Map.Entry<String, Playing> k : this ){
			//System.out.println("Ruszam gracza : " + k.getKey());
			BasePlane plane = (BasePlane)k.getValue().getPlane();
			plane.move();
			checkHit(plane);
		}
		for(int i=0;i<bullets.size();++i){
			BaseWeapon b= bullets.get(i);
			b.move();
			if( b.getX()<0 || b.getX()>AnimationCanvas.GameWidth
					|| b.getY()<0 || b.getY()>AnimationCanvas.GameHeight )
				this.bullets.remove(i);			  
		}
		
	}
	/**
	 * checks hits adds score
	 */
	public void checkHit(BasePlane plane){
		for(int i =0;i<this.bullets.size();++i){
			BaseWeapon b = this.bullets.get(i);
			try{
				if(!b.getShooterNick().equals(plane.getPilotName())
						&& b.distance(plane)<30){
					Playing shooter = getPlayer(b.getShooterNick());
					shooter.setScore(shooter.getScore() + 1);
					plane.setX((short)(Math.round(Math.random()*AnimationCanvas.GameWidth)));
					plane.setY((short)((Math.round(Math.random()*AnimationCanvas.GameHeight))));
					plane.setAngle(0F);
					plane.setSpeedY((short)0);
					plane.setSpeedX((short)(BasePlane.getMaxSpeed()/2 +1));
					this.bullets.remove(i);
				}
			}catch(RemoteException e){
				System.err.println("checkHit error!!");
				e.printStackTrace();
			}
		}
	}
	
	
	public void run() {
		try{
			
			do{
				Thread.sleep(30);
				this.moveAll();
			}while(!this.stopped);
			
		}catch(InterruptedException e){
			System.out.println("Watek actions w Grze zostal zatrzymany!");
		}catch( RemoteException e){
			System.err.println("Dziwaczny blad nie powinien sie pojawic");
			e.printStackTrace();
		}
		
		this.actions = null;
	}
	public synchronized Map<String,Playing> getPlayers() throws RemoteException{
		return this.players;
	}
	/**
	 * @return the stopped
	 */
	public boolean isStopped() {
		return stopped;
	}
	
	/**
	 * @return the waitForPlayers
	 */
	public boolean isWaitForPlayers() {
		return waitForPlayers;
	}
	
	
	public synchronized void sendEvent(String nick, KeyEvent e) throws RemoteException {
		// TODO Auto-generated method stub
		Playing player = this.getPlayer(nick);
		player.setLastSeen(new Date());
		Piloting plane = player.getPlane();
		//System.out.println("Gracz "+nick+" wcisnal klaiwsz "+e.paramString());
		switch(e.getKeyChar()){			
			case 'a':
				plane.turnLeft((float)Math.PI/24F);
				break;
			case 'd':
				plane.turnRight((float)Math.PI/24F);
				break;
				
			case 'w':
				plane.speedUp();
				break;
			case 's':
				plane.speedDown();
				break;
			case KeyEvent.VK_ENTER:
				//System.out.println("Wcisniety enter");
				if(nick == this.nick)
					this.start();
				break;
			case 'q':
				if(nick == this.nick)
					this.stop();
				break;
			case KeyEvent.VK_SPACE:
				//System.out.println("Strzelil gracz "+nick);
				if( ((new Date()).getTime() - plane.getLastShoot().getTime()) > 100 ){
					BaseWeapon nb = new BaseWeapon(plane);
					plane.setLastShoot(new Date());
					this.bullets.add(nb);
				}
				break;
		
		}
	}
	public synchronized Vector<BaseWeapon> getBullets() throws RemoteException {
		return this.bullets;
	}
	
	public synchronized Vector<Point> getBulletsCoords() throws RemoteException{
		Vector<Point> vp = new Vector<Point>();
		for(BaseWeapon b:this.bullets){
			vp.add(new Point(b.getX(),b.getY()));
		}
		return vp;
	}
}
