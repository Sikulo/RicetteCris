
package it.tecnosphera.interfaces;

import java.sql.Connection;
import java.util.List;

import it.tecnosphera.domain.Ricetta;


public abstract class IMySQLManager 
{
	
	public abstract Connection getConnectionDB();
	public abstract void writeBooks(List<Ricetta> books);
	public abstract void caricaDatiFile2DB();
		
}

