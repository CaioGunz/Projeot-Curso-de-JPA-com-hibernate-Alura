package br.com.caio.loja.dao;

import javax.persistence.EntityManager;

import br.com.caio.loja.modelo.Categoria;

public class CategoriaDAO {
	
	private EntityManager em;

	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void Cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}

}
