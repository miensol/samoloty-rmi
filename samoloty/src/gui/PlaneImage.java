package gui;



import java.rmi.Naming;

import game.Game;

import org.eclipse.swt.widgets.Composite;

import common.Piloting;

public class PlaneImage extends MovingImage {
	protected String nick;
	public PlaneImage(Composite composite,String path, String nick) {
		super(composite, path);	
		this.nick = nick;
		this.moving = this.getPiloting();
	}
	@Override
	protected Piloting getPiloting() {
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

}
