package apresentacao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import persistencia.CirurgiaDAO;
import persistencia.CirurgiaFerramentaDAO;
import persistencia.FerramentaDAO;
import persistencia.MedicoDAO;
import persistencia.PlanoDeSaudeDAO;
import persistencia.UsuarioDAO;
import pojo.Cirurgia;
import pojo.CirurgiaFerramenta;
import pojo.Ferramenta;
import pojo.Medico;
import pojo.Usuario;

public class CirurgiaCadastro {
	
	CirurgiaDAO cirDAO = new CirurgiaDAO();
	UsuarioDAO userDAO = new UsuarioDAO();
	MedicoDAO medDAO = new MedicoDAO();
	PlanoDeSaudeDAO planoDAO = new PlanoDeSaudeDAO();
	FerramentaDAO ferDAO = new FerramentaDAO();
	CirurgiaFerramentaDAO cfDAO= new CirurgiaFerramentaDAO();
	Cirurgia cirurgia = new Cirurgia();
	Usuario usuario = new Usuario();
	Medico medico = new Medico();
	CirurgiaFerramenta cirurgiaFerramenta = new CirurgiaFerramenta();
	Mensagem mensagem = new Mensagem();
	Ferramenta ferramenta;
	List<CirurgiaFerramenta> listaCirurgiaFerramenta = new ArrayList<CirurgiaFerramenta>();
	Scanner sc = new Scanner(System.in);
	
	public void tabelaCirurgia(){
		
		listaCirurgiaFerramenta = null;
		String tipoCirurgia, descricaoCirurgia, dataCirurgia, horaCirurgia;
		int escolha, salaCirurgia;
		double precoCirurgia;
		long idUsuario=0, idMedico=0, id;
		
		System.out.println("\n1-Para cadastrar \n2-Para editar \n3-Para excluir \n4-Cadastrar ferramentas em cirurgias  \n5-Excluir ferramentas de cirurgias \n6-Fazer busca de cirurgias\n");
		escolha=sc.nextInt();
		if(escolha==1){
			List<Usuario> listaUsuario = userDAO.buscarPacientes();
			mensagem.imprimeListaUsuario(listaUsuario);
			System.out.println("\nDigite o ID do paciente: \n");
			idUsuario=sc.nextLong();
			List<Medico> listaMedico= medDAO.buscarTodos();
			mensagem.imprimeListaMedico(listaMedico);
			System.out.println("\nDigite o ID do médico\n");
			idMedico=sc.nextLong();
			System.out.println("\nTipo de cirurgia:");
			tipoCirurgia=sc.nextLine();
			tipoCirurgia=sc.nextLine();
			System.out.println("Descrição:");
			descricaoCirurgia=sc.nextLine();
			System.out.println("Data: ");
			dataCirurgia=sc.next();
			System.out.println("Hora: ");
			horaCirurgia=sc.next();
			System.out.println("Sala:");
			salaCirurgia=sc.nextInt();
			System.out.println("Preço:");
			precoCirurgia=sc.nextDouble();
			
			usuario= userDAO.buscarPorId(idUsuario);
			medico= medDAO.buscarPorId(idMedico);
			
			double renda= userDAO.buscarRendaPorId(idUsuario);
			long idPlano = userDAO.buscarPlanoPorId(idUsuario);
			if(idPlano>0){
				int beneficio= planoDAO.buscarBeneficioPorId(idUsuario);	
				if(renda+(renda*beneficio/100)>=precoCirurgia){
					cirurgia= new Cirurgia(0, tipoCirurgia, descricaoCirurgia, dataCirurgia, horaCirurgia, salaCirurgia, precoCirurgia, usuario, medico, listaCirurgiaFerramenta);
					cirDAO.salvar(cirurgia);
					System.out.println("\nCirurgia marcada\n");
				}else{
					System.out.println("\nNão foi possível marcar cirurgia, motivo: pagamento insuficiente\n");
				}
			}else if(renda>=precoCirurgia){
				cirurgia= new Cirurgia(0, tipoCirurgia, descricaoCirurgia, dataCirurgia, horaCirurgia, salaCirurgia, precoCirurgia, usuario, medico, listaCirurgiaFerramenta);
				cirDAO.salvar(cirurgia);
				System.out.println("\nCirurgia marcada\n");
			}else{
				System.out.println("\nNão foi possível marcar cirurgia, motivo: pagamento insuficiente\n");
			}
		}
		
		else if(escolha==2){
			List<Cirurgia> listaCirurgia= cirDAO.buscarTodos();
			mensagem.imprimeListaCirurgia(listaCirurgia);
			System.out.println("\nDigite o ID da cirurgia para editar: \n");
			id=sc.nextLong();
			System.out.println("\nTipo de cirurgia:");
			tipoCirurgia=sc.nextLine();
			System.out.println("Descrição:");
			descricaoCirurgia=sc.nextLine();
			System.out.println("Data: ");
			dataCirurgia=sc.next();
			System.out.println("Hora: ");
			horaCirurgia=sc.next();
			System.out.println("Sala: ");
			salaCirurgia=sc.nextInt();
			System.out.println("Preço:");
			precoCirurgia=sc.nextDouble();
			cirurgia= new Cirurgia(id, tipoCirurgia, descricaoCirurgia, dataCirurgia, horaCirurgia, salaCirurgia, precoCirurgia, usuario, medico, listaCirurgiaFerramenta);
			cirDAO.editar(cirurgia); 
		}
		
		else if(escolha==3){
			List<Cirurgia> listaCirurgia= cirDAO.buscarTodos();
			mensagem.imprimeListaCirurgia(listaCirurgia);
			System.out.println("\nDigite o ID da cirurgia para excluir:\n");
			id=sc.nextLong();
			cirDAO.excluir(id);
		}
		
		else if(escolha==4){
			long idCirurgia, idFerramenta;
			List<Cirurgia> listaCirurgia = cirDAO.buscarTodos();
			mensagem.imprimeListaCirurgia(listaCirurgia);
			System.out.println("\nDigite o ID da cirurgia: \n");
			idCirurgia = sc.nextLong();
			List<Ferramenta> listaFerramenta = ferDAO.buscarTodos();
			mensagem.imprimeListaFerramenta(listaFerramenta);
			System.out.println("\nDigite o ID da ferramenta: \n");
			idFerramenta = sc.nextLong();
			cirurgia = cirDAO.buscarPorId(idCirurgia);
			ferramenta = ferDAO.buscarPorId(idFerramenta);
			cirurgiaFerramenta = new CirurgiaFerramenta(0, cirurgia, ferramenta);
			cfDAO.salvar(cirurgiaFerramenta);
		}
		
		else if(escolha==5){
			List<CirurgiaFerramenta> listaCirurgiaFerramenta = cfDAO.buscarTodos();
			mensagem.imprimeListaCirurgiaFerramenta(listaCirurgiaFerramenta);
			System.out.println("\nDigite o ID cirurgiaFerramenta para excluir: \n");
			id = sc.nextLong();
			cfDAO.excluir(id);
		}
		
		else if(escolha==6){
			List<Cirurgia> listaCirurgias= cirDAO.buscarTodos();
			System.out.println("\nCirurgias cadastrados no sistema: ");
			for(Cirurgia cir:listaCirurgias){			
				System.out.println("\n\n\nID cirurgia: "+cir.getIdCirurgia());	
				System.out.println("Tipo de cirurgia: "+cir.getTipoCirurgia());	
				System.out.println("Descrição: "+cir.getDescricaoCirurgia());	
				System.out.println("Data: "+cir.getDataCirurgia());	
				System.out.println("Hora: " + cir.getHoraCirurgia());
				System.out.println("Sala: "+cir.getSalaCirurgia());	
				System.out.println("Preço: "+cir.getPrecoCirurgia());
				System.out.println("ID Paciente: "+cir.getUsuario().getIdUsuario());
				usuario= userDAO.buscarPorId(cir.getUsuario().getIdUsuario());
				System.out.println("Nome do paciente: "+usuario.getNomeUsuario());
				System.out.println("CPF do paciente: "+usuario.getCpfUsuario());
				System.out.println("ID médico: "+cir.getMedico().getIdMedico());
				medico= medDAO.buscarPorId(cir.getMedico().getIdMedico());
				System.out.println("Nome do médico: "+medico.getNomeMedico());
				System.out.println("CPF do médico: "+medico.getCpfMedico());
				List<CirurgiaFerramenta> listaCirurgiaFerramenta = cfDAO.buscarPorIdCirurgia(cir.getIdCirurgia());
				mensagem.imprimeListaCirurgiaFerramenta(listaCirurgiaFerramenta);
			}
		}
	}
}