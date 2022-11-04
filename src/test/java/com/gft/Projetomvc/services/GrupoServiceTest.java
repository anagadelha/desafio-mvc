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

import com.gft.Projetomvc.entities.Grupo;
import com.gft.Projetomvc.repositories.GrupoRepository;

@SpringBootTest
public class GrupoServiceTest {

	// ClientesService = GrupoRepository
	// ClientesHelper = GrupoService

	@InjectMocks
	private GrupoService grupoService;

	@Mock
	private GrupoRepository grupoRepository;

	private List<Grupo> grupos;
	private Grupo grupo1;
	private Grupo grupo2;
	private Grupo grupo3;

	@Before
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void deveAcharTodosOsGrupos() throws Exception {

		Mockito.when(grupoRepository.findAll()).thenReturn(getGrupos());

		List<Grupo> grupos = grupoService.listarGrupos();

		Assert.assertNotNull(grupos);
		Assert.assertEquals(grupos.size(), 3);
		Assert.assertEquals("Grupo 1", grupos.get(0).getNome());
	}

	@Test(expected = Exception.class)
	public void deveLancarExceptionQuandoFalhaEmAcharTodosGrupos() throws Exception {

		Mockito.when(grupoRepository.findAll()).thenThrow(new Exception("Ops! Não encontramos nenhum grupo."));

		grupoService.listarGrupos();
	}

	@Test
	public void deveSalvarGrupo() throws Exception {

		Mockito.when(grupoRepository.save(any())).thenReturn(getGrupo());

		grupoService.salvarGrupo(grupo1);

		Assert.assertNotNull(grupo1);
		Assert.assertEquals("Grupo 1", grupo1.getNome());
	}

	@Test
	public void deveAcharGrupoPeloId() throws Exception {

		Mockito.when(grupoRepository.findById(any())).thenReturn(getGrupo(1L));

		Grupo grupo = grupoService.obterGrupo(1L);

		Assert.assertNotNull(grupo);
		Assert.assertEquals("Grupo 1", grupo.getNome());

	}

	@Test
	public void deveExcluirGrupoPeloId() throws Exception {

		Mockito.doNothing().when(grupoRepository).deleteById(any());

		grupoService.excluirGrupo(1L);
	}

	@Test(expected = Exception.class)
	public void deveLancarExceptionAoNaoConseguirExcluir() throws Exception {

		Mockito.doThrow(new Exception("Houve um problema ao excluir este grupo.")).when(grupoRepository)
				.deleteById(any());

		grupoService.excluirGrupo(1L);
	}

	private List<Grupo> getGrupos() {

		grupos = new ArrayList<>();

		grupo1 = new Grupo();
		grupo1.setId(1L);
		grupo1.setNome("Grupo 1");

		grupo2 = new Grupo();
		grupo2.setId(2L);
		grupo2.setNome("Grupo 2");

		grupo3 = new Grupo();
		grupo3.setId(3L);
		grupo3.setNome("Grupo 3");

		grupos.add(grupo1);
		grupos.add(grupo2);
		grupos.add(grupo3);

		return grupos;
	}

	private Grupo getGrupo() {

		grupo1 = new Grupo();
		grupo1.setId(1L);
		grupo1.setNome("Grupo 1");

		return grupo1;
	}

	private Optional<Grupo> getGrupo(Long id) {

		grupo1 = new Grupo();
		grupo1.setId(1L);
		grupo1.setNome("Grupo 1");

		return Optional.of(grupo1);
	}
}
