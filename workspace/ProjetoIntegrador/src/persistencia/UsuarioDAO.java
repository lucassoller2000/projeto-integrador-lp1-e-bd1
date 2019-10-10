package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Cirurgia;
import pojo.Endereco;
import pojo.Medicamento;
import pojo.PlanoDeSaude;
import pojo.Usuario;
import pojo.UsuarioMedicamento;

public class UsuarioDAO implements GenericDAO<Usuario>{
	private ConexaoMysql conexao;
	
	EnderecoDAO endDAO = new EnderecoDAO();
	PlanoDeSaudeDAO planoDAO= new PlanoDeSaudeDAO();	
	MedicoDAO medDAO = new MedicoDAO();
	FerramentaDAO ferDAO = new FerramentaDAO();
	CirurgiaDAO cirDAO = new CirurgiaDAO();
	ConsultaDAO consDAO = new ConsultaDAO();
	UsuarioMedicamentoDAO umDAO = new UsuarioMedicamentoDAO();
	CirurgiaFerramentaDAO cfDAO = new CirurgiaFerramentaDAO();
	MedicamentoDAO mediDAO = new MedicamentoDAO();
	DoacaoSangueDAO doaDAO = new DoacaoSangueDAO();
	PlanoDeSaude planoDeSaude = new PlanoDeSaude();
	UsuarioMedicamento usuarioMedicamento = new UsuarioMedicamento();
	Medicamento medicamento = new Medicamento();
	Cirurgia cirurgia = new Cirurgia();
	Usuario usuario, user;
	Endereco endereco;

	public UsuarioDAO() {
		this.conexao = new ConexaoMysql("localhost", "Hospital", "root", "");
	}

	public Usuario salvar(Usuario usuario) {
		String slqInsert = "INSERT INTO usuario VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(slqInsert,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, usuario.getNomeUsuario());
			statement.setInt(2, usuario.getIdade());
			statement.setString(3, usuario.getTipoSangue());
			statement.setString(4, usuario.getDataNasc());
			statement.setString(5, usuario.getEstadoCivil());
			statement.setString(6, usuario.getCpfUsuario());
			statement.setString(7, usuario.getSexoUsuario());
			statement.setDouble(8, usuario.getPeso());
			statement.setDouble(9, usuario.getRenda());
			statement.setString(10, usuario.getTipoUsuario());
			statement.setString(11, usuario.getTelefoneCasa());
			statement.setString(12, usuario.getTelefoneCelular());
			statement.setString(13, usuario.getTelefoneCasa());
			statement.setLong(14, usuario.getPlanoDeSaude().getIdPlano());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				usuario.setIdUsuario(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return usuario;
	}

	public Usuario salvarSemPlano(Usuario usuario) {
		String slqInsert = "INSERT INTO usuario VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null)";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(slqInsert,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, usuario.getNomeUsuario());
			statement.setInt(2, usuario.getIdade());
			statement.setString(3, usuario.getTipoSangue());
			statement.setString(4, usuario.getDataNasc());
			statement.setString(5, usuario.getEstadoCivil());
			statement.setString(6, usuario.getCpfUsuario());
			statement.setString(7, usuario.getSexoUsuario());
			statement.setDouble(8, usuario.getPeso());
			statement.setDouble(9, usuario.getRenda());
			statement.setString(10, usuario.getTipoUsuario());
			statement.setString(11, usuario.getTelefoneCasa());
			statement.setString(12, usuario.getTelefoneCelular());
			statement.setString(13, usuario.getTelefoneCasa());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				usuario.setIdUsuario(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return usuario;
	}

	public void excluir(long id) {
		
		endDAO.excluir(id);
		cirurgia= cirDAO.buscarPorIdUsuario(id);
		if(cirurgia != null){
			cfDAO.excluirPorIdCirurgia(cirurgia.getIdCirurgia());
			cirDAO.excluirPorIdUsuario(id);
		}
		consDAO.excluirPorIdUsuario(id);
		umDAO.excluirPorIdUsuario(id);
		doaDAO.excluirPorIdDoador(id);
		doaDAO.excluirPorIdReceptor(id);
		
		String slqDelete = "DELETE FROM usuario WHERE id_usuario=?";
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

	public void editar(Usuario usuario) {
		String slqEdit = "UPDATE usuario SET nome_usuario=?, idade_usuario=?, tipo_sanguineo=?, data_nasc=?, estado_civil=?, cpf_usuario=?, sexo_usuario=?, peso=?, renda=?, tipo_usuario=?, telefone_casa=?, telefone_celular=?, telefone_familia=?, id_plano=? WHERE id_usuario=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(slqEdit);
			statement.setString(1, usuario.getNomeUsuario());
			statement.setInt(2, usuario.getIdade());
			statement.setString(3, usuario.getTipoSangue());
			statement.setString(4, usuario.getDataNasc());
			statement.setString(5, usuario.getEstadoCivil());
			statement.setString(6, usuario.getCpfUsuario());
			statement.setString(7, usuario.getSexoUsuario());
			statement.setDouble(8, usuario.getPeso());
			statement.setDouble(9, usuario.getRenda());
			statement.setString(10, usuario.getTipoUsuario());
			statement.setString(11, usuario.getTelefoneCasa());
			statement.setString(12, usuario.getTelefoneCelular());
			statement.setString(13, usuario.getTelefoneCasa());
			statement.setLong(14, usuario.getPlanoDeSaude().getIdPlano());
			statement.setLong(15, usuario.getIdUsuario());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public List<Usuario> buscarTodos() {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		String sqlBuscarTodos = "SELECT * FROM usuario";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarTodos);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNomeUsuario(rs.getString("nome_usuario"));
				usuario.setIdade(rs.getInt("idade_usuario"));
				usuario.setTipoSangue(rs.getString("tipo_sanguineo"));
				usuario.setDataNasc(rs.getString("data_nasc"));
				usuario.setEstadoCivil(rs.getString("estado_civil"));
				usuario.setCpfUsuario(rs.getString("cpf_usuario"));
				usuario.setSexoUsuario(rs.getString("sexo_usuario"));
				usuario.setPeso(rs.getDouble("peso"));
				usuario.setRenda(rs.getDouble("renda"));
				usuario.setTipoUsuario(rs.getString("tipo_usuario"));
				usuario.setTelefoneCasa(rs.getString("telefone_casa"));
				usuario.setTelefoneCelular(rs.getString("telefone_celular"));
				usuario.setTelefoneFamilia(rs.getString("telefone_familia"));
				listaUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaUsuarios;
	}

	public List<Usuario> buscarPacientes() {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		String sqlBuscarPacientes = "SELECT * FROM usuario WHERE tipo_usuario='paciente'";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarPacientes);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNomeUsuario(rs.getString("nome_usuario"));
				usuario.setIdade(rs.getInt("idade_usuario"));
				usuario.setTipoSangue(rs.getString("tipo_sanguineo"));
				usuario.setDataNasc(rs.getString("data_nasc"));
				usuario.setEstadoCivil(rs.getString("estado_civil"));
				usuario.setCpfUsuario(rs.getString("cpf_usuario"));
				usuario.setSexoUsuario(rs.getString("sexo_usuario"));
				usuario.setPeso(rs.getDouble("peso"));
				usuario.setRenda(rs.getDouble("renda"));
				usuario.setTipoUsuario(rs.getString("tipo_usuario"));
				usuario.setTelefoneCasa(rs.getString("telefone_casa"));
				usuario.setTelefoneCelular(rs.getString("telefone_celular"));
				usuario.setTelefoneFamilia(rs.getString("telefone_familia"));
				listaUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaUsuarios;
	}
	public List<Usuario> buscarDoadores() {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		String sqlBuscarDoadores = "SELECT * FROM usuario WHERE tipo_usuario='doador'";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarDoadores);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNomeUsuario(rs.getString("nome_usuario"));
				usuario.setIdade(rs.getInt("idade_usuario"));
				usuario.setTipoSangue(rs.getString("tipo_sanguineo"));
				usuario.setDataNasc(rs.getString("data_nasc"));
				usuario.setEstadoCivil(rs.getString("estado_civil"));
				usuario.setCpfUsuario(rs.getString("cpf_usuario"));
				usuario.setSexoUsuario(rs.getString("sexo_usuario"));
				usuario.setPeso(rs.getDouble("peso"));
				usuario.setRenda(rs.getDouble("renda"));
				usuario.setTelefoneCasa(rs.getString("telefone_casa"));
				usuario.setTelefoneCelular(rs.getString("telefone_celular"));
				usuario.setTelefoneFamilia(rs.getString("telefone_familia"));
				listaUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaUsuarios;
	}

	public List<Usuario> buscarReceptores() {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		String sqlBuscarReceptores = "SELECT * FROM usuario WHERE tipo_usuario='receptor'";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarReceptores);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNomeUsuario(rs.getString("nome_usuario"));
				usuario.setIdade(rs.getInt("idade_usuario"));
				usuario.setTipoSangue(rs.getString("tipo_sanguineo"));
				usuario.setDataNasc(rs.getString("data_nasc"));
				usuario.setEstadoCivil(rs.getString("estado_civil"));
				usuario.setCpfUsuario(rs.getString("cpf_usuario"));
				usuario.setSexoUsuario(rs.getString("sexo_usuario"));
				usuario.setPeso(rs.getDouble("peso"));
				usuario.setRenda(rs.getDouble("renda"));
				usuario.setTelefoneCasa(rs.getString("telefone_casa"));
				usuario.setTelefoneCelular(rs.getString("telefone_celular"));
				usuario.setTelefoneFamilia(rs.getString("telefone_familia"));
				listaUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaUsuarios;
	}

	public long buscarPlanoPorId(long id) {
		String sqlBuscarPlanoPorId = "SELECT id_plano FROM usuario WHERE id_usuario=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarPlanoPorId);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				planoDeSaude.setIdPlano(rs.getLong("id_plano"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return planoDeSaude.getIdPlano();
	}
	
	public double buscarRendaPorId(long id) {
		Usuario usuario = null;
		String sqlBuscarRendaPorId = "SELECT renda FROM usuario WHERE id_usuario=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarRendaPorId);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				usuario = new Usuario();
				usuario.setRenda(rs.getDouble("renda"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return usuario.getRenda();
	}
	public Usuario buscarPorId(long id) {
		Usuario usuario = null;
		String sqlBuscarPorId = "SELECT * FROM usuario WHERE id_usuario=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlBuscarPorId);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNomeUsuario(rs.getString("nome_usuario"));
				usuario.setIdade(rs.getInt("idade_usuario"));
				usuario.setTipoSangue(rs.getString("tipo_sanguineo"));
				usuario.setDataNasc(rs.getString("data_nasc"));
				usuario.setEstadoCivil(rs.getString("estado_civil"));
				usuario.setCpfUsuario(rs.getString("cpf_usuario"));
				usuario.setSexoUsuario(rs.getString("sexo_usuario"));
				usuario.setPeso(rs.getDouble("peso"));
				usuario.setRenda(rs.getDouble("renda"));
				usuario.setTipoUsuario(rs.getString("tipo_usuario"));
				usuario.setTelefoneCasa(rs.getString("telefone_casa"));
				usuario.setTelefoneCelular(rs.getString("telefone_celular"));
				usuario.setTelefoneFamilia(rs.getString("telefone_familia"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return usuario;
	}
}