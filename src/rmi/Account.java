/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

/**
 *
 * @author Ahmed
 */
public class Account {
    String username;
    String password;
    private Database db;
    
    public Account(String username, String password)
    {
        this.username=username;
        this.password=password;
    }
    boolean login(String x)
    {
        if(x=="company_admin")
            return db.verifyCompanyadmin(username, password);
        else if(x=="store_admin")
            return db.verifyStoreadmin(username, password);
        else if(x=="shipment_admin")
            return db.verifyShipmentadmin(username, password);
        else if(x=="customer")
            return db.verifyCustomer(username, password);
        return false;    
    }
    
    void register(String username, String password)
    {
        
    }
}
