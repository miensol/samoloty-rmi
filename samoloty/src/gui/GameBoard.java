package gui;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Map;
import java.util.Vector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import common.Gaming;
import common.Playing;
/**
 * Game board represents PlaneGame in GUI
 * @author Piotr
 *
 */
public class GameBoard extends Canvas  {
	public static final int width= 600;
	public static final int height = 800;
	protected Gaming game;
	protected Vector<MovingImage> canvases;
	protected String url;
	GameBoard(Composite composite,String url) throws Exception{
		super(composite,SWT.BACKGROUND);
		this.setSize(GameBoard.width, GameBoard.height);
		this.setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_BLUE));
		this.url = url;
		this.game = this.findGame();
		this.addPlayers();
	}
	
	protected void addPlayers() throws Exception{
		if( this.game == null)
			throw new Exception("addPlayers: GameBoard ma gre ustawiona na null!");
		for(Map.Entry<String, Playing> k:this.game){
			PlaneImage pi = new PlaneImage(this.getShell(),"img/samolocik1.gif",k.getKey());
			// ustawia w losowym miejscu na mapie
			pi.setLocation(Math.round((float)Math.random()* GameBoard.width),Math.round((float)Math.random()*GameBoard.height));
			canvases.add(pi);
		}
	}
	
	private Gaming findGame(){
		try{
			Gaming game = (Gaming)Naming.lookup(this.url);
			return game;
		}catch(NotBoundException e){
			System.out.println("findGame : Nie ma takiej gry " + e);
		}catch(MalformedURLException e){
			System.out.println("findGame : podano zly url " + e);
		}catch(RemoteException e){
			System.err.println("Wystapil blad na serwerze");
			e.printStackTrace();
		}
		return null;
	}

}
