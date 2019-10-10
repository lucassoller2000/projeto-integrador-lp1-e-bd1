package apresentacao;
import java.util.Scanner;
import pojo.Usuario;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int escolha;
		MedicoCadastro m = new MedicoCadastro();
		UsuarioCadastro u = new UsuarioCadastro();
		PlanoCadastro p = new PlanoCadastro();
		EnderecoCadastro e = new EnderecoCadastro();
		CirurgiaCadastro c = new CirurgiaCadastro();
		FerramentaCadastro f = new FerramentaCadastro();
		MedicamentoCadastro me = new MedicamentoCadastro();
		ConsultaCadastro co = new ConsultaCadastro();
		DoacaoSangueCadastro ds = new DoacaoSangueCadastro();
		Usuario usuario = null;
		
		System.out.println("Bem-vindo ao sistema do Hospital, digite o número correspondente da função e você será direcionada a ela");
		do{
			System.out.println("\n1-Médico \n2-Usuário \n3-Plano de saúde \n4-Endereço \n5-Cirurgia \n6-Ferramenta \n7-Medicamento \n8-Consultas \n9-Doação de sangue\n0-Sair\n");
			escolha=sc.nextInt();
			if(escolha==1){
				m.tabelaMedico();	
			}else if(escolha==2){
				u.tabelaUsuario();
			}else if(escolha==3){
				p.tabelaPlano();
			}else if(escolha==4){
				System.out.println("\n1-Editar cadastro \n2-Ver cadastros\n");
				escolha=sc.nextInt();
				e.tabelaEndereco(escolha);
			}else if(escolha==5){
				c.tabelaCirurgia();
			}else if(escolha==6){
				f.tabelaFerramenta();
			}else if(escolha==7){
				me.tabelaMedicamento();
			}else if(escolha==8){
				co.tabelaConsulta();
			}else if(escolha==9){
				System.out.println("\n1-Excluir cadastro \n2-Ver cadastros\n");
				escolha=sc.nextInt();
				ds.tabelaDoacaoSangue(escolha,usuario);
			}		
		}while(escolha!=0);
		sc.close();		
	}
}