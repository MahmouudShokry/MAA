/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Ahmed
 */
public interface Inventory_interface extends Remote{
    public void Add_product(Product p) throws RemoteException;
    public void Remove_product(Product p) throws RemoteException;
    public void Update_product(Product p,int id)throws RemoteException;
}
