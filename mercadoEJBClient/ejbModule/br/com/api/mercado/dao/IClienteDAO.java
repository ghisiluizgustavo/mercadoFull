package br.com.api.mercado.dao;

import java.util.List;
import javax.ejb.Local;
import br.com.api.mercado.model.Cliente;

@Local
public interface IClienteDAO {
	
	public List<Cliente> buscarTodos(Cliente cliente);
	
	public Cliente add(Cliente cliente);
	
	public void delete(Cliente cliente, Integer cod);
	
	public Cliente update(Cliente cliente);
	
	public Cliente filtrar(Cliente cliente, Integer cod);
	
}
