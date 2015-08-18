// -----------------------------------------------------------------------------
// Projet : test1
// Client : Pôle Emploi
// Auteur : Vincent Powazny / Bull S.A.S.
// -----------------------------------------------------------------------------
package fr.test.hibernate.builder;

import fr.test.hibernate.entities.Gadgio;

public class PersonneBnjBuilder
{

   private Gadgio personneBnj;

   // ------------------------- Membres private -------------------------
   // ------------------------- Constructeur -------------------------

   public PersonneBnjBuilder()
   {
      personneBnj = new Gadgio();
   }

   public Gadgio build()
   {
      return personneBnj;
   }



   // ------------------------- Méthodes public -------------------------

   public PersonneBnjBuilder setNom(String p_Nom)
   {
      personneBnj.setNom(p_Nom);
      return this;
   }

   public PersonneBnjBuilder setPrenom(String p_Prenom)
   {
      personneBnj.setPrenom(p_Prenom);
      return this;
   }

   public PersonneBnjBuilder setAge(int p_Age)
   {
      personneBnj.setAge(p_Age);
      return this;
   }

   public PersonneBnjBuilder setPourcentageMochitude(int p_Pourcentage)
   {
      personneBnj.setPourcentageMochitude(p_Pourcentage);
      return this;
   }

   // ------------------------- Méthodes private -------------------------
}
