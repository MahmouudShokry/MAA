/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ahmed
 */
public class Transaction implements Serializable{
    private int id;
    private int Customer_id;
    private ArrayList<Product> products;
    private Date time;
    private float price;
    
    public Transaction() throws RemoteException
    {
        
    }
    
    public Transaction(int id, int Customer_id, ArrayList<Product> products, Date time, float price) throws RemoteException
    {
        this.id=id;
        this.Customer_id=Customer_id;
        this.products=products;
        this.time=time;
        this.price=price;
    }
    

    public Transaction ViewTransaction() throws RemoteException{
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(int Customer_id) {
        this.Customer_id = Customer_id;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
