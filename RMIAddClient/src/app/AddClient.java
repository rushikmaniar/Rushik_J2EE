package app;

import java.rmi.*;
import demo.AddServerIntf;

public class AddClient {
  public static void main(String args[]) {
    try {
      String addServerURL = "rmi://" + "localhost" + "/AddServer"; //args[0]
	System.setProperty("java.rmi.server.hostname","127.0.0.1");
        
        AddServerIntf addServerIntf =
                    (AddServerIntf)Naming.lookup(addServerURL);
      //System.out.println("The first number is: " + args[1]);
      //double d1 = Double.valueOf(args[1]).doubleValue();
      double d1 = 3;
      //System.out.println("The second number is: " + args[2]);

      //double d2 = Double.valueOf(args[2]).doubleValue();
      double d2 = 4;
      System.out.println("The sum is: " + addServerIntf.add(d1, d2));
    }
    catch(Exception e) {
      System.out.println("Exception: " + e);
    }
  }
}