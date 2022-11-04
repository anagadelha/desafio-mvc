package com.gft.Projetomvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.gft.Projetomvc.entities.Administrador;
import com.gft.Projetomvc.repositories.AdministradorRepository;

@Controller
public class LoginController {
	
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private AdministradorRepository repository;


	@GetMapping("/login")
	public String login() {
		return "login/paginaLogin";
	}

	@GetMapping("/")
	public String index() {
		return "login/index";
	}
	
	@GetMapping("/cadastro")
	public String cadastrar() {
		return "login/cadastro";
	}
	
	@PostMapping("/administradores/criar")
	public String criar(Administrador administrador) {
		administrador.setSenha(passwordEncoder().encode(administrador.getSenha()));
		repository.save(administrador);
		return "redirect:/login";
	}
	
	@GetMapping("/home")
	public String home() {
		return "login/home";
	}



}
