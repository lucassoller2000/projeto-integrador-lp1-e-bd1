package pojo;

public class Endereco {
	
	private long idEndereco;
	private String rua;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	private String cep;
	private String complemento;
	private Usuario usuario;
	
	public Endereco() {
		
	}	
	
	public Endereco(long idEndereco, String rua, int numero, String bairro, String cidade, String estado,
			String pais, String cep, String complemento, Usuario usuario) {
		this.idEndereco = idEndereco;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.cep = cep;
		this.complemento = complemento;
		this.usuario = usuario;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "\nID endereço: " + idEndereco + "\nRua: " + rua + "\nNúmero:" + numero + "\nBairro: " + bairro
				+ "\nCidade: " + cidade + "\nEstado: " + estado + "\nPaís: " + pais + "\nCEP: " + cep + "\nComplemento: "
				+ complemento;
	}	
}