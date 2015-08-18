package fr.test.hibernate.bnj;

import org.hibernate.Session;
import org.junit.Test;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import fr.test.hibernate.bnj.entities.PersonneBnj;
import fr.test.hibernate.bnj.persistence.HibernateUtil;

public class HibTest
{
  @Test
  public void addPersonne()
  {
    // Creating POJO
    PodamFactory pojoFactory = new PodamFactoryImpl();
    PersonneBnj personne1 = pojoFactory.manufacturePojo(PersonneBnj.class);
    personne1.setPourcentageMochitude(0);

    PersonneBnj personne2 = pojoFactory.manufacturePojo(PersonneBnj.class);
    personne2.setPrenom("le moche");
    personne2.setPourcentageMochitude(100);

    // Persisting POJO
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.save(personne1);
    session.save(personne2);
    session.flush();

    HibernateUtil.shutdown();
  }
}
