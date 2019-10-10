package pojo;

public class DoacaoSangue {

	private long idDoacao;
	private Usuario usuario;

	public DoacaoSangue() {

	}

	public DoacaoSangue(long idDoacao, Usuario usuario) {
		this.idDoacao = idDoacao;
		this.usuario = usuario;
	}

	public long getIdDoacao() {
		return idDoacao;
	}

	public void setIdDoacao(long idDoacao) {
		this.idDoacao = idDoacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String toStringDoador() {
		return "\nID doação: " + idDoacao + "\nID doador: " + usuario.getIdUsuario() + "\nNome " + usuario.getNomeUsuario() + "\nCPF: " + usuario.getCpfUsuario() + "\nTipo sanguíneo: " + usuario.getTipoSangue();
	}

	public String toStringReceptor() {
		return "\nID doação: " + idDoacao + "\nID receptor: " + usuario.getIdUsuario() + "\nNome " + usuario.getNomeUsuario() + "\nCPF: " + usuario.getCpfUsuario() + "\nTipo sanguíneo: " + usuario.getTipoSangue();
	}	
}