package br.com.api.mercado.service;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.api.mercado.dao.IProdutosDAO;
import br.com.api.mercado.model.Produtos;

@WebService(name="ProdutosService")
public class ProdutosService {
	
	@EJB
	private IProdutosDAO produtosDAO;
	
    @WebMethod(operationName="buscarTodos")
    @WebResult(name="ListaProdutos")
    public List<Produtos> buscarTodos(){
    	List<Produtos> alProdutos = produtosDAO.buscarTodos(new Produtos());    	
    	return alProdutos;
    }	
    
    @WebMethod(operationName="addProdutos")
    @WebResult(name="ProdutoAdicionado")
    public Produtos add(@WebParam(name="Produto") Produtos produtos){
    	produtos.setCodigo(null);
    	return produtosDAO.add(produtos);
    }
    
    @WebMethod(operationName="deleteProdutos")
    public void deleteProdutos(@WebParam(name="Produto") Produtos produtos, @WebParam(name="id") Integer id){
    	produtosDAO.delete(produtos, id);
    }
    
    @WebMethod(operationName="updateProdutos")
    @WebResult(name="ProdutosUpdated")
    public Produtos updateProdutos(@WebParam(name="Produtos") Produtos produtos){
    	return produtosDAO.update(produtos);    	
    }
    
    @WebMethod(operationName="filtrarProdutos")
    @WebResult(name="ProdutosFiltrado")
    public Produtos filtrar(@WebParam(name="id")Integer id){
    	return produtosDAO.filtrar(new Produtos(), id);
    }
        
}
