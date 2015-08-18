package fr.test.hibernate.bnj.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{

  private static final String                   confPath               = "/fr/test/hibernate/bnj/hibernate.cfg.xml";

  private static Configuration                  configuration          = getConfiguration();
  private static StandardServiceRegistryBuilder serviceRegistryBuilder = getServiceRegistryBuilder();
  private static StandardServiceRegistry        serviceRegistry        = getServiceRegistry();
  private static SessionFactory                 sessionFactory         = getSessionFactory();

  public static void shutdown()
  {
    // Close caches and connection pools
    getSessionFactory().close();
    getServiceRegistryBuilder().destroy(getServiceRegistry());
  }

  private static Configuration getConfiguration()
  {
    if (configuration == null)
    {
      configuration = new Configuration().configure(confPath);
    }
    return configuration;
  }

  private static StandardServiceRegistryBuilder getServiceRegistryBuilder()
  {
    if (serviceRegistryBuilder == null)
    {
      serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(getConfiguration()
          .getProperties());
    }
    return serviceRegistryBuilder;
  }

  private static StandardServiceRegistry getServiceRegistry()
  {
    if (serviceRegistry == null)
    {
      serviceRegistry = getServiceRegistryBuilder().build();
    }
    return serviceRegistry;
  }

  public static SessionFactory getSessionFactory()
  {
    if (sessionFactory == null)
    {
      try
      {
        // Create the SessionFactory from hibernate.cfg.xml
        sessionFactory = getConfiguration().buildSessionFactory(serviceRegistry);
      }
      catch (Throwable ex)
      {
        // Make sure you log the exception, as it might be swallowed
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
      }
    }
    return sessionFactory;
  }

}