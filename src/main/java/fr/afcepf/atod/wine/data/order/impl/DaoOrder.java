package fr.afcepf.atod.wine.data.order.impl;

import fr.afcepf.atod.vin.data.exception.WineErrorCode;
import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.data.impl.DaoGeneric;
import fr.afcepf.atod.wine.data.order.api.IDaoOrder;
import fr.afcepf.atod.wine.entity.Customer;
import fr.afcepf.atod.wine.entity.Order;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Classe permettant l'accès à l'unité de persistence
 * dans l'application pour les commandes.
 * TODO déplacer cette classe dans la partie DATA associée.
 * @author Metabeen
 *
 */
@Service
@Transactional
public class DaoOrder extends DaoGeneric<Order, Integer> implements IDaoOrder {
    /*****************************************************
     *                  Requetes HQL
     ****************************************************/
    private static final String REQ_LIST_CMD_BYID = "SELECT DISTINCT(c) FROM Customer c "
            + "left join fetch c.orders as o left join fetch o.ordersDetail "
            + "WHERE c.id = :idCustomer";    
    private static final String REQORDERSBYCUSTOMER = "FROM Order o fetch left join FETCH o.customers WHERE o =:paramOrder"; 
    /*****************************************************
     *              Fin Requetes HQL                    
     ****************************************************/
    @Override
    public Customer ordersCustomerById(Integer idCustomer) throws WineException {
        Customer customer;
        if(idCustomer!=null){
        customer = (Customer)getSf().getCurrentSession()
                            .createQuery(REQ_LIST_CMD_BYID)
                            .setParameter("idCustomer", idCustomer)
                            .uniqueResult();
        if (customer.getOrders().isEmpty()) {
            throw new WineException(WineErrorCode.CA_NE_FONCTIONNE_PAS,
                    "no orders been found in the db");
        } 
        }else {
            throw new WineException(WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                "Orders from customer not referenced in the db");
        }
        return customer;
    }
   	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllOrdersByCustomer(Customer customer) throws WineException{
		List<Order> liste;
		liste = getSf().getCurrentSession().createQuery(REQORDERSBYCUSTOMER).setParameter("paramOrder", customer)
				.list();
		return liste;
	}
}
