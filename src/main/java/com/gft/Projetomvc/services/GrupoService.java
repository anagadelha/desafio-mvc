package com.gft.Projetomvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.Projetomvc.entities.Grupo;
import com.gft.Projetomvc.entities.ParticipanteEvento;
import com.gft.Projetomvc.repositories.GrupoRepository;
import com.gft.Projetomvc.repositories.ParticipanteEventoRepository;

@Service
public class GrupoService {

	@Autowired
	private GrupoRepository grupoRepository;

	@Autowired
	private ParticipanteEventoRepository participanteEventoRepository;

	public Grupo obterGrupo(Long id) throws Exception {

		Optional<Grupo> grupo = grupoRepository.findById(id);

		if (grupo.isEmpty()) {
			throw new Exception("Desculpe, não encontramos este grupo.");
		}

		return grupo.get();
	}

	public Grupo salvarGrupo(Grupo grupo) {

		return grupoRepository.save(grupo);
	}

	public List<Grupo> listarGrupos() {

		return grupoRepository.findAll();
	}

	public void excluirGrupo(Long id) {

		grupoRepository.deleteById(id);
	}

	public List<ParticipanteEvento> listarParticipantesDoGrupo(Long id) {

		return participanteEventoRepository.findAllByGrupoId(id);
	}
}
