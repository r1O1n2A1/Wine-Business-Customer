package fr.afcepf.atod.business.customer.test;

import java.util.Date;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.atod.customer.data.api.IDaoCustomer;
import fr.afcepf.atod.vin.data.exception.WineErrorCode;
import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.entity.Adress;
import fr.afcepf.atod.wine.entity.Civility;
import fr.afcepf.atod.wine.entity.User;

public class TestConnectBuCustomer {
    /**
     * Mock avec EasyMock pour le daoCustomer.
     */
    private IDaoCustomer mock;
    /**
     * CAS NOMINAL
     * String mail correspondant à l'adresse mail
     * de l'utilisateur ayant pour identifiant = 2.
     */
    private String mailNominal = "fenwang@hotmail.com";
    /**
     * CAS NOMINAL
     * String password correspondant à l'adresse mail
     * de l'utilisateur ayant pour identifiant = 2.
     */
    private String passwordNominal = "test1234";
    /**
     * CAS NOMINAL
     */
    /**
     * Utilisateur retourné par la méthode
     * pour le cas de connexion nominal.
     * (Doit être présent dans l'unité de persistence).
     */
    private User userNominalExpected;
    /**
     * CAS NOMINAL
     * Identifiant attendu par le retour de la
     * méthode.
     */
    private final int ID_EXPECTED = 2;
    /**
     * CAS ERREUR MDP
     * Mot de passe dans le cas ou l'utilisateur tente de se connecter
     * avec un mot de passe absent de l'unité de persistence.
     * 
     */
    private String passwordErreur = "WRONG";
    /**
     * CAS ERREUR MDP
     * Exception retournée par la méthode en cas d'erreur sur 
     * le mot de passe.
     */
    private WineException exceptionMauvaisIdentifiant;
    /**
     * Initialisation des variables de test.
     */
    public  TestConnectBuCustomer() {
        userNominalExpected = new User(ID_EXPECTED,"Test","Test",new Date(),mailNominal,"login",passwordNominal,"tel",new Date(), new Date(),Civility.MR, new Adress());
        exceptionMauvaisIdentifiant = new WineException(WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                mailNominal + " or " + passwordErreur + " -  invalid");
        mock = EasyMock.createMock(IDaoCustomer.class);
    }
    @Test
    public void connect() throws WineException {
        EasyMock.expect(mock.connect(mailNominal, passwordNominal)).andReturn(userNominalExpected);
        EasyMock.replay(mock);
        Assert.assertEquals(userNominalExpected.getMail(), mailNominal);        
        Assert.assertEquals(userNominalExpected.getPassword(), passwordNominal);

    }
     @Test
     public void connectTestNull() throws WineException {
         EasyMock.expect(mock.connect(mailNominal, null)).andStubThrow(exceptionMauvaisIdentifiant);
         EasyMock.replay(mock);
     }
}
