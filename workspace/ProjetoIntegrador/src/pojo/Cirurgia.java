package pojo;

import java.util.ArrayList;
import java.util.List;

public class Cirurgia {
	private long idCirurgia;
	private String tipoCirurgia;
	private String descricaoCirurgia;
	private String dataCirurgia;
	private String horaCirurgia;
	private int salaCirurgia;
	private double precoCirurgia;
	private Medico medico;
	private Usuario usuario;
	private List<CirurgiaFerramenta> listaCirurgiaFerramenta;
	
	
	public Cirurgia() {
	
	}
	
	public Cirurgia(long idCirurgia, String tipoCirurgia, String descricaoCirurgia, String dataCirurgia,
			String horaCirurgia ,int salaCirurgia, double precoCirurgia, Usuario usuario, Medico medico,
			List<CirurgiaFerramenta> listaCirurgiaFerramenta) {
		this.idCirurgia = idCirurgia;
		this.tipoCirurgia = tipoCirurgia;
		this.descricaoCirurgia = descricaoCirurgia;
		this.dataCirurgia = dataCirurgia;
		this.horaCirurgia = horaCirurgia;
		this.salaCirurgia = salaCirurgia;
		this.precoCirurgia = precoCirurgia;
		this.medico = medico;
		this.usuario = usuario;
		this.listaCirurgiaFerramenta = new ArrayList<CirurgiaFerramenta>();
	}


	public long getIdCirurgia() {
		return idCirurgia;
	}

	public void setIdCirurgia(long idCirurgia) {
		this.idCirurgia = idCirurgia;
	}

	public String getTipoCirurgia() {
		return tipoCirurgia;
	}

	public void setTipoCirurgia(String tipoCirurgia) {
		this.tipoCirurgia = tipoCirurgia;
	}

	public String getDescricaoCirurgia() {
		return descricaoCirurgia;
	}

	public void setDescricaoCirurgia(String descricaoCirurgia) {
		this.descricaoCirurgia = descricaoCirurgia;
	}

	public String getDataCirurgia() {
		return dataCirurgia;
	}

	public void setDataCirurgia(String dataCirurgia) {
		this.dataCirurgia = dataCirurgia;
	}

	public String getHoraCirurgia() {
		return horaCirurgia;
	}

	public void setHoraCirurgia(String horaCirurgia) {
		this.horaCirurgia = horaCirurgia;
	}

	public int getSalaCirurgia() {
		return salaCirurgia;
	}

	public void setSalaCirurgia(int salaCirurgia) {
		this.salaCirurgia = salaCirurgia;
	}

	public double getPrecoCirurgia() {
		return precoCirurgia;
	}

	public void setPrecoCirurgia(double precoCirurgia) {
		this.precoCirurgia = precoCirurgia;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<CirurgiaFerramenta> getListaCirurgiaFerramenta() {
		return listaCirurgiaFerramenta;
	}

	public void setCirurgiaFerramenta(List<CirurgiaFerramenta> listaCirurgiaFerramenta) {
		this.listaCirurgiaFerramenta = listaCirurgiaFerramenta;
	}

	@Override
	public String toString() {
		return "\nID cirurgia: " + idCirurgia + "\nTipo de cirurgia: " + tipoCirurgia + "\nDescrição: "
				+ descricaoCirurgia + "\nData: " + dataCirurgia + "\nHora: " + horaCirurgia
				+ "\nSala: " + salaCirurgia + " \nPreço: " + precoCirurgia;
	}
}