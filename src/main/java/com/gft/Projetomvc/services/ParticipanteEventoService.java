package com.gft.Projetomvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.Projetomvc.entities.ParticipanteEvento;
import com.gft.Projetomvc.repositories.ParticipanteEventoRepository;
import com.gft.Projetomvc.repositories.PresencaRepository;

@Service
public class ParticipanteEventoService {

	@Autowired
	private ParticipanteEventoRepository participanteEventoRepository;
	
	@Autowired
	private PresencaRepository presencaRepository;

	public ParticipanteEvento obterParticipante(Long id) throws Exception {

		Optional<ParticipanteEvento> participanteEvento = participanteEventoRepository.findById(id);

		if (participanteEvento.isEmpty()) {
			throw new Exception("Desculpe, não encontramos este participante.");
		}

		return participanteEvento.get();
	}

	public ParticipanteEvento salvarParticipante(ParticipanteEvento participanteEvento) {

		return participanteEventoRepository.save(participanteEvento);
	}

	public List<ParticipanteEvento> listarParticipantes() {

		return participanteEventoRepository.findAll();
	}

	public void excluirParticipante(Long id) {

		presencaRepository.deleteAllByParticipanteId(id);
		participanteEventoRepository.deleteById(id);
	}
}
