package app;

import java.net.*;
import java.rmi.*;
import demo.AddServerImpl;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddServer {
  //public static Registry registry;
  public static void main(String args[]) throws RemoteException {
    try {
      //AddServerImpl addServerImpl = new AddServerImpl();
        // create on port 1099
        Registry registry = LocateRegistry.createRegistry(1099);
        
        // create a new service named myMessage
        registry.rebind("AddServer", new AddServerImpl());
        
        System.out.println("Server Launching....");
        //Naming.rebind("AddServer", addServerImpl);
    }
    catch(Exception e) {
      System.out.println("Exception: " + e);
    }
    
  }
}