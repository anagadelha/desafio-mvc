package com.gft.Projetomvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.Projetomvc.entities.Atividades;
import com.gft.Projetomvc.repositories.AtividadesRepository;

@Service
public class AtividadesService {
	

	@Autowired
	private AtividadesRepository repository;

	public List<Atividades> listarAtividades() {
		return repository.findAll();
		
	}
	
	public Atividades findById(Long id) {
		
		Optional<Atividades> obj = repository.findById(id);
		return obj.get();
	}
	
	public void  excluirAtividades(Long id) {
		repository.deleteById(id);
	}

	public Atividades editarAtividades(Atividades atividades) {
		return repository.save(atividades);
	}
	

}
