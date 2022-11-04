package com.gft.Projetomvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gft.Projetomvc.entities.Presenca;

@Repository
@Transactional
public interface PresencaRepository extends JpaRepository<Presenca, Long> {

	@Modifying
	@Query("DELETE FROM Presenca WHERE participanteEvento.id = :id")
	void deleteAllByParticipanteId(@Param(value = "id") Long id);
}
