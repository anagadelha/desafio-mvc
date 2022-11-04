package com.gft.Projetomvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.Projetomvc.entities.AtividadeRealizada;

@Repository
public interface AtividadeRealizadaRepository extends JpaRepository<AtividadeRealizada, Long> {

}
