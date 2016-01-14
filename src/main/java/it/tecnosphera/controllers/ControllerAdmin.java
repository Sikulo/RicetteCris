
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
public class ControllerAdmin
{

	@Autowired
	IServiceRicette serviceRicette; 
			

	//PER CONTROLLARE LE MAPPATURE AUTOMATICHE TRA VISTA E CAMPI DI OGGETTI USO UN Binder:
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.setDisallowedFields("");
	}
	
	
	//MAPPATURA PER ANDARE ALLA PAGINA INIZIALE DI ADMIN:
	//[http://localhost:8008/ricette/admin/homericetteadmin]
	@RequestMapping(value = "admin/homericetteadmin")
	public String homeRicetteAdmin(Model m)
	{
		//PRELEVO TUTTE LE RICETTE PRESENTI NELLA TABELLA ricette:
		List<Ricetta> ricettecollection1 = serviceRicette.findAllRicette();
		m.addAttribute("ricettecollection", ricettecollection1);
		
		return "homericetteadmin"; 
	}

	
	//MAPPATURA PER EDIT RICETTA (PER ID) - LATO AMMINISTRATORE:
	//[http://localhost:8008/ricette/admin/edit/1]
	@RequestMapping(value = "/admin/edit/{id}")
	public String mostraRicettaAdmin(Model m, @PathVariable("id") int id)
	{		
		Ricetta ricetta1 = serviceRicette.getRicetta(id);
		m.addAttribute("ricetta", ricetta1);
		
		return "ricetta/formricetta";
	}
	
	
	//UPDATE RICETTA (admin):
	//[http://localhost:8008/ricette/admin/edit/formricetta]
	@RequestMapping(value = "/admin/edit/formricetta", method=RequestMethod.POST)
	public String updateRicettaAdmin(@Valid Ricetta ricetta, BindingResult binder, Model m)
	{
		if (binder.hasErrors())
		{
			m.addAttribute("ricetta", ricetta);
			return "ricette/formricetta";
		}
		
		serviceRicette.updateRicetta(ricetta);
		
		return "redirect:../homericetteadmin";
	}	
		
}

