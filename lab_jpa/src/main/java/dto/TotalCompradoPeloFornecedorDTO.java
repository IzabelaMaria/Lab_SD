package dto;

import java.math.BigDecimal;

public class TotalCompradoPeloFornecedorDTO {

	private final String fornecedorRazaoSocial;
	private final BigDecimal totalComprado;
	
	public TotalCompradoPeloFornecedorDTO(String fornecedorRazaoSocial, BigDecimal totalComprado) {
		this.fornecedorRazaoSocial = fornecedorRazaoSocial;
		this.totalComprado = totalComprado;
	}

	public String getFornecedorRazaoSocial() {
		return fornecedorRazaoSocial;
	}

	public BigDecimal getTotalComprado() {
		return totalComprado;
	}

	@Override
	public String toString() {
		return "TotalCompradoPeloFornecedorDTO [fornecedorRazaoSocial=" + fornecedorRazaoSocial + ", totalComprado="
				+ totalComprado + "]";
	}
	
	
}