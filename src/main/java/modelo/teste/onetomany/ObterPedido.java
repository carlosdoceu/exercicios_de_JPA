package modelo.teste.onetomany;

import infra.DAO;
import modelo.onetomany.ItemPedido;
import modelo.onetomany.Pedido;

public class ObterPedido {

	public static void main(String[] args) {
		DAO<Pedido> dao = new DAO<>(Pedido.class);
	
			Pedido pedido = dao.getById(3L);
			
			for (ItemPedido item: pedido.getItens()) {
				System.out.println(item.getQuantidade());
				System.out.println(item.getProduto().getNome());
			}
			dao.fechar();
	}
}
