package apresentacao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import persistencia.FerramentaDAO;
import pojo.CirurgiaFerramenta;
import pojo.Ferramenta;

public class FerramentaCadastro {
	
	FerramentaDAO ferDAO = new FerramentaDAO();
	Ferramenta ferramenta = new Ferramenta();
	Mensagem mensagem = new Mensagem();
	List<CirurgiaFerramenta> listaCirurgiaFerramenta = new ArrayList<CirurgiaFerramenta>();
	Scanner sc = new Scanner(System.in);
	
	public void tabelaFerramenta(){
		
		listaCirurgiaFerramenta = null;
		String nomeFerramenta, tipoFerramenta, material;
		int escolha, quantidadeFerramenta;
		long id;
		
		System.out.println("\n1-Para cadastrar \n2-Para editar \n3-Para excluir \n4-Fazer busca de ferramentas\n");
		escolha=sc.nextInt();
		if(escolha==1){
			System.out.println("\nNome:");
			nomeFerramenta=sc.nextLine();
			nomeFerramenta=sc.nextLine();
			System.out.println("Tipo:");
			tipoFerramenta=sc.nextLine();
			System.out.println("Material:");
			material=sc.nextLine();
			System.out.println("Quantidade:");
			quantidadeFerramenta=sc.nextInt();
			ferramenta= new Ferramenta(0, nomeFerramenta, tipoFerramenta, material, quantidadeFerramenta, listaCirurgiaFerramenta);
			ferDAO.salvar(ferramenta);
		}
		
		else if(escolha==2){
			List<Ferramenta> listaFerramenta = ferDAO.buscarTodos();
			mensagem.imprimeListaFerramenta(listaFerramenta);
			System.out.println("\nDigite o ID da ferramenta para editar: \n");
			id=sc.nextLong();
			System.out.println("\nNome:");
			nomeFerramenta=sc.nextLine();
			nomeFerramenta=sc.nextLine();
			System.out.println("Tipo:");
			tipoFerramenta=sc.nextLine();
			System.out.println("Material:");
			material=sc.nextLine();
			System.out.println("Quantidade:");
			quantidadeFerramenta=sc.nextInt();
			ferramenta= new Ferramenta(id, nomeFerramenta, tipoFerramenta, material, quantidadeFerramenta, listaCirurgiaFerramenta);
			ferDAO.editar(ferramenta);
		}
		
		else if(escolha==3){
			List<Ferramenta> listaFerramenta = ferDAO.buscarTodos();
			mensagem.imprimeListaFerramenta(listaFerramenta);
			System.out.println("\nDigite o ID da ferramenta para excluir: \n");
			id=sc.nextLong();
			ferDAO.excluir(id);
		}
		
		else if(escolha==4){
			List<Ferramenta> listaFerramenta = ferDAO.buscarTodos();
			mensagem.imprimeListaFerramenta(listaFerramenta);
		}
	}
}