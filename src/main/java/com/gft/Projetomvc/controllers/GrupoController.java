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

import com.gft.Projetomvc.entities.Grupo;
import com.gft.Projetomvc.services.EventoService;
import com.gft.Projetomvc.services.GrupoService;
import com.gft.Projetomvc.services.ParticipanteEventoService;

@Controller
@RequestMapping("grupo")
public class GrupoController {

	@Autowired
	private GrupoService grupoService;

	@Autowired
	private ParticipanteEventoService participanteEventoService;

	@Autowired
	private EventoService eventoService;

	@RequestMapping(path = "/editar")
	public ModelAndView editarGrupo(@RequestParam(required = false) Long id) {

		ModelAndView mv = new ModelAndView("grupo/form.html");

		Grupo grupo;

		if (id == null) {
			grupo = new Grupo();
		} else {
			try {
				grupo = grupoService.obterGrupo(id);
			} catch (Exception e) {
				grupo = new Grupo();
				mv.addObject("mensagem", e.getMessage());
			}
		}

		mv.addObject("grupo", grupo);
		mv.addObject("listaParticipantes", participanteEventoService.listarParticipantes());
		mv.addObject("listaEventos", eventoService.listEvento());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/editar")
	public ModelAndView salvarGrupo(@Valid Grupo grupo, BindingResult bindingResult) {

		ModelAndView mv = new ModelAndView("grupo/form.html");

		boolean novo = true;

		if (grupo.getId() != null)
			novo = false;

		if (bindingResult.hasErrors())
			mv.addObject("grupo", grupo);

		grupoService.salvarGrupo(grupo);

		if (novo)
			mv.addObject("grupo", new Grupo());
		else
			mv.addObject("grupo", grupo);

		return mv;
	}

	@RequestMapping
	public ModelAndView listarGrupos() {

		ModelAndView mv = new ModelAndView("grupo/listar.html");
		mv.addObject("listaGrupos", grupoService.listarGrupos());

		return mv;
	}

	@RequestMapping("/excluir")
	public ModelAndView excluirGrupo(@RequestParam Long id, RedirectAttributes redirectAttributes) {

		ModelAndView mv = new ModelAndView("redirect:/grupo");

		try {
			grupoService.excluirGrupo(id);
			redirectAttributes.addFlashAttribute("mensagem", "Grupo exclu??do com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem",
					"Houve um problema ao excluir este grupo." + e.getMessage());
		}

		return mv;
	}

	@RequestMapping(path = "visualizar")
	public ModelAndView visualizarGrupo(@RequestParam Long id) {

		ModelAndView mv = new ModelAndView("grupo/visualizar");

		try {
			mv.addObject("grupo", grupoService.obterGrupo(id));
			mv.addObject("listaParticipantes", grupoService.listarParticipantesDoGrupo(id));
		} catch (Exception e) {
			mv.addObject("mensagem", e.getMessage());
		}

		return mv;
	}
}
