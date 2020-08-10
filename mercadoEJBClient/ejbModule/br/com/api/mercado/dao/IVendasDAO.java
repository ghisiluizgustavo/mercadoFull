package br.com.api.mercado.dao;

import java.util.List;

import javax.ejb.Local;
import br.com.api.mercado.model.Vendas;

@Local
public interface IVendasDAO {

	public List<Vendas> buscarTodos(Vendas vendas);

	public Vendas add(Vendas vendas);

	public void delete(Vendas vendas, Integer cod);

	public Vendas update(Vendas vendas);

	public Vendas filtrar(Vendas vendas, Integer cod);

}
