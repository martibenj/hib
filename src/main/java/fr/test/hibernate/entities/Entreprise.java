package fr.test.hibernate.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ENTREPRISE")
public class Entreprise implements Serializable
{

  /** Serial UID */
  private static final long serialVersionUID = -8365901147684140166L;

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long              id;

  @Column(name = "nomQuiDechire", nullable = false, unique = true)
  private String            nomQuiDechire;

  @Column(name = "slogan", nullable = false, unique = false)
  private String            slogan;

  @OneToMany(mappedBy = "trucMap", fetch = FetchType.LAZY, cascade = CascadeType.ALL,
      targetEntity = Gadgio.class, orphanRemoval = true)
  private List<Gadgio>      personneSalaries = new ArrayList<Gadgio>();

  /*
   * (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public String toString()
  {
    return "PersonneBnj [id=" + id + ", nomQuiDechire=" + nomQuiDechire + ", slogan=" + slogan
        + ", personneSalaries=" + personneSalaries + "]";
  }

  /**
   * @return the nomQuiDechire
   */
  public String getNomQuiDechire()
  {
    return nomQuiDechire;
  }

  /**
   * @param nomQuiDechire
   *          the nomQuiDechire to set
   */
  public void setNomQuiDechire(String nomQuiDechire)
  {
    this.nomQuiDechire = nomQuiDechire;
  }

  /**
   * @return the slogan
   */
  public String getSlogan()
  {
    return slogan;
  }

  /**
   * @param slogan
   *          the slogan to set
   */
  public void setSlogan(String slogan)
  {
    this.slogan = slogan;
  }

  /**
   * @return the personneSalaries
   */
  public List<Gadgio> getPersonneSalaries()
  {
    return personneSalaries;
  }

  /**
   * @param personneSalaries
   *          the personneSalaries to set
   */
  public void setPersonneSalaries(List<Gadgio> personneSalaries)
  {
    this.personneSalaries = personneSalaries;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((nomQuiDechire == null) ? 0 : nomQuiDechire.hashCode());
    result = prime * result + ((personneSalaries == null) ? 0 : personneSalaries.hashCode());
    result = prime * result + ((slogan == null) ? 0 : slogan.hashCode());
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
    Entreprise other = (Entreprise) obj;
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
    if (nomQuiDechire == null)
    {
      if (other.nomQuiDechire != null)
      {
        return false;
      }
    }
    else if (!nomQuiDechire.equals(other.nomQuiDechire))
    {
      return false;
    }
    if (personneSalaries == null)
    {
      if (other.personneSalaries != null)
      {
        return false;
      }
    }
    else if (!personneSalaries.equals(other.personneSalaries))
    {
      return false;
    }
    if (slogan == null)
    {
      if (other.slogan != null)
      {
        return false;
      }
    }
    else if (!slogan.equals(other.slogan))
    {
      return false;
    }
    return true;
  }

}
