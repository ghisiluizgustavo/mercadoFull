package br.com.api.mercado.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import br.com.api.mercado.dao.IClienteDAO;
import br.com.api.mercado.model.Cliente;


@ManagedBean
public class ClienteBean {
	
	@EJB
	private IClienteDAO clienteDAO;
	
	private Cliente cliente;
	private String mensagem;
	private boolean status = false;
	
	public ClienteBean() {
		cliente = new Cliente();
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

//	Operações com o BANCO (DAO)
	
	public void add(){
		this.mensagem = null;
		cliente.setCodigo(null);  
		
		Cliente clienteRetorno = clienteDAO.add(cliente);
		
		if (clienteRetorno == null) {
			this.mensagem = "Erro ao cadastrar cliente";
		} else {
			this.mensagem = "Cliente cadastrado com sucesso";
		}
		
	}
	
	public List<Cliente> buscarTodos(){
		List<Cliente> alClientes = new ArrayList<Cliente>();
		alClientes = clienteDAO.buscarTodos(cliente);
		return alClientes;
	}
	
	public void filtrar(){
		cliente = clienteDAO.filtrar(cliente, cliente.getCodigo());		
	}

	
	
	


}