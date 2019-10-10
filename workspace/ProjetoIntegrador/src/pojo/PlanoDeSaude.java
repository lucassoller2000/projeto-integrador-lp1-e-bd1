package pojo;

import java.util.ArrayList;
import java.util.List;

public class PlanoDeSaude {
	private long idPlano;
	private int beneficios;
	private String categoria;
	private String dataEmissao;
	private String validade;
	private String empresaPlano;
	private List<Usuario> listaUsuario;

	public PlanoDeSaude() {

	}

	public PlanoDeSaude(long idPlano, int beneficios, String categoria, String dataEmissao, String validade,
			String empresaPlano, List<Usuario> listaUsuario) {
		this.idPlano = idPlano;
		this.beneficios = beneficios;
		this.categoria = categoria;
		this.dataEmissao = dataEmissao;
		this.validade = validade;
		this.empresaPlano = empresaPlano;
		this.listaUsuario = new ArrayList<Usuario>();
	}

	public long getIdPlano() {
		return idPlano;
	}

	public void setIdPlano(long idPlano) {
		this.idPlano = idPlano;
	}

	public int getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(int beneficios) {
		this.beneficios = beneficios;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public String getEmpresaPlano() {
		return empresaPlano;
	}

	public void setEmpresaPlano(String empresaPlano) {
		this.empresaPlano = empresaPlano;
	}

	public List<Usuario> getUsuario() {
		return listaUsuario;
	}

	public void setUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	@Override
	public String toString() {
		return "\nID plano: " + idPlano + "\nBenefícios: " + beneficios + "% \nCategoria: " + categoria
				+ "\nData de emissão: " + dataEmissao + "\nValidade: " + validade + "\nEmpresa plano: " + empresaPlano;
	}
	
	
}
