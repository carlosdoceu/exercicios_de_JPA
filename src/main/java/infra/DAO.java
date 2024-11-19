package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

//Classe genérica para manipulação de entidades no banco de dados usando JPA
public class DAO<E> {
	// Fábrica para criar EntityManagers, compartilhada por todas as instâncias da classe
	private static EntityManagerFactory emf;
	// Gerenciador de entidades, usado para interagir com o banco de dados
	private EntityManager em;
	// Representa o tipo da entidade manipulada pela instância do DAO
	private Class<E> classe;

	static {
		try {
			// Inicializa a EntityManagerFactory com as configurações do persistence.xml
			emf = Persistence.createEntityManagerFactory("exercicios_jpa");
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	// Construtor padrão, não associa a classe de entidade ainda
	public DAO() {
		this(null); 
	}

	public DAO(Class<E> classe) {
		this.classe = classe; // Define a classe da entidade associada
		em = emf.createEntityManager(); // Cria um EntityManager para interações com o banco de dados
	}

	public DAO<E> abrirT() {
		em.getTransaction().begin(); // Inicia uma transação
		return this; // Retorna a própria instância para facilitar o encadeamento de chamadas
	}

	public DAO<E> fecharT() {
		em.getTransaction().commit(); // Finaliza e confirma a transação
		return this; // Retorna a própria instância para encadeamento
	}

	public DAO<E> incluir(E entidade) {
		em.persist(entidade); // Adiciona a entidade ao banco de dados
		return this; // Retorna a própria instância para encadeamento
	}

	public DAO<E> incluirAtomico(E entidade) {
		// Realiza uma operação atômica (inclusão dentro de uma transação aberta e
		// fechada no método)
		return this.abrirT().incluir(entidade).fecharT();
	}

	public E getById(Object id) {
		// Busca uma entidade pelo seu ID
		return em.find(classe, id);
	}

	public List<E> obterTodos() {
		// Retorna os 10 primeiros registros por padrão
		return this.obterTodos(10, 0);
	}

	public List<E> obterTodos(int qtde, int deslocamento) {
		// Retorna uma lista de entidades com paginação
		if (classe == null) {
			throw new UnsupportedOperationException("Classe nula"); // Garante que a classe foi especificada
		}

		// Consulta JPQL para selecionar todas as entidades do tipo especificado
		String jpql = "SELECT e FROM " + classe.getName() + " e";

		// Cria uma consulta tipada e configura paginação
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(qtde); // Limita o número de resultados
		query.setFirstResult(deslocamento); // Define o deslocamento para paginação

		return query.getResultList(); // Retorna os resultados
	}

	public void fechar() {
		em.close(); // Fecha o EntityManager para liberar recursos
	}

	public List<E> consultar(String nomeConsulta, Object... params) {
		// Executa uma consulta nomeada (Named Query) com parâmetros opcionais
		TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);
		for (int i = 0; i < params.length; i += 2) {
			// Configura os parâmetros da consulta (pares nome-valor)
			query.setParameter(params[i].toString(), params[i + 1]);
		}

		return query.getResultList(); // Retorna os resultados da consulta
	}

	public E consultarUmFilme(String nomeConsulta, Object... params) {
		// Executa uma consulta nomeada e retorna apenas o primeiro resultado, ou null
		// se a lista estiver vazia
		List<E> lista = consultar(nomeConsulta, params);
		return lista.isEmpty() ? null : lista.get(0);
	}
}
