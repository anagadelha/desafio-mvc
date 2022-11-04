package com.atividades.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gft.Projetomvc.entities.Atividades;
import com.gft.Projetomvc.repositories.AtividadesRepository;
import com.gft.Projetomvc.services.AtividadesService;

@SpringBootTest
public class AtividadesServiceTests {

	@Autowired
	private AtividadesService service;
	
	@Before
	private void setup() {


	}
	
	@Mock
	private AtividadesRepository atividadesRepository;
	

	@Test
	public void deveSalvarComSucesso() {
		
		Atividades entitie = new Atividades();
		
		Mockito.when(atividadesRepository.save(entitie).thenReturn(entitie));
		
		Assertions.assertNotNull(entitie);
		Assertions.assertEquals("Atividades", entitie.getNome());
	}

		
	/*
	 * @Test public void deveDeletarAtividadePeloId() throws Exception {
	 *
	 * Mockito.doNothing().when(atividadesRepository).deleteById(id);
	 *
	 * service.deleteAtividades(null);
	 *
	 * }
	 *
	 * public void deveAtualizarAtividade() {
	 *
	 * Mockito.when(atividadesRepository).save(atividades).thenReturn(atividades);
	 *
	 *
	 * }
	 */
}
	
	
	
