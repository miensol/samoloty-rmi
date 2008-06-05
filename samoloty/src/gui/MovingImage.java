package gui;

import java.rmi.RemoteException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import common.Piloting;

public abstract class MovingImage extends Canvas implements PaintListener{
	protected Image image;
	protected ImageData imageData;
	protected int height;
	protected int width;


	protected Piloting moving;
	/**
	 * 
	 * @param composite required by canvas
	 * @param path path to image that should be displayed
	 * @param remoteName name of remote object that implement Piloting interface
	 */
	MovingImage(Composite composite, String path){
		super(composite,SWT.NONE);
		this.image = new Image(composite.getDisplay(),MovingImage.class.getResourceAsStream(path));
		this.imageData = this.image.getImageData();
		this.height = this.imageData.height;
		this.width = this.imageData.width;
		this.setBackground(this.getDisplay().getSystemColor(SWT.COLOR_BLUE));
		this.setSize(Math.max(this.width, this.height),Math.max(this.width, this.height));
				
		// beautiful ;d;d;d;d
		this.addPaintListener(this);
		
	}
	/**
	 * This method should find and return remote interface Piloting 
	 * according to what type of MovingImage it is
	 * @return remote interface Piloting
	 */
	protected abstract Piloting getPiloting();

	@Override
	public void paintControl(PaintEvent pEvent) {
		//System.out.print("wszedlem");
		try{
			int angle = Math.round(this.moving.getAngle()*180/(float)Math.PI);
			System.out.println("Kat : " + this.moving.getAngle()+" pozycja x : "+this.moving.getX());
			System.out.println("Kat : " + angle);	
			this.imageRotate(pEvent,angle);
			pEvent.gc.drawImage(this.image, 0, 0);
			this.setLocation(this.moving.getX(), this.moving.getY());		
			System.out.println("Pozycja : "+this.moving.getX()+" "+this.moving.getY());
		}catch(RemoteException e){
			System.err.println("Wystapil blad na serwerze!");
			e.printStackTrace();
		}catch(Exception e){
			System.err.println("Wystapil blad!");
		}
	}
	@Override
	public void setLocation(int x, int y) {
		/*try{
			this.moving.setX(((Integer)x).shortValue());
			this.moving.setY(((Integer)y).shortValue());
		}catch(RemoteException e)
		{
			System.out.println("Nie moge ruszyc gracza przez MovingImage");
			e.printStackTrace(System.out);
		}
		*/
		super.setLocation(x, y);
	}
	
	public void imageRotate(PaintEvent pEvent,float angle){
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
	/**
	 * @return the moving
	 */
	public Piloting getMoving() {
		return moving;
	}
	
	
	

}
