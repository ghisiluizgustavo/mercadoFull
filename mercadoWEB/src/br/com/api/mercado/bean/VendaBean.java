package br.com.api.mercado.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import br.com.api.mercado.dao.IVendasDAO;
import br.com.api.mercado.model.Vendas;

@ManagedBean
public class VendaBean {
	
	@EJB
	private IVendasDAO vendaDAO;
	private Vendas vendas;
	private String mensagem;
	private List<Vendas> alVendas = new ArrayList<Vendas>();
	
	@PostConstruct
	public void Vendas(){
		vendas = new Vendas();
		buscarTodos();
	}
	public Vendas getVendas() {
		return vendas;
	}
	public void setVendas(Vendas vendas) {
		this.vendas = vendas;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public List<Vendas> getAlVendas() {
		return alVendas;
	}
	public void setAlVendas(List<Vendas> alVendas) {
		this.alVendas = alVendas;
	}
	
//	Operações com o Banco
	
	public void buscarTodos() {
		setAlVendas(vendaDAO.buscarTodos(vendas));		
	}
	
	public void add(){
		if (vendas.getCodigo() != null){
			setMensagem("Código preenchido, não é possivel cadastrar");
			return;
		}
		
		Vendas vendaRetorno = vendaDAO.add(vendas);
		if (vendaRetorno == null){
			setMensagem("Erro ao cadastrar o cliente");
		} else {
			setMensagem("Cliente cadastrado com sucesso");
			buscarTodos();
		}
	}
	
	public void selecionar(Vendas vendaSel){
		setVendas(vendaSel);
	}
	
	public void filtrar(){
		if(vendas.getCodigo() == null){
			setMensagem("Codigo vazio, informe o valor para pesquisar!");
			return;
		}
		
		vendas = vendaDAO.filtrar(vendas, vendas.getCodigo());
		setMensagem(null);
	}
	
	public void update(){
		if(vendas.getCodigo() == null){
			setMensagem("Código vazio informe o valor para pesquisar!");
			return;
		}
		vendas = vendaDAO.update(vendas);
		setVendas(vendas);
		this.vendas = new Vendas();
		setMensagem(null);
	}
	
	public void delete(){
		vendaDAO.delete(vendas, vendas.getCodigo());
		this.vendas = new Vendas();
		setMensagem("Venda Deletada!");
		buscarTodos();
	}
	
	
}
