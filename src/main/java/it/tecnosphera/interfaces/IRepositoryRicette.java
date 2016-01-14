
//INTERFACCA, COMPONENTE CHE INTERAGIRA CON LE BASI DI DATI...

package it.tecnosphera.interfaces;

import java.util.List;
import it.tecnosphera.domain.Ricetta;


public interface IRepositoryRicette 
{
	
	List<Ricetta> findAllRicette(); 
	Ricetta getRicetta(int id);
	Ricetta updateRicetta(Ricetta ricetta);
	Ricetta addRicetta(Ricetta ricetta);	
	 
}

