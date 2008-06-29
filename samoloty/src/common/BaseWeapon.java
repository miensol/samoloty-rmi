package common;

import java.io.Serializable;
import java.rmi.RemoteException;

import core.MapElement;
import core.Movable;

public class BaseWeapon extends Movable<Short> implements Serializable{

	/**
	 * here we should have information about shooter for now represented by his
	 * name maybe reference to plane would be better
	 */
	protected String shooterNick;

	protected static enum State {
		SHOOTED, DIED
	};

	protected State state;

	public BaseWeapon(Piloting p) throws RemoteException {
		super(p.getX(), p.getY(), (short)(p.getSpeedX()*2), (short)(p.getSpeedY()*2));
		//double r = Math.sqrt(60*60 + 25*25);
		short x = 52; // szerokosc samolotu		
		short y = 30; // polowa wysokosci
		//System.err.println("x'="+x+" y'=" +y +" kat="+p.getAngle() );
		float angle = p.getAngle();
		double x2 = (x*Math.cos(angle) - y*Math.sin(angle));
		double y2 = (x*Math.sin(angle) + y*Math.cos(angle));
		x = (short)Math.round(x2);
		y = (short)Math.round(y2);
		this.setX((short)(getX() + x));
		this.setY((short)(getY() + y));
		this.shooterNick = p.getPilotName();
	}

	
	public void move() {
		this.x += this.speedX;
		this.y += this.speedY;
	}

	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * @return the shooterNick
	 */
	public String getShooterNick() {
		return shooterNick;
	}
	
	@Override
	public Short distance(MapElement<Short> a) {
		short dist = 0;
		try{
			short x1 = a.getX();
			short y1 = a.getY();
			double d = Math.sqrt((this.x-x1)*(this.x-x1) + (this.y-y1)*(this.y-y1) );
			dist = (short)Math.round(d);
		}catch(RemoteException e){
			System.err.println("Distance Error!!");
			e.printStackTrace();
		}
		return dist;
	}
}
