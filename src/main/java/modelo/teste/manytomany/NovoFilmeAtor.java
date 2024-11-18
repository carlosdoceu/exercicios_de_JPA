package modelo.teste.manytomany;

import infra.DAO;
import modelo.manytomany.Ator;
import modelo.manytomany.Filme;

public class NovoFilmeAtor {
	public static void main(String[] args) {
		Filme filmeA = new Filme("Star Wars",8.9);
		Filme filmeB = new Filme("Fugitivo",8.1);
		
		Ator atorA = new Ator("Harrison Ford");
		Ator atorB = new Ator("Carrie Fisher");
		
		
		filmeA.adicionarAtor(atorA);
		filmeA.adicionarAtor(atorB);
		filmeB.adicionarAtor(atorA);
		
		
		DAO<Filme> dao = new DAO<Filme>();
		dao.incluirAtomico(filmeA);
		
		
	}

}
