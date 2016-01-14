
//CLASSE PER Categoria

package it.tecnosphera.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="categorie")
public class Categoria 
{
	
	// VARIABILI:	
	//MAPPO I CAMPI DELLA TABELLA 'categorie':
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="nomecat")
	private String nomecat;
	
	//MAPPO SEMPLICEMENTE LE RICETTE DA QUI (categorie) - non ci sono altre colonne aggiuntive
	@ManyToMany(mappedBy="categorie")	
	private List<Ricetta> ricette;
	
	
	//GETTERS-SETTERS:
	public int getId()
	{
		return id;
	}	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getNomecat() 
	{
		return nomecat;
	}	
	public void setNomecat(String nomecat) 
	{
		this.nomecat = nomecat;
	}
		
}
