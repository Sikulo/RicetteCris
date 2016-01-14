
package it.tecnosphera.components;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.tecnosphera.domain.Ricetta;
import it.tecnosphera.interfaces.IRepositoryRicette;
import it.tecnosphera.interfaces.IServiceRicette;


@Service
public class ServiceRicette implements IServiceRicette
{	
	
	@Autowired
	IRepositoryRicette repositoryRicette;

	
	@Override
	public List<Ricetta> findAllRicette()
	{
		//PRELEVO TUTTE LE RICETTE:
		List<Ricetta> ricette = repositoryRicette.findAllRicette();
		
			//      ORDINO LE RICETTE PER NOME (fai andare!):
			//		Collections.sort(ricette, new Comparator<Ricetta>()
			//		{
			//			@Override
			//			public int compare(Ricetta ricetta1, Ricetta ricetta2)
			//			{
			//				return ricetta1.getIngrediente().getNomeing().compareToIgnoreCase(ricetta2.getIngrediente().getNomeing());
			//			}
			//		});
		
		return ricette;
	}


	@Override
	public Ricetta getRicetta(int id) 
	{
		return repositoryRicette.getRicetta(id);		
	}
	
	
		//	@Override
		//	public Ricetta getRicetta(String nomeric) 
		//	{
		//		return repositoryRicette.getRicetta(nomeric);		
		//	}
	
	
	@Override
	public Ricetta updateRicetta(Ricetta ricetta) 
	{		
		return repositoryRicette.updateRicetta(ricetta);
	}
				
}

