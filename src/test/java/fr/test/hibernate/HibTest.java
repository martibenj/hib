package fr.test.hibernate;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import fr.test.hibernate.dao.GadgioDAO;
import fr.test.hibernate.entities.GadgioEntity;
import fr.test.hibernate.util.HibernateUtil;

public class HibTest
{
  @Test
  public void addPersonne()
  {
    // Creating POJO
    PodamFactory pojoFactory = new PodamFactoryImpl();
    String prenom = "le moche";
    GadgioEntity gadgio1 = pojoFactory.manufacturePojo(GadgioEntity.class);
    gadgio1.setPourcentageMochitude(0);

    GadgioEntity gadgio2 = pojoFactory.manufacturePojo(GadgioEntity.class);
    gadgio2.setPrenom(prenom);
    gadgio2.setPourcentageMochitude(100);

    // Persisting POJO
    Session session = HibernateUtil.getSession();
    session.save(gadgio1);
    session.save(gadgio2);
    session.flush();
    session.close();

    Assert.assertEquals(1, GadgioDAO.findGadgioByPrenom(prenom).size());
    Assert.assertEquals(prenom, GadgioDAO.findGadgioLePlusMoche().getPrenom());
    Assert.assertEquals(2, GadgioDAO.findGadgio().size());
  }

  @After
  public void after()
  {
    HibernateUtil.closeSessionFactory();
  }
}
