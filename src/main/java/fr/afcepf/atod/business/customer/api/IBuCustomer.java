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
 * Interface pour les r�gles de gestion associ� au
 * client dans l'application.
 * @author ronan - metabeen
 */
public interface IBuCustomer {
	/**
	 * M�thode permettant la v�rification par son mail et son password
	 * de son existence dans la base de donn� et retourne un {@link User}.
	 * @param mail Param�tre de type String.
	 * @param password Param�tre de type String.
	 * @return Un {@link User}.
	 * @throws WineException
	 * <ul>
	 * <li>Le mail ou le password n'existent pas dans la base,</li>
	 * <li>les contraintes de saisies ne sont pas respect�es,</li>
	 * <li>l'unit� de persistence est inaccessible.</li>
	 * </ul>
	 */
	User connect(String mail, String password) throws WineException;
	/**
	 * M�thode permettant de r�cup�rer un {@link User} dans l'unit� de persistence.
	 * @param id Param�tre de type int.
	 * @return un {@link User}.
	 * @throws WineException 
	 * <ul>
	 * <li>L'identifiant en argument ne correspond � aucun utilisateur
	 * dans l'unit� de persistence,</li>
	 * <li>les contraintes de saisies ne sont pas respect�es,</li>
	 * <li>l'unit� de persistence est inaccessible.</li>
	 * </ul>
	 */
	User findUserById(int id) throws WineException;
	/**
	 * M�thode permettant l'ajout d'un {@link User} dans l'unit� de persistence.
	 * @param customer un {@link Customer} ajout� dans la base de donn� avec son identifiant.
	 * @return un {@link Customer}.
	 * @throws WineException 
	 * <ul>
	 * <li>Les contraintes de saisies ne sont pas respect�es,</li>
	 * <li>l'unit� de persistence est inaccessible.</li>
	 * </ul>
	 */
	Customer addNewCustomer(Customer customer) throws WineException;  
}
