/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.api.mercado.service;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.api.mercado.dao.IClienteDAO;
import br.com.api.mercado.model.Cliente;

@WebService(name="ClienteService")
public class ClienteService {
	
	@EJB
	private IClienteDAO clienteDAO;
	
    @WebMethod(operationName="buscarTodos")
    @WebResult(name="ListaClientes")
    public List<Cliente> buscarTodos(){
    	List<Cliente> alClientes = clienteDAO.buscarTodos(new Cliente());    	
    	return alClientes;
    }	
    
    @WebMethod(operationName="addCliente")
    @WebResult(name="ClienteAdicionado")
    public Cliente add(@WebParam(name="cliente") Cliente cliente){
    	cliente.setCodigo(null);
    	return clienteDAO.add(cliente);
    }
    
    @WebMethod(operationName="deleteCliente")
    public void deleteCliente(@WebParam(name="Cliente") Cliente cliente, @WebParam(name="id") Integer id){
    	clienteDAO.delete(cliente, id);
    }
    
    @WebMethod(operationName="updateCliente")
    @WebResult(name="ClienteUpdated")
    public Cliente updateCliente(@WebParam(name="Cliente") Cliente cliente){
    	return clienteDAO.update(cliente);    	
    }
    
    @WebMethod(operationName="filtrarCliente")
    @WebResult(name="ClienteFiltrado")
    public Cliente filtrar(@WebParam(name="id")Integer id){
    	return clienteDAO.filtrar(new Cliente(), id);
    }
        
}