package apresentacao;
import java.util.Scanner;
import persistencia.ConsultaDAO;
import persistencia.MedicoDAO;
import persistencia.PlanoDeSaudeDAO;
import persistencia.UsuarioDAO;
import pojo.Consulta;
import pojo.Medico;
import pojo.Usuario;
import java.util.List;

public class ConsultaCadastro {
	
	Consulta consulta = new Consulta();
	Medico medico = new Medico();
	Usuario usuario = new Usuario();
	ConsultaDAO consDAO = new ConsultaDAO();
	UsuarioDAO userDAO = new UsuarioDAO();
	MedicoDAO medDAO = new MedicoDAO();
	PlanoDeSaudeDAO planoDAO = new PlanoDeSaudeDAO();
	Mensagem mensagem = new Mensagem();
	Scanner sc = new Scanner(System.in);

	public void tabelaConsulta() {
		
		String descricaoConsulta, dataConsulta, horaConsulta;
		int salaConsulta, escolha;
		double precoConsulta;
		long id = 0, idUsuario, idMedico;

		System.out.println("\n1-Salvar cadastro \n2-Editar cadastro \n3-Excluir cadastro \n4-Ver cadastros\n");
		escolha = sc.nextInt();
		if (escolha == 1) {
			List<Usuario> listaUsuario = userDAO.buscarPacientes();
			mensagem.imprimeListaUsuario(listaUsuario);
			System.out.println("\nDigite o ID do paciente: \n");
			idUsuario=sc.nextLong();
			List<Medico>listaMedico = medDAO.buscarTodos();
			mensagem.imprimeListaMedico(listaMedico);
			System.out.println("\nDigite o ID do médico: \n");
			idMedico = sc.nextLong();	
			System.out.println("\nDescrição da consulta:");
			descricaoConsulta = sc.nextLine();
			descricaoConsulta = sc.nextLine();
			System.out.println("Data da consulta:");
			dataConsulta = sc.next();
			System.out.println("Hora da consulta:");
			horaConsulta = sc.next();
			System.out.println("Sala da Consulta:");
			salaConsulta = sc.nextInt();
			System.out.println("Preço da consulta:");
			precoConsulta = sc.nextDouble();
			
			usuario= userDAO.buscarPorId(idUsuario);
			medico = medDAO.buscarPorId(idMedico);
			
			double renda= userDAO.buscarRendaPorId(idUsuario);
			long idPlano = userDAO.buscarPlanoPorId(idUsuario);
			if(idPlano>0){
				int beneficio= planoDAO.buscarBeneficioPorId(idUsuario);
				if(renda+(renda*beneficio/100)>=precoConsulta){
					consulta = new Consulta(0, descricaoConsulta, dataConsulta, horaConsulta, salaConsulta, precoConsulta, usuario, medico);
					consDAO.salvar(consulta);
					System.out.println("\nConsulta marcada\n");
				}else{
					System.out.println("\nNão foi possível marcar consulta, motivo: pagamento insuficiente\n");
				}
			}else if(renda>=precoConsulta){
				consulta = new Consulta(0, descricaoConsulta, dataConsulta, horaConsulta, salaConsulta, precoConsulta, usuario, medico);
				consDAO.salvar(consulta);
				System.out.println("\nConsulta marcada\n");
			}else{
				System.out.println("\nNão foi possível marcar consulta, motivo: pagamento insuficiente\n");
			}
		} 
		
		else if (escolha == 2) {
			List<Consulta> listaConsulta= consDAO.buscarTodos();
			mensagem.imprimeListaConsulta(listaConsulta);
			System.out.println("\nDigite o ID da consulta para editar: \n");
			id = sc.nextLong();
			System.out.println("\nDescrição da consulta:");
			descricaoConsulta = sc.nextLine();
			System.out.println("Data da consulta:");
			dataConsulta = sc.next();
			System.out.println("Hora da consulta:");
			horaConsulta = sc.next();
			System.out.println("Sala da consulta: ");
			salaConsulta = sc.nextInt();
			System.out.println("Preço da consulta:");
			precoConsulta = sc.nextInt();
			consulta = new Consulta(id, descricaoConsulta, dataConsulta, horaConsulta, salaConsulta, precoConsulta, usuario, medico);
			consDAO.editar(consulta);	
		} 
		
		else if (escolha == 3) {
			List<Consulta> listaConsulta= consDAO.buscarTodos();
			mensagem.imprimeListaConsulta(listaConsulta);
			System.out.println("\nDigite o ID da consulta para excluir: \n");
			id = sc.nextLong();
			consDAO.excluir(id);
		} 
		
		else if (escolha == 4) {
			List<Consulta> listaConsulta= consDAO.buscarTodos();
			System.out.println("\nConsultas cadastrados no sistema: ");
			for (Consulta cons : listaConsulta) {
				System.out.println("\n\n\nID consulta: " + cons.getIdConsulta());
				System.out.println("Tipo de cirurgia: " + cons.getDescricaoConsulta());
				System.out.println("Data da consulta:: " + cons.getDataConsulta());
				System.out.println("Sala da consulta: " + cons.getSalaConsulta());
				System.out.println("Preço da consulta: " + cons.getPrecoConsulta());
				System.out.println("ID Paciente: "+cons.getUsuario().getIdUsuario());
				usuario= userDAO.buscarPorId(cons.getUsuario().getIdUsuario());
				System.out.println("Nome do paciente: "+usuario.getNomeUsuario());
				System.out.println("CPF do paciente: "+usuario.getCpfUsuario());
				System.out.println("ID médico: "+cons.getMedico().getIdMedico());
				medico= medDAO.buscarPorId(cons.getMedico().getIdMedico());
				System.out.println("Nome do médico: "+medico.getNomeMedico());
				System.out.println("CPF do médico: "+medico.getCpfMedico());
			}
		}
	}
}

