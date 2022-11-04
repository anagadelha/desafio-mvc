package com.gft.Projetomvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.Projetomvc.entities.AtividadeRealizada;
import com.gft.Projetomvc.entities.Atividades;
import com.gft.Projetomvc.repositories.AtividadeRealizadaRepository;

@Service
public class AtividadeRealizadaService {

	@Autowired
	private AtividadeRealizadaRepository atividadeRealizadaRepository;

	public AtividadeRealizada salvarAtividade(AtividadeRealizada atividadeRealizada) {
		Atividades atividade = atividadeRealizada.getAtividade();

		atividadeRealizada.setAtividade(atividade);
		return atividadeRealizadaRepository.save(atividadeRealizada);
	}



}