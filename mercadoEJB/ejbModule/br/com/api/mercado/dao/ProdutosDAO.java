package br.com.api.mercado.dao;

import javax.ejb.Stateless;

import br.com.api.mercado.model.Produtos;

@Stateless
public class ProdutosDAO extends DAO<Produtos> implements IProdutosDAO {

}
