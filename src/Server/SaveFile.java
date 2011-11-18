/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.*;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author quanmt
 */
public interface SaveFile extends Remote {
    
    public void save(byte[] baos) throws RemoteException;
    
}
