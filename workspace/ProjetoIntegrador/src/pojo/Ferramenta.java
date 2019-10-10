package pojo;

import java.util.ArrayList;
import java.util.List;

public class Ferramenta {
	private long idFerramenta;
	private String nomeFerramenta;
	private String tipoFerramenta;
	private String material;
	private int quantidadeFerramenta;
	private List<CirurgiaFerramenta> listaCirurgiaFerramenta;
	
	public Ferramenta() {
	
	}

	public Ferramenta(long idFerramenta, String nomeFerramenta, String tipoFerramenta, String material,
			int quantidadeFerramenta, List<CirurgiaFerramenta> listaCirurgiaFerramenta) {
		this.idFerramenta = idFerramenta;
		this.nomeFerramenta = nomeFerramenta;
		this.tipoFerramenta = tipoFerramenta;
		this.material = material;
		this.quantidadeFerramenta = quantidadeFerramenta;
		this.listaCirurgiaFerramenta = new ArrayList<CirurgiaFerramenta>();
	}

	public long getIdFerramenta() {
		return idFerramenta;
	}

	public void setIdFerramenta(long idFerramenta) {
		this.idFerramenta = idFerramenta;
	}

	public String getNomeFerramenta() {
		return nomeFerramenta;
	}

	public void setNomeFerramenta(String nomeFerramenta) {
		this.nomeFerramenta = nomeFerramenta;
	}

	public String getTipoFerramenta() {
		return tipoFerramenta;
	}

	public void setTipoFerramenta(String tipoFerramenta) {
		this.tipoFerramenta = tipoFerramenta;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getQuantidadeFerramenta() {
		return quantidadeFerramenta;
	}

	public void setQuantidadeFerramenta(int quantidadeFerramenta) {
		this.quantidadeFerramenta = quantidadeFerramenta;
	}

	public List<CirurgiaFerramenta> getListaCirurgiaFerramenta() {
		return listaCirurgiaFerramenta;
	}

	public void setListaCirurgiaFerramenta(List<CirurgiaFerramenta> listaCirurgiaFerramenta) {
		this.listaCirurgiaFerramenta = listaCirurgiaFerramenta;
	}

	@Override
	public String toString() {
		return "\nID ferramenta: " + idFerramenta + "\nNome: " + nomeFerramenta + "\nTipo: "
				+ tipoFerramenta + "\nMaterial: " + material + "\nQuantidade: " + quantidadeFerramenta;
	}
}