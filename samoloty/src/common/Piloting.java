/**
 * 
 */
package common;

import java.rmi.RemoteException;

import core.Flying;

/**
 * @author Piotr
 * 
 */
public interface Piloting extends Flying<Float, Short> {
	public void speedUp() throws RemoteException;
	public void speedDown() throws RemoteException;
}
