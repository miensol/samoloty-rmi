package core;

import java.rmi.Remote;

/***
 * Interface template of movable object in game
 * @author Piotr
 * 
 * @param <T> type of coordinates and speed
 */
public interface Moving <T> extends Remote{
	T getX();
	T getY();
	void setX(T x);
	void setY(T y);
	T getSpeedX();
	void setSpeedX(T speed);
	T getSpeedY();
	void setSpeedY(T speed);
	/**
	 * performs of object, affects coordinates
	 */
	void move();
}
