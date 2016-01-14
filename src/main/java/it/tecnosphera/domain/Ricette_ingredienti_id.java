
package it.tecnosphera.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;


@Embeddable
public class Ricette_ingredienti_id implements java.io.Serializable
{
	
	//VARIABILI:
	private Ricetta ricetta;	
	private Ingrediente ingrediente;	

	
	//METTO IN RELAZIONE:
	@ManyToOne
	public Ricetta getRicetta()
	{
		return ricetta;
	}	
	public void setRicetta(Ricetta ricetta) 
	{
		this.ricetta = ricetta;
	}
	
	@ManyToOne
	public Ingrediente getIngrediente()
	{
		return ingrediente;
	}
	public void setIngrediente(Ingrediente ingrediente) 
	{
		this.ingrediente = ingrediente;
	}	
				
}

