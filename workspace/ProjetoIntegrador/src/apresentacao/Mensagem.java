package apresentacao;
import java.util.List;
import persistencia.CirurgiaDAO;
import persistencia.ConsultaDAO;
import persistencia.FerramentaDAO;
import persistencia.MedicamentoDAO;
import persistencia.MedicoDAO;
import persistencia.UsuarioDAO;
import pojo.Cirurgia;
import pojo.CirurgiaFerramenta;
import pojo.Consulta;
import pojo.DoacaoSangue;
import pojo.Endereco;
import pojo.Ferramenta;
import pojo.Medicamento;
import pojo.Medico;
import pojo.PlanoDeSaude;
import pojo.Usuario;
import pojo.UsuarioMedicamento;


public class Mensagem {
	CirurgiaDAO cirDAO = new CirurgiaDAO();
	ConsultaDAO consDAO = new ConsultaDAO();
	MedicoDAO medDAO = new MedicoDAO(); 
	FerramentaDAO ferDAO = new FerramentaDAO();
	MedicamentoDAO mediDAO = new MedicamentoDAO();
	UsuarioDAO userDAO = new UsuarioDAO();
	
	public void imprimeListaCirurgia(List<Cirurgia>listaCirurgia){
		for(Cirurgia cir: listaCirurgia){
			System.out.println(cir.toString());
		}
	}
	
	public void imprimeListaConsulta(List<Consulta>listaConsulta){
		for(Consulta cons: listaConsulta){
			System.out.println(cons.toString());
		}
	}
	public void imprimeListaFerramenta(List<Ferramenta>listaFerramenta){
		for(Ferramenta fer: listaFerramenta){
			System.out.println(fer.toString());
		}
	}
	public void imprimeListaMedicamento(List<Medicamento>listaMedicamento){
		for(Medicamento medi : listaMedicamento){
			System.out.println(medi.toString());
		}
	}
	public void imprimeListaMedico(List<Medico>listaMedico){
		for(Medico med : listaMedico){
			System.out.println(med.toString());
		}
	}
	
	public void imprimeListaUsuario(List<Usuario>listaUsuario){
		System.out.println("\nUsuários cadastrados no sistema:");
		for(Usuario user : listaUsuario){
			System.out.println(user.toString());
		}
	}
	
	public void imprimeListaPlano(List<PlanoDeSaude>listaPlano){
		for(PlanoDeSaude plano : listaPlano){
			System.out.println(plano.toString());
		}
	}
	
	public void imprimeListaUsuarioMedicamento(List<UsuarioMedicamento>listaUsuarioMedicamento){
		for(UsuarioMedicamento um : listaUsuarioMedicamento){
			System.out.println(um.toString());
		}
	}
	
	public void imprimeListaEndereco(List<Endereco>listaEndereco){
		for(Endereco end : listaEndereco){
			System.out.println(end.toString());
		}
	}
	
	public void imprimeListaCirurgiaFerramenta(List<CirurgiaFerramenta>listaCirurgiaFerramenta){
		for(CirurgiaFerramenta cf : listaCirurgiaFerramenta){
			System.out.println(cf.toString());
		}
	}
	
	public void imprimeListaDoador(List<DoacaoSangue>listaDoador){
		for(DoacaoSangue doa : listaDoador){
			System.out.println(doa.toStringDoador());
		}
	}	
	
	public void imprimeListaReceptor(List<DoacaoSangue>listaReceptor){
		for(DoacaoSangue doa : listaReceptor){
			System.out.println(doa.toStringReceptor());
		}
	}	
}