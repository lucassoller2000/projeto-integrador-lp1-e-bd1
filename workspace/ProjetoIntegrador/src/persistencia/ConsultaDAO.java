package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Consulta;
import pojo.Medico;
import pojo.Usuario;


public class ConsultaDAO implements GenericDAO<Consulta>{
	private ConexaoMysql conexao;
	
	Usuario usuario = new Usuario();
	Medico medico = new Medico();

	public ConsultaDAO() {
		this.conexao = new ConexaoMysql("localhost", "Hospital", "root", "");
	}

	public Consulta salvar(Consulta consulta) {
		String slqInsert = "INSERT INTO consulta VALUES(null, ?, ?, ?, ?, ?, ?, ?)";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(slqInsert,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, consulta.getDescricaoConsulta());
			statement.setString(2, consulta.getDataConsulta());
			statement.setString(3, consulta.getHoraConsulta());
			statement.setInt(4, consulta.getSalaConsulta());
			statement.setDouble(5, consulta.getPrecoConsulta());
			statement.setLong(6, consulta.getUsuario().getIdUsuario());
			statement.setLong(7, consulta.getMedico().getIdMedico());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				consulta.setIdConsulta(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return consulta;
	}
	
	public void excluir(long id) {
		String slqDelete = "DELETE FROM consulta WHERE id_consulta=?";
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
	public void excluirPorIdUsuario(long id){
		String slqDelete= "DELETE FROM consulta WHERE id_usuario=?";
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
	public void excluirPorIdMedico(long id){
		String slqDelete= "DELETE FROM consulta WHERE id_medico=?";
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
	
	public void editar(Consulta consulta) {
		String slqEdit = "UPDATE consulta set descricao_consulta=?, data_consulta=?, hora_consulta=?, sala_consulta=?, preco_consulta=? WHERE id_consulta=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(slqEdit,Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, consulta.getDescricaoConsulta());
			statement.setString(2, consulta.getDataConsulta());
			statement.setString(3, consulta.getHoraConsulta());
			statement.setInt(4, consulta.getSalaConsulta());
			statement.setDouble(5, consulta.getPrecoConsulta());
			statement.setDouble(6, consulta.getIdConsulta());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public List<Consulta> buscarTodos() {
		List<Consulta> listaConsulta = new ArrayList<Consulta>();
		String sqlBuscarTodos = "SELECT * FROM consulta";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarTodos);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Consulta consulta = new Consulta();
				Medico medico = new Medico();
				Usuario usuario = new Usuario();
				consulta.setIdConsulta(rs.getLong("id_consulta"));
				consulta.setDescricaoConsulta(rs.getString("descricao_consulta"));
				consulta.setDataConsulta(rs.getString("data_consulta"));
				consulta.setSalaConsulta(rs.getInt("sala_consulta"));
				consulta.setHoraConsulta(rs.getString("hora_consulta"));
				consulta.setPrecoConsulta(rs.getDouble("preco_consulta"));
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				medico.setIdMedico(rs.getLong("id_medico"));
				consulta.setUsuario(usuario);
				consulta.setMedico(medico);
				listaConsulta.add(consulta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaConsulta;
	}
}