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
public class Shipment_admin extends Person{
    ArrayList<Shipment> shipments;
    Database db;

    public Shipment_admin(ArrayList<Shipment> shipments, int id, Account account, String email, int number) throws RemoteException {
        super(id, account, email, number);
        this.shipments = shipments;
    }
    
    String check_status(Shipment s)
    {
        return s.getStatus();
    }
    
    ArrayList<String> view_shipments()
    {
        ArrayList<String> arr=new ArrayList();
        ArrayList<Shipment> arr2=new ArrayList();
        arr2=db.getAllApprovedShipment();
        for(int i=0;i<arr2.size();i++)
        {
            arr.add(arr2.get(i).getId()+"  "+arr2.get(i).getDestination()+"  "+arr2.get(i).getDestination()+"  "+arr2.get(i).getStatus());
        }
        return arr;
    }
}
