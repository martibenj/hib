package fr.test.hibernate;

import org.hibernate.Session;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import fr.test.hibernate.entities.PersonneBnj;
import fr.test.hibernate.util.HibernateUtil;

public class MainBnj
{
  public static void main(String[] args)
  {
    // Creating POJO
    PodamFactory pojoFactory = new PodamFactoryImpl();
    PersonneBnj user1 = pojoFactory.manufacturePojo(PersonneBnj.class);
    user1.setPourcentageMochitude(0);

    PersonneBnj user2 = pojoFactory.manufacturePojo(PersonneBnj.class);
    user2.setPrenom("le moche");
    user2.setPourcentageMochitude(100);

    // Persisting POJO
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.save(user1);
    session.save(user2);
    session.flush();

    HibernateUtil.shutdown();
  }
}
