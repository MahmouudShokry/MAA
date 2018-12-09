/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ahmed
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void insert() throws RemoteException{
    Database db=new Database();
    Company_admin Ahmed;
    Ahmed = Company_admin.getinstance(232,new Account("Ahmed","Ahmed"),"Ahmed@yahoo.com",01272723);
    Store_admin Youssef=new Store_admin(4343,new Account("Youssef","you"),"Youssef@gmail.com",046262626);
    ArrayList<Product> arr= new ArrayList();
    arr.add(new Product(53434,"54lkd","Shoes",340,new Date(),40));
    ArrayList<Shipment> shipment=new ArrayList();
    shipment.add(new Shipment(arr,"maadi",12345,"delevired",true));
    Shipment_admin Mohamed=new Shipment_admin(shipment,7473,new Account("Mohamed","Moh"),"Mohamed@gmail.com",017272723);
    Customer Seif=new Customer(2123,new Account("Seif","Cut"),"Seif@gmail.com",01027363663,"23 TomanbayStreet");
    Employee Ayman=new Employee(53434,new Account("Ayman","Cut"),"Ayman@gmail.com",01027363663);
    Employee mohamed=new Employee(4343,new Account("mohamed","dsd"),"Ahmed@gmail.com",01343443);
    Employee Mostafa=new Employee(543433,new Account("Mostafa","jdj"),"Mostafa@gmail.com",01434343);
    Product a=new Product(53434,"54lkd","Shoes",340,new Date(),40);
       
    Shipment s=new Shipment(arr,"Cairo",54333,"Delivered",true);
   
    }
    public static void main(String[] args) throws RemoteException, AlreadyBoundException{
        // TODO code application logic here
        Store_admin mystoreadmin = new Store_admin();
        
        // Set data
       mystoreadmin.setId(1234);
       mystoreadmin.setAccount(new Account("Ehab","hdhd"));
       mystoreadmin.setEmail("Ahmed@gmail.com");
        mystoreadmin.setNumber(0122232233);
        Store_AdminFacadeInt sa=new Store_AdminFacade(mystoreadmin);
        Inventory_interface i= new Inventory();
        Shipment_interface s=new Shipment();
        Customer_interface c=new Customer(1, new Account("ahmed","pass"), "ahmed@", 12345, "maadi");
        Store_admin_interface store_admin=new Store_admin(1, new Account("ahmed","pass"), "ahmed@", 12345);
        
        
        
        
        // Publish to client
        Registry reg = LocateRegistry.createRegistry(1099);
        reg.bind("mystoreadminfacade", sa);
        reg.bind("Inventory", i);
        reg.bind("Shipment", s);
        reg.bind("Customer", c);
        
        System.out.println("Server is ready");
    }
    
}
