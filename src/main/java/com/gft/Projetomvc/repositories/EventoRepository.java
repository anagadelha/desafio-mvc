package com.gft.Projetomvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.Projetomvc.entities.Evento;


@Repository
public interface EventoRepository  extends JpaRepository<Evento, Long>{

}
