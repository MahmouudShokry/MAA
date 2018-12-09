/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.util.ArrayList;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Ahmed
 */
public interface Shipment_interface extends Remote {
    public void confirm_shipment_delivery() throws RemoteException;
    public void add_shipment(ArrayList<Product> p, String destination, int Store_number, String status, boolean Approved) throws RemoteException;
    public void approve_shipment() throws RemoteException;
    public void Reject_shipment() throws RemoteException;



}
