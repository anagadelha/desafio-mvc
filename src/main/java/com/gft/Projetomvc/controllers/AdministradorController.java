package com.gft.Projetomvc.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gft.Projetomvc.entities.Administrador;
import com.gft.Projetomvc.repositories.AdministradorRepository;

@Controller
public class AdministradorController {

	@Autowired
	private AdministradorRepository repository;

	@GetMapping("/administradores")
	public String index(Model model) {
		List<Administrador> administradores = (List<Administrador>) repository.findAll();
		model.addAttribute("administradores", administradores);
		return "administrador/administradores";
	}
	
	@GetMapping("/administradores/{id}")
	public String busca(@PathVariable int id, Model model) {
		Optional<Administrador> admin = repository.findById(id);
		try {
			model.addAttribute("administrador", admin.get());
		} catch (Exception err) {
			return "redirect:/administradores";
		}

		return "administrador/editar";
	}

	@PostMapping("/administradores/{id}/editar")
	public String editar(@PathVariable int id, Administrador administrador) {
		if (!repository.existsById(id)) {
			return "redirect:/administradores";
		}

		repository.save(administrador);

		return "redirect:/administradores";
	}

	@GetMapping("/administradores/{id}/excluir")
	public String excluir(@PathVariable int id) {
		repository.deleteById(id);
		return "redirect:/administradores";
	}

}
