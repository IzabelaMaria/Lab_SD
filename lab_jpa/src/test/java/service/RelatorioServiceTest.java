package service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dto.TotalCompradoPeloFornecedorDTO;

@SpringBootTest
class RelatorioServiceTest {

	@Autowired
	private RelatorioService service;
	
	@Test
	void test() {
		List<TotalCompradoPeloFornecedorDTO> listaDTO = service.pesquisarTotalCompradoPeloFornecedor();
		assertFalse(listaDTO.isEmpty());
		listaDTO.forEach(System.out::println);
	}

}
