package modelo.teste.basico;

import java.util.List;

import infra.ProdutoDAO;
import modelo.basico.Produto;

public class ObterProdutos {

	public static void main(String[] args) {
		ProdutoDAO dao = new ProdutoDAO();

		List<Produto> produtos = dao.obterTodos();

		for (Produto produto : produtos) {
			System.out.println(produto.getId() + "-Nome produto: " + produto.getNome() + " Preco: " + produto.getPreco());
		}

		double precoTotal = produtos.stream().map(produto -> produto.getPreco()).reduce(0.0, (t, p) -> t + p)
				.doubleValue();

		System.out.println("Valor total: R$" + precoTotal);

		dao.fechar();

	}

}
