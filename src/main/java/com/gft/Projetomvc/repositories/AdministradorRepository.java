package com.gft.Projetomvc.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gft.Projetomvc.entities.Administrador;

public interface AdministradorRepository extends CrudRepository<Administrador, Integer>{
	  @Query(value="select * from administradores where usuario = :usuario and senha = :senha", nativeQuery = true)
	  public Administrador Login(String usuario, String senha);

}
