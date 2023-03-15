package br.com.caio.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.caio.loja.dao.CategoriaDAO;
import br.com.caio.loja.dao.ProdutoDAO;
import br.com.caio.loja.modelo.Categoria;
import br.com.caio.loja.modelo.Produto;
import br.com.caio.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		
		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		
		Produto p = produtoDao.buscarPorId(1l);
		System.out.println(p.getPreco());
		
		List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("CELULARES");
		todos.forEach(p2 -> System.out.println(p.getNome()));
		
		BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Xiaomi redmi 8");
		System.out.println(precoDoProduto);
	}

	private static void cadastrarProduto() {
		Categoria ceulares = new Categoria("CELULARES");
		
		Produto celular = new Produto("Xiaomi redmi 8", "Muito Legal", new BigDecimal("800"), ceulares);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(ceulares);
		produtoDao.cadastrar(celular);
		
		em.getTransaction().commit();
		em.close();
	}
	
}
