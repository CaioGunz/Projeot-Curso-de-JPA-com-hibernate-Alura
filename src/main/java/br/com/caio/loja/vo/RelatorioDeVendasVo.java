package br.com.caio.loja.vo;

import java.time.LocalDate;

public class RelatorioDeVendasVo {

	private String nomeProduto;
	private Long qauntidadeVendida;
	private LocalDate dataUltimaVenda;
	
	public RelatorioDeVendasVo(String nomeProduto, Long qauntidadeVendida, LocalDate dataUltimaVenda) {
		this.nomeProduto = nomeProduto;
		this.qauntidadeVendida = qauntidadeVendida;
		this.dataUltimaVenda = dataUltimaVenda;
	}
	

	@Override
	public String toString() {
		return "RelatorioDeVendasVo [nomeProduto=" + nomeProduto + ", qauntidadeVendida=" + qauntidadeVendida
				+ ", dataUltimaVenda=" + dataUltimaVenda + "]";
	}



	public String getNomeProduto() {
		return nomeProduto;
	}

	public Long getQauntidadeVendida() {
		return qauntidadeVendida;
	}

	public LocalDate getDataUltimaVenda() {
		return dataUltimaVenda;
	}
	
	
	
}
