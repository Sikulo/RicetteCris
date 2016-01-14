
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
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity  //IDENTIFICO LA CLASSE Ricetta COME ENTITA DEL DOMINIO
@Table(name="ricette")  //MAPPO LA CLASSE Ricetta SULLA TABELLA ricette DEL DB
public class Ricetta
{
	
	//VARIABILI DI OGGETTO:	
	private int id;		
	private String nomeric;
	private String preparazione;
	private long tempoprepara;
	private int difficolta;
	
	//VARIABILI DI ALTRI OGGETTI...:
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "stock", cascade = CascadeType.ALL)
	private int Ingrediente;
	
	private Map<Ricetta,Ricette_ingredienti> dosi;
	
	//TRASFORMA IN MAPPA (anche) POI ANCHE PER PRESENTARE LA LISTA DI INGREDIENTI PER UNA RICETTA:
		//private Map<Ingrediente, String> dosi;
		//private List<Ricette_ingredienti> dosi;
	private List<Categoria> categorie;
	
		
	
	//COSTRUTTORE:
		//public Ricetta(int id, String preparazione, long tempoprepara, int difficolta)
	public Ricetta(int id, String nomeric, String preparazione, long tempoprepara, int difficolta)
	{
		this.id = id;
		this.nomeric = nomeric;
		this.preparazione = preparazione;
		this.tempoprepara = tempoprepara;
		this.difficolta = difficolta;
	}
		
	//COSTRUTTORE VUOTO (definisco per evitare errori):
	public Ricetta()
	{ }
	
	
	
	//GETTERS/SETTERS VARIABILI:
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique=true, nullable=false, insertable=false, updatable=false)
	public int getId()
	{
		return id;
	}	
	public void setId(int id)
	{
		this.id = id;
	}
	
	@Column(name = "nomeric")
	public String getNomeric() 
	{
		return nomeric;
	}
	public void setNomeric(String nomeric) 
	{
		this.nomeric = nomeric;
	}
	
	@Column(name="preparazione")
	public String getPreparazione() 
	{
		return preparazione;
	}
	public void setPreparazione(String preparazione) 
	{
		this.preparazione = preparazione;
	}

	@Column(name="tempoprepara")
	public long getTempoprepara() 
	{
		return tempoprepara;
	}
	public void setTempoprepara(long tempoprepara) 
	{
		this.tempoprepara = tempoprepara;
	}

	@Column(name="difficolta")
	public int getDifficolta() 
	{
		return difficolta;
	}
	public void setDifficolta(int difficolta)
	{
		this.difficolta = difficolta;
	}
	
	@Column(name="id_ingrediente")
	//@Column(name="id")  //forse meglio se uso solo l' 'id', tanto e uguale a questo possibile 'id_ingrediente'
	public int getIngrediente()
	{
		return Ingrediente;
	}
	public void setIngrediente(int ingrediente)
	{
		Ingrediente = ingrediente;
	}
	
		//	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
		//		//public Map<Ingrediente, String> getDosi()
		//	public List<Ricette_ingredienti> getDosi()
		//	{
		//		return dosi;
		//	}
		//		//public void setDosi(Map<Ingrediente, String> dosi) 
		//	public void setDosi(List<Ricette_ingredienti> dosi) 
		//	{
		//		this.dosi = dosi;
		//	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	public Map<Ricetta, Ricette_ingredienti> getDosi()
	{
		return dosi;
	}
	public void setDosi(Map<Ricetta, Ricette_ingredienti> dosi) 
	{
		this.dosi = dosi;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)  //applica modifiche in cascata alle cose che dipendono...
	@JoinTable(name = "ricette_categorie", 
			   joinColumns = { @JoinColumn(name="id_ricetta", nullable = false, updatable = false) },
			   inverseJoinColumns = { @JoinColumn(name = "id_categoria", nullable = false, updatable = false) })
	public List<Categoria> getCategorie()
	{
		return categorie;
	}
	public void setCategorie(List<Categoria> categorie)
	{
		this.categorie = categorie;
	}	
			
}





//ALTRI VECCHI

//COSTRUTTORE CON PARAMETRI PER CREAZIONE (NUOVA) 'ricetta':
//	public Ricetta(int id, Ingrediente ingrediente, Map<Ingrediente, String> dosi, String preparazione, long tempoprepara, int difficolta) 
//	{
//		this.id = id;
//		this.ingrediente = ingrediente;
//		this.dosi = dosi;
//		this.preparazione = preparazione;
//		this.tempoprepara = tempoprepara;
//		this.difficolta = difficolta;
//	}
	
	//COSTRUTTORE DEDICATO AL CARICAMENTO DI DATI DA UN FILE (come default riempimento iniziale DB... facoltativo):
//	public Ricetta(Ingrediente ingrediente, String preparazione, long tempoprepara, int difficolta) 
//	{					
//		this.ingrediente = ingrediente;					
//		this.preparazione = preparazione;
//		this.tempoprepara = tempoprepara;
//		this.difficolta = difficolta;
//	}	


//public Ingrediente getIngrediente()
//	{
//		return ingrediente;
//	}
//	public void setIngrediente(Ingrediente ingrediente) 
//	{
//		this.ingrediente = ingrediente;
//	}
	
//	public Map<Ingrediente, String> getDosi()
//	{
//		return dosi;
//	}
//	public void setDosi(Map<Ingrediente, String> dosi)
//	{
//		this.dosi = dosi;
//	}


		
//MAPPO IL PARAMETRO DI CLASSE id COME CHIAVE PRIMARIA (DEL DB)
//@GeneratedValue(strategy=GenerationType.AUTO)  //MAPPO L'id COME AUTOINCREMENTANTE
//@Column(name="id")  //MAPPO L'id SULLA COLONNA 'id' DELLA TABELLA 'ricetta'
//@ManyToOne(cascade = {CascadeType.ALL})
//@JoinTable(name="ricette_ingredienti",
//		   joinColumns={@JoinColumn(name="id_ricetta")},
//		   inverseJoinColumns={@JoinColumn(name="id_ingrediente")})

//MAPPATURA 1-1 CON GLI INGREDIENTI (DELLE RICETTE)
//[qui riferisco all'id... probabile perche in tal modo 
// posso USARE effettivamente i metodi dell'oggetto RIFERITO (tramite chiave esterna solo)]:
//@OneToOne
//@JoinColumn(name="id", referencedColumnName = "id")
//private int Ingrediente;

//@Column(name="ingrediente_id")
//@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//@JoinColumn(name = "id_ingrediente", nullable = false)
//@OneToMany(cascade = {CascadeType.ALL})
//private int id_ricetta;
//private Map<Ingrediente, String> dosi;

		
//MAPPO UNA RELAZIONE 1-M TRA LE RICETTE (che saranno ANCHE ingredienti) E GLI INGREDIENTI (che stanno su un'altra tabella, mappata da un'altra Entity):
//[perche per ogni ricetta corrisponde almeno un ingrediente - per come ho costruito il tutto]
//@ManyToOne(fetch = FetchType.EAGER)
//@JoinColumn(name = "id_ingrediente", nullable = false)
//@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//@JoinTable(name = "ricette_ingredienti", joinColumns = { @JoinColumn(name="id_ricetta", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_ingrediente", nullable = false, updatable = false) })
//private List<Ingrediente> ingredienti;

//@OneToMany(fetch=FetchType.LAZY, mappedBy="ingrediente", cascade={ CascadeType.ALL })
//@MapKey(name="ingredienti")
//@Transient
//@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//@JoinTable(name = "ricette_ingredienti", joinColumns = { @JoinColumn(name="id_ricetta", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_ingrediente", nullable = false, updatable = false) })
//private Map<Ingrediente, String> dosi;  //associo ogni ingrediente (di una ricetta) alla sua dose (vedi come gestire)


//@Column(name="preparazione")
//private String preparazione;

//@Column(name="tempoprepara")
//private long tempoprepara;

//@Column(name="difficolta")
//private int difficolta;

//MAPPO UNA RELAZIONE CON ALTRA TABELLA (QUELLA INTERMEDIA TRA RICETTE E CATEGORIE):
//@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)  //applica modifiche in cascata alle cose che dipendono...
//@JoinTable(name = "ricette_categorie", 
//		   joinColumns = { @JoinColumn(name="id_ricetta", nullable = false, updatable = false) },
//		   inverseJoinColumns = { @JoinColumn(name = "id_category", nullable = false, updatable = false) } )
//private List<Categoria> categorie;

