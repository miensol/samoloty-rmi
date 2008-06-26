/**
 * 
 */
package common;


import java.rmi.RemoteException;

import oldgui.GameBoard;

import core.Movable;

/**
 * Base class for all planes flying in game ;)
 * 
 * @author Piotr
 * 
 */
public class BasePlane extends Movable<Short> implements Piloting {
	/**
	 * Maximal speed of a plane
	 */
	protected static short maxSpeed = 10;

	/**
	 * Angle of a plane
	 */
	protected float angle;

	protected static enum State {
		WELL, CRASHED
	};

	protected State state = State.WELL;

	/**
	 * represents nick of player piloting this plane
	 */
	protected String pilotName;

	public BasePlane(String player) throws RemoteException {
		// should be changed when BasePlane constructor gets parameters
		super((short) 0, (short) 0, (short) 0, (short) 0);
		this.pilotName = player;
	}

	/*
	 * Now we can implement this method because we have type Short specified
	 * 
	 * @see core.Moving#move()
	 */
	@Override
	public void move() throws RemoteException {
		//System.out.println("Player " + this.pilotName + " moved");
		this.x += this.speedX;
		this.y += this.speedY;
		checkCoordinates();
	}
	/**
	 * checks coordinates after moving
	 */
	private void checkCoordinates(){
		if( this.x < 0 )
			this.x = 0;
		if( this.y < 0 )
			this.y = 0;
		if( this.x > GameBoard.width )
			this.x = GameBoard.width;
		if ( this.y > GameBoard.height )
			this.y = GameBoard.height;
	}

	/**
	 * @return the angle
	 */
	public Float getAngle() throws RemoteException {
		return angle;
	}

	/**
	 * @param angle
	 *            the angle of a plane to set
	 */
	public void setAngle(Float angle) throws RemoteException {
		this.angle = angle;
	}

	/**
	 * @return the maximal plane speed
	 */
	public static short getMaxSpeed() throws RemoteException {
		return maxSpeed;
	}

	@Override
	public void turnRight(Float angle) throws RemoteException {
		if( angle < 0 && Math.abs(angle)>Math.PI)
			throw new RemoteException("Blad turnRight: Kat powinien byc dodatni i mniejszy od PI");

		this.angle += angle;
		// sets angle between 0 and 2PI
		if (this.angle >  Math.PI)
			this.angle = (float)Math.PI * 2 - this.angle;
		normalizeSpeed();
	}

	@Override
	public void turnLeft(Float angle) throws RemoteException {
		if( angle < 0 && Math.abs(angle)>Math.PI)
			throw new RemoteException("Blad turnLeft: Kat powinien byc dodatni i mniejszy od PI");
		this.angle -= angle;
		System.out.println("Skercam w lewo");
		// sets angle between 0 and 2PI
		if (this.angle < -Math.PI)
			this.angle =  (float)Math.PI * 2 + this.angle;
		normalizeSpeed();
	}

	@Override
	/**
	 * Turns left 90 degrees
	 */
	public void turnLeft() throws RemoteException {
		this.turnLeft((float) Math.PI * 0.5F);
	}

	/**
	 * Turn right 90 degrees
	 */
	@Override
	public void turnRight() throws RemoteException {
		this.turnRight((float) Math.PI * 0.5F);
	}

	/**
	 * Changes speedX and speedY after changing the angle
	 */
	private void normalizeSpeed() {
		double speed = Math.sqrt(this.speedX * this.speedX + this.speedY
				* this.speedY);
		Integer spx = Math.round((float) speed * (float) Math.cos(this.angle));
		Integer spy = Math.round((float) speed * (float) Math.sin(this.angle));
		this.speedX = spx.shortValue();
		this.speedY = spy.shortValue();
	}

	/**
	 * @return pilot's/player's nick name
	 */
	public String getPilotName() throws RemoteException {
		return pilotName;
	}
	
	public void speedUp(){
		double speed = Math.sqrt(this.speedX * this.speedX + this.speedY
				* this.speedY);
		if( speed * 1.1 < this.maxSpeed )
			speed*=1.1;

		Integer spx = Math.round((float) speed * (float) Math.cos(this.angle));
		Integer spy = Math.round((float) speed * (float) Math.sin(this.angle));
		this.speedX = spx.shortValue();
		this.speedY = spy.shortValue();
		
	}
	
	public void speedDown(){
		double speed = Math.sqrt(this.speedX * this.speedX + this.speedY
				* this.speedY);
		if( speed * 0.9 > this.maxSpeed*0.5 )
			speed*=0.9;

		Integer spx = Math.round((float) speed * (float) Math.cos(this.angle));
		Integer spy = Math.round((float) speed * (float) Math.sin(this.angle));
		this.speedX = spx.shortValue();
		this.speedY = spy.shortValue();		
		
	}
}
