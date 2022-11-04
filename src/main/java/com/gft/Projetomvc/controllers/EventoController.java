package com.gft.Projetomvc.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.Projetomvc.entities.Evento;
import com.gft.Projetomvc.services.EventoService;

@Controller
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	EventoService eventoService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/get")
	public ModelAndView getEvento(@RequestParam Long id) {

		ModelAndView eventoMv = new ModelAndView("evento/evento.html");

		try {
		Evento evento = eventoService.getEvento(id);

		eventoMv.addObject("evento", evento);
		
		}catch(Exception e) {
			
			eventoMv.addObject("message", e.getMessage());
		}

		return eventoMv;

	}

	@RequestMapping(method = RequestMethod.GET, path = "/new")
	public ModelAndView formEvento() {
		ModelAndView formMv = new ModelAndView("evento/formEvento.html");
		
		formMv.addObject("evento", new Evento());

		return formMv;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/edit")
	public ModelAndView editEvento(@RequestParam Long id) {
		ModelAndView editMv = new ModelAndView("evento/formEvento.html");
		
		try {
			Evento evento = eventoService.getEvento(id);
			editMv.addObject("evento", evento);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return editMv;
	}

	@RequestMapping(method = RequestMethod.POST, path="/create")
	public ModelAndView newEvento(Evento evento, RedirectAttributes redirectAttributes) {
		ModelAndView cadastrarMv = new ModelAndView("redirect:/evento");
		
		eventoService.saveEvento(evento);
		
		redirectAttributes.addFlashAttribute("message", "Evento Registrado");

		return cadastrarMv;
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/delete")
	public ModelAndView deleteEvento(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView deleteMv = new ModelAndView("redirect:/evento");
		try {
			eventoService.deleteEvento(id);
			redirectAttributes.addFlashAttribute("message", "Evento Removido");
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("message", "Erro ao Excluir");
		}
		
		return deleteMv;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listEvento() {
		
		ModelAndView mv = new ModelAndView("evento/listEvento.html");
		mv.addObject("list", eventoService.listEvento());
		
		return mv;
	}
}
