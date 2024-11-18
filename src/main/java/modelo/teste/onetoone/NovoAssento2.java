package modelo.teste.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import infra.DAO;
import modelo.onetoone.Assento;
import modelo.onetoone.Cliente;

public class NovoAssento2 {
	public static void main(String[] args) {
		Assento assento = new Assento("4D");
		
		Cliente cliente = new Cliente("Maria", assento);
		
		DAO<Cliente> dao = new DAO<>(Cliente.class);
		dao.incluirAtomico(cliente);
		
		//Neste exercicio foi adicionado na Classe Cliente uma notação em assento onde 	@OneToOne(cascade = CascadeType.PERSIST) 
		//realiza uma persistencia em cascata 
		
		
			
	}

}
