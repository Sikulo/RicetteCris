package it.tecnosphera.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ControllerHome 
{
		
	//MAPPO LA PAGINA 'home' BASE (qui 'http://localhost:8008/ricette/'):
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) 
	{				
		//RITORNO LA PAGINA 'home.jsp':
		return "home";
	}
	
}
