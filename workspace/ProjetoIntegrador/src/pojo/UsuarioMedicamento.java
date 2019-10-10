package pojo;

public class UsuarioMedicamento {

	private long idUsuarioMedicamento;
	private Usuario usuario;
	private Medicamento medicamento;

	public UsuarioMedicamento() {

	}

	public UsuarioMedicamento(long idUsuarioMedicamento, Usuario usuario, Medicamento medicamento) {
		this.idUsuarioMedicamento = idUsuarioMedicamento;
		this.usuario = usuario;
		this.medicamento = medicamento;
	}

	public long getIdUsuarioMedicamento() {
		return idUsuarioMedicamento;
	}

	public void setIdUsuarioMedicamento(long idUsuarioMedicamento) {
		this.idUsuarioMedicamento = idUsuarioMedicamento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	@Override
	public String toString() {
		return "\nID usuarioMedicamento: " + idUsuarioMedicamento + " \nID medicamento: "
				+ medicamento.getIdMedicamento() + "\nTipo de medicamento: " + medicamento.getTipoMedicamento()
				+ "\nQuantidade de medicamento: " + medicamento.getQuantidadeMedicamento() + "\nHorário medicamento: "
				+ medicamento.getHoraMedicamento();
	}

}