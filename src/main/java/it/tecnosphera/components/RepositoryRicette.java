
package it.tecnosphera.components;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.tecnosphera.domain.Ricetta;
import it.tecnosphera.interfaces.IRepositoryRicette;


@Repository
public class RepositoryRicette implements IRepositoryRicette
{

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	
	//METODO PER RECUPERARE TUTTE LE RICETTE DALLA TABELLA 'ricetta':
	@Override
	public List<Ricetta> findAllRicette()
	{
		EntityManager em = entityManagerFactory.createEntityManager();
				
		//PRELEVO TUTTE LE RICETTE DALLA TABELLA ricetta (anche se qui agisco sull'oggetto!)
		//E LE METTO IN UNA LISTA DI OGGETTI Ricetta:
		//List<Ricetta> ricettaList = em.createQuery("FROM Ricetta JOIN Ingredienti WHERE id=:id_ingredienti").getResultList();
		@SuppressWarnings("unchecked")
		List<Ricetta> ricettaList = em.createQuery("FROM Ricetta").getResultList();
		em.close();
		
		return ricettaList;
	}
	
	
	//METODO PER PRELEVARE UNA RICETTA PER id:
	@Override
	public Ricetta getRicetta(int id)
	{	
		EntityManager em = entityManagerFactory.createEntityManager();
		Ricetta ricettaX = (Ricetta) em.createQuery("FROM  Ricetta  WHERE  id=:id").setParameter("id", id).getSingleResult();
		em.close();
			
		return ricettaX;		
	}
	
	
	//METODO PER FARE L'AGGIORNAMENTO DELLA RICETTA (modifico - solo admin):
	@Override
	public Ricetta updateRicetta(Ricetta ricetta)
	{
		return addRicetta(ricetta);
	}
	
	
	@Override
	public Ricetta addRicetta(Ricetta ricetta)
	{
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Ricetta managed = null;
		try
		{
			managed = em.merge(ricetta);
			em.flush();
			tx.commit();
		}
		catch (Exception e) 
		{
			tx.rollback();
		}
		em.close();

		return managed;
	}

}

