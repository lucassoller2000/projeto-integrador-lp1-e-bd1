package pojo;

public class CirurgiaFerramenta {
	private long idCirurgiaFerramenta;
	private Cirurgia cirurgia;
	private Ferramenta ferramenta;
	
	public CirurgiaFerramenta() {
	
	}

	public CirurgiaFerramenta(long idCirurgiaFerramenta, Cirurgia cirurgia, Ferramenta ferramenta) {
		this.idCirurgiaFerramenta = idCirurgiaFerramenta;
		this.cirurgia = cirurgia;
		this.ferramenta = ferramenta;
	}

	public long getIdCirurgiaFerramenta() {
		return idCirurgiaFerramenta;
	}

	public void setIdCirurgiaFerramenta(long idCirurgiaFerramenta) {
		this.idCirurgiaFerramenta = idCirurgiaFerramenta;
	}

	public Cirurgia getCirurgia() {
		return cirurgia;
	}

	public void setCirurgia(Cirurgia cirurgia) {
		this.cirurgia = cirurgia;
	}

	public Ferramenta getFerramenta() {
		return ferramenta;
	}

	public void setFerramenta(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
	}

	@Override
	public String toString() {
		return "\nID cirurgiaFerramenta: " + idCirurgiaFerramenta + "\nID ferramenta: " + ferramenta.getIdFerramenta()
				+ "\nNome da ferramenta: " + ferramenta.getNomeFerramenta() + "\nTipo de ferramenta: "
				+ ferramenta.getTipoFerramenta() + "\nMaterial da ferramenta: " + ferramenta.getMaterial()
				+ "\nQuantidade da ferramenta: " + ferramenta.getQuantidadeFerramenta();
	}

}