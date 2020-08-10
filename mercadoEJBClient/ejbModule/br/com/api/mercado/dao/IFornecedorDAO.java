package br.com.api.mercado.dao;

import java.util.List;
import javax.ejb.Local;
import br.com.api.mercado.model.Fornecedor;

@Local
public interface IFornecedorDAO {
	
	public List<Fornecedor> buscarTodos(Fornecedor fornecedor);
	
	public Fornecedor add(Fornecedor fornecedor);
	
	public void delete(Fornecedor fornecedor, Integer cod);
	
	public Fornecedor update(Fornecedor fornecedor);
	
	public Fornecedor filtrar(Fornecedor fornecedor, Integer cod);
	
}
