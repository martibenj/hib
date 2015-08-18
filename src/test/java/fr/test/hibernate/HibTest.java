package fr.test.hibernate;

import junit.framework.Assert;

import org.hibernate.Session;
import org.junit.Test;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import fr.test.hibernate.dao.GadgioDAO;
import fr.test.hibernate.entities.Gadgio;
import fr.test.hibernate.util.HibernateUtil;

public class HibTest
{
  @Test
  public void addPersonne()
  {
    // Creating POJO
    PodamFactory pojoFactory = new PodamFactoryImpl();
    String prenom = "le moche";
    Gadgio personne1 = pojoFactory.manufacturePojo(Gadgio.class);
    personne1.setPourcentageMochitude(0);

    Gadgio personne2 = pojoFactory.manufacturePojo(Gadgio.class);
    personne2.setPrenom(prenom);
    personne2.setPourcentageMochitude(100);

    // Persisting POJO
    Session session = HibernateUtil.getSession();
    session.save(personne1);
    session.save(personne2);
    session.flush();
    session.close();

    Assert.assertEquals(1, GadgioDAO.findPersonneBnjByPrenom(prenom).size());
    HibernateUtil.closeSessionFactory();
  }
}
