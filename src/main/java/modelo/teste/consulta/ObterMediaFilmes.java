package modelo.teste.consulta;

import infra.DAO;
import modelo.consulta.NotaFilme;
import modelo.manytomany.Filme;

public class ObterMediaFilmes {
	public static void main(String[] args) {
		DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
		
		NotaFilme nota=  dao.consultarUmFilme("obterMediaGeralDosFilmes");
		System.out.println(nota.getMedia());
		
		
	}

}
