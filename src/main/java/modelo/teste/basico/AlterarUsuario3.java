package modelo.teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario3 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios_jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Usuario usuario = em.find(Usuario.class,7L);
		em.detach(usuario); //desasocia um objeto 
		
		usuario.setNome("Leo");
		
		em.merge(usuario); // associa novamente
		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
