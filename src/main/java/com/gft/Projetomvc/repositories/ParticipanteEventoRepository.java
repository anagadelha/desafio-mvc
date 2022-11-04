package com.gft.Projetomvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.Projetomvc.entities.ParticipanteEvento;

public interface ParticipanteEventoRepository extends JpaRepository<ParticipanteEvento, Long> {

	List<ParticipanteEvento> findAllByGrupoId(Long id);

}
