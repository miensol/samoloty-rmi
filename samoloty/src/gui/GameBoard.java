package gui;

import game.Game;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import common.Gaming;
import common.Playing;
/**
 * Game board represents PlaneGame in GUI
 * @author Piotr
 *
 */
public class GameBoard extends Canvas implements Runnable {
	public static final int width= 600;
	public static final int height = 800;
	protected Thread t;
	private Composite composite;
	private boolean stopped = false;
	protected Gaming game;
	protected Vector<MovingImage> canvases;
	protected String gameUrl;
	protected String owner;

	GameBoard(Composite composite,String gameUrl,String owner) throws Exception{
		super(composite,SWT.BACKGROUND);
		this.composite = composite;
		this.setSize(GameBoard.width, GameBoard.height);
		this.setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_BLUE));
		this.gameUrl = gameUrl;
		this.owner = owner;
		this.game = this.findGame();
	}
	/**
	 * Adds players from remote game to this GameBoard
	 * @throws NullPointerException
	 * @throws MalformedURLException
	 * @throws RemoteException
	 */
	protected void addPlayers() throws NullPointerException,MalformedURLException,RemoteException{
		if( this.game == null)
			throw new NullPointerException("addPlayers: GameBoard ma gre ustawiona na null!");
		if ( this.canvases == null)
			this.canvases = new Vector<MovingImage>();
		if ( this.canvases.size() >= this.game.getPlayerCount())
			return;
		for(String s:Naming.list(Game.URL_BASE)){
			// TODO this is awful :(
			String przedrostek = "//localhost:10002/";
			System.out.println(s);
			if( s.contains("/plane")){	
				String nick = s.substring(przedrostek.length(),s.indexOf('/',przedrostek.length()));
				//System.out.println("Nick = " + nick);

				if(! isInGame(nick)){
					MovingImage mi = null;
					LocalPlayer lp = null;
					if( nick != this.owner)
						mi = new PlaneImage(this.composite,"img/samolocik.gif",nick);
					else {
						lp = new LocalPlayer(this.composite,nick);
						this.addKeyListener(lp);
						mi = lp;
						lp.getMoving().setX((short)(((short)lp.width)*((short)this.game.getPlayerCount())));
					}
						
					mi.moveAbove(this);
				
					mi.setLocation(mi.getMoving().getX(),mi.getMoving().getY());												
					canvases.add(mi);				
				}
			}
		}
	}
	
	private boolean isInGame(String nick){
		for(MovingImage mi:this.canvases){
			if( mi instanceof PlaneImage){
				if( ((PlaneImage)mi).getNick() == nick )
					return true;
			}
		}
		return false;
	}
	
	private Gaming findGame(){
		try{
			Gaming game = (Gaming)Naming.lookup(this.gameUrl);
			return game;
		}catch(NotBoundException e){
			System.out.println("findGame : Nie ma takiej gry " + e);
		}catch(MalformedURLException e){
			System.out.println("findGame : podano zly gameUrl " + e);
		}catch(RemoteException e){
			System.err.println("Wystapil blad na serwerze");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Starts method run
	 */
	public void start(){		
		if( this.t != null && this.t.isAlive()){
			System.out.println("Nie moge rozpoaczac GameBoarda");
			return;
		}
		this.t = new Thread(this);
		this.t.start();
		this.stopped = false;
	}
	
	
	public void stop(){
		this.stopped = true;

	}
	@Override
	public void run() {
		try{
			do{			
				System.out.println("czekam na graczy...");
				Thread.sleep(500);
				this.addPlayers();
			}while(this.game.isWaitForPlayers());
		}catch(InterruptedException e){
			System.out.println("BoardGame thread was interuppted while sleeping");
			return;
		}catch(RemoteException e){
			System.out.println("Blad podczas pobierania stanu gry");			
			e.printStackTrace();
			return;
		}catch(MalformedURLException e){
			System.out.println("Dziwny blad nie powienien wystapic");
			e.printStackTrace();
			return;
		}
		
		try{
			do{
				for(MovingImage mi:this.canvases){
					mi.redraw();
					System.out.println("Odrysowalem ");
				}
				Thread.sleep(500);
			}while(!stopped);
		}catch(InterruptedException e){
			System.out.println("BoardGame thread was interuppted while sleeping");
			return;
		}
	}
	
}
