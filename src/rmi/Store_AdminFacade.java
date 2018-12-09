/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Ahmed
 */
public class Store_AdminFacade extends UnicastRemoteObject implements Store_AdminFacadeInt{
    private final Store_admin storeadmin;
    
    public Store_AdminFacade(Store_admin storeadmin) throws RemoteException{
        this.storeadmin=storeadmin;
    }
    public String getStoreadmin()throws RemoteException{
        String result=storeadmin.getId() +","
                +storeadmin.getAccount()+","
                +storeadmin.getEmail()+","
                +storeadmin.getNumber();
        return result;
    }
    public void setstoreadmin(int id,String username,String password,String email,int number) throws RemoteException{
        storeadmin.setId(id);
        storeadmin.setAccount(new Account(username,password));
        storeadmin.setEmail(email);
        storeadmin.setNumber(number);
    }
}
