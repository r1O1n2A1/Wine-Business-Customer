/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.atod.business.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.atod.business.customer.api.IBuCustomer;
import fr.afcepf.atod.customer.data.api.IDaoCustomer;
import fr.afcepf.atod.customer.data.impl.DaoCustomer;
import fr.afcepf.atod.vin.data.exception.WineErrorCode;
import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.entity.Customer;
import fr.afcepf.atod.wine.entity.User;

/**
 *
 * @author ronan
 */
@Service
public class BuCustomer implements IBuCustomer {

    @Autowired
    private IDaoCustomer daoCustomer;

    
    @Override
    public User connect(String mail, String password) throws WineException {
        User user = null;
        WineException wineException = null;
        try {
            if (!mail.equalsIgnoreCase("")
                    && !password.equalsIgnoreCase("")) {
                user = daoCustomer.connect(mail, password);
                if (!user.getLastname().equalsIgnoreCase("")) {
                    // return user;
                } else {
                    wineException = new WineException(
                            WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                            mail + " - not found in the db");
                }
            } else {
                wineException = new WineException(
                        WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                        mail + " or " + password
                        + " -  invalid");
            }
        } catch (Exception e) {
            wineException = new WineException(
                    WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                    mail + " or " + password
                    + " -  invalid");
        }
        if (wineException != null) {
            throw wineException;
        }
        return user;
    }

	public User findUserById(int id) throws WineException {
		return daoCustomer.findObj(id);
		
	}
	public Customer addNewCustomer(Customer customer) {
		try {
			daoCustomer.insertObj(customer);
		} catch (WineException e) {
			e.printStackTrace();
		}
		return customer;		
	}
    
}
