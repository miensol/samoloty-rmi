/**
 * 
 */
package common;


import core.Flying;
import core.Movable;

/**
 * Base class for all planes flying in game ;)
 * @author Piotr
 *
 */
public class BasePlane extends Movable <Short> implements Flying<Float, Short>{
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
	
	public BasePlane(String player){
		// should be changed when BasePlane constructor gets parameters
		super((short)0,(short)0,(short)0,(short)0);	
		this.pilotName = player;
	}

	/* 
	 * Now we can implement this method because we have type Short specified  
	 * @see core.Moving#move()
	 */
	@Override
	public void move() {
		this.x+=this.speedX;
		this.y+=this.speedY;
	}

	/**
	 * @return the angle
	 */
	public Float getAngle() {
		return angle;
	}

	/**
	 * @param angle the angle of a plane to set
	 */
	public void setAngle(Float angle) {
		this.angle = angle;
	}

	/**
	 * @return the maximal plane speed
	 */
	public static short getMaxSpeed() {
		return maxSpeed;
	}
	
	@Override
	public void turnLeft(Float angle) {
		this.angle+=angle;
		// sets angle between 0 and 2PI
		if( this.angle > 2*Math.PI )
			this.angle-=2*Math.PI;
	}
	
	@Override
	public void turnRight(Float angle) {
		this.angle-=angle;
		// sets angle between 0 and 2PI		
		if( this.angle < 0 )
			this.angle+=2*Math.PI;
		
	}

	/**
	 * @return pilot's/player's nick name 
	 */
	public String getPilotName() {
		return pilotName;
	}

}
