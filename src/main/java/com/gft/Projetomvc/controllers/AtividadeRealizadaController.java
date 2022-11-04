package com.gft.Projetomvc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.Projetomvc.entities.AtividadeRealizada;
import com.gft.Projetomvc.services.AtividadeRealizadaService;
import com.gft.Projetomvc.services.ParticipanteEventoService;

@Controller
public class AtividadeRealizadaController {

	@Autowired
	private AtividadeRealizadaService atividadeRealizadaService;

	@Autowired
	private ParticipanteEventoService participanteEventoService;

	@RequestMapping("/atividaderealizada")
	public ModelAndView listaAtividadeRealizada() {

		ModelAndView mv = new ModelAndView("atividadeRealizada/listaAtividadeRealizada.html");

		mv.addObject("atividadeRealizada", new AtividadeRealizada());
		mv.addObject("listaParticipantes", participanteEventoService.listarParticipantes());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/atividaderealizada")
	public ModelAndView salvarPresenca(@Valid AtividadeRealizada atividade, BindingResult bindingResult) {

		ModelAndView mv = new ModelAndView("atividadeRealizada/listaAtividadeRealizada.html");

		boolean novo = true;

		if (atividade.getId() != null)
			novo = false;

		if (bindingResult.hasErrors())
			mv.addObject("atividadeRealizada", atividade);

		atividadeRealizadaService.salvarAtividade(atividade);

		if (novo)
			mv.addObject("atividadeRealizada", new AtividadeRealizada());
		else
			mv.addObject("atividadeRealizada", atividade);

		return mv;
	}

}
