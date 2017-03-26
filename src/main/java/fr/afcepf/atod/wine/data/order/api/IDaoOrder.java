package fr.afcepf.atod.wine.data.order.api;

import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.data.api.IDaoGeneric;
import fr.afcepf.atod.wine.entity.Customer;
import fr.afcepf.atod.wine.entity.Order;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Interface pour la r�cup�ration de commandes
 * de l'unit� de persistence.
 * @author ronan - Metabeen
 */
public interface IDaoOrder extends IDaoGeneric<Order, Integer> {

    /**
     * M�thode permettant la r�cup�ration des {@link Order}
     * en utilisant l'identifiant d'un client.
     * @return un objet {@link Customer}.
     * @throws WineException
     * <ul>
     * <li>Absence de commandes li�es � l'indentifiant dans l'unit� de persistence.</li>
     * </ul>
     */
    Customer ordersCustomerById(Integer idCustomer) throws WineException;
    /**
     * M�thode permettant la r�cup�ration des {@link Order}
     * en utilisant un objet {@link Customer}.
     * @param customer un objet {@link Customer} dont on souhaite
     * obtenir la liste des commandes.
     * @return une {@link List} d'objets {@link Order}.
     * @throws WineException
     * <ul>
     * <li>Absence de commandes li�es � l'indentifiant dans l'unit� de persistence.</li>
     * </ul>
     */
    List<Order> getAllOrdersByCustomer(Customer customer) throws WineException;

}
