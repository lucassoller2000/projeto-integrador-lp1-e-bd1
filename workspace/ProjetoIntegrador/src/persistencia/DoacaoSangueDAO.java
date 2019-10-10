package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojo.DoacaoSangue;
import pojo.Usuario;

public class DoacaoSangueDAO{
	private ConexaoMysql conexao;

	public DoacaoSangueDAO() {
		this.conexao = new ConexaoMysql("localhost", "Hospital", "root", "");
	}
	
	public DoacaoSangue salvarDoador (DoacaoSangue doacaoSangue) {
		String slqInsert = "INSERT INTO doacao_sangue VALUES(null, ?, ?, ?, ?, null)";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(slqInsert,Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, doacaoSangue.getUsuario().getNomeUsuario());
			statement.setString(2, doacaoSangue.getUsuario().getCpfUsuario());
			statement.setString(3, doacaoSangue.getUsuario().getTipoSangue());
			statement.setLong(4, doacaoSangue.getUsuario().getIdUsuario());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				doacaoSangue.setIdDoacao(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return doacaoSangue;
	}
	
	public DoacaoSangue salvarReceptor (DoacaoSangue doacaoSangue) {
		String slqInsert = "INSERT INTO doacao_sangue VALUES(null, ?, ?, ?, null, ?)";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(slqInsert,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, doacaoSangue.getUsuario().getNomeUsuario());
			statement.setString(2, doacaoSangue.getUsuario().getCpfUsuario());
			statement.setString(3, doacaoSangue.getUsuario().getTipoSangue());
			statement.setLong(4, doacaoSangue.getUsuario().getIdUsuario());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				doacaoSangue.setIdDoacao(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return doacaoSangue;
	}

	public void excluir(long id) {
		String slqDelete = "DELETE FROM doacao_sangue WHERE id_doacao=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(slqDelete);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	public void excluirPorIdDoador(long id){
		String slqDelete= "DELETE FROM doacao_sangue WHERE id_doador=?";
		this.conexao.abrirConexao();
		try{
			PreparedStatement statement=this.conexao.getConexao().prepareStatement(slqDelete);
			statement.setLong(1,id);
			statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	public void excluirPorIdReceptor(long id){
		String slqDelete= "DELETE FROM doacao_sangue WHERE id_receptor=?";
		this.conexao.abrirConexao();
		try{
			PreparedStatement statement=this.conexao.getConexao().prepareStatement(slqDelete);
			statement.setLong(1,id);
			statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	public List<DoacaoSangue> buscarDoador(long id){
		List<DoacaoSangue> listaDoador = new ArrayList<DoacaoSangue>();
		String sqlBuscarDoador = "SELECT * FROM doacao_sangue WHERE id_doador=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarDoador);	
			statement.setLong(1, id);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				DoacaoSangue doacaoSangue = new DoacaoSangue();
				Usuario usuario = new Usuario();
				doacaoSangue.setIdDoacao(rs.getLong("id_doacao"));
				usuario.setNomeUsuario(rs.getString("nome_doacao"));
				usuario.setCpfUsuario(rs.getString("cpf_doacao"));
				usuario.setTipoSangue(rs.getString("tipo_sanguineo"));
				usuario.setIdUsuario(rs.getLong("id_doador"));
				doacaoSangue.setUsuario(usuario);
				listaDoador.add(doacaoSangue);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaDoador;
	}
	
	public List<DoacaoSangue> buscarReceptor(long id) {
		List<DoacaoSangue> listaReceptor = new ArrayList<DoacaoSangue>();
		String sqlBuscarReceptor = "SELECT * FROM doacao_sangue WHERE id_receptor=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarReceptor);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				DoacaoSangue doacaoSangue = new DoacaoSangue();
				Usuario usuario = new Usuario();
				doacaoSangue.setIdDoacao(rs.getLong("id_doacao"));
				usuario.setNomeUsuario(rs.getString("nome_doacao"));
				usuario.setCpfUsuario(rs.getString("cpf_doacao"));
				usuario.setTipoSangue(rs.getString("tipo_sanguineo"));
				usuario.setIdUsuario(rs.getLong("id_receptor"));
				doacaoSangue.setUsuario(usuario);
				listaReceptor.add(doacaoSangue);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaReceptor;
	}
}