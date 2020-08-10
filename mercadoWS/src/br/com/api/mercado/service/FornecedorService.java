package br.com.api.mercado.service;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.api.mercado.dao.IFornecedorDAO;
import br.com.api.mercado.model.Fornecedor;

@WebService(name="FornecedorService")
public class FornecedorService {
	
	@EJB
	private IFornecedorDAO fornecedorDAO;

	@WebMethod(operationName="buscarTodos")
	@WebResult(name="ListaFornecedores")
	public List<Fornecedor> buscarTodos(){
		List<Fornecedor> alFornecedores = fornecedorDAO.buscarTodos(new Fornecedor());
		
		return alFornecedores;
	}
	
	@WebMethod(operationName="filtrarFornecedores")
    @WebResult(name="FornecedorFiltrado")
    public Fornecedor filtrar(@WebParam(name="id")Integer id){
    	return fornecedorDAO.filtrar(new Fornecedor(), id);
    }	
	
	@WebMethod(operationName="addFornecedor")
    @WebResult(name="FornecedorAdicionado")
    public Fornecedor add(@WebParam(name="fornecedor") Fornecedor fornecedor){
		fornecedor.setCodigo(null);
    	return fornecedorDAO.add(fornecedor);
    }
	
	@WebMethod(operationName="deleteFornecedor")
    public void delete(@WebParam(name="Fornecedor") Fornecedor fornecedor, @WebParam(name="id") Integer id){
    	fornecedorDAO.delete(fornecedor, id);
    }
	
	@WebMethod(operationName="updateFornecedor")
    @WebResult(name="FornecedorUpdated")
    public Fornecedor update(@WebParam(name="Fornecedor") Fornecedor fornecedor){
    	return fornecedorDAO.update(fornecedor);    	
    }
	
		
}
