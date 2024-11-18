package modelo.teste.onetomany;

import infra.DAO;
import modelo.basico.Produto;
import modelo.onetomany.ItemPedido;
import modelo.onetomany.Pedido;

public class NovoPedido {

	public static void main(String[] args) {

		DAO<Object> dao = new DAO<>();

		Pedido pedido = new Pedido();
		Produto produto = new Produto("Produto_Relacionado", 2800.00);

		ItemPedido itemPedido = new ItemPedido(pedido, produto, 3);

		dao.abrirT()
		.incluir(produto)
		.incluir(pedido)
		.incluir(itemPedido)
		.fecharT().fechar();

	}

}
