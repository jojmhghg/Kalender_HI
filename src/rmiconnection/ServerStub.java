/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiconnection;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author nader
 */
interface ServerStub extends Remote  {
    public void reconnect(String ip , int port) throws RemoteException;
}
