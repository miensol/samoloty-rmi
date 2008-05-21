/**
 * 
 */
package common;


import core.Movable;

/**
 * @author Piotr
 *
 */
public class BasePlane extends Movable <Short>{
	
	public BasePlane(){
		// should be changed when BasePlane constructor gets parameters
		super((short)0,(short)0,(short)0,(short)0);		
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

	
	
}
