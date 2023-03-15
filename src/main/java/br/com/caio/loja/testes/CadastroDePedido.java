package br.com.caio.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.caio.loja.dao.CategoriaDAO;
import br.com.caio.loja.dao.ClienteDAO;
import br.com.caio.loja.dao.PedidoDAO;
import br.com.caio.loja.dao.ProdutoDAO;
import br.com.caio.loja.modelo.Categoria;
import br.com.caio.loja.modelo.Cliente;
import br.com.caio.loja.modelo.ItemPedido;
import br.com.caio.loja.modelo.Pedido;
import br.com.caio.loja.modelo.Produto;
import br.com.caio.loja.util.JPAUtil;
import br.com.caio.loja.vo.RelatorioDeVendasVo;

public class CadastroDePedido {

	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		ClienteDAO clienteDao = new ClienteDAO(em);
		Produto produto = produtoDao.buscarPorId(1l);
		Cliente cliente = clienteDao.buscarPorId(1l);
		
		em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		
		PedidoDAO pedidoDao = new PedidoDAO(em);
		pedidoDao.cadastrar(pedido);

		
		
		em.getTransaction().commit();
		
		BigDecimal totalVendido = pedidoDao.valorTotalVendido();
		System.out.println("Valor total: " + totalVendido);
		
		List<RelatorioDeVendasVo> relatorio =  pedidoDao.relatorioDevendas();
		relatorio.forEach(System.out::println);
	}
		
	private static void popularBancoDeDados() {
		Categoria ceulares = new Categoria("CELULARES");
		
		Produto celular = new Produto("Xiaomi redmi 8", "Muito Legal", new BigDecimal("800"), ceulares);
		Cliente cliente =  new Cliente("Rodrigo", "123456");
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);
		ClienteDAO clienteDao = new ClienteDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(ceulares);
		produtoDao.cadastrar(celular);
		clienteDao.cadastrar(cliente);
		
		em.getTransaction().commit();
		em.close();
	}

}
