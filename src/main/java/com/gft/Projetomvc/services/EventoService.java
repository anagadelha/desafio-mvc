package com.gft.Projetomvc.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.Projetomvc.entities.Evento;
import com.gft.Projetomvc.repositories.EventoRepository;

@Service
public class EventoService {

	@Autowired
	EventoRepository eventoRepository;

	public Evento createEvento() {

		Evento evento = new Evento();

		evento.setNome("Primeiro Evento");
		evento.setDataInicio(LocalDate.of(2022, 10, 20));
		evento.setDataFinal(LocalDate.of(2022, 12, 20));

		return evento;
	}

	public Evento saveEvento(Evento evento) {
		return eventoRepository.save(evento);
	}

	public Evento getEvento(long id) throws Exception {

		Optional<Evento> evento = eventoRepository.findById(id);

		if (evento.isEmpty()) {
			throw new Exception("Evento não encontrado");
		}

		return evento.get();
	}

	public void deleteEvento(long id) {
		eventoRepository.deleteById(id);
	}

	public List<Evento> listEvento() {

		return eventoRepository.findAll();
	}
}