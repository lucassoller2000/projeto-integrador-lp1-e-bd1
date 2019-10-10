package apresentacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import persistencia.DoacaoSangueDAO;
import persistencia.EnderecoDAO;
import persistencia.MedicamentoDAO;
import persistencia.PlanoDeSaudeDAO;
import persistencia.UsuarioDAO;
import persistencia.UsuarioMedicamentoDAO;
import pojo.Cirurgia;
import pojo.Endereco;
import pojo.Medicamento;
import pojo.PlanoDeSaude;
import pojo.Usuario;
import pojo.UsuarioMedicamento;

public class UsuarioCadastro {

	UsuarioDAO userDAO = new UsuarioDAO();
	EnderecoDAO endDAO = new EnderecoDAO();
	PlanoDeSaudeDAO planoDAO = new PlanoDeSaudeDAO();
	UsuarioMedicamentoDAO umDAO = new UsuarioMedicamentoDAO();
	MedicamentoDAO mediDAO = new MedicamentoDAO();
	DoacaoSangueDAO doaDAO = new DoacaoSangueDAO();
	PlanoDeSaude planoDeSaude = new PlanoDeSaude();
	UsuarioMedicamento usuarioMedicamento = new UsuarioMedicamento();
	Medicamento medicamento = new Medicamento();
	Mensagem mensagem = new Mensagem();
	Usuario usuario, user;
	Endereco endereco;
	List<Cirurgia> listaCirurgias = new ArrayList<Cirurgia>();
	List<UsuarioMedicamento> listaUsuarioMedicamento = new ArrayList<UsuarioMedicamento>();
	Scanner sc = new Scanner(System.in);

	public void tabelaUsuario() {

		listaCirurgias = null;
		listaUsuarioMedicamento = null;
		planoDeSaude = null;
		String nomeUsuario, dataNasc, cpfUsuario, sexoUsuario, estadoCivil, tipoSangue, tipoUsuario, telefone,
		telefone2, telefone3;
		int idadeUsuario, escolha;
		double peso, renda;
		long id = 0, idMedicamento, idUsuario;

		System.out.println("\n1-Salvar cadastro \n2-Editar cadastro \n3-Excluir cadastro \n4-Cadastrar medicamentos em pacientes \n5-Excluir medicamentos de pacientes \n6-Ver cadastros\n");
		escolha = sc.nextInt();
		if (escolha == 1) {
			System.out.println("\nNome:");
			nomeUsuario = sc.nextLine();
			nomeUsuario = sc.nextLine();
			System.out.println("Idade:");
			idadeUsuario = sc.nextInt();
			System.out.println("Data de nascimento");
			dataNasc = sc.next();
			System.out.println("CPF:");
			cpfUsuario = sc.next();
			System.out.println("Sexo:");
			sexoUsuario = sc.next();
			System.out.println("Peso:");
			peso = sc.nextDouble();
			System.out.println("Estado civil:");
			estadoCivil = sc.next();
			System.out.println("Tipo sanguíneo:");
			tipoSangue = sc.next();
			System.out.println("Renda:");
			renda = sc.nextDouble();
			System.out.println("Tipo de usuário:\n\nPaciente \nDoador \nReceptor");
			tipoUsuario = sc.next();
			System.out.println("Telefone residencial:");
			telefone = sc.next();
			System.out.println("Telefone celular:");
			telefone2 = sc.next();
			System.out.println("Telefone de um parente:");
			telefone3 = sc.next();
			usuario = new Usuario(0, nomeUsuario, idadeUsuario, dataNasc, cpfUsuario, sexoUsuario, peso, estadoCivil,
					tipoSangue, renda, tipoUsuario, telefone, telefone2, telefone3, planoDeSaude,
					listaUsuarioMedicamento, listaCirurgias);
			EnderecoCadastro e = new EnderecoCadastro();
			endereco = e.tabelaEndereco(0);
			if (tipoUsuario.equalsIgnoreCase("paciente")) {
				System.out.println("Possui plano de saúde: \n1-Sim \n2-Não");
				escolha = sc.nextInt();
				if (escolha == 1) {
					List<PlanoDeSaude> listaPlano = planoDAO.buscarTodos();
					mensagem.imprimeListaPlano(listaPlano);
					System.out.println("\nDigite o ID do plano de saúde: \n");
					long idPlano = sc.nextLong();
					planoDeSaude = planoDAO.buscarPorId(idPlano);
					usuario.setPlanoDeSaude(planoDeSaude);
					userDAO.salvar(usuario);
				} else if (escolha == 2) {
					userDAO.salvarSemPlano(usuario);
				}
			} else if (tipoUsuario.equalsIgnoreCase("doador")) {
				userDAO.salvarSemPlano(usuario);
				DoacaoSangueCadastro doa = new DoacaoSangueCadastro();
				doa.tabelaDoacaoSangue(-1, usuario);
			} else if (tipoUsuario.equalsIgnoreCase("receptor")) {
				userDAO.salvarSemPlano(usuario);
				DoacaoSangueCadastro doa = new DoacaoSangueCadastro();
				doa.tabelaDoacaoSangue(0, usuario);
			}
			endereco.setUsuario(usuario);
			endDAO.salvar(endereco);
		} 
		
		else if (escolha == 2) {
			List<Usuario> listaUsuario = userDAO.buscarTodos();
			mensagem.imprimeListaUsuario(listaUsuario);
			System.out.println("\nDigite ID do usuário para editar: \n");
			id = sc.nextLong();
			System.out.println("\nNome:");
			nomeUsuario = sc.nextLine();
			nomeUsuario = sc.nextLine();
			System.out.println("Idade:");
			idadeUsuario = sc.nextInt();
			System.out.println("Data de nascimento");
			dataNasc = sc.next();
			System.out.println("CPF:");
			cpfUsuario = sc.next();
			System.out.println("Sexo:");
			sexoUsuario = sc.next();
			System.out.println("Peso(kg):");
			peso = sc.nextDouble();
			System.out.println("Estado civil:");
			estadoCivil = sc.next();
			System.out.println("Tipo sanguíneo:");
			tipoSangue = sc.next();
			System.out.println("Renda:");
			renda = sc.nextDouble();
			System.out.println("Tipo de usuário:\n\nPaciente \nDoador \nReceptor");
			tipoUsuario = sc.next();
			System.out.println("Telefone residencial:");
			telefone = sc.next();
			System.out.println("Telefone celular:");
			telefone2 = sc.next();
			System.out.println("Telefone de um parente:");
			telefone3 = sc.next();
			usuario = new Usuario(id, nomeUsuario, idadeUsuario, dataNasc, cpfUsuario, sexoUsuario, peso, estadoCivil,
					tipoSangue, renda, tipoUsuario, telefone, telefone2, telefone3, planoDeSaude,
					listaUsuarioMedicamento, listaCirurgias);
			userDAO.salvar(usuario);
		} 
		
		else if (escolha == 3) {
			List<Usuario> listaUsuario = userDAO.buscarTodos();
			mensagem.imprimeListaUsuario(listaUsuario);
			System.out.println("\nDigite o ID do usuário para excluir: \n");
			id = sc.nextLong();		
			userDAO.excluir(id);
		} 
		
		else if (escolha == 4) {
			List<Medicamento> listaMedicamento = mediDAO.buscarTodos();
			mensagem.imprimeListaMedicamento(listaMedicamento);
			System.out.println("\nDigite o ID do medicamento: \n");
			idMedicamento = sc.nextLong();
			List<Usuario> listaUsuario = userDAO.buscarPacientes();
			mensagem.imprimeListaUsuario(listaUsuario);
			System.out.println("\nDigite o ID do paciente: \n");
			idUsuario = sc.nextLong();
			medicamento = mediDAO.buscarPorId(idMedicamento);
			usuario = userDAO.buscarPorId(idUsuario);
			usuarioMedicamento = new UsuarioMedicamento(0, usuario, medicamento);
			umDAO.salvar(usuarioMedicamento);
		} 
		
		else if (escolha == 5) {
			List<UsuarioMedicamento> listaUsuarioMedicamento = umDAO.buscarTodos();
			mensagem.imprimeListaUsuarioMedicamento(listaUsuarioMedicamento);
			System.out.println("\nDigite o ID usuarioMedicamento para excluir\n");
			id = sc.nextLong();
			umDAO.excluir(id);
		} 
		
		else if (escolha == 6) {
			List<Usuario> listaUsuarios = userDAO.buscarTodos();
			System.out.println("\nUsuários cadastrados no sistema: ");
			for (Usuario user : listaUsuarios) {
				System.out.println("\n\n\nID usuário: " + user.getIdUsuario());
				System.out.println("Nome: " + user.getNomeUsuario());
				System.out.println("Idade: " + user.getIdade());
				System.out.println("Data de nascimento: " + user.getDataNasc());
				System.out.println("CPF: " + user.getCpfUsuario());
				System.out.println("Sexo: " + user.getSexoUsuario());
				System.out.println("Peso(kg): " + user.getPeso());
				System.out.println("Estado civil: " + user.getEstadoCivil());
				System.out.println("Tipo snaguíneo: " + user.getTipoSangue());
				System.out.println("Renda R$:" + user.getRenda());
				System.out.println("Tipo de usuário: " + user.getTipoUsuario());
				System.out.println("Telefone residencial: " + user.getTelefoneCasa());
				System.out.println("Telefone celular: " + user.getTelefoneCelular());
				System.out.println("Telefone de parente " + user.getTelefoneFamilia());

				List<Endereco> listaEndereco = endDAO.buscarPorId(user.getIdUsuario());
				mensagem.imprimeListaEndereco(listaEndereco);
				long idPlano = userDAO.buscarPlanoPorId(user.getIdUsuario());
				if (idPlano > 0) {
					List<PlanoDeSaude> listaPlano = planoDAO.buscarPorIdPlano(idPlano);
					mensagem.imprimeListaPlano(listaPlano);
				}
				List<UsuarioMedicamento> listaUsuarioMedicamento = umDAO.buscarPorIdUsuario(user.getIdUsuario());
				mensagem.imprimeListaUsuarioMedicamento(listaUsuarioMedicamento);
			}
		}
	}
}