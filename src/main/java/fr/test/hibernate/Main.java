package fr.test.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main
{

  public static void main(String[] args)
  {
    Configuration configuration = new Configuration().configure();
    StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder()
        .applySettings(configuration.getProperties());

    // If you miss the below line then it will complaing about a missing dialect setting
    ServiceRegistry sr = serviceRegistryBuilder.build();
    SessionFactory sf = configuration.buildSessionFactory(sr);

    Personne user1 = new Personne();
    user1.setNom("bob5");
    user1.setPrenom("le marrant");
    user1.setAge(26);

    Session ss = sf.openSession();
    ss.beginTransaction();
    // saving objects to session

    ss.save(user1);
    ss.getTransaction().commit();
    ss.close();

    serviceRegistryBuilder.destroy(sr);
  }
}
