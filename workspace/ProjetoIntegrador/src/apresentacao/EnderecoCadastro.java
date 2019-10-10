package apresentacao;
import java.util.List;
import java.util.Scanner;

import persistencia.EnderecoDAO;
import pojo.Endereco;
import pojo.Usuario;

public class EnderecoCadastro {
	
	EnderecoDAO endDAO = new EnderecoDAO();
	Endereco endereco = new Endereco();
	Usuario usuario = new Usuario();
	Mensagem mensagem = new Mensagem();
	Scanner sc = new Scanner(System.in);
	
	public Endereco tabelaEndereco(int escolha){
		
		String rua, bairro, cidade, estado, pais, cep, complemento;
		int numero;
		
		if(escolha==0){
			System.out.println("Digite o nome da rua:");
			rua=sc.nextLine();
			System.out.println("Número:");
			numero=sc.nextInt();
			System.out.println("Bairro:");
			bairro=sc.nextLine();
			bairro=sc.nextLine();
			System.out.println("Cidade:");
			cidade=sc.nextLine();
			System.out.println("Estado:");
			estado=sc.nextLine();
			System.out.println("País:");
			pais=sc.nextLine();
			System.out.println("CEP:");
			cep=sc.next();
			System.out.println("Complemento:");
			complemento=sc.next();
			endereco= new Endereco(0, rua, numero, bairro, cidade, estado, pais, cep, complemento, usuario);
		}
		
		else if(escolha==1){
			List<Endereco> listaEndereco= endDAO.buscarTodos();
			mensagem.imprimeListaEndereco(listaEndereco);
			System.out.println("\n Digite o ID do endereço para editar: \n");
			long id=sc.nextLong();
			System.out.println("\nDigite o nome da rua:");
			rua=sc.nextLine();
			rua=sc.nextLine();
			System.out.println("Número:");
			numero=sc.nextInt();
			System.out.println("Bairro:");
			bairro=sc.nextLine();
			bairro=sc.nextLine();
			System.out.println("Cidade:");
			cidade=sc.nextLine();
			System.out.println("Estado:");
			estado=sc.nextLine();
			System.out.println("País:");
			pais=sc.nextLine();
			System.out.println("CEP:");
			cep=sc.next();
			System.out.println("Complemento:");
			complemento=sc.next();
			endereco= new Endereco(id, rua, numero, bairro, cidade, estado, pais, cep, complemento,usuario);
			endDAO.editar(endereco);
		}
		
		else if(escolha==2){
			List<Endereco> listaEndereco= endDAO.buscarTodos();
			mensagem.imprimeListaEndereco(listaEndereco);
		}
		return endereco;
	}
}