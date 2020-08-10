package br.com.api.mercado.service;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.api.mercado.dao.IVendasDAO;
import br.com.api.mercado.model.Vendas;

@WebService(name="VendasService")
public class VendasService {

	@EJB
	private IVendasDAO vendasDAO;
	
	@WebMethod(operationName="buscarTodos")
	public List<Vendas> buscarTodos(){
		List<Vendas> alVendas = vendasDAO.buscarTodos(new Vendas());
		return alVendas;
	}
	
	@WebMethod(operationName="addVendas")
	@WebResult(name="VendaAdicionada")
	public Vendas add(@WebParam(name="Venda") Vendas vendas){
		vendas.setCodigo(null);
		return vendasDAO.add(vendas);
	}
	
	@WebMethod(operationName="updateVendas")
	@WebResult(name="VendaUpdated ")
	public Vendas update(@WebParam(name="Venda")Vendas Vendas){
		return vendasDAO.update(new Vendas());
	}
	
	@WebMethod(operationName="filtrarVendas")
	@WebResult(name="VendaFiltrada")
	public Vendas filtrar(@WebParam(name="id") Integer id){
		return vendasDAO.filtrar(new Vendas(), id);
	}
	
	@WebMethod(operationName="deletarVendas")
	public void delete(@WebParam(name="id") Integer id){
		vendasDAO.delete(new Vendas(), id);
	}
	
}
