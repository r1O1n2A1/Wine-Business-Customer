package fr.afcepf.atod.business.customer.api;
import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.entity.Customer;
import fr.afcepf.atod.wine.entity.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ronan
 */
public interface IBuCustomer {

    /**
     *
     * @param mail
     * @param password
     * @return
     * @throws WineException
     */
    User connect(String mail, String password) throws WineException;

    /**
     * 
     * @param id
     * @return
     * @throws WineException 
     */
    User findUserById(int id) throws WineException;
    /**
     * 
     * @param customer
     * @return
     * @throws WineException 
     */
    Customer addNewCustomer(Customer customer) throws WineException;  
    
   
}
