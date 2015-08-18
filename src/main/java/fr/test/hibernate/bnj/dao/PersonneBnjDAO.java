package fr.test.hibernate.bnj.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.test.hibernate.bnj.entities.PersonneBnj;
import fr.test.hibernate.bnj.persistence.HibernateUtil;

/**
 * Je ne sais pas s'il faut faire comme ça mais bon...
 * 
 * @author B-Martinelli
 */
@SuppressWarnings("unchecked")
public final class PersonneBnjDAO
{
  public static PersonneBnj findPersonneBnjByNomPrenom(String pNom, String pPrenom)
  {
    Session session = HibernateUtil.getSession();
    Query query = session
        .createQuery("from PERSONNEBNJ pb where pb.nom like :nom and pb.prenom like :prenom");
    List<PersonneBnj> pbList = query.setParameter("nom", pNom).setParameter("prenom", pPrenom).list();
    return pbList.get(0);
  }

  public static List<PersonneBnj> findPersonneBnjByPrenom(String pPrenom)
  {
    Session session = HibernateUtil.getSession();
    Query query = session
        .createQuery("from PERSONNEBNJ pb where pb.nom like :nom and pb.prenom like :prenom");
    return query.setParameter("prenom", pPrenom).list();
  }
}
