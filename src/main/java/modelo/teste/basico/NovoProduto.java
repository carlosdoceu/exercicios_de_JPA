package modelo.teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {
	public static void main(String[] args) {
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		
		
		Produto produto = new Produto("Geladeira furacao", 5150.0);
		
		
//		dao.abrirT().incluir(produto).fecharT().fechar();
		dao.incluirAtomico(produto).fechar();
		
		
		System.out.println("ID produto:"+produto.getId()+ " Inserido");
		
		
		
	}
}
