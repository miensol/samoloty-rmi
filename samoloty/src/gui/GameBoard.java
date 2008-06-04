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
public class GameBoard extends Canvas {
	public static final int width= 600;
	public static final int height = 800;
	private Composite composite;
	protected Gaming game;
	protected Vector<MovingImage> canvases;
	protected String gameUrl;
	GameBoard(Composite composite,String gameUrl) throws Exception{
		super(composite,SWT.BACKGROUND);
		this.composite = composite;
		this.setSize(GameBoard.width, GameBoard.height);
		this.setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_BLUE));
		this.gameUrl = gameUrl;
		this.game = this.findGame();
		this.addPlayers();
	}
	
	protected void addPlayers() throws Exception{
		if( this.game == null)
			throw new Exception("addPlayers: GameBoard ma gre ustawiona na null!");
		if ( this.canvases == null)
			this.canvases = new Vector<MovingImage>();
		for(String s:Naming.list(Game.URL_BASE)){
			String przedrostek = "//localhost:10002/";
			System.out.println(s);
			if( s.contains("/plane")){	
				String nick = s.substring(przedrostek.length(),s.indexOf('/',przedrostek.length()));
				System.out.println("Nick = " + nick);
				PlaneImage pi = new PlaneImage(this.composite,"img/samolocik.gif",nick);
			// ustawia w losowym miejscu na mapie
				pi.setLocation(Math.round((float)Math.random()* GameBoard.width),Math.round((float)Math.random()*GameBoard.height));
				canvases.add(pi);
				
			}
		}
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

}
