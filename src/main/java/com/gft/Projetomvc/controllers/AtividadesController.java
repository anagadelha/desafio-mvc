package com.gft.Projetomvc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.Projetomvc.entities.Atividades;
import com.gft.Projetomvc.services.AtividadesService;
import com.gft.Projetomvc.services.EventoService;

@RestController
@RequestMapping("atividades")
public class AtividadesController {

	@Autowired
	private AtividadesService atividadesService;

	@Autowired
	private EventoService eventoService;

	@RequestMapping(path = "/editar")
	public ModelAndView editarAtividades(@RequestParam(required = false) Long id) {

		ModelAndView mv = new ModelAndView("atividades/formAtividades.html");

		Atividades atividades;

		if (id == null) {
			atividades = new Atividades();
		} else {
			try {
				atividades = atividadesService.findById(id);
			} catch (Exception e) {
				atividades = new Atividades();
				mv.addObject("mensagem", e.getMessage());
			}
		}

		mv.addObject("atividades", atividades);
		mv.addObject("listaEventos", eventoService.listEvento());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/editar")
	public ModelAndView salvarAtividades(@Valid Atividades atividades, BindingResult bindingResult) {

		ModelAndView mv = new ModelAndView("atividades/formAtividades.html");

		boolean novo = true;

		if (atividades.getId() != null)
			novo = false;

		if (bindingResult.hasErrors())
			mv.addObject("atividades", atividades);

		atividadesService.editarAtividades(atividades);

		if (novo)
			mv.addObject("atividades", new Atividades());
		else
			mv.addObject("atividades", atividades);

		return mv;
	}

	@RequestMapping(path = "listar")
	public ModelAndView listarAtividades() {

		ModelAndView mv = new ModelAndView("atividades/listar.html");

		mv.addObject("lista", atividadesService.listarAtividades());

		return mv;
	}

	@RequestMapping("/excluir")
	public ModelAndView excluirAtiviedades(@RequestParam Long id, RedirectAttributes redirectAttributes) {

		ModelAndView mv = new ModelAndView("redirect:/atividades/listar");

		try {
			atividadesService.excluirAtividades(id);
			redirectAttributes.addFlashAttribute("mensagem", "Atividade deletada com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem",
					"Erro, não foi possível fazer a solicitação desejada." + e.getMessage());

		}

		return mv;

	}

}
