/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import RMI.Store_AdminFacadeInt;
/**
 *
 * @author Ahmed
 */
public class Store {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, NotBoundException{
        // TODO code application logic here
        
        Registry reg = LocateRegistry.getRegistry(1099);

        // Get the remote facade reference
       Store_AdminFacadeInt mystoreadmin = (Store_AdminFacadeInt) reg.lookup("mystoreadmin");
        
        // Print out original address
        System.out.println(mystoreadmin.getStoreadmin());

        // Edit the address and print the new one
        mystoreadmin.setstoreadmin(1234,"Ahmed","ddsjd","Ahmedyasser@gmail.com", 012373736263);
        System.out.println(mystoreadmin.getStoreadmin());

    }
    }
    

