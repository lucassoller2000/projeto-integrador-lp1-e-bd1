package pojo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private long idUsuario;
	private String nomeUsuario;
	private int idade;
	private String dataNasc;
	private String cpfUsuario;
	private String sexoUsuario;
	private double peso;
	private String estadoCivil;
	private String tipoSangue;
	private double renda;
	private String tipoUsuario;
	private String telefoneCasa;
	private String telefoneCelular;
	private String telefoneFamilia;
	private PlanoDeSaude planoDeSaude= null;
	private List<UsuarioMedicamento> listaUsuarioMedicamento;
	private List<Cirurgia> listaCirurgias;
	private long idDoador;
	private long idReceptor;
	
	public Usuario() {
		
	}

	public Usuario(long idUsuario, String nomeUsuario, int idade, String dataNasc, String cpfUsuario, String sexoUsuario,
			double peso, String estadoCivil, String tipoSangue, double renda, String tipoUsuario, String telefoneCasa,
			String telefoneCelular, String telefoneFamilia, PlanoDeSaude planoDeSaude, List<UsuarioMedicamento> listaUsuarioMedicamento,
			List<Cirurgia> listaCirurgias) {
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.idade = idade;
		this.dataNasc = dataNasc;
		this.cpfUsuario = cpfUsuario;
		this.sexoUsuario = sexoUsuario;
		this.peso = peso;
		this.estadoCivil = estadoCivil;
		this.tipoSangue = tipoSangue;
		this.renda = renda;
		this.tipoUsuario = tipoUsuario;
		this.telefoneCasa = telefoneCasa;
		this.telefoneCelular = telefoneCelular;
		this.telefoneFamilia = telefoneFamilia;
		this.planoDeSaude = planoDeSaude;
		this.listaUsuarioMedicamento = new ArrayList<UsuarioMedicamento>();
		this.listaCirurgias = new ArrayList<Cirurgia>();
	}


	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}
	
	public String getSexoUsuario() {
		return sexoUsuario;
	}

	public void setSexoUsuario(String sexoUsuario) {
		this.sexoUsuario = sexoUsuario;
	}
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getTipoSangue() {
		return tipoSangue;
	}

	public void setTipoSangue(String tipoSangue) {
		this.tipoSangue = tipoSangue;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getTelefoneCasa() {
		return telefoneCasa;
	}

	public void setTelefoneCasa(String telefoneCasa) {
		this.telefoneCasa = telefoneCasa;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getTelefoneFamilia() {
		return telefoneFamilia;
	}

	public void setTelefoneFamilia(String telefoneFamilia) {
		this.telefoneFamilia = telefoneFamilia;
	}

	public PlanoDeSaude getPlanoDeSaude() {
		return planoDeSaude;
	}

	public void setPlanoDeSaude(PlanoDeSaude planoDeSaude) {
		this.planoDeSaude = planoDeSaude;
	}

	public List<UsuarioMedicamento> getListaUsuarioMedicamento() {
		return listaUsuarioMedicamento;
	}

	public void setListaUsuarioMedicamento(List<UsuarioMedicamento> listaUsuarioMedicamento) {
		this.listaUsuarioMedicamento = listaUsuarioMedicamento;
	}

	public List<Cirurgia> getListaCirurgias() {
		return listaCirurgias;
	}

	public void setListaCirurgias(List<Cirurgia> listaCirurgias) {
		this.listaCirurgias = listaCirurgias;
	}

	public long getIdDoador() {
		return idDoador;
	}

	public void setIdDoador(long idDoador) {
		this.idDoador = idDoador;
	}

	public long getIdReceptor() {
		return idReceptor;
	}

	public void setIdReceptor(long idReceptor) {
		this.idReceptor = idReceptor;
	}

	@Override
	public String toString() {
		return "\nID usuário: " + idUsuario + "\nNome: " + nomeUsuario + "\nIdade: " + idade + "\nData de nascimento: "
				+ dataNasc + "\nCPF: " + cpfUsuario + "\nSexo: " + sexoUsuario + "\nPseo(kg): " + peso
				+ "\nEstado civil: " + estadoCivil + "\nTipo sanguíneo: " + tipoSangue + "\nRenda R$:" + renda + "\nTipo de usuário: "
				+ tipoUsuario + "\nTelefone residencial: " + telefoneCasa + "\nTelefone celular: " + telefoneCelular
				+ "\nTelefone de parente: " + telefoneFamilia;
	}
}