package com.gft.Projetomvc.services;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.gft.Projetomvc.entities.ParticipanteEvento;
import com.gft.Projetomvc.repositories.ParticipanteEventoRepository;

@SpringBootTest
public class ParticipanteEventoServiceTest {

	@InjectMocks
	private ParticipanteEventoService participanteEventoService;

	@Mock
	private ParticipanteEventoRepository participanteEventoRepository;

	private List<ParticipanteEvento> participantes;
	private ParticipanteEvento participante1;
	private ParticipanteEvento participante2;
	private ParticipanteEvento participante3;

	@Before
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void deveAcharTodosOsParticipantes() throws Exception {

		Mockito.when(participanteEventoRepository.findAll()).thenReturn(getParticipantes());

		List<ParticipanteEvento> participantes = participanteEventoService.listarParticipantes();

		Assert.assertNotNull(participantes);
		Assert.assertEquals(participantes.size(), 3);
		Assert.assertEquals("Participante 1", participantes.get(0).getNome());
	}

	@Test(expected = Exception.class)
	public void deveLancarExceptionQuandoFalhaEmAcharTodosOsParticipantes() throws Exception {

		Mockito.when(participanteEventoRepository.findAll())
				.thenThrow(new Exception("Ops! Não encontramos nenhum participante."));

		participanteEventoService.listarParticipantes();
	}

	@Test
	public void deveSalvarParticipante() throws Exception {

		Mockito.when(participanteEventoRepository.save(any())).thenReturn(getParticipante());

		participanteEventoService.salvarParticipante(participante1);

		Assert.assertNotNull(participante1);
		Assert.assertEquals("Participante 1", participante1.getNome());
	}

	@Test
	public void deveAcharParticipantePeloId() throws Exception {

		Mockito.when(participanteEventoRepository.findById(any())).thenReturn(getParticipante(1L));

		ParticipanteEvento participante = participanteEventoService.obterParticipante(1L);

		Assert.assertNotNull(participante);
		Assert.assertEquals("Participante 1", participante.getNome());

	}

	@Test
	public void deveExcluirParticipantePeloId() throws Exception {

		Mockito.doNothing().when(participanteEventoRepository).deleteById(any());

		participanteEventoService.excluirParticipante(1L);
	}

	@Test(expected = Exception.class)
	public void deveLancarExceptionAoNaoConseguirExcluir() throws Exception {

		Mockito.doThrow(new Exception("Houve um problema ao excluir este grupo.")).when(participanteEventoRepository)
				.deleteById(any());

		participanteEventoService.excluirParticipante(1L);
	}

	private List<ParticipanteEvento> getParticipantes() {

		participantes = new ArrayList<>();

		participante1 = new ParticipanteEvento();
		participante1.setId(1L);
		participante1.setNome("Participante 1");

		participante2 = new ParticipanteEvento();
		participante2.setId(2L);
		participante2.setNome("Participante 2");

		participante3 = new ParticipanteEvento();
		participante3.setId(3L);
		participante3.setNome("Participante 3");

		participantes.add(participante1);
		participantes.add(participante2);
		participantes.add(participante3);

		return participantes;
	}

	private ParticipanteEvento getParticipante() {

		participante1 = new ParticipanteEvento();
		participante1.setId(1L);
		participante1.setNome("Participante 1");

		return participante1;
	}

	private Optional<ParticipanteEvento> getParticipante(Long id) {

		participante1 = new ParticipanteEvento();
		participante1.setId(1L);
		participante1.setNome("Participante 1");

		return Optional.of(participante1);
	}
}
