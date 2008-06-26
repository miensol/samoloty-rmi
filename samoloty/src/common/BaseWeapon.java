package common;

import java.io.Serializable;
import java.rmi.RemoteException;

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

	public BaseWeapon(BasePlane p) throws RemoteException {
		super(p.getX(), p.getY(), p.getSpeedX(), p.getSpeedY());
		this.shooterNick = p.getPilotName();
	}

	@Override
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
}
