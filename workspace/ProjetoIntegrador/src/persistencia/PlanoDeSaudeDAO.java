package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojo.PlanoDeSaude;


public class PlanoDeSaudeDAO implements GenericDAO<PlanoDeSaude>{
	private ConexaoMysql conexao;
	public PlanoDeSaudeDAO(){
		this.conexao= new ConexaoMysql("localhost","Hospital","root","");
	}
	public PlanoDeSaude salvar(PlanoDeSaude planoDeSaude){
		String slqInsert = "INSERT INTO plano_de_saude VALUES(null, ?, ?, ?, ?, ?)";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(slqInsert, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1,planoDeSaude.getBeneficios());
			statement.setString(2,planoDeSaude.getCategoria());
			statement.setString(3,planoDeSaude.getDataEmissao());
			statement.setString(4,planoDeSaude.getValidade());
			statement.setString(5,planoDeSaude.getEmpresaPlano());	
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if(rs.next()) {
				planoDeSaude.setIdPlano(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return planoDeSaude;
	}
	public void excluir(long id){
		String slqDelete= "DELETE FROM plano_de_saude WHERE id_plano=?";
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
	public void editar(PlanoDeSaude planoDeSaude){
		String slqEdit= "UPDATE plano_de_saude SET beneficios=?, categoria=?, data_emissao=?, validade=?, empresa_plano=? WHERE id_plano=?";
		this.conexao.abrirConexao();
		try{
			PreparedStatement statement=this.conexao.getConexao().prepareStatement(slqEdit);
			statement.setInt(1,planoDeSaude.getBeneficios());
			statement.setString(2,planoDeSaude.getCategoria());
			statement.setString(3,planoDeSaude.getDataEmissao());
			statement.setString(4,planoDeSaude.getValidade());
			statement.setString(5,planoDeSaude.getEmpresaPlano());
			statement.setLong(6,planoDeSaude.getIdPlano());
			statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			this.conexao.fecharConexao();
		}
	}public List<PlanoDeSaude> buscarTodos(){
		List<PlanoDeSaude> listaPlanos = new ArrayList<PlanoDeSaude>();
		String sqlBuscarTodos= "SELECT * FROM plano_de_saude";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarTodos);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				PlanoDeSaude planoDeSaude = new PlanoDeSaude();
				planoDeSaude.setIdPlano(rs.getLong("id_plano"));
				planoDeSaude.setBeneficios(rs.getInt("beneficios"));
				planoDeSaude.setCategoria(rs.getString("categoria"));
				planoDeSaude.setDataEmissao(rs.getString("data_emissao"));
				planoDeSaude.setValidade(rs.getString("validade"));
				planoDeSaude.setEmpresaPlano(rs.getString("empresa_plano"));
				listaPlanos.add(planoDeSaude);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaPlanos;
	}
	public int buscarBeneficioPorId(long id){
		PlanoDeSaude planoDeSaude=null;
		String sqlBuscarBeneficioPorId = "SELECT beneficios FROM plano_de_saude INNER JOIN usuario ON usuario.id_plano= plano_de_saude.id_plano WHERE id_usuario=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarBeneficioPorId);			
			statement.setLong(1,id);
			ResultSet rs=statement.executeQuery();

			while(rs.next()){
				planoDeSaude= new PlanoDeSaude();
				planoDeSaude.setBeneficios(rs.getInt("beneficios"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return planoDeSaude.getBeneficios();
	}
	public PlanoDeSaude buscarPorId(long id){
		PlanoDeSaude planoDeSaude=null;
		String sqlBuscarPorId = "SELECT * FROM plano_de_saude WHERE id_plano=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarPorId);			
			statement.setLong(1,id);
			ResultSet rs=statement.executeQuery();

			while(rs.next()){;
				planoDeSaude = new PlanoDeSaude();
				planoDeSaude.setIdPlano(rs.getLong("id_plano"));
				planoDeSaude.setBeneficios(rs.getInt("beneficios"));
				planoDeSaude.setCategoria(rs.getString("categoria"));
				planoDeSaude.setDataEmissao(rs.getString("data_emissao"));
				planoDeSaude.setValidade(rs.getString("validade"));
				planoDeSaude.setEmpresaPlano(rs.getString("empresa_plano"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return planoDeSaude;
	}
	public List<PlanoDeSaude> buscarPorIdPlano(long id){
		PlanoDeSaude planoDeSaude=null;
		List<PlanoDeSaude> listaPlanoDeSaude = new ArrayList<PlanoDeSaude>();
		String sqlBuscarPorIdPlano = "SELECT * FROM plano_de_saude WHERE id_plano=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarPorIdPlano);			
			statement.setLong(1,id);
			ResultSet rs=statement.executeQuery();

			while(rs.next()){;
				planoDeSaude = new PlanoDeSaude();
				planoDeSaude.setIdPlano(rs.getLong("id_plano"));
				planoDeSaude.setBeneficios(rs.getInt("beneficios"));
				planoDeSaude.setCategoria(rs.getString("categoria"));
				planoDeSaude.setDataEmissao(rs.getString("data_emissao"));
				planoDeSaude.setValidade(rs.getString("validade"));
				planoDeSaude.setEmpresaPlano(rs.getString("empresa_plano"));
				listaPlanoDeSaude.add(planoDeSaude);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaPlanoDeSaude;
	}
}
