package com.gft.Projetomvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.Projetomvc.entities.Evento;
import com.gft.Projetomvc.entities.Presenca;
import com.gft.Projetomvc.repositories.PresencaRepository;

@Service
public class PresencaService {

	@Autowired
	private PresencaRepository presencaRepository;

	public Presenca salvarPresenca(Presenca presenca) {

		Evento evento = presenca.getParticipanteEvento().getGrupo().getEvento();

		presenca.setEvento(evento);

		return presencaRepository.save(presenca);
	}
}
