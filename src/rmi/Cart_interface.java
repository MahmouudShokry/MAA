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
public interface Cart_interface extends Remote{
    void add_to_cart(Product p) throws RemoteException;
    void remove_from_cart(Product p) throws RemoteException;
    ArrayList<Product> getProducts() throws RemoteException;
}
