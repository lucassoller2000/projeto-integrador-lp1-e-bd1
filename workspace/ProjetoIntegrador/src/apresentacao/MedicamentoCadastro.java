package apresentacao;
import java.util.Scanner;
import persistencia.MedicamentoDAO;
import pojo.Medicamento;
import pojo.UsuarioMedicamento;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoCadastro {

	MedicamentoDAO mediDAO = new MedicamentoDAO();
	Medicamento medicamento;
	Mensagem mensagem = new Mensagem();
	List<UsuarioMedicamento> listaUsuarioMedicamento= new ArrayList<UsuarioMedicamento>();
	Scanner sc= new Scanner(System.in);
	
	public void tabelaMedicamento(){
		
		listaUsuarioMedicamento=null;
		String tipoMedicamento,  horaMedicamento;
		long id=0;
		int escolha,quantidadeMedicamento;
		
		System.out.println("\n1-Salvar cadastro \n2-Editar cadastro \n3-Excluir cadastro \n4-Ver cadastros\n");
		escolha=sc.nextInt();
		if(escolha==1){	
			System.out.println("\nTipo do medicamento:");
			tipoMedicamento=sc.nextLine();
			tipoMedicamento=sc.nextLine();
			System.out.println("Quantidade do medicamento:");
			quantidadeMedicamento=sc.nextInt();
			System.out.println("Horário do medicamento:");
			horaMedicamento=sc.nextLine();
			horaMedicamento=sc.nextLine();
			medicamento= new Medicamento(0,tipoMedicamento, quantidadeMedicamento, horaMedicamento,listaUsuarioMedicamento);	
			mediDAO.salvar(medicamento); 
		}
		
		else if(escolha==2){
			List<Medicamento> listaMedicamento = mediDAO.buscarTodos();
			mensagem.imprimeListaMedicamento(listaMedicamento);
			System.out.println("\nDigite o ID do medicamento para editar:\n");
			id=sc.nextLong();
			System.out.println("\nTipo do medicamento:");
			tipoMedicamento=sc.nextLine();
			tipoMedicamento=sc.nextLine();
			System.out.println("quantidade do medicamento:");
			quantidadeMedicamento=sc.nextInt();
			System.out.println("Horário do medicamento:");
			horaMedicamento=sc.nextLine();
			horaMedicamento=sc.nextLine();
			medicamento = new Medicamento(id,tipoMedicamento, quantidadeMedicamento, horaMedicamento,listaUsuarioMedicamento);	
			mediDAO.editar(medicamento); 
		}
		
		else if(escolha==3){
			List<Medicamento> listaMedicamento = mediDAO.buscarTodos();
			mensagem.imprimeListaMedicamento(listaMedicamento);
			System.out.println("\nDigite o ID do medicamento para excluir: \n");
			id=sc.nextLong();	
			mediDAO.excluir(id);
		}
		
		else if(escolha==4){
			List<Medicamento> listaMedicamento = mediDAO.buscarTodos();
			mensagem.imprimeListaMedicamento(listaMedicamento);
		}
	}
}