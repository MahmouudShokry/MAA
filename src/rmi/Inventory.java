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
public class Inventory extends UnicastRemoteObject implements Inventory_interface{

    private ArrayList<Product> products;
    private Database db;
    public Inventory() throws RemoteException
    {
        
    }
    
    public Inventory(ArrayList<Product> products) throws RemoteException
    {
        this.products=products;
    }
    @Override
    public void Add_product(Product p) throws RemoteException {
        products.add(p);
        db.insertProductinInventory(p);
    }

    @Override
    public void Remove_product(Product p) throws RemoteException {
        products.remove(p);
        db.deleteProductfromInventory(p);
    }

    @Override
    public void Update_product(Product p, int id) throws RemoteException 
    {
        for(int i=0; i<products.size();i++)
        {
            if(products.get(i).getId()==id)
            {
                products.remove(products.get(i));
                products.add(i, p);
            }
        }
        db.updateProduct(p);
    }

    public ArrayList<Product> getProducts() {
        return db.getAllProductsintoInventory();
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    
    
}
