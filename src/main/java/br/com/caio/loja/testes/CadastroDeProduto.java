package br.com.caio.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caio.loja.dao.CategoriaDAO;
import br.com.caio.loja.dao.ProdutoDAO;
import br.com.caio.loja.modelo.Categoria;
import br.com.caio.loja.modelo.Produto;
import br.com.caio.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		
		Categoria ceulares = new Categoria("CELULARES");
		
		Produto celular = new Produto("Xiaomi redmi 8", "Muito Legal", new BigDecimal("800"), ceulares);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDao.Cadastrar(ceulares);
		produtoDao.cadastrar(celular);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
}
