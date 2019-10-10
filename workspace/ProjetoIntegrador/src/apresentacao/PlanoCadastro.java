package apresentacao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import persistencia.PlanoDeSaudeDAO;
import persistencia.UsuarioDAO;
import pojo.PlanoDeSaude;
import pojo.Usuario;

public class PlanoCadastro {
	
	PlanoDeSaude planoDeSaude = new PlanoDeSaude();
	PlanoDeSaudeDAO planoDAO = new PlanoDeSaudeDAO();
	UsuarioDAO userDAO = new UsuarioDAO();
	Mensagem mensagem = new Mensagem();
	List<Usuario> listaUsuarios= new ArrayList<Usuario>();
	Scanner sc= new Scanner(System.in);
	
	public void tabelaPlano(){
		
		listaUsuarios= null;
		String categoria, dataEmissao, validade, empresaPlano;
		int beneficios, escolha;
		long id;
		
		System.out.println("\n1-Salvar cadastro \n2-Editar cadastro \n3-Excluir cadastro \n4-Ver cadastros\n");
		escolha=sc.nextInt();
		if(escolha==1){
			System.out.println("\nBenefícios: (porcentagem referente a renda)");
			beneficios=sc.nextInt();
			System.out.println("Categoria:");
			categoria=sc.next();
			System.out.println("Data de emissão:");
			dataEmissao=sc.next();
			System.out.println("Data de validade:");
			validade=sc.next();
			System.out.println("Empresa plano:");
			empresaPlano=sc.next();	
			planoDeSaude= new PlanoDeSaude(0, beneficios, categoria, dataEmissao, validade, empresaPlano, listaUsuarios);
			planoDAO.salvar(planoDeSaude);
		}
		
		
		else if(escolha==2){
			List<PlanoDeSaude> listaPlano = planoDAO.buscarTodos();
			mensagem.imprimeListaPlano(listaPlano);
			System.out.println("\nDigite ID do plano de saúde para editar:\n");
			id = sc.nextLong();
			System.out.println("\nBenefícios: ");
			beneficios = sc.nextInt();
			System.out.println("Categoria:");
			categoria = sc.next();
			System.out.println("Data de emissão:");
			dataEmissao = sc.next();
			System.out.println("Data de validade:");
			validade = sc.next();
			System.out.println("Empresa plano:");
			empresaPlano = sc.next();
			planoDeSaude = new PlanoDeSaude(id, beneficios, categoria, dataEmissao, validade, empresaPlano, listaUsuarios);
			planoDAO.editar(planoDeSaude);
		} 
		
		else if (escolha == 3) {
			List<PlanoDeSaude> listaPlano = planoDAO.buscarTodos();
			mensagem.imprimeListaPlano(listaPlano);
			System.out.println("\nDigite o ID do plano de saúde para excluir: \n");
			id=sc.nextLong();
			planoDAO.excluir(id);
		} 
		
		else if (escolha == 4) {
			List<PlanoDeSaude> listaPlano = planoDAO.buscarTodos();
			mensagem.imprimeListaPlano(listaPlano);
		}
	}
}