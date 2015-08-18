package fr.test.hibernate;

import org.hibernate.Session;

import fr.test.hibernate.builder.PersonneBnjBuilder;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import fr.test.hibernate.entities.PersonneBnj;
import fr.test.hibernate.util.HibernateUtil;

public class MainBnj
{
  public static void main(String[] args)
  {
    // Creating POJO
    //PodamFactory pojoFactory = new PodamFactoryImpl();
    //PersonneBnj user1 = pojoFactory.manufacturePojo(PersonneBnj.class);
    PersonneBnj user1 = new PersonneBnjBuilder().setPourcentageMochitude(0).build();
    //user1.setPourcentageMochitude(0);

    // PersonneBnj user2 = pojoFactory.manufacturePojo(PersonneBnj.class);
    PersonneBnj user2 = new PersonneBnjBuilder().setPrenom("le moche").setPourcentageMochitude(100).build();
    //user2.setPrenom("le moche");
    //user2.setPourcentageMochitude(100);

    // Persisting POJO
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.save(user1);
    session.save(user2);
    session.flush();

    HibernateUtil.shutdown();
  }
}
