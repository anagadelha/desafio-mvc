package com.gft.Projetomvc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AtividadeRealizada {

	@ManyToOne
	private Atividades atividadeParticipante;

	@ManyToOne
	private ParticipanteEvento participanteEvento;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private boolean realizouAtv;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isRealizouAtv() {
		return realizouAtv;
	}

	public void setRealizouAtv(boolean realizouAtv) {
		this.realizouAtv = realizouAtv;
	}

	public Atividades getAtividade() {
		return atividadeParticipante;
	}

	public void setAtividade(Atividades atividade) {
		this.atividadeParticipante = atividade;
	}

	public ParticipanteEvento getParticipanteEvento() {
		return participanteEvento;
	}

	public void setParticipanteEvento(ParticipanteEvento participanteEvento) {
		this.participanteEvento = participanteEvento;
	}

}
