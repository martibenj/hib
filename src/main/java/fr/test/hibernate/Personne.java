// -----------------------------------------------------------------------------
// Projet : hybernate
// Client : Pôle Emploi
// Auteur : Vincent Powazny / Bull S.A.S.
// -----------------------------------------------------------------------------
package fr.test.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="table1")
public class Personne implements Serializable
{
   @Id
   @Column(name="nom")
   private String nom;

   @Column(name="prenom")
   private String prenom;
   @Column(name="age")
   private int age;

   public String getNom()
   {
      return nom;
   }

   public void setNom(String p_nom)
   {
      nom = p_nom;
   }

   public String getPrenom()
   {
      return prenom;
   }

   public void setPrenom(String p_prenom)
   {
      prenom = p_prenom;
   }

   public int getAge()
   {
      return age;
   }

   public void setAge(int p_age)
   {
      age = p_age;
   }




}
