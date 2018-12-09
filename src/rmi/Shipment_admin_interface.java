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
public interface Shipment_admin_interface extends Remote{
    String check_status(ArrayList<Product> p, String destination, int Store_number, String status, boolean Approved) throws RemoteException;
    ArrayList<String> view_shipments() throws RemoteException;
    
}
