package br.com.api.mercado.dao;

import java.util.List;
import br.com.api.mercado.model.Produtos;

public interface IProdutosDAO {

	public List<Produtos> buscarTodos(Produtos produtos);

	public Produtos add(Produtos produtos);

	public void delete(Produtos produtos, Integer cod);

	public Produtos update(Produtos produtos);

	public Produtos filtrar(Produtos produtos, Integer cod);

}
