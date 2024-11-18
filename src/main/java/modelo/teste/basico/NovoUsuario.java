package modelo.teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {
	
	public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios_jpa");
        EntityManager em = emf.createEntityManager();

        Usuario novoUsuario = new Usuario("Gessica Cristiane Ferreira Pinto", "gcfp@gmail.com");

        
        
        
        em.getTransaction().begin();
        em.persist(novoUsuario);
        em.getTransaction().commit();
        
        System.out.println("Id gerado:"+novoUsuario.getId()+" Nome:"+ novoUsuario.getNome());

        em.close();
        emf.close();

    }

}
