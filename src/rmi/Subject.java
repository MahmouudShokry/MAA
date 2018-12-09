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
public interface Subject {
    void AddObserver(Observer o);
    void RemoveObserver(Observer o);
    void NotifyAll(String a);
    
}
