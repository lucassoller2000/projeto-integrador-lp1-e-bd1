package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojo.Ferramenta;

public class FerramentaDAO implements GenericDAO<Ferramenta>{
	
	private ConexaoMysql conexao;
	
	CirurgiaFerramentaDAO cfDAO = new CirurgiaFerramentaDAO();
	
	public FerramentaDAO(){
		this.conexao= new ConexaoMysql("localhost","Hospital","root","");
	}
	public Ferramenta salvar(Ferramenta ferramenta){
		String slqInsert = "INSERT INTO ferramenta VALUES(null, ?, ?, ?, ?)";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(slqInsert, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, ferramenta.getNomeFerramenta());
			statement.setString(2, ferramenta.getTipoFerramenta());
			statement.setString(3, ferramenta.getMaterial());
			statement.setLong(4, ferramenta.getQuantidadeFerramenta());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if(rs.next()) {
				ferramenta.setIdFerramenta(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return ferramenta;
	}
	public void excluir(long id){
		cfDAO.excluirPorIdFerramenta(id);
		
		String slqDelete= "DELETE FROM ferramenta WHERE id_ferramenta=?";
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
	public void editar(Ferramenta ferramenta){
		String slqEdit= "UPDATE ferramenta set nome_ferramenta=?, tipo_ferramenta=?, material=?, quantidade_ferramenta=? WHERE id_ferramenta=?";
		this.conexao.abrirConexao();
		try{
			PreparedStatement statement=this.conexao.getConexao().prepareStatement(slqEdit);
			statement.setString(1, ferramenta.getNomeFerramenta());
			statement.setString(2, ferramenta.getTipoFerramenta());
			statement.setString(3, ferramenta.getMaterial());
			statement.setLong(4, ferramenta.getQuantidadeFerramenta());
			statement.setLong(5, ferramenta.getIdFerramenta());
			statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	public List<Ferramenta> buscarTodos(){
		List<Ferramenta> listaFerramentas = new ArrayList<Ferramenta>();
		String sqlBuscarTodos= "SELECT * FROM ferramenta";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarTodos);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				Ferramenta ferramenta= new Ferramenta();
				ferramenta.setIdFerramenta(rs.getLong("id_ferramenta"));
				ferramenta.setNomeFerramenta(rs.getString("nome_ferramenta"));
				ferramenta.setTipoFerramenta(rs.getString("tipo_ferramenta"));
				ferramenta.setMaterial(rs.getString("material"));
				ferramenta.setQuantidadeFerramenta(rs.getInt("quantidade_ferramenta"));
				listaFerramentas.add(ferramenta);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaFerramentas;
	}public Ferramenta buscarPorId(long id){
		Ferramenta ferramenta=null;
		String sqlBuscarPorId = "SELECT * FROM ferramenta WHERE id_ferramenta=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarPorId);
			statement.setLong(1,id);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				ferramenta= new Ferramenta();
				ferramenta.setIdFerramenta(rs.getLong("id_ferramenta"));
				ferramenta.setNomeFerramenta(rs.getString("nome_ferramenta"));
				ferramenta.setTipoFerramenta(rs.getString("tipo_ferramenta"));
				ferramenta.setMaterial(rs.getString("material"));
				ferramenta.setQuantidadeFerramenta(rs.getInt("quantidade_ferramenta"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return ferramenta;
	}
	
}
