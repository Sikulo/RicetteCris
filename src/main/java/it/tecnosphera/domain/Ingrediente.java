
package it.tecnosphera.domain;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="ingredienti")
public class Ingrediente
{
	
	//VARIABILI DI OGGETTO:
	private int id;
	private String nomeing;
	
	//VARIABILI DI ALTRI OGGETTI:
		//private Map<Ingrediente, String> dosi;
	private List<Ricette_ingredienti> dosi;
	
	//Qui metto il riferimento alla ricetta (1-1):
	private Ricetta ricetta;
	
			
	//COSTRUTTORE CON DEFINIZIONE DEL SOLO id (utile al 'ReadFileRicette') - facoltativo:
	public Ingrediente(int id, String nomeing)
	{
		this.id = id;
		this.nomeing = nomeing;				
	}
	
	//COSTRUTTORE CON ANCHE LE DOSI...:
	public Ingrediente(int id, String nomeing, List<Ricette_ingredienti> dosi)
	{
		this.id = id;
		this.nomeing = nomeing;		
		this.dosi = dosi;
	}
	
	//COSTRUTTORE VUOTO (per evitare errori):
	public Ingrediente()
	{ }
	
	
	
	//GETTERS-SETTERS:
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", unique = true, nullable = false)
	public int getId()
	{
		return id;
	}	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	@Column(name="nomeing")	
	public String getNomeing() 
	{
		return nomeing;
	}	
	public void setNomeing(String nomeing) 
	{
		this.nomeing = nomeing;
	}		
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
		//public Map<Ingrediente, String> getDosi()
	public List<Ricette_ingredienti> getDosi()
	{
		return dosi;
	}
		//public void setDosi(Map<Ingrediente, String> dosi) 
	public void setDosi(List<Ricette_ingredienti> dosi) 
	{
		this.dosi = dosi;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Ricetta getRicetta() 
	{
		return ricetta;
	}
	public void setRicetta(Ricetta ricetta) 
	{
		this.ricetta = ricetta;
	}
	
}

