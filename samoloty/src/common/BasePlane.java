/**
 * 
 */
package common;


import java.rmi.RemoteException;

import core.Flying;
import core.Movable;

/**
 * Base class for all planes flying in game ;)
 * @author Piotr
 *
 */
public class BasePlane extends Movable <Short> implements Piloting{
	/**
	 * Maximal speed of a plane
	 */
	protected static short maxSpeed;
	
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
	
	public BasePlane(String player) throws RemoteException{
		// should be changed when BasePlane constructor gets parameters
		super((short)0,(short)0,(short)0,(short)0);	
		this.pilotName = player;
	}

	/* 
	 * Now we can implement this method because we have type Short specified  
	 * @see core.Moving#move()
	 */
	@Override
	public void move() throws RemoteException {
		System.out.println("Player "+ this.pilotName + " moved");
		this.x+=this.speedX;
		this.y+=this.speedY;
	}

	/**
	 * @return the angle
	 */
	public Float getAngle() throws RemoteException {
		return angle;
	}

	/**
	 * @param angle the angle of a plane to set
	 */
	public void setAngle(Float angle) throws RemoteException {
		this.angle = angle;
	}

	/**
	 * @return the maximal plane speed
	 */
	public static short getMaxSpeed()  throws RemoteException{
		return maxSpeed;
	}
	
	@Override
	public void turnLeft(Float angle)  throws RemoteException{
		this.angle+=angle;
		// sets angle between 0 and 2PI
		if( this.angle > 2*Math.PI )
			this.angle-=2*Math.PI;
	}
	
	@Override
	public void turnRight(Float angle)  throws RemoteException{
		this.angle-=angle;
		// sets angle between 0 and 2PI		
		if( this.angle < 0 )
			this.angle+=2*Math.PI;
		
	}

	/**
	 * @return pilot's/player's nick name 
	 */
	public String getPilotName()  throws RemoteException{
		return pilotName;
	}

}
