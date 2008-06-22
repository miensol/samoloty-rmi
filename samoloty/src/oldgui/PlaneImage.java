package oldgui;



import java.rmi.Naming;
import java.rmi.RemoteException;

import game.Game;

import org.eclipse.swt.widgets.Composite;

import common.Piloting;
import common.Playing;

public class PlaneImage extends MovingImage {
	protected String nick;
	public PlaneImage(Composite composite,String path, String nick) {
		super(composite, path);	
		this.nick = nick;
		this.moving = this.getPiloting();
	}
	public PlaneImage(Composite composite,String path,Playing player){
		super(composite,path);
		try{
			this.moving = player.getPlane();
			this.nick = player.getNick();
		}catch(RemoteException e){
			System.err.println("Wystapil blad podczas tworzenia plane image!");
			e.printStackTrace();
		}
	}
	@Override
	protected Piloting getPiloting() {
		if( this.moving != null)
			return this.moving;
		try {
			String url = Game.URL_BASE + "/" + this.nick + "/plane";
			System.out.println("Chce pobrac : " + url);
			Piloting pl = (Piloting)Naming.lookup(url);
			return pl;
		} catch (Exception e) {
			System.err.println("Wystapil blad podczas pobierania samolotu");
			e.printStackTrace();
		}	
		return null;
	}
	/**
	 * @return the nick
	 */
	public String getNick() {
		return nick;
	}

}
