package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojo.Medicamento;

public class MedicamentoDAO implements GenericDAO<Medicamento>{
	private ConexaoMysql conexao;
	
	UsuarioMedicamentoDAO umDAO = new UsuarioMedicamentoDAO();

	public MedicamentoDAO() {
		this.conexao = new ConexaoMysql("localhost", "Hospital", "root", "");
	}

	public Medicamento salvar(Medicamento medicamento) {
		String slqInsert = "INSERT INTO medicamento VALUES(null, ?, ?, ?)";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(slqInsert,Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, medicamento.getTipoMedicamento());
			statement.setInt(2, medicamento.getQuantidadeMedicamento());
			statement.setString(3, medicamento.getHoraMedicamento());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				medicamento.setIdMedicamento(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return medicamento;
	}

	public void excluir(long id) {
		
		umDAO.excluirPorIdMedicamento(id);
		
		String slqDelete = "DELETE FROM medicamento WHERE id_medicamento=?";
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

	public void editar(Medicamento medicamento) {
		String slqEdit = "UPDATE medicamento set tipo_medicamento=?, quantidade_medicamento=?, hora_medicamento=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(slqEdit);
			statement.setString(1, medicamento.getTipoMedicamento());
			statement.setInt(2, medicamento.getQuantidadeMedicamento());
			statement.setString(3, medicamento.getHoraMedicamento());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public List<Medicamento> buscarTodos() {
		List<Medicamento> listaMedicamento = new ArrayList<Medicamento>();
		String sqlBuscarTodos = "SELECT * FROM medicamento";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarTodos);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Medicamento medicamento = new Medicamento();
				medicamento.setIdMedicamento(rs.getLong("id_medicamento"));
				medicamento.setTipoMedicamento(rs.getString("tipo_medicamento"));
				medicamento.setQuantidadeMedicamento(rs.getInt("quantidade_medicamento"));
				medicamento.setHoraMedicamento(rs.getString("hora_medicamento"));
				listaMedicamento.add(medicamento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaMedicamento;
	}
	public Medicamento buscarPorId(long id){
		Medicamento  medicamento =null;
		String sqlBuscarPorId = "SELECT * FROM medicamento WHERE id_medicamento=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarPorId);
			statement.setLong(1,id);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				medicamento= new Medicamento();
				medicamento.setIdMedicamento(rs.getLong("id_medicamento"));
				medicamento.setTipoMedicamento(rs.getString("tipo_medicamento"));
				medicamento.setQuantidadeMedicamento(rs.getInt("quantidade_medicamento"));
				medicamento.setHoraMedicamento(rs.getString("hora_medicamento"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return medicamento;
	}
}
