package br.com.caio.loja.testes;

import java.math.BigDecimal;

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

public class TesteCriteria {

	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em); 
		produtoDao.buscaPorParametroComCriteria("PS5", null, null);
	}

	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAMES");
		Categoria informatica = new Categoria("INFORMATICA");

		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
		Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("8000"), videogames);
		Produto macbook = new Produto("Macbook", "Macboo pro retina", new BigDecimal("14000"), informatica);



		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);

		em.getTransaction().begin();

		categoriaDao.cadastrar(celulares);
		categoriaDao.cadastrar(videogames);
		categoriaDao.cadastrar(informatica);

		produtoDao.cadastrar(celular);
		produtoDao.cadastrar(videogame);
		produtoDao.cadastrar(macbook);

		em.getTransaction().commit();
		em.close();
	}

}
