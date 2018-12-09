/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;


import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Ahmed
 */
public class Store_admin extends Person implements Store_admin_interface,Observer {
    private ArrayList<Transaction> transactions;
    private Inventory inv;
    private String store_address;
    private int store_number;
    private Database db;
    public Store_admin(int id, Account account, String email, int number) throws RemoteException {
        super(id, account, email, number);
        this.transactions = new ArrayList();
        db.insertStoreadmin(this);
    }
Store_admin()throws RemoteException{}
   
    public ArrayList<Product> view_sold_products() throws RemoteException
    {
        ArrayList<Product> arr=new ArrayList();
        for(int i=0; i<transactions.size();i++)
        {
            for(int y=0;y<transactions.get(i).getProducts().size();y++)
            {
                arr.add(transactions.get(i).getProducts().get(y));
            }
        }
        
        return db.getAllsoldProducts();
        
    }
    
    public float CalculateProfit()throws RemoteException
    {
        float sum=0;
        for(int i=0; i<transactions.size();i++)
        {
            for(int y=0;y<transactions.get(i).getProducts().size();y++)
            {
                sum=sum+transactions.get(i).getProducts().get(y).getPrice();
            }
        }
        return sum;
    }
    
    public void request_shipment(ArrayList<Product> p) throws RemoteException
    {
        db.insertShipment(new Shipment(p,store_address,store_number,"pending",false));
    }

    @Override
    public ArrayList<Product> view_inventory() throws RemoteException {
        ArrayList<Product> arr=new ArrayList();
        for(int i=0;i<inv.getProducts().size();i++)
        {
            arr.add(inv.getProducts().get(i));
        }
        return db.getAllProductsintoInventory();
    }

    @Override
    public String Notify(String s) {
        System.out.println("New notification: "+s);
        return s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    
}
