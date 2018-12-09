/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Ahmed
 */
public interface Customer_interface extends Remote{
    void Confirm_order(ArrayList<Product> p) throws RemoteException;
    ArrayList<Transaction> view_transaction() throws RemoteException;
    
}
