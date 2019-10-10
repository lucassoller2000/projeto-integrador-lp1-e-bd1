package persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojo.Endereco;

public class EnderecoDAO implements GenericDAO<Endereco>{
	private ConexaoMysql conexao;
	public EnderecoDAO(){
		this.conexao= new ConexaoMysql("localhost","Hospital","root","");
	}
	public Endereco salvar(Endereco endereco){
		String slqInsert = "INSERT INTO endereco VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(slqInsert, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, endereco.getRua());
			statement.setInt(2, endereco.getNumero());
			statement.setString(3, endereco.getBairro());
			statement.setString(4, endereco.getComplemento());
			statement.setString(5, endereco.getCidade());
			statement.setString(6, endereco.getEstado());
			statement.setString(7, endereco.getPais());
			statement.setString(8, endereco.getCep());
			statement.setLong(9, endereco.getUsuario().getIdUsuario());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if(rs.next()) {
				endereco.setIdEndereco(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return endereco;
	}
	public void excluir(long id){
		String slqDelete= "DELETE FROM endereco WHERE id_usuario=?";
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
	public void editar(Endereco endereco){
		String slqEdit= "UPDATE endereco SET rua=?, numero=?, bairro=?, complemento=?, cidade=?, estado=?, pais=?, cep=? WHERE id_endereco=?";
		this.conexao.abrirConexao();
		try{
			PreparedStatement statement=this.conexao.getConexao().prepareStatement(slqEdit);
			statement.setString(1, endereco.getRua());
			statement.setInt(2, endereco.getNumero());
			statement.setString(3, endereco.getBairro());
			statement.setString(4, endereco.getComplemento());
			statement.setString(5, endereco.getCidade());
			statement.setString(6, endereco.getEstado());
			statement.setString(7, endereco.getPais());
			statement.setString(8, endereco.getCep());
			statement.setLong(9, endereco.getIdEndereco());
			statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	public List<Endereco> buscarTodos(){
		List<Endereco> listaEnderecos = new ArrayList<Endereco>();
		String sqlBuscarTodos= "SELECT * FROM endereco";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarTodos);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				Endereco endereco= new Endereco();
				endereco.setIdEndereco(rs.getLong("id_endereco"));
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getInt("numero"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setComplemento(rs.getString("complemento"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setPais(rs.getString("pais"));
				endereco.setCep(rs.getString("cep"));
				listaEnderecos.add(endereco);
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaEnderecos;
	}
	public List<Endereco> buscarPorId(long id) {
		Endereco endereco=null;
		List<Endereco> listaEnderecos = new ArrayList<Endereco>();
		String sqlBuscarPorId = "SELECT * FROM endereco WHERE id_usuario=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarPorId);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				endereco = new Endereco();
				endereco.setIdEndereco(rs.getLong("id_endereco"));
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getInt("numero"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setComplemento(rs.getString("complemento"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setPais(rs.getString("pais"));
				endereco.setCep(rs.getString("cep"));
				listaEnderecos.add(endereco);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaEnderecos;
	}
}