package fr.afcepf.atod.wine.data.order.test;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.atod.wine.data.order.api.IDaoOrder;
/**
 * Classe générée pour l'execution de tests.
 * TODO Convertir en tests unitaires.
 * @author Metabeen
 *
 */
public class DaoOrderTest {
	/**
	 * Logger de log 4j pour les codes d'erreur.
	 */
	private static Logger log = Logger.getLogger(DaoOrderTest.class);
	/**
	 * Point d'entrée de l'application
	 * pour les tests.
	 * @param args Inutilisé dans ce contexte.
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		BeanFactory bf = new ClassPathXmlApplicationContext("classpath:springData.xml");
		@SuppressWarnings("unused")
		IDaoOrder daoOrd = bf.getBean(IDaoOrder.class);
	}
}
