package fr.test.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.test.hibernate.entities.Gadgio;
import fr.test.hibernate.util.HibernateUtil;

/**
 * Je ne sais pas s'il faut faire comme ça mais bon...
 * 
 * @author B-Martinelli
 */
@SuppressWarnings("unchecked")
public final class GadgioDAO
{
  public static Gadgio findPersonneBnjByNomPrenom(String pNom, String pPrenom)
  {
    Session session = HibernateUtil.getSession();
    Query query = session.createQuery("from " + Gadgio.TABLENAME
        + " pb where pb.nom like :nom and pb.prenom like :prenom");
    List<Gadgio> pbList = query.setParameter("nom", pNom).setParameter("prenom", pPrenom).list();
    return pbList.get(0);
  }

  public static List<Gadgio> findPersonneBnjByPrenom(String pPrenom)
  {
    Session session = HibernateUtil.getSession();
    Query query = session.createQuery("from " + Gadgio.TABLENAME
        + " pb where pb.nom like :nom and pb.prenom like :prenom");
    return query.setParameter("prenom", pPrenom).list();
  }
}
