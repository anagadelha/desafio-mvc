package com.gft.Projetomvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.Projetomvc.entities.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {

}
