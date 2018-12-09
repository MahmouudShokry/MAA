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
public class Person extends UnicastRemoteObject {
    int id;
    Account account;
    String email;
    int number;
    Person(int id, Account account, String email, int number)throws RemoteException
    {
        this.id=id;
        this.account=account;
        this.email=email;
        this.number=number;               
    }
    Person()throws RemoteException
    {
     
    }
}
