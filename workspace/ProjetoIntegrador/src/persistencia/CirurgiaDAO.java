package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojo.Cirurgia;
import pojo.Medico;
import pojo.Usuario;

public class CirurgiaDAO implements GenericDAO<Cirurgia>{
	
	CirurgiaFerramentaDAO cfDAO = new CirurgiaFerramentaDAO();
	Usuario usuario = new Usuario();
	Medico medico = new Medico();
	
	private ConexaoMysql conexao;
	public CirurgiaDAO(){
		this.conexao= new ConexaoMysql("localhost","Hospital","root","");
	}
	public Cirurgia salvar(Cirurgia cirurgia){
		String slqInsert = "INSERT INTO cirurgia VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(slqInsert, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, cirurgia.getTipoCirurgia());
			statement.setString(2, cirurgia.getDescricaoCirurgia());
			statement.setString(3, cirurgia.getDataCirurgia());
			statement.setString(4, cirurgia.getHoraCirurgia());
			statement.setInt(5, cirurgia.getSalaCirurgia());
			statement.setDouble(6, cirurgia.getPrecoCirurgia());			
			statement.setLong(7, cirurgia.getUsuario().getIdUsuario());
			statement.setLong(8, cirurgia.getMedico().getIdMedico());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if(rs.next()) {
				cirurgia.setIdCirurgia(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return cirurgia;
	}
	public void excluir(long id){
		
		cfDAO.excluirPorIdCirurgia(id);
		
		String slqDelete= "DELETE FROM cirurgia WHERE id_cirurgia=?";
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
	public void excluirPorIdUsuario(long id){
		String slqDelete= "DELETE FROM cirurgia WHERE id_usuario=?";
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
		String slqDelete= "DELETE FROM cirurgia WHERE id_medico=?";
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
	public void editar(Cirurgia cirurgia){
		String slqEdit= "UPDATE cirurgia SET tipo_cirurgia=?, descricao_cirurgia=?, data_cirurgia=?, hora_cirurgia=?, sala_cirurgia=?, preco_cirurgia=? WHERE id_cirurgia=?";
		this.conexao.abrirConexao();
		try{
			PreparedStatement statement=this.conexao.getConexao().prepareStatement(slqEdit);
			statement.setString(1, cirurgia.getTipoCirurgia());
			statement.setString(2, cirurgia.getDescricaoCirurgia());
			statement.setString(3, cirurgia.getDataCirurgia());
			statement.setString(4, cirurgia.getHoraCirurgia());
			statement.setInt(5, cirurgia.getSalaCirurgia());
			statement.setDouble(6, cirurgia.getPrecoCirurgia());	
			statement.setLong(7, cirurgia.getIdCirurgia());
			statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	public List<Cirurgia> buscarTodos(){
		List<Cirurgia> listaCirurgia = new ArrayList<Cirurgia>();
		String sqlBuscarTodos= "SELECT * FROM cirurgia";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarTodos);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				Cirurgia cirurgia= new Cirurgia();
				Medico medico = new Medico();
				Usuario usuario = new Usuario();
				cirurgia.setIdCirurgia(rs.getLong("id_cirurgia"));
				cirurgia.setTipoCirurgia(rs.getString("tipo_cirurgia"));
				cirurgia.setDescricaoCirurgia(rs.getString("descricao_cirurgia"));
				cirurgia.setDataCirurgia(rs.getString("data_cirurgia"));
				cirurgia.setHoraCirurgia(rs.getString("hora_cirurgia"));
				cirurgia.setSalaCirurgia(rs.getInt("sala_cirurgia"));
				cirurgia.setPrecoCirurgia(rs.getDouble("preco_cirurgia"));
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				medico.setIdMedico(rs.getLong("id_medico"));
				cirurgia.setUsuario(usuario);
				cirurgia.setMedico(medico);
				listaCirurgia.add(cirurgia);		
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaCirurgia;
	}
	
	public Cirurgia buscarPorId(long id){
		Cirurgia cirurgia=null;
		String sqlBuscarPorId = "SELECT * FROM cirurgia WHERE id_cirurgia=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarPorId);
			statement.setLong(1,id);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				cirurgia= new Cirurgia();
				cirurgia.setIdCirurgia(rs.getLong("id_cirurgia"));
				cirurgia.setTipoCirurgia(rs.getString("tipo_cirurgia"));
				cirurgia.setDescricaoCirurgia(rs.getString("descricao_cirurgia"));
				cirurgia.setDataCirurgia(rs.getString("data_cirurgia"));
				cirurgia.setHoraCirurgia(rs.getString("hora_cirurgia"));
				cirurgia.setSalaCirurgia(rs.getInt("sala_cirurgia"));
				cirurgia.setPrecoCirurgia(rs.getDouble("preco_cirurgia"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return cirurgia;
	}
	
	public Cirurgia buscarPorIdUsuario(long id){
		Cirurgia cirurgia=null;
		String sqlBuscarPorIdUsuario = "SELECT * FROM cirurgia WHERE id_usuario=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarPorIdUsuario);
			statement.setLong(1,id);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				cirurgia= new Cirurgia();
				cirurgia.setIdCirurgia(rs.getLong("id_cirurgia"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return cirurgia;
	}
	public Cirurgia buscarPorIdMedico(long id){
		Cirurgia cirurgia=null;
		String sqlBuscarPorIdMedico = "SELECT * FROM cirurgia WHERE id_medico=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarPorIdMedico);
			statement.setLong(1,id);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				cirurgia= new Cirurgia();
				cirurgia.setIdCirurgia(rs.getLong("id_cirurgia"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return cirurgia;
	}
}