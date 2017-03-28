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
 * Interface pour les règles de gestion associées au
 * client dans l'application.
 * @author ronan - metabeen
 */
public interface IBuCustomer {
	/**
	 * Méthode permettant la vérification par son mail et son password
	 * de son existence dans l'unité de persistence et retourne un {@link User}.
	 * @param mail Paramètre de type String.
	 * @param password Paramètre de type String.
	 * @return Un {@link User}.
	 * @throws WineException
	 * <ul>
	 * <li>Le mail ou le password n'existent pas dans la base,</li>
	 * <li>les contraintes de saisies ne sont pas respectées,</li>
	 * <li>l'unité de persistence est inaccessible.</li>
	 * </ul>
	 */
	User connect(String mail, String password) throws WineException;
	/**
	 * Méthode permettant de récupérer un {@link User} dans l'unité de persistence.
	 * @param id Paramètre de type int.
	 * @return un {@link User}.
	 * @throws WineException 
	 * <ul>
	 * <li>L'identifiant en argument ne correspond à aucun utilisateur
	 * dans l'unité de persistence,</li>
	 * <li>les contraintes de saisies ne sont pas respectées,</li>
	 * <li>l'unité de persistence est inaccessible.</li>
	 * </ul>
	 */
	User findUserById(int id) throws WineException;
	/**
	 * Méthode permettant l'ajout d'un {@link User} dans l'unité de persistence.
	 * @param customer un {@link Customer} ajouté dans l'unité de persistence
	 *  avec son identifiant.
	 * @return un {@link Customer}.
	 * @throws WineException 
	 * <ul>
	 * <li>Les contraintes de saisies ne sont pas respectées,</li>
	 * <li>l'unité de persistence est inaccessible.</li>
	 * </ul>
	 */
	Customer addNewCustomer(Customer customer) throws WineException;  
}
