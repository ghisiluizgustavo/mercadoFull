package br.com.api.mercado.bean;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import br.com.api.mercado.dao.IFornecedorDAO;
import br.com.api.mercado.model.Fornecedor;

@ManagedBean
public class FornecedorBean {

	@EJB
	private IFornecedorDAO fornecedorDAO;
	private Fornecedor fornecedor;
	private String mensagem;
	private boolean status = false;
	
	public FornecedorBean(){
		fornecedor = new Fornecedor();
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
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
		fornecedor.setCodigo(null);
		
		Fornecedor fornRetorno = fornecedorDAO.add(fornecedor);
		if(fornRetorno == null){
			setMensagem("Erro ao cadastrar fornecedor");
		} else {
			setMensagem("Fornecedor cadastrado com sucesso");
		}	
	}
}
