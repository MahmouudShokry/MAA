/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

/**
 *
 * @author Ahmed
 */
public class Product implements Serializable {

    private static int id;
    private String name;
    private String type;
    private float price;
    private Date release_date;
    private int quantity;
    
    public Product()throws RemoteException
    {
        
    }
    public Product(int id, String name, String type, float price, Date release_date, int quantity)throws RemoteException
    {
        this.id=id;
        this.name=name;
        this.type=type;
        this.price=price;
        this.release_date=release_date;
        this.quantity=quantity;
    }
    
    
    public Product getproduct() throws RemoteException {
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
