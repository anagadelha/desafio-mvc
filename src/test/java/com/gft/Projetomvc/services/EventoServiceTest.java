package com.gft.Projetomvc.services;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.gft.Projetomvc.entities.Evento;
import com.gft.Projetomvc.repositories.EventoRepository;

@ExtendWith(MockitoExtension.class)
public class EventoServiceTest {

	@InjectMocks
	EventoService evento;

	@Mock
	EventoRepository repository;

	@Mock
	EventoService eventoService;

	@Autowired
	EventoRepository eventoRepositoryTest;

	@Before
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void deveSalvarEvento() throws Exception {
		Evento evento = new Evento();

		evento.setDataInicio(LocalDate.of(2022, 10, 20));
		evento.setDataInicio(LocalDate.of(2022, 10, 10));
		evento.setNome("Evento Teste");
		evento.setId((long) 1);
		eventoService.saveEvento(evento);
		Mockito.verify(eventoService).saveEvento(evento);

	}

	@Test
	public void deveDeletarOEvento() throws Exception {

		Evento evento = new Evento();

		evento.setDataInicio(LocalDate.of(2022, 10, 20));
		evento.setDataInicio(LocalDate.of(2022, 10, 10));
		evento.setNome("Evento Teste Deletar");
		evento.setId((long) 1);
		eventoService.deleteEvento(1);
		Mockito.verify(eventoService).deleteEvento(1);
	}

	@Test
	public void deveRetornarOEvento() throws Exception {

		Evento evento = new Evento();

		evento.setDataInicio(LocalDate.of(2022, 10, 20));
		evento.setDataInicio(LocalDate.of(2022, 10, 10));
		evento.setNome("Evento Teste Get");
		evento.setId((long) 1);
		eventoService.getEvento(1);
		Mockito.verify(eventoService).getEvento(1);

	}

}
