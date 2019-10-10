package apresentacao;
import java.util.Scanner;
import persistencia.UsuarioDAO;
import persistencia.DoacaoSangueDAO;
import pojo.DoacaoSangue;
import pojo.Usuario;
import java.util.List;

public class DoacaoSangueCadastro {
	
	DoacaoSangueCadastro doacaoSangueCadastro;
	DoacaoSangue doacaoSangue;
	DoacaoSangueDAO doaDAO = new DoacaoSangueDAO();
	UsuarioDAO userDAO = new UsuarioDAO();
	Mensagem mensagem = new Mensagem();
	Scanner sc = new Scanner(System.in);

	public void tabelaDoacaoSangue(int escolha, Usuario usuario) {
		if (escolha == -1) {
			doacaoSangue = new DoacaoSangue(0, usuario);
			if(usuario.getPeso()>=50){
				if(usuario.getIdade()>=16 && usuario.getIdade()<=69){
					doaDAO.salvarDoador(doacaoSangue);
				}else{
					System.out.println("\nNão foi possível cadastrar doação, motivo: idade mínima não atingida\n");
				}
			}else{
				System.out.println("\nNão foi possível cadastrar doação, motivo: peso mínimo não atingido\n");
			}
		} else if (escolha == 0) {
			doacaoSangue = new DoacaoSangue(0, usuario);
			doaDAO.salvarReceptor(doacaoSangue);
		}else if (escolha == 1){
			
			List<Usuario> listaDoadores = userDAO.buscarDoadores();
			System.out.println("\nDoadores cadastrados no sistema:");
			for (Usuario userDoador : listaDoadores) {
				List<DoacaoSangue> listaDoador = doaDAO.buscarDoador(userDoador.getIdUsuario());
				mensagem.imprimeListaDoador(listaDoador);
			}
			List<Usuario> listaReceptores = userDAO.buscarReceptores();
			System.out.println("\nReceptores cadastrados no sistema:");
			for(Usuario userReceptor : listaReceptores){
				List<DoacaoSangue> listaReceptor = doaDAO.buscarReceptor(userReceptor.getIdUsuario());
				mensagem.imprimeListaReceptor(listaReceptor);
			}
			System.out.println("\nDigite o ID da doação para excluir: \n");
			long id=sc.nextLong();
			doaDAO.excluir(id);
		} 
		
		else if (escolha == 2) {
			List<Usuario> listaDoadores = userDAO.buscarDoadores();
			System.out.println("\nDoadores cadastrados no sistema:");
			for (Usuario userDoador : listaDoadores) {
				List<DoacaoSangue> listaDoador = doaDAO.buscarDoador(userDoador.getIdUsuario());
				mensagem.imprimeListaDoador(listaDoador);
			}
			List<Usuario> listaReceptores = userDAO.buscarReceptores();
			System.out.println("\nReceptores cadastrados no sistema:");
			for(Usuario userReceptor : listaReceptores){
				List<DoacaoSangue> listaReceptor = doaDAO.buscarReceptor(userReceptor.getIdUsuario());
				mensagem.imprimeListaReceptor(listaReceptor);
			}
		}
	}
}