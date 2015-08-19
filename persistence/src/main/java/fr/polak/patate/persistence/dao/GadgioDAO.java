package fr.polak.patate.persistence.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import fr.polak.patate.persistence.entities.GadgioEntity;
import fr.polak.patate.persistence.util.HibernateUtil;

/**
 * Je ne sais pas s'il faut faire comme ça mais bon...
 * 
 * @author B-Martinelli
 */
@SuppressWarnings("unchecked")
public final class GadgioDAO
{
  public static List<GadgioEntity> findGadgio()
  {
    return HibernateUtil.getSession().createCriteria(GadgioEntity.class).list();
  }

  public static List<GadgioEntity> findGadgioByNom(String pNom)
  {
    Session session = HibernateUtil.getSession();
    Criteria crit = session.createCriteria(GadgioEntity.class);
    crit.add(Restrictions.eq("nom", pNom));
    crit.addOrder(Order.asc("nom"));
    return crit.list();
  }

  public static List<GadgioEntity> findGadgioByPrenom(String pPrenom)
  {
    Session session = HibernateUtil.getSession();
    Criteria crit = session.createCriteria(GadgioEntity.class);
    crit.add(Restrictions.eq("prenom", pPrenom));
    crit.addOrder(Order.asc("prenom"));
    return crit.list();
  }

  public static GadgioEntity findGadgioWithNomAndPrenom(String pNom, String pPrenom)
  {
    Session session = HibernateUtil.getSession();
    Criteria crit = session.createCriteria(GadgioEntity.class);
    crit.add(Restrictions.eq("nom", pNom));
    crit.add(Restrictions.eq("prenom", pPrenom));
    return (GadgioEntity) crit.uniqueResult();
  }

  public static GadgioEntity findGadgioLePlusMoche()
  {
    Session session = HibernateUtil.getSession();
    Criteria crit = session.createCriteria(GadgioEntity.class);
    crit.addOrder(Order.desc("pourcentageMochitude"));
    return (GadgioEntity) crit.list().get(0);
  }
}
