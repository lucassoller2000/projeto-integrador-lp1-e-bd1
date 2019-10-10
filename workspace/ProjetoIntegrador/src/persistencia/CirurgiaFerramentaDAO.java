package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojo.CirurgiaFerramenta;
import pojo.Ferramenta;

public class CirurgiaFerramentaDAO implements GenericDAO<CirurgiaFerramenta>
{
	private ConexaoMysql conexao;
	public CirurgiaFerramentaDAO(){
		this.conexao= new ConexaoMysql("localhost","Hospital","root","");
	}
	public CirurgiaFerramenta salvar(CirurgiaFerramenta cirurgiaFerramenta){
		String slqInsert = "INSERT INTO cirurgia_ferramenta VALUES(null, ?, ?)";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(slqInsert, Statement.RETURN_GENERATED_KEYS);
			statement.setLong(1, cirurgiaFerramenta.getCirurgia().getIdCirurgia());
			statement.setLong(2, cirurgiaFerramenta.getFerramenta().getIdFerramenta());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if(rs.next()) {
				cirurgiaFerramenta.setIdCirurgiaFerramenta(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return cirurgiaFerramenta;
	}
	public void excluir(long id){
		String slqDelete= "DELETE FROM cirurgia_ferramenta WHERE id_cirurgia_ferramenta=?";
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
	
	public void excluirPorIdCirurgia(long id){
		String slqDelete= "DELETE FROM cirurgia_ferramenta WHERE id_cirurgia=?";
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
	
	public void excluirPorIdFerramenta(long id){
		String slqDelete= "DELETE FROM cirurgia_ferramenta WHERE id_ferramenta=?";
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
	public List<CirurgiaFerramenta> buscarPorIdCirurgia(long id){
		List<CirurgiaFerramenta> listaCirurgiaFerramentas = new ArrayList<CirurgiaFerramenta>();
		String sqlBuscarPorIdCirurgia= "SELECT * FROM cirurgia_ferramenta INNER JOIN ferramenta ON cirurgia_ferramenta.id_ferramenta= ferramenta.id_ferramenta WHERE id_cirurgia=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarPorIdCirurgia);
			statement.setLong(1,id);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				CirurgiaFerramenta cirurgiaFerramenta = new CirurgiaFerramenta();
				Ferramenta ferramenta = new Ferramenta();
				cirurgiaFerramenta.setIdCirurgiaFerramenta(rs.getLong("id_cirurgia_ferramenta"));
				ferramenta.setIdFerramenta(rs.getLong("id_ferramenta"));
				ferramenta.setNomeFerramenta(rs.getString("nome_ferramenta"));
				ferramenta.setTipoFerramenta(rs.getString("tipo_ferramenta"));
				ferramenta.setMaterial(rs.getString("material"));
				ferramenta.setQuantidadeFerramenta(rs.getInt("quantidade_ferramenta"));
				cirurgiaFerramenta.setFerramenta(ferramenta);
				listaCirurgiaFerramentas.add(cirurgiaFerramenta);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaCirurgiaFerramentas;
	}
	public List<CirurgiaFerramenta> buscarTodos(){
		List<CirurgiaFerramenta> listaCirurgiaFerramentas = new ArrayList<CirurgiaFerramenta>();
		String sqlBuscarTodos= "SELECT * FROM cirurgia_ferramenta INNER JOIN ferramenta ON cirurgia_ferramenta.id_ferramenta= ferramenta.id_ferramenta";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarTodos);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				CirurgiaFerramenta cirurgiaFerramenta = new CirurgiaFerramenta();
				Ferramenta ferramenta = new Ferramenta();
				cirurgiaFerramenta.setIdCirurgiaFerramenta(rs.getLong("id_cirurgia_ferramenta"));
				ferramenta.setIdFerramenta(rs.getLong("id_ferramenta"));
				ferramenta.setNomeFerramenta(rs.getString("nome_ferramenta"));
				ferramenta.setTipoFerramenta(rs.getString("tipo_ferramenta"));
				ferramenta.setMaterial(rs.getString("material"));
				ferramenta.setQuantidadeFerramenta(rs.getInt("quantidade_ferramenta"));
				cirurgiaFerramenta.setFerramenta(ferramenta);
				listaCirurgiaFerramentas.add(cirurgiaFerramenta);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaCirurgiaFerramentas;
	}
	
	public void editar(CirurgiaFerramenta objeto) throws SQLException {
		
	}
}