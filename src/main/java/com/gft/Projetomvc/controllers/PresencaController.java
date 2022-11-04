package com.gft.Projetomvc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.Projetomvc.entities.Presenca;
import com.gft.Projetomvc.services.ParticipanteEventoService;
import com.gft.Projetomvc.services.PresencaService;

@Controller
public class PresencaController {

	@Autowired
	private PresencaService presencaService;

	@Autowired
	private ParticipanteEventoService participanteEventoService;

	@RequestMapping("/presenca")
	public ModelAndView listaPresenca() {

		ModelAndView mv = new ModelAndView("presenca/listaPresenca.html");

		mv.addObject("presenca", new Presenca());
		mv.addObject("listaParticipantes", participanteEventoService.listarParticipantes());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/presenca")
	public ModelAndView salvarPresenca(@Valid Presenca presenca, BindingResult bindingResult) {

		ModelAndView mv = new ModelAndView("presenca/listaPresenca.html");

		boolean novo = true;

		if (presenca.getId() != null)
			novo = false;

		if (bindingResult.hasErrors())
			mv.addObject("presenca", presenca);

		presencaService.salvarPresenca(presenca);

		if (novo)
			mv.addObject("presenca", new Presenca());
		else
			mv.addObject("presenca", presenca);

		return mv;
	}
}
