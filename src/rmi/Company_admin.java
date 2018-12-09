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
public class Company_admin extends Person implements Company_admin_interface,Subject {
    private ArrayList<Employee> Employees;
    private ArrayList<Product> products;
    private ArrayList<Shipment> shipments; 
    private static Company_admin instance;
    private ArrayList<Observer> observers;
    private Database db;

    private Company_admin(int id, Account account, String email, int number) throws RemoteException{
        super(id, account, email, number);
        db.insertCompanyAdmin(instance);
    }
    
    public static Company_admin getinstance(int id, Account account, String email, int number) throws RemoteException
    {
        if(instance==null)
        {
            instance=new Company_admin(id, account, email, number);
        }
        
        return instance;
    }
    
    
    
    public void add_employee(int id, String username, String password, String email, int number) throws RemoteException
    {
        Employees.add(new Employee(id,new Account(username,password), email, number));
    }
    public void remove_employee(int id) throws RemoteException
    {
        Employees.remove(id);
        db.deleteEmployee(id);
    }
    public void update_employee(int id, String username, String password, String email, int number, int x) throws RemoteException
    {
        for(int i=0; i<Employees.size();i++)
        {
            if(id==Employees.get(i).id)
                Employees.set(i,new Employee(id,new Account(username,password),email, number));
        }
        db.updateEmployee(new Employee(id,new Account(username,password),email, number));
    }
    public void Approve_shipment(int id)throws RemoteException
    {
        for(int i=0;i<shipments.size();i++)
        {
            if(id==shipments.get(i).getId())
                shipments.get(i).approve_shipment();
        }
    }
    public void Reject_shipment(int id) throws RemoteException
    {
        for(int i=0;i<shipments.size();i++)
        {
            if(id==shipments.get(i).getId())
                shipments.get(i).Reject_shipment();
        }
    }
    
    public void release_new_product(Product p) throws RemoteException
    {
        products.add(p);
        db.insertProduct(p);
    }
    
    public void Remove_old_product(Product p)  throws RemoteException
    {
        products.remove(p);
        db.deleteProduct(p.getId());
    }
    
    public void update_existing_product(Product p, int id) throws RemoteException
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

    @Override
    public void AddObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void RemoveObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void NotifyAll(String a) {
        for(int i=0; i<observers.size();i++)
        {
            observers.get(i).Notify(a);
        }
    }
    
}
