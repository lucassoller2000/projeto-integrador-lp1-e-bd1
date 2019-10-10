package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMysql {
	private Connection conexao;
	private String ip;
	private String nomeBd;
	private String login;
	private String senha;

	public ConexaoMysql(String ip, String nomeBd, String login, String senha) {

		this.ip = ip;
		this.nomeBd = nomeBd;
		this.login = login;
		this.senha = senha;
	}

	public Connection getConexao(){
		return conexao;
	}
	
	public void abrirConexao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String endereco = "jdbc:mysql://" + this.ip + "/" + this.nomeBd;
			this.conexao = DriverManager.getConnection(endereco, login, senha);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void fecharConexao() {

		if (this.conexao != null) {
			// VERIFICAR A CONEX�O
			try {
				if (!this.conexao.isClosed()) {

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

