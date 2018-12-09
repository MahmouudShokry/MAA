/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import RMI.Customer_interface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import online.store.AddToCart;
import online.store.LoginRegesteration;

/**
 *
 * @author Ahmed
 */
public class Login {
    LoginRegesteration gui;
    Registry r;
    
    // The constructor takes the gui and the rmi registry as paramaters
    public Login(LoginRegesteration gui, Registry r)
    {
        this.gui = gui;
        this.r = r;
        // This registers the button with our action listener below (the inner class)
        gui.getregisterbutton().addActionListener(new registerBtnAction());       
    }
    class registerBtnAction implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
                
                AddToCart A=new AddToCart();
                
                
               
        }
    }
    class LoginBtnAction implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                Customer_interface ci=(Customer_interface) r.lookup("Customer");
                
                AddToCart A=new AddToCart();
                
                
               
            } catch (RemoteException ex) {
                Logger.getLogger(LoginRegesteration.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(LoginRegesteration.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
