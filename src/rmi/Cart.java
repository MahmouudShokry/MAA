/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Ahmed
 */
public class Cart extends UnicastRemoteObject implements Cart_interface{
    ArrayList<Product> products;
    float price;
    
    Cart() throws RemoteException
    {
        products=new ArrayList();
        price=0;
    }
    public void add_to_cart(Product p) throws RemoteException
    {
        products.add(p);
        price=price+p.getPrice();
        
    }
    
    public void remove_from_cart(Product p) throws RemoteException
    {
        if(products.size()>0)
        {
            products.remove(p);
            price=price-p.getPrice();
        }
    }

    @Override
    public ArrayList<Product> getProducts() throws RemoteException{
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
}
