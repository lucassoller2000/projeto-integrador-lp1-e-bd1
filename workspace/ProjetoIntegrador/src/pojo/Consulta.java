package pojo;

public class Consulta {
	private long idConsulta;
	private String descricaoConsulta;
	private String dataConsulta;
	private String horaConsulta;
	private int salaConsulta;
	private double precoConsulta;
	private Usuario usuario;
	private Medico medico;
	

	public Consulta() {
		
	}

	public Consulta(long idConsulta, String descricaoConsulta, String dataConsulta, String horaConsulta,
			int salaConsulta, double precoConsulta,  Usuario usuario, Medico medico) {
		this.idConsulta = idConsulta;
		this.descricaoConsulta = descricaoConsulta;
		this.dataConsulta = dataConsulta;
		this.horaConsulta = horaConsulta;
		this.salaConsulta = salaConsulta;
		this.precoConsulta = precoConsulta;
		this.usuario = usuario;
		this.medico = medico;
	}

	public long getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(long idConsulta) {
		this.idConsulta = idConsulta;
	}

	public String getDescricaoConsulta() {
		return descricaoConsulta;
	}

	public void setDescricaoConsulta(String descricaoConsulta) {
		this.descricaoConsulta = descricaoConsulta;
	}

	public String getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	
	public String getHoraConsulta() {
		return horaConsulta;
	}

	public void setHoraConsulta(String horaConsulta) {
		this.horaConsulta = horaConsulta;
	}

	public int getSalaConsulta() {
		return salaConsulta;
	}

	public void setSalaConsulta(int salaConsulta) {
		this.salaConsulta = salaConsulta;
	}

	public double getPrecoConsulta() {
		return precoConsulta;
	}

	public void setPrecoConsulta(double precoConsulta) {
		this.precoConsulta = precoConsulta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	@Override
	public String toString() {
		return "\nID consulta: " + idConsulta + "\nDescrição: "
				+ descricaoConsulta + "\nData: " + dataConsulta + "\nHora: " + horaConsulta
				+ "\nSala: " + salaConsulta + " \nPreço: " + precoConsulta;
	}
}