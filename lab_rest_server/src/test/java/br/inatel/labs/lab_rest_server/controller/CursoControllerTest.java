package br.inatel.labs.lab_rest_server.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.inatel.labs.lab_rest_server.model.Curso;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CursoControllerTest {

	@Autowired
	private WebTestClient webTestClient;
	
	@Test
	void deveListarCursos() {
		webTestClient.get()
		.uri("/curso")
		.exchange()
		.expectStatus()
		.isOk()
		.expectBody()
		.returnResult();
	}

	
	@Test
	void dadoCursoIdValido_quandoGetCursoPorId_entaoRespondeComCursoValido() {
		Long cursoIdValido = 1L;
		
		Curso cursoRespondido = webTestClient.get()
			.uri("/curso/" + cursoIdValido)
			.exchange()
			.expectStatus()
			.isOk()
			.expectBody(Curso.class)
			.returnResult()
			.getResponseBody();
		
		//assertNotNull(cursoRespondido);
		//assertEquals(cursoRespondido.getId(), cursoIdValido);
			assertThat(cursoRespondido).isNotNull();
			assertThat(cursoIdValido).isEqualTo(cursoRespondido.getId());
	}
	
	@Test
	void dadoCursoIdInvalido_quandoGetCursoPeloId_entaoRespondeComStatusNotFound() {
		Long cursoIdInvalido = 99L;
		
		webTestClient.get()
		.uri("/curso/" + cursoIdInvalido)
		.exchange()
		.expectStatus().isNotFound();
	}

	@Test 
	void dadoNovoCurso_quandoPostCurso_entaoRespondeComStatusCreatedECursoValido() {
		Curso novoCurso = new Curso();
		novoCurso.setDescricao("Testando REST com Spring WebFlux");
		novoCurso.setCargaHoraria(120);
		
		Curso cursoRespondido = webTestClient.post()
				.uri("/curso")
				.bodyValue(novoCurso)
				.exchange()
				.expectStatus()
				.isCreated()
				.expectBody(Curso.class)
				.returnResult()
				.getResponseBody();
		
		assertThat(cursoRespondido).isNotNull();
		assertThat(cursoRespondido.getId()).isNotNull();
	}
}
