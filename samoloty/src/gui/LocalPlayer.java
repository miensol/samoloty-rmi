package gui;

import java.rmi.RemoteException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;



public class LocalPlayer extends PlaneImage implements KeyListener {
	LocalPlayer(Composite composite,String nick){
		super(composite,"img/samolocik2.gif",nick);

	}
	
	@Override
	public void keyPressed(KeyEvent ke) {		
		System.out.println("Wcisnales klawisz");		
		try{
			switch( ke.keyCode ){
				case (int)'a': this.moving.setSpeedX((short)(this.moving.getSpeedX() - (short)1));
				break;
				case (int)'d': this.moving.setSpeedX((short)(this.moving.getSpeedX() + (short)1));
				break;
			}
		}catch(RemoteException e){
			System.out.println("blad podczas zmienania pozycji na serwerze");
		}
	}
	
	@Override
	public void keyReleased(KeyEvent ke) {
		System.out.println("Pusciles klawisz");
		try{
			switch( ke.keyCode ){
			case (int)'a': this.moving.setSpeedX((short)(this.moving.getSpeedX() - (short)1));
			break;
			case (int)'d': this.moving.setSpeedX((short)(this.moving.getSpeedX() + (short)1));
			break;
		}
		}catch(RemoteException e){
			System.out.println("blad podczas zmienania pozycji na serwerze");
		}
		
	}
	
}
