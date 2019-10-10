package persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Cirurgia;
import pojo.Medico;

public class MedicoDAO implements GenericDAO<Medico>{
	private ConexaoMysql conexao;
	
	ConsultaDAO conDAO = new ConsultaDAO();
	CirurgiaDAO cirDAO = new CirurgiaDAO();
	CirurgiaFerramentaDAO cfDAO = new CirurgiaFerramentaDAO();
	Cirurgia cirurgia = new Cirurgia();
	
	public MedicoDAO(){
		this.conexao= new ConexaoMysql("localhost","Hospital","root","");
	}
	public Medico salvar(Medico medico){
		String slqInsert = "INSERT INTO medico VALUES(null, ?, ?, ?, ?, ?, ?)";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(slqInsert, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, medico.getNomeMedico());
			statement.setInt(2, medico.getIdadeMedico());
			statement.setString(3, medico.getEspecializacao());
			statement.setString(4, medico.getCpfMedico());
			statement.setString(5, medico.getSexoMedico());
			statement.setString(6, medico.getTelefone());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if(rs.next()) {
				medico.setIdMedico(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return medico;
	}
	public void excluir(long id){
		
		cirurgia= cirDAO.buscarPorIdMedico(id);
		if(cirurgia!=null){
			cfDAO.excluirPorIdCirurgia(cirurgia.getIdCirurgia());
			cirDAO.excluirPorIdMedico(id);	
		}
		conDAO.excluirPorIdMedico(id);

		String slqDelete= "DELETE FROM medico WHERE id_medico=?";
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
	public void editar(Medico medico){
		String slqEdit= "UPDATE medico SET nome_medico=?, idade_medico=?, especializacao=?, cpf_medico=?, sexo_medico=?, telefone=? WHERE id_medico=?";
		this.conexao.abrirConexao();
		try{
			PreparedStatement statement=this.conexao.getConexao().prepareStatement(slqEdit);
			statement.setString(1, medico.getNomeMedico());
			statement.setInt(2, medico.getIdadeMedico());
			statement.setString(3, medico.getEspecializacao());
			statement.setString(4, medico.getCpfMedico());
			statement.setString(5, medico.getSexoMedico());
			statement.setString(6, medico.getTelefone());
			statement.setLong(7, medico.getIdMedico());
			statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	public List<Medico> buscarTodos(){
		List<Medico> listaMedicos = new ArrayList<Medico>();
		String sqlBuscarTodos= "SELECT * FROM medico";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarTodos);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				Medico medico= new Medico();
				medico.setIdMedico(rs.getLong("id_medico"));
				medico.setIdadeMedico(rs.getInt("idade_medico"));
				medico.setNomeMedico(rs.getString("nome_medico"));
				medico.setEspecializacao(rs.getString("especializacao"));
				medico.setCpfMedico(rs.getString("cpf_medico"));
				medico.setSexoMedico(rs.getString("sexo_medico"));
				medico.setTelefone(rs.getString("telefone"));
				listaMedicos.add(medico);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaMedicos;
	}
	public Medico buscarPorId(long id){
		Medico medico= null;
		String sqlBuscarPorId= "SELECT * FROM medico WHERE id_medico=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarPorId);
			statement.setLong(1,id);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				medico= new Medico();
				medico.setIdMedico(rs.getLong("id_medico"));
				medico.setIdadeMedico(rs.getInt("idade_medico"));
				medico.setNomeMedico(rs.getString("nome_medico"));
				medico.setEspecializacao(rs.getString("especializacao"));
				medico.setCpfMedico(rs.getString("cpf_medico"));
				medico.setSexoMedico(rs.getString("sexo_medico"));
				medico.setTelefone(rs.getString("telefone"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return medico;
	}
}