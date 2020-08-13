package br.com.api.mercado.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import br.com.api.mercado.dao.IFornecedorDAO;
import br.com.api.mercado.model.Fornecedor;

@ManagedBean
public class FornecedorBean {

	@EJB
	private IFornecedorDAO fornecedorDAO;
	private Fornecedor fornecedor;
	private String mensagem;
	private List<Fornecedor> alFornecedores = new ArrayList<Fornecedor>();

	@PostConstruct
	public void FornecedorBean() {
		fornecedor = new Fornecedor();
		buscarTodos();
	}

	public List<Fornecedor> getAlFornecedores() {
		return alFornecedores;
	}

	public void setAlFornecedores(List<Fornecedor> alFornecedores) {
		this.alFornecedores = alFornecedores;
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

	// Operações com o BANCO (DAO)

	public void add() {
		setMensagem(null);

		if (fornecedor.getCodigo() != null) {
			setMensagem("Codigo preenchido, não é possivel cadastrar!");
			return;
		}

		Fornecedor fornRetorno = fornecedorDAO.add(fornecedor);
		if (fornRetorno == null) {
			setMensagem("Erro ao cadastrar fornecedor");
		} else {
			setMensagem("Fornecedor cadastrado com sucesso");
			buscarTodos();
		}
	}

	public void selecionar(Fornecedor fornecedorSel) {
		setFornecedor(fornecedorSel);
	}

	public void buscarTodos() {
		setAlFornecedores(fornecedorDAO.buscarTodos(fornecedor));
	}

	public void filtrar() {
		if (fornecedor.getCodigo() == null) {
			setMensagem("Informe o valor do codigo para filtrar");
			return;
		}
		fornecedor = fornecedorDAO.filtrar(fornecedor, fornecedor.getCodigo());
		setMensagem(null);
	}

	public void update() {
		if (fornecedor.getCodigo() == null) {
			setMensagem("Código não preenchido, favor informar para a atualizar!");
			return;
		}
		fornecedor = fornecedorDAO.update(fornecedor);
		setFornecedor(fornecedor);
		this.fornecedor = new Fornecedor();
		setMensagem("Fornecedor Atualizado");
	}

	public void delete() {
		fornecedorDAO.delete(fornecedor, fornecedor.getCodigo());
		this.fornecedor = new Fornecedor();
		setMensagem("Fornecedor Deletado!");
		buscarTodos();
	}

}
