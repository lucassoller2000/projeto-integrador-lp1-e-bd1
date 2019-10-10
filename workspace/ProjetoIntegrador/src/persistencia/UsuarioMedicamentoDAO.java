package persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojo.Medicamento;
import pojo.UsuarioMedicamento;

public class UsuarioMedicamentoDAO implements GenericDAO<UsuarioMedicamento>{
	private ConexaoMysql conexao;
	public UsuarioMedicamentoDAO(){
		this.conexao= new ConexaoMysql("localhost","Hospital","root","");
	}


	public UsuarioMedicamento salvar(UsuarioMedicamento usuarioMedicamento){
		String slqInsert = "INSERT INTO  usuario_medicamento VALUES(null, ?, ?)";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(slqInsert, Statement.RETURN_GENERATED_KEYS);
			statement.setLong(1, usuarioMedicamento.getUsuario().getIdUsuario());
			statement.setLong(2, usuarioMedicamento.getMedicamento().getIdMedicamento());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if(rs.next()) {
				usuarioMedicamento.setIdUsuarioMedicamento(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return  usuarioMedicamento;
	}
	public void excluir(long id){
		String slqDelete= "DELETE FROM usuario_medicamento WHERE id_usuario_medicamento=?";
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
		String slqDelete= "DELETE FROM usuario_medicamento WHERE id_usuario=?";
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
	
	public void excluirPorIdMedicamento(long id){
		String slqDelete= "DELETE FROM usuario_medicamento WHERE id_medicamento=?";
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
	
	public List< UsuarioMedicamento> buscarPorIdUsuario(long id){
		List< UsuarioMedicamento> listaUsuarioMedicamento = new ArrayList< UsuarioMedicamento>();
		String sqlBuscarPorIdUsuario= "SELECT * FROM usuario_medicamento INNER JOIN medicamento ON usuario_medicamento.id_medicamento= medicamento.id_medicamento WHERE id_usuario=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarPorIdUsuario);
			statement.setLong(1,id);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				UsuarioMedicamento usuarioMedicamento = new UsuarioMedicamento();
				Medicamento medicamento = new Medicamento();
				usuarioMedicamento.setIdUsuarioMedicamento(rs.getLong("id_usuario_medicamento"));
				medicamento.setIdMedicamento(rs.getLong("id_medicamento"));
				medicamento.setTipoMedicamento(rs.getString("tipo_medicamento"));
				medicamento.setQuantidadeMedicamento(rs.getInt("quantidade_medicamento"));
				medicamento.setHoraMedicamento(rs.getString("hora_medicamento"));
				usuarioMedicamento.setMedicamento(medicamento);
				listaUsuarioMedicamento.add(usuarioMedicamento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaUsuarioMedicamento;
	}
	public List< UsuarioMedicamento> buscarTodos(){
		List< UsuarioMedicamento> listaUsuarioMedicamento = new ArrayList< UsuarioMedicamento>();
		String sqlBuscarTodos= "SELECT * FROM usuario_medicamento INNER JOIN medicamento ON usuario_medicamento.id_medicamento= medicamento.id_medicamento";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarTodos);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				UsuarioMedicamento usuarioMedicamento = new UsuarioMedicamento();
				Medicamento medicamento = new Medicamento();
				usuarioMedicamento.setIdUsuarioMedicamento(rs.getLong("id_usuario_medicamento"));
				medicamento.setIdMedicamento(rs.getLong("id_medicamento"));
				medicamento.setTipoMedicamento(rs.getString("tipo_medicamento"));
				medicamento.setQuantidadeMedicamento(rs.getInt("quantidade_medicamento"));
				medicamento.setHoraMedicamento(rs.getString("hora_medicamento"));
				usuarioMedicamento.setMedicamento(medicamento);
				listaUsuarioMedicamento.add(usuarioMedicamento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaUsuarioMedicamento;
	}

	public void editar(UsuarioMedicamento objeto) throws SQLException {
		
	}
}