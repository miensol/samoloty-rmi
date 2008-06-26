/**
 * 
 */
package common;

import java.rmi.RemoteException;
import java.util.Date;

import core.Flying;

/**
 * @author Piotr
 * 
 */
public interface Piloting extends Flying<Float, Short> {
	public void speedUp() throws RemoteException;
	public void speedDown() throws RemoteException;
	public Date getLastShoot() throws RemoteException;
	public void setLastShoot(Date d) throws RemoteException;
	public String getPilotName() throws RemoteException ;
}
