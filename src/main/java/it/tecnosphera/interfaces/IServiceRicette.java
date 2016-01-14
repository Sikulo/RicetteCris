
package it.tecnosphera.interfaces;

import java.util.List;
import it.tecnosphera.domain.Ricetta;


public interface IServiceRicette
{

	List<Ricetta> findAllRicette();
	Ricetta getRicetta(int id);
		//Ricetta getRicetta(String nomeric);
	Ricetta updateRicetta(Ricetta ricetta);
			
}
