/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Ahmed
 */
public interface Store_admin_interface extends Remote{
    ArrayList<Product> view_sold_products()throws RemoteException;
    
    float CalculateProfit()throws RemoteException;
    
    void request_shipment(ArrayList<Product> p) throws RemoteException;
    
    ArrayList<Product> view_inventory()throws RemoteException;
}
