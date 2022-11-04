package com.gft.Projetomvc.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Presenca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Evento evento;

	@OneToOne
	private ParticipanteEvento participanteEvento;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;

	private Boolean isPresente;

	private Boolean isAtrasado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public ParticipanteEvento getParticipanteEvento() {
		return participanteEvento;
	}

	public void setParticipanteEvento(ParticipanteEvento participanteEvento) {
		this.participanteEvento = participanteEvento;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Boolean getIsPresente() {
		return isPresente;
	}

	public void setIsPresente(Boolean isPresente) {
		this.isPresente = isPresente;
	}

	public Boolean getIsAtrasado() {
		return isAtrasado;
	}

	public void setIsAtrasado(Boolean isAtrasado) {
		this.isAtrasado = isAtrasado;
	}
}
