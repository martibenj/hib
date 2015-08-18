package fr.test.hibernate.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import uk.co.jemos.podam.common.PodamExclude;

@Entity
@Table(name = "GADGIO")
public class GadgioEntity implements Serializable
{
  /** Serial UID */
  private static final long serialVersionUID = -8365901147684140166L;

  @Id
  @Column(name = "gadgioId", nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long              gadgioId;

  @Column(name = "nom", nullable = false, unique = false)
  private String            nom;

  @Column(name = "prenom", nullable = false, unique = false)
  private String            prenom;

  @Column(name = "age", nullable = false, unique = false)
  private int               age;

  @Column(name = "percentmochitude", nullable = false, unique = false)
  private int               pourcentageMochitude;

  @PodamExclude
  @ManyToOne(fetch = FetchType.LAZY, targetEntity = EntrepriseEntity.class, optional = true)
  @JoinColumn(name = "entrepriseId", nullable = true)
  private EntrepriseEntity  entrepriseField;

  /*
   * (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public String toString()
  {
    return "PersonneBnj [gadgioId=" + gadgioId + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age
        + ", pourcentageMochitude=" + pourcentageMochitude + "]";
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + age;
    result = prime * result + ((entrepriseField == null) ? 0 : entrepriseField.hashCode());
    result = prime * result + ((gadgioId == null) ? 0 : gadgioId.hashCode());
    result = prime * result + ((nom == null) ? 0 : nom.hashCode());
    result = prime * result + pourcentageMochitude;
    result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
    return result;
  }

  /**
   * {@inheritDoc}
   */
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
    GadgioEntity other = (GadgioEntity) obj;
    if (age != other.age)
    {
      return false;
    }
    if (entrepriseField == null)
    {
      if (other.entrepriseField != null)
      {
        return false;
      }
    }
    else if (!entrepriseField.equals(other.entrepriseField))
    {
      return false;
    }
    if (gadgioId == null)
    {
      if (other.gadgioId != null)
      {
        return false;
      }
    }
    else if (!gadgioId.equals(other.gadgioId))
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

  /**
   * @return the nom
   */
  public String getNom()
  {
    return nom;
  }

  /**
   * @param nom
   *          the nom to set
   */
  public void setNom(String nom)
  {
    this.nom = nom;
  }

  /**
   * @return the prenom
   */
  public String getPrenom()
  {
    return prenom;
  }

  /**
   * @param prenom
   *          the prenom to set
   */
  public void setPrenom(String prenom)
  {
    this.prenom = prenom;
  }

  /**
   * @return the age
   */
  public int getAge()
  {
    return age;
  }

  /**
   * @param age
   *          the age to set
   */
  public void setAge(int age)
  {
    this.age = age;
  }

  /**
   * @return the pourcentageMochitude
   */
  public int getPourcentageMochitude()
  {
    return pourcentageMochitude;
  }

  /**
   * @param pourcentageMochitude
   *          the pourcentageMochitude to set
   */
  public void setPourcentageMochitude(int pourcentageMochitude)
  {
    this.pourcentageMochitude = pourcentageMochitude;
  }

  /**
   * @return the entrepriseField
   */
  public EntrepriseEntity getEntrepriseField()
  {
    return entrepriseField;
  }

  /**
   * @param entrepriseField
   *          the entrepriseField to set
   */
  public void setEntrepriseField(EntrepriseEntity entrepriseField)
  {
    this.entrepriseField = entrepriseField;
  }

  /**
   * @return the gadgioId
   */
  public Long getGadgioId()
  {
    return gadgioId;
  }

  /**
   * @param gadgioId
   *          the gadgioId to set
   */
  public void setGadgioId(Long gadgioId)
  {
    this.gadgioId = gadgioId;
  }

}
