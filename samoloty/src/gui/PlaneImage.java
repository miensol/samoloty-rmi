package gui;

import game.Game;

import java.rmi.Naming;
import java.rmi.RemoteException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;

import common.Piloting;
import common.Playing;
import core.Flying;

public class PlaneImage extends Canvas implements PaintListener{
	protected Image image;
	protected ImageData imageData;
	protected int height;
	protected int width;
	public String nick;
	public Playing player;
	public Piloting plane;
	PlaneImage(Composite composite, String path, String nick){
		super(composite,SWT.NULL);
		this.image = new Image(Plain.display,PlaneImage.class.getResourceAsStream(path));
		this.imageData = this.image.getImageData();
		this.height = this.imageData.height;
		this.width = this.imageData.width;
		this.setSize(this.width+10,this.height+10);
		this.nick = nick;
		this.plane = this.getPlane();
		
		// beautiful ;d;d;d;d
		this.addPaintListener(this);
		
		
	}
	
	@Override
	public void paintControl(PaintEvent pEvent) {
		System.out.print("wszedlem");
		imageRotate(pEvent, 2);
		pEvent.gc.drawImage(this.image, 0, 0);
		try{
			this.setLocation(this.plane.getX(), this.plane.getY());
			System.out.println("Pozycja : "+this.plane.getX()+" "+this.plane.getY());
		}catch(RemoteException e){
			System.err.println("Wystapil blad na serwerze!");
			e.printStackTrace();
		}catch(Exception e){
			System.err.println("Wystapil blad!");
		}
	}
	
	public void imageRotate(PaintEvent pEvent,int angle){
		//check java abilities
		
		pEvent.gc.setAdvanced(true);
		if (!pEvent.gc.getAdvanced()){
			pEvent.gc.drawText("Advanced graphics not supported", 30, 30, true);
			return;
		}
		Transform transform = new Transform(Display.getCurrent());
		transform.rotate(angle);
		pEvent.gc.setTransform(transform);
		transform.dispose();
	}
	
	
	public Piloting getPlane(){
		
		try{
			/*for(String s:Naming.list(Game.URL_BASE))
				System.out.println(s);
			System.out.println("A szukam : " + Game.URL_BASE+"/"+this.nick);*/
			this.player = (Playing)Naming.lookup(Game.URL_BASE+"/"+this.nick);
			
			return this.player.getPlane();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
