package modelo.teste.onetoone;

import infra.DAO;
import modelo.onetoone.Assento;
import modelo.onetoone.Cliente;

public class NovoClienteAssento1 {
	
	public static void main(String[] args) {
		Assento assento = new Assento("28A");
		Cliente cliente = new Cliente("Daniel",assento);
		
		
		DAO<Object> dao = new DAO<>();
		
		dao.abrirT()
		.incluir(assento)
		.incluir(cliente)
		.fecharT()
		.fechar();
	}

}
