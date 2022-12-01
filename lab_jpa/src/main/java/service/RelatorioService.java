package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import dto.TotalCompradoPeloFornecedorDTO;

@Service
public class RelatorioService {

	@PersistenceContext
	private EntityManager em;
	
	public List<TotalCompradoPeloFornecedorDTO> pesquisarTotalCompradoPeloFornecedor() {
		String query 
		= " select new dto.TotalCompradoPeloFornecedorDTO "
		+ "		(f.razaoSocial "
		+ "		, sum( i.quantidade * i.valorCompraProduto)"
		+ "		) "
		+ " from NotaCompraItem i "
		+ "		join i.notaCompra n "
		+ "		join n.fornecedor f "
		+ " group by f.razaoSocial "
		;
		
		return em.createQuery(query, TotalCompradoPeloFornecedorDTO.class).getResultList();
	}
}