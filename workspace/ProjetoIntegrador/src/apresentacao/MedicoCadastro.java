package apresentacao;
import java.util.Scanner;
import persistencia.CirurgiaDAO;
import persistencia.MedicoDAO;
import pojo.Cirurgia;
import pojo.Consulta;
import pojo.Medico;

import java.util.List;

public class MedicoCadastro {

	MedicoDAO medDAO = new MedicoDAO();
	CirurgiaDAO cirDAO = new CirurgiaDAO();
	Mensagem mensagem = new Mensagem();
	Medico medico;
	List<Cirurgia> listaCirurgias;
	List<Consulta> listaConsultas;
	Scanner sc= new Scanner(System.in);
	
	public void tabelaMedico(){
		
		listaCirurgias = null;
		listaConsultas = null;
		String nomeMedico, cpfMedico, sexoMedico, especializacao, telefone;
		int idadeMedico, escolha;
		long id=0;
		
		System.out.println("\n1-Salvar cadastro \n2-Editar cadastro \n3-Excluir cadastro \n4-Ver cadastros\n");
		escolha=sc.nextInt();
		if(escolha==1){	
			System.out.println("\nNome:");
			nomeMedico=sc.nextLine();
			nomeMedico=sc.nextLine();
			System.out.println("Idade:");
			idadeMedico=sc.nextInt();
			System.out.println("Área de especialização:");
			especializacao=sc.nextLine();
			especializacao=sc.nextLine();
			System.out.println("CPF:");
			cpfMedico=sc.next();
			System.out.println("Sexo:");
			sexoMedico=sc.next();
			System.out.println("Telefone:");
			telefone=sc.next();
			medico = new Medico(0, nomeMedico, idadeMedico, especializacao, cpfMedico, sexoMedico, telefone, listaCirurgias, listaConsultas);	
			medDAO.salvar(medico); 
		}
		
		else if(escolha==2){
			List<Medico>listaMedico = medDAO.buscarTodos();
			mensagem.imprimeListaMedico(listaMedico);
			System.out.println("\nDigite o ID do médico para editar:\n");
			id=sc.nextLong();
			System.out.println("\nNome:");
			nomeMedico=sc.nextLine();
			nomeMedico=sc.nextLine();
			System.out.println("Idade:");
			idadeMedico=sc.nextInt();
			System.out.println("Área de especialização:");
			especializacao=sc.nextLine();
			especializacao=sc.nextLine();
			System.out.println("CPF:");
			cpfMedico=sc.next();
			System.out.println("Sexo:");
			sexoMedico=sc.next();
			System.out.println("Telefone:");
			telefone=sc.next();
			medico = new Medico(id, nomeMedico, idadeMedico, especializacao, cpfMedico, sexoMedico, telefone, listaCirurgias, listaConsultas);	
			medDAO.editar(medico); 
		}
		
		else if(escolha==3){
			List<Medico>listaMedico = medDAO.buscarTodos();
			mensagem.imprimeListaMedico(listaMedico);
			System.out.println("\nDigite o ID do médico para excluir\n");
			id=sc.nextLong();
			medDAO.excluir(id);
		}
		
		else if(escolha==4){
			List<Medico>listaMedico = medDAO.buscarTodos();
			mensagem.imprimeListaMedico(listaMedico);
		}
	}
}