/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Ahmed
 */
public interface Company_admin_interface extends Remote{

    
    void add_employee(int id, String username, String password, String email, int number) throws RemoteException;    
    void remove_employee(int id) throws RemoteException;  
    void update_employee(int id, String username, String password, String email, int number, int x) throws RemoteException; 
    void Approve_shipment(int id)throws RemoteException;
    void Reject_shipment(int id) throws RemoteException;
    void release_new_product(Product p)throws RemoteException;
    void Remove_old_product(Product p)throws RemoteException;
    void update_existing_product(Product p, int id)throws RemoteException;
    
}
