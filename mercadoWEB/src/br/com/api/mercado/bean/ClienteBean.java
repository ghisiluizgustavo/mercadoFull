package br.com.api.mercado.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import br.com.api.mercado.dao.IClienteDAO;
import br.com.api.mercado.model.Cliente;

@ManagedBean
public class ClienteBean {
	
	@EJB
	private IClienteDAO clienteDAO;
	
	private List<Cliente> alClientes = new ArrayList<Cliente>();
	private Cliente cliente;
	private String mensagem;
	private boolean status = false;
	
	@PostConstruct
	public void ClienteBean() { //constructor
		cliente = new Cliente();
		this.alClientes = clienteDAO.buscarTodos(cliente);
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
	
	public List<Cliente> getAlClientes() {
		return alClientes;
	}

	public void setAlClientes(List<Cliente> alClientes) {
		this.alClientes = alClientes;
	}

//	Operações com o BANCO (DAO)
	
	public void add(){
		this.mensagem = null;
		
		if (cliente.getCodigo() != null) {
			this.mensagem = "Código preenchido, não é possivel cadastrar!";
			return;
		}
		
		Cliente clienteRetorno = clienteDAO.add(cliente);
		
		if (clienteRetorno == null) {
			this.mensagem = "Erro ao cadastrar cliente";
		} else {
			this.mensagem = "Cliente cadastrado com sucesso";
			this.alClientes = clienteDAO.buscarTodos(cliente);
		}
	}
	
	public void selecionar(Cliente clienteSel) {
		this.cliente = clienteSel;
	}
	
	public void buscarTodos(){
		alClientes = clienteDAO.buscarTodos(cliente);
	}
	
	public void filtrar() {
		
		if (cliente.getCodigo() == null) {
			this.mensagem = "Código não preenchido, favor informar para a pesquisa!";
			return;
		}
		
		cliente = clienteDAO.filtrar(cliente, cliente.getCodigo());
		setMensagem("");
	}
	
	public void update(){
		
		if (cliente.getCodigo() == null) {
			this.mensagem = "Código não preenchido, favor informar para a atualizar!";
			return;
		}
		
		cliente = clienteDAO.update(cliente);
		setCliente(cliente);
		setStatus(false);
		this.cliente = new Cliente();
		setMensagem("");

		this.alClientes = clienteDAO.buscarTodos(cliente);
	}
	
	public void delete(){
		
		if (cliente.getCodigo() == null) {
			this.mensagem = "Código não preenchido, favor informar para a excluir!";
			return;
		}
		
		clienteDAO.delete(cliente, cliente.getCodigo());
		this.cliente = new Cliente();
		setMensagem("Cliente Deletado!");
		buscarTodos();
	}
}