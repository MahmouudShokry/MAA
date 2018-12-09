/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ahmed
 */
public class Customer extends Person implements Customer_interface{
    private Cart cart;
    private ArrayList<Transaction> purchases;
    private String address;
    private Database db;

    public Customer(int id, Account account, String email, int number, String address) throws RemoteException {
        super(id, account, email, number);
        this.address=address;
        cart=new Cart();
        purchases=new ArrayList();
        db.insertCustomer(this);
        
    }
    
    public void Confirm_order(ArrayList<Product> p) throws RemoteException
    {
        float price=0;
        for(int i=0;i<p.size();i++)
        {
            price=price+p.get(i).getPrice();
        }
        purchases.add(new Transaction(purchases.size()+1, this.id, p,new Date() ,price));
        db.insertTransaction(new Transaction(purchases.size()+1, this.id, p,new Date() ,price));
    }
    
    public ArrayList<Transaction> view_transaction() throws RemoteException
    {
        db.getAllTransactionsforCustomer(id);
        return purchases;
        
    }
}
