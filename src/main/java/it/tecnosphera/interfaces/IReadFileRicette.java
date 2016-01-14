
package it.tecnosphera.interfaces;

import java.util.List;
import it.tecnosphera.domain.Ricetta;


//QUESTE COME 'abstract' COSI POSSO IMPLEMENTARE:
public abstract class IReadFileRicette
{
	
	public abstract List<Ricetta> readFileRicette(String nomeFile);
	
}
