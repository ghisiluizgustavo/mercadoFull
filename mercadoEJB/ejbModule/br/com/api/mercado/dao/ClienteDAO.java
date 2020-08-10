package br.com.api.mercado.dao;
import javax.ejb.Stateless;

import br.com.api.mercado.model.Cliente;

@Stateless
public class ClienteDAO extends DAO<Cliente> implements IClienteDAO {
	
}