package pojo;

import java.util.ArrayList;
import java.util.List;

public class Medicamento {

	private long idMedicamento;
	private String tipoMedicamento;
	private int quantidadeMedicamento;
	private String horaMedicamento;
	private List<UsuarioMedicamento> usuarioMedicamento;

	public Medicamento() {

	}

	public Medicamento(long idMedicamento, String tipoMedicamento, int quantidadeMedicamento, String horaMedicamento,
			List<UsuarioMedicamento> usuarioMedicamento) {

		this.idMedicamento = idMedicamento;
		this.tipoMedicamento = tipoMedicamento;
		this.quantidadeMedicamento = quantidadeMedicamento;
		this.horaMedicamento = horaMedicamento;
		this.usuarioMedicamento = new ArrayList<UsuarioMedicamento>();
	}

	public List<UsuarioMedicamento> getUsuarioMedicamento() {
		return usuarioMedicamento;
	}

	public void setUsuarioMedicamento(List<UsuarioMedicamento> usuarioMedicamento) {
		this.usuarioMedicamento = usuarioMedicamento;
	}

	public long getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(long idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public String getTipoMedicamento() {
		return tipoMedicamento;
	}

	public void setTipoMedicamento(String tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}

	public int getQuantidadeMedicamento() {
		return quantidadeMedicamento;
	}

	public void setQuantidadeMedicamento(int quantidadeMedicamento) {
		this.quantidadeMedicamento = quantidadeMedicamento;
	}

	public String getHoraMedicamento() {
		return horaMedicamento;
	}

	public void setHoraMedicamento(String horaMedicamento) {
		this.horaMedicamento = horaMedicamento;
	}

	@Override
	public String toString() {
		return "\nID medicamento: " + idMedicamento + " \ntipo de medicamento: " + tipoMedicamento
				+ " \nQuantidade de medicamento: " + quantidadeMedicamento + " \nhora do medicamento: " + horaMedicamento;
	}
}