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
public class Shipment extends UnicastRemoteObject implements Shipment_interface{

    private static int id;
    private ArrayList<Product> Products;
    private String destination;
    private int Store_number;
    private String status;
    private boolean Approved;
    private Database db;
    
    public Shipment()throws RemoteException
    {
        
    }

    public Shipment( ArrayList<Product> Products, String destination, int Store_number, String status, boolean Approved) throws RemoteException
    {
        this.id=this.id+1;
        this.Products=Products;
        this.destination=destination;
        this.Store_number=Store_number;
        this.status=status;
        this.Approved=Approved;
    }
    @Override
    public void confirm_shipment_delivery() throws RemoteException {
        status="deliverd";
    }

    @Override
    public void add_shipment(ArrayList<Product> p, String destination, int Store_number, String status, boolean Approved) throws RemoteException {
        db.insertShipment(new Shipment(p,destination,Store_number,status,Approved));
    }

    @Override
    public void approve_shipment() throws RemoteException {
        this.Approved=true;
        db.updateShipment(new Shipment(Products,destination,Store_number,status,true));
    }

    @Override
    public void Reject_shipment() throws RemoteException {
        this.Approved=false;
        db.updateShipment(new Shipment(Products,destination,Store_number,status,false));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Product> getProducts() {
        return Products;
    }

    public void setProducts(ArrayList<Product> Products) {
        this.Products = Products;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getStore_number() {
        return Store_number;
    }

    public void setStore_number(int Store_number) {
        this.Store_number = Store_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isApproved() {
        return Approved;
    }

    public void setApproved(boolean Approved) {
        this.Approved = Approved;
    }
    
        
}
