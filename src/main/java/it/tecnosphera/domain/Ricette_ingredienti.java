
package it.tecnosphera.domain;

import java.util.Map;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name="ricette_ingredienti")
//@AssociationOverrides({
//	@AssociationOverride(name="pk.ricetta", 
//		joinColumns = @JoinColumn(name="id_ricetta")),
//	@AssociationOverride(name="pk.ingrediente", 
//		joinColumns = @JoinColumn(name = "id_ingrediente")) })
public class Ricette_ingredienti implements java.io.Serializable
{
	
	//VARIABILI DI OGGETTO:
		//@Id
		//private int id_ricetta;	
		//@Id
		//private int id_ingrediente;	
		//@Column(name="doseing")
	private String doseing;
	
	//VARIABILI DI ALTRI OGGETTI:
	private Ricette_ingredienti_id pk = new Ricette_ingredienti_id();
		
		//@ManyToOne(fetch=FetchType.LAZY, cascade={ CascadeType.ALL })
	//private Ricetta ricetta;
		
		//@ManyToOne(fetch=FetchType.LAZY, cascade={ CascadeType.ALL })
	//private Ingrediente ingrediente;
	
	
		
	
		//COSTRUTTORE CON DEFINIZIONE DEL SOLO id (utile al 'ReadFileRicette') - facoltativo:
		//public Ricette_ingredienti(int id_ricetta, int id_ingrediente, String doseing)
		//{
		//	this.id_ricetta = id_ricetta;
		//	this.id_ingrediente = id_ingrediente;
		//	this.doseing = doseing;
		//}
	
	//COSTRUTTORE VUOTO (per evitare errori):
	public Ricette_ingredienti()
	{ }

	

	//GETTERS-SETTERS:
	@EmbeddedId
	public Ricette_ingredienti_id getPk() 
	{
		return pk;
	}
	public void setPk(Ricette_ingredienti_id pk) 
	{
		this.pk = pk;
	}
	
	@Transient
	public Ricetta getRicetta() 
	{
		return getPk().getRicetta();
	}
	public void setStock(Ricetta ricetta) 
	{
		getPk().setRicetta(ricetta);
	}

	@Transient
	public Ingrediente getIngrediente() 
	{
		return getPk().getIngrediente();
	}
	public void setIngrediente(Ingrediente ingrediente) 
	{
		getPk().setIngrediente(ingrediente);
	}
	
	@Column(name = "doseing", nullable = false, length = 10)
	public String getDoseing() 
	{
		return this.doseing;
	}
	public void setDoseing(String doseing)
	{
		this.doseing = doseing;
	}
				
}
