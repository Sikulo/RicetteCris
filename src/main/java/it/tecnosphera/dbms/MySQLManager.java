
//CLASSE PER ESEGUIRE LA CONNESSIONE E SCRIVERE SUL DB I DATI PRELEVATI DAL FILE:
//[non uso Hibernate qui, sarebbe il caso se riesci...]

package it.tecnosphera.dbms;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JFileChooser;
import com.mysql.jdbc.CallableStatement;
import it.tecnosphera.domain.Ricetta;
import it.tecnosphera.interfaces.IMySQLManager;


public class MySQLManager extends IMySQLManager
{

	//PARAMETRI DI CONNESSIONE (DIRETTA) - poi mettili in un file a parte:
	private static final String url = "127.0.0.1";
	private static final String port = "3306";
	private static final String user = "root";
	private static final String password = "Cristiano1!_";
	private static final String nomeDatabase = "awesome";
	
	
	//METODO PER RICHIAMARE LA CONNESSIONE:
	@Override
	public Connection getConnectionDB()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{			
			e.printStackTrace();
		}

		String connectionString = "jdbc:mysql://" +  url + ":" + port + "/" + nomeDatabase + "?user=" + user + "&password=" + password;
		
	    Connection conn = null;
	    
		try 
		{
			conn = DriverManager.getConnection( connectionString );
		}
		catch (SQLException e)
		{			
			e.printStackTrace();
		}
		
	    return conn;		
	}

	
	
	//METODO PER SCRIVERE I DATI (DELLA LISTA DI ricette) SUL DB:
	public void writeRicette(List<Ricetta> ricette)
	{				
		//DEFINISCO LA QUERY DI INSERIMENTO DI UNA ricetta IN TABELLA ricette:
		String sqlInsBook = "INSERT INTO ricette.ricette (title, author, publisher, edition) VALUES (?, ?, ?, ?)";
		
		//DEFINISCO LA QUERY DI SELECT DEI PUBLISHER ESISTENTI:
		String sqlSelPubl = "SELECT awesome.publisher FROM publisher WHERE name LIKE ";
				
		//DEFINISCO LA QUERY DI INSERIMENTO DI UN publisher IN TABELLA publisher:
		//String sqlInsPubl = "INSERT INTO awesome.publisher (publisher) VALUES (?)";
		
							
		//INIZIALIZZO CONNESSIONE:
		Connection conn = null;
		
		PreparedStatement stmt1 = null;
			
		for (Ricetta ricetta : ricette)
		{
			try
			{
				conn = getConnectionDB();
				
				
				//CONTROLLO SE IL publisher GIA ESISTE NELLA TABELLA publisher E SE NO LO INSERISCO:
				int idPublisher = getIdPublisher(ricetta.getPublisher());
				
				if(idPublisher==0)
				{
					insertPublisher(ricetta.getPublisher());
				}
				
				
				//ESEGUO UNA PreparedStatement PER L'INSERIMENTO DI UN book NELLA TABELLA book:
				stmt1 = conn.prepareStatement(sqlInsRicetta);				
				stmt1.setString(1, ricetta.getTitle());
				stmt1.setString(2, ricetta.getAuthor());			
				stmt1.setInt(3, ricetta.getPublisher().getId());  //prendo anche il nome del publisher di un book
				stmt1.setInt(4, ricetta.getEdition());					
				stmt1.execute();
				
					//ESEGUO UNA QUERY PER LA SELECT DI TUTTI I publisher ESISTENTI NELLA TABELLA publisher DEL DB
					//CON publisher PARI A UNO RICHIESTO (meglio andare per ID! Non per nome/titolo!):
					//[per controllare se ce gia uno univoco]
					//ResultSet rs = conn.prepareStatement(sqlSelPubl + book.getPublisher().getNome());
					//resultStmt2 = stmt2.execute();
				
					//ESEGUO UNA PreparedStatement PER L'INSERIMENTO DI UN publisher NELLA TABELLA publisher:
					//stmt3 = conn.prepareStatement(sqlInsPubl);
					//stmt3.setString(1, book.getPublisher().getName());  //qui estraggo il nome del publisher di quel book
					//stmt3.execute();
				
				System.out.println("Libro: " + ricetta.getTitle() + " inserito con successo");
			}
			catch (SQLException e) 
			{
				System.out.println("Eccezione SQL");
			} 
			catch (ClassNotFoundException e)
			{				
				e.printStackTrace();
			}
			finally
			{
				try 
				{
					if (null != stmt1) stmt1.close();
					//if (null != stmt2) stmt2.close();
					if (null != conn) conn.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}	
	}
	
	
	
	//METODO PER PRELEVARE L'Id DEL publisher:
	public int getIdPublisher(Publisher publisher) throws ClassNotFoundException, SQLException
	{
		int id = 0;
		
		String sqlIdPubl = "SELECT * FROM awesome.publisher WHERE name='" + publisher.getName() + "'";
		
		Connection conn = getConnectionDB();
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(sqlIdPubl);
		
		if (rs.first()) 
		{
			id = rs.getInt("id");		
			publisher.setId(id);
		} 
		
		return id;
	}
	
	
	
	//METODO PER INSERIRE I publisher IN TABELLA publisher:
	public boolean insertPublisher(Publisher publisher) throws  ClassNotFoundException, SQLException
	{		
		int id = -1;
		
		String sqlPublisher="INSERT INTO awesome.publisher (name) VALUES (?)";
		
		Connection conn = getConnectionDB();
		
		PreparedStatement stmtPublisher = conn.prepareStatement(sqlPublisher, PreparedStatement.RETURN_GENERATED_KEYS);
		stmtPublisher.setString(1, publisher.getName());
		
		boolean retValPublisher = stmtPublisher.execute();
		
		ResultSet rs= stmtPublisher.getGeneratedKeys();
		
		if (rs != null && rs.next()) 
		{
		    id = rs.getInt(1);
		    publisher.setId(id);
		}
		
		return retValPublisher;		
	}
	
	
	
	//======================================================================================================
	
	
	
	//METODO CHE ESEGUE LETTURA DA FILE (fai a scelta!) E SCRITTURA SU DB:
	public void caricaDatiFile2DB()
	{				
		//String absolutePathFile = "C:/Users/cristiano/workspace/dbms/src/main/resources/Titoli.txt";
		String absolutePathFile = "C:/Users/cristiano/Desktop/CORSO JAVA/9_RICETTE/src/main/webapp/resources/Files/Ricette_default.txt";
		
				//FACCIO SELEZIONARE IL PATH DA UTENTE!
				//String filename = File.separator + "tmp";
				//JFileChooser fc = new JFileChooser(new File(filename));
		
				// Show open dialog; this method does not return until the dialog is closed:
				//fc.showOpenDialog(frame);
				//File selFile = fc.getSelectedFile();
		
				// Show save dialog; this method does not return until the dialog is closed:
				//fc.showSaveDialog(frame);
				//selFile = fc.getSelectedFile();
		
		try
		{
			ReadFileRicette lettoreFILE = new ReadFileRicette();
			MySQLManager scrittoreDB = new MySQLManager();
			
			//LEGGO IL FILE:
			List<Ricetta> listaLibri = lettoreFILE.readFileRicette(absolutePathFile);
			
			//SCRIVO I LIBRI (e i publisher) NELLE RISPETTIVE TABELLE (in join):
			scrittoreDB.writeBooks(listaLibri);
		}
		catch (Exception e)
		{ }
		
		System.out.println("Dati copiati sul DB!");
	}
	
}

