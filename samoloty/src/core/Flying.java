/**
 * 
 */
package core;


/**
 * Template of an interface of flying objects
 * @param U sets type of angle
 * @param T sets type of coordinates
 * @author Piotr
 *
 */
public interface Flying <U,T> extends Moving<T>{
	void setAngle(U angle);
	U getAngle();
	void turnLeft(U angle);
	void turnRight(U angle);
}
