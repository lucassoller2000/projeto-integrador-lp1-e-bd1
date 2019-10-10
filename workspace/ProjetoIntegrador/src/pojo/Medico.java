package pojo;

import java.util.ArrayList;
import java.util.List;

public class Medico {
	private long idMedico;
	private String nomeMedico;
	private int idadeMedico;
	private String cpfMedico;
	private String sexoMedico;
	private String especializacao;
	private String telefone;
	private List<Cirurgia> listaCirurgias;
	private List<Consulta> listaConsultas;
	
	public Medico() {
		
	}
	public Medico(long idMedico, String nomeMedico, int idadeMedico, String cpfMedico, String sexoMedico, 
			String especializacao, String telefone, List<Cirurgia> listaCirurgias, List<Consulta> listaConsultas) {
		this.idMedico = idMedico;
		this.nomeMedico = nomeMedico;
		this.idadeMedico = idadeMedico;
		this.cpfMedico = cpfMedico;
		this.sexoMedico = sexoMedico;
		this.especializacao = especializacao;
		this.telefone = telefone;
		this.listaCirurgias = new ArrayList<Cirurgia>();
		this.listaConsultas = new ArrayList<Consulta>();
	}


	public long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(long idMedico) {
		this.idMedico = idMedico;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public int getIdadeMedico() {
		return idadeMedico;
	}

	public void setIdadeMedico(int idadeMedico) {
		this.idadeMedico = idadeMedico;
	}

	public String getCpfMedico() {
		return cpfMedico;
	}

	public void setCpfMedico(String cpfMedico) {
		this.cpfMedico = cpfMedico;
	}

	public String getSexoMedico() {
		return sexoMedico;
	}
	public void setSexoMedico(String sexoMedico) {
		this.sexoMedico = sexoMedico;
	}
	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Cirurgia> getCirurgia() {
		return listaCirurgias;
	}

	public void setCirurgia(List<Cirurgia> listaCirurgias) {
		this.listaCirurgias = listaCirurgias;
	}
	public List<Consulta> getConsulta() {
		return listaConsultas;
	}
	public void setConsulta(List<Consulta> listaConsultas) {
		this.listaConsultas = listaConsultas;
	}
	@Override
	public String toString() {
		return "\nID medico: " + idMedico + "\nNome: " + nomeMedico + "\nIdade: " + idadeMedico
				+ "\nCPF: " + cpfMedico + "\nSexo: " + sexoMedico + "\nEspecialização: " + especializacao
				+ "\nTelefone: " + telefone;
	}
}