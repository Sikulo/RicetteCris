
//CLASSE CHE IMPLEMENTA LA CLASSE ASTRATTA 'ReadFile', UTILE A LEGGERE IL FILE PASSATO:

package it.tecnosphera.dbms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import it.tecnosphera.domain.Ingrediente;
import it.tecnosphera.domain.Ricetta;
import it.tecnosphera.interfaces.IReadFileRicette;


public class ReadFileRicette extends IReadFileRicette
{
		
	//METODO PER LEGGERE UN FILE ED ESTRARRE LIBRI: 	
	@Override
	public List<Ricetta> readFileRicette(String nomeFile)
	{		
		List<Ricetta> listaricettedafile = new ArrayList<Ricetta>();		
		BufferedReader filein = null;
												
		try
		{
			filein = new BufferedReader(new FileReader(nomeFile));			
			String lineaFILE;
			
			while ((lineaFILE = filein.readLine()) != null)
			{
				//SPLITTO LE RIGHE:
				String[] elementi = lineaFILE.split(";");
				
				//TOLGO GLI SPAZI DAI SINGOLI ELEMENTI DELLA RIGA CORRENTE:
				int i = 0;
				for (String element : elementi)
				{
					elementi[i] = element.trim();
					i++;
				}
								
				//COSTRUTTORE DOVE PASSO 'nomeing' e 'id' (DI UN DATO INGREDIENTE):
				Ingrediente ingrediente = new Ingrediente(elementi[0], Integer.parseInt(elementi[1]));
				
				//USO UN APPOSITO COSTRUTTORE PER CREARE UNA NUOVA ricettaX CON GLI ELEMENTI CORRISPONDENTI AI CAMPI NEL FILE:
				Ricetta ricettaX = new Ricetta(ingrediente, elementi[2], Long.parseLong(elementi[3]), Integer.parseInt(elementi[4]));
				
				//AGGIUNGO L'OGGETTO ALLA LISTA DI LIBRI FINALE:
				listaricettedafile.add(ricettaX);
			}				
		}
		catch (FileNotFoundException err2)
		{
			err2.printStackTrace();
		}
		catch (IOException err3)
		{ }
		finally
		{
			try
			{
				filein.close();
			}
			catch (IOException ignora)
			{ }
		}
		
		return listaricettedafile;
	}
	
}
