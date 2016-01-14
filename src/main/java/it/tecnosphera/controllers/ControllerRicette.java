
package it.tecnosphera.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import it.tecnosphera.domain.Ricetta;
import it.tecnosphera.interfaces.IServiceRicette;


@Controller
public class ControllerRicette
{

	@Autowired
	IServiceRicette serviceRicette; 
			

	//PER CONTROLLARE LE MAPPATURE AUTOMATICHE TRA VISTA E CAMPI DI OGGETTI USO UN Binder:
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.setDisallowedFields("");
	}
	
	
	//MAPPATURA PER ANDARE ALLA PAGINA INIZIALE (non la 'home' base qui) CON PRESENTAZIONE DI TUTTE LE RICETTE:
	//[http://localhost:8008/ricette/]
	@RequestMapping(value = "/")
	public String homeRicette(Model m)
	{
		//PRELEVO TUTTE LE RICETTE PRESENTI NELLA TABELLA ricette:
		List<Ricetta> ricettecollection1 = serviceRicette.findAllRicette();
		m.addAttribute("ricettecollection", ricettecollection1);
		
		return "homericette"; 
	}
	
	
	//MAPPATURA PER MOSTRARE LA RICETTA CLICCATA (per ora per 'id', ma va fatto per 'nome'!):
	//[http://localhost:8008/ricette/ricetta/id]
	@RequestMapping(value = "/ricetta/{id}")
	public String mostraRicetta(Model m, @PathVariable("id") int id)
	//@RequestMapping(value = "/ricetta/{nomeric}")
	//public String mostraRicetta(Model m, @PathVariable("nomeric") String nomeric)
	{		
		//Ricetta ricetta1 = serviceRicette.getRicetta(nomeric);
		Ricetta ricetta1 = serviceRicette.getRicetta(id);
		m.addAttribute("ricetta", ricetta1);
		
		return "ricetta/mostraricetta";
	}
	
	
	
		
}

