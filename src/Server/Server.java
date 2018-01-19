/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Utilities.DatenbankException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import org.omg.CORBA.portable.RemarshalException;

/**
 *
 * @author timtim
 */
public class Server {

    private final ServerDaten serverDaten;
    private final String[] args;

    public Server(String[] args) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        this.serverDaten = new ServerDaten(args);
        this.args = args;
        System.setProperty("java.rmi.server.hostname", args[0]);
    }

    /**
     * Startet den Server und ruft alle Methoden auf, die dazu notwendig sind
     *
     * @throws RemoteException
     * @throws AlreadyBoundException
     * @throws NotBoundException
     * @throws UnknownHostException
     * @throws SQLException
     * @throws DatenbankException
     * @throws IOException
     * @throws java.lang.ClassNotFoundException
     * @throws java.security.NoSuchAlgorithmException
     */
    public void start() throws RemoteException, AlreadyBoundException, NotBoundException, UnknownHostException, SQLException, DatenbankException, IOException, ClassNotFoundException, NoSuchAlgorithmException, RemarshalException {
        String serverID = null;
        String verbindungsID = null;
        
        System.out.println("LOG * Starte Server");
        System.out.println("LOG * Server-IP: " + serverDaten.ownIP);
        System.out.println("LOG * ");

        //initialisiere Stubs für Server & Clients
        System.out.println("LOG * ");
        initServerStub();

        //baut Verbindung zu Parent auf
        if (!args[1].equals("root")) {
            this.serverDaten.connectToParent();
            
        }

        else {
            this.serverDaten.ladeDatenbank();

            // Client meldet erstesmal bei root 
            System.out.println("LOG * ");
            serverID = this.serverDaten.serverKalenderAnzahlBewerten().split("/")[0];
            
            verbindungsID = this.serverDaten.serverKalenderAnzahlBewerten().split("/")[2];
          
            initClientStub(serverID, verbindungsID);
            
            System.out.println("LOG * ");
            System.out.println("LOG * " + args[1] + " Server laeuft!");

        }

        System.out.println("LOG * ");
        System.out.println("LOG * Server laeuft!");
        System.out.println("---------------------------------------------");
    }

    /**
     * initialisiert den Stub für die Server
     *
     * @throws RemoteException
     * @throws AlreadyBoundException
     */
    private void initServerStub() throws RemoteException, AlreadyBoundException {
        ServerStubImpl serverLauncher = new ServerStubImpl(serverDaten);
        ServerStub serverStub = (ServerStub) UnicastRemoteObject.exportObject(serverLauncher, 0);
        Registry serverRegistry = LocateRegistry.createRegistry(1100);
        serverRegistry.bind("ServerStub", serverStub);
        System.out.println("LOG * ServerStub initialisiert!");
    }

    /**
     * initialisiert den Stub für die Clients
     *
     * @throws RemoteException
     * @throws AlreadyBoundException
     * @throws SQLException
     * @throws DatenbankException
     */
    private void initClientStub(String serverID, String stelle) throws RemoteException, AlreadyBoundException, SQLException, DatenbankException {
        if(serverID.equals("0")){
            ClientStubImpl clientLauncher = new ClientStubImpl(this.serverDaten.datenbank);
            ClientStub clientStub = (ClientStub) UnicastRemoteObject.exportObject(clientLauncher, 0);
            Registry clientRegistry = LocateRegistry.createRegistry(1099);
            clientRegistry.bind("ClientStub", clientStub);
            System.out.println("LOG * ClientStub initialisiert!");
        }else{
            
            ClientStubImpl clientLauncher = new ClientStubImpl(this.serverDaten.datenbank);
            ClientStub clientStub = (ClientStub) UnicastRemoteObject.exportObject(clientLauncher, 0);
            Registry clientRegistry = LocateRegistry.createRegistry(1099);
            clientRegistry.bind("ClientStub", clientStub);
            System.out.println("LOG * ClientStub initialisiert!");
        }
        
    }

}
