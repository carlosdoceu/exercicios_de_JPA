package modelo.teste.consulta;

import java.util.List;

import infra.DAO;
import modelo.manytomany.Ator;
import modelo.manytomany.Filme;

public class ObterFilmes {
	public static void main(String[] args) {
		DAO<Filme> dao = new DAO<>(Filme.class);
		List<Filme> filmes = dao.consultar("obterFilmesComNotaMaiorQue", "nota", 8.0);
		
		
		for (Filme filme : filmes) {
			System.out.println("Nome do filme:"+filme.getNome());
			System.out.println("Atores:");
			for(Ator ator: filme.getAtores()) {
				System.out.println("-"+ator.getNome());
				
			}
		}
		
	}

}
