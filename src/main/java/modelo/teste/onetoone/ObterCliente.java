package modelo.teste.onetoone;



import infra.DAO;
import modelo.onetoone.Assento;
import modelo.onetoone.Cliente;

public class ObterCliente {

	public static void main(String[] args) {
		
		
		DAO<Cliente> dao = new DAO<>(Cliente.class);
		
		Cliente cliente = dao.getById(1L);
		System.out.println(cliente.getAssento().getNome());
		dao.fechar();
		
		
		
		
		
		DAO<Assento> daoAssento = new DAO<>(Assento.class);
		Assento assento = daoAssento.getById(4L);
		System.out.println(assento.getCliente().getNome());
		daoAssento.fechar();
	}
}
