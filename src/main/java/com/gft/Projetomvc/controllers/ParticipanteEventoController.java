package com.gft.Projetomvc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.Projetomvc.entities.ParticipanteEvento;
import com.gft.Projetomvc.services.GrupoService;
import com.gft.Projetomvc.services.ParticipanteEventoService;

@Controller
@RequestMapping("participante")
public class ParticipanteEventoController {

	@Autowired
	private ParticipanteEventoService participanteEventoService;

	@Autowired
	private GrupoService grupoService;

	@RequestMapping(path = "/editar")
	public ModelAndView editarParticipante(@RequestParam(required = false) Long id) {

		ModelAndView mv = new ModelAndView("participante/form.html");

		ParticipanteEvento participanteEvento;

		if (id == null) {
			participanteEvento = new ParticipanteEvento();
		} else {
			try {
				participanteEvento = participanteEventoService.obterParticipante(id);
			} catch (Exception e) {
				participanteEvento = new ParticipanteEvento();
				mv.addObject("mensagem", e.getMessage());
			}
		}

		mv.addObject("participanteEvento", participanteEvento);
		mv.addObject("listaGrupos", grupoService.listarGrupos());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/editar")
	public ModelAndView salvarParticipante(@Valid ParticipanteEvento participanteEvento, BindingResult bindingResult) {

		ModelAndView mv = new ModelAndView("participante/form.html");

		boolean novo = true;

		if (participanteEvento.getId() != null)
			novo = false;

		if (bindingResult.hasErrors())
			mv.addObject("participanteEvento", participanteEvento);

		participanteEventoService.salvarParticipante(participanteEvento);

		if (novo)
			mv.addObject("participanteEvento", new ParticipanteEvento());
		else
			mv.addObject("participanteEvento", participanteEvento);

		return mv;
	}

	@RequestMapping
	public ModelAndView listarParticipantes() {

		ModelAndView mv = new ModelAndView("participante/listar.html");
		mv.addObject("listaParticipantes", participanteEventoService.listarParticipantes());

		return mv;
	}

	@RequestMapping("excluir")
	public ModelAndView excluirParticipante(@RequestParam Long id, RedirectAttributes redirectAttributes) {

		ModelAndView mv = new ModelAndView("redirect:/participante");

		try {
			participanteEventoService.excluirParticipante(id);
			redirectAttributes.addFlashAttribute("mensagem", "Participante excluído com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem",
					"Houve um problema ao excluir este participante." + e.getMessage());
		}

		return mv;
	}
}
