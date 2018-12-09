/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Ahmed
 */
public interface Store_AdminFacadeInt extends Remote{
    String getStoreadmin() throws RemoteException;
    void setstoreadmin(int id,String username,String password,String email,int number)throws RemoteException;
}
