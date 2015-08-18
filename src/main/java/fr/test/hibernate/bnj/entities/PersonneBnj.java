package fr.test.hibernate.bnj.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PERSONNEBNJ")
public class PersonneBnj implements Serializable
{

  /** Serial UID */
  private static final long serialVersionUID = -8365901147684140166L;

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long              id;

  @Column(name = "nom", nullable = false, unique = false)
  private String            nom;

  @Column(name = "prenom", nullable = false, unique = false)
  private String            prenom;

  @Column(name = "age", nullable = false, unique = false)
  private int               age;

  @Column(name = "percentmochitude", nullable = false, unique = false)
  private int               pourcentageMochitude;

  @NotNull
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

  /** @return the pourcentageMochitude */
  public int getPourcentageMochitude()
  {
    return pourcentageMochitude;
  }

  /**
   * @param p_pourcentageMochitude
   *          the pourcentageMochitude to set
   */
  public void setPourcentageMochitude(int p_pourcentageMochitude)
  {
    pourcentageMochitude = p_pourcentageMochitude;
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public String toString()
  {
    return "PersonneBnj [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age
        + ", pourcentageMochitude=" + pourcentageMochitude + "]";
  }

  /** {@inheritDoc} */
  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + age;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((nom == null) ? 0 : nom.hashCode());
    result = prime * result + pourcentageMochitude;
    result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
    return result;
  }

  /** {@inheritDoc} */
  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
    {
      return true;
    }
    if (obj == null)
    {
      return false;
    }
    if (getClass() != obj.getClass())
    {
      return false;
    }
    PersonneBnj other = (PersonneBnj) obj;
    if (age != other.age)
    {
      return false;
    }
    if (id == null)
    {
      if (other.id != null)
      {
        return false;
      }
    }
    else if (!id.equals(other.id))
    {
      return false;
    }
    if (nom == null)
    {
      if (other.nom != null)
      {
        return false;
      }
    }
    else if (!nom.equals(other.nom))
    {
      return false;
    }
    if (pourcentageMochitude != other.pourcentageMochitude)
    {
      return false;
    }
    if (prenom == null)
    {
      if (other.prenom != null)
      {
        return false;
      }
    }
    else if (!prenom.equals(other.prenom))
    {
      return false;
    }
    return true;
  }

}
