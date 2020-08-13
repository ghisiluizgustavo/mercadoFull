package br.com.api.mercado.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import br.com.api.mercado.dao.IProdutosDAO;
import br.com.api.mercado.model.Produtos;

@ManagedBean
public class ProdutoBean {

	@EJB
	private IProdutosDAO produtoDAO;
	private Produtos produtos;
	private String mensagem = null;
	private List<Produtos> alProdutos = new ArrayList<Produtos>();

	@PostConstruct
	public void ProdutoBean() {
		produtos = new Produtos();
		buscarTodos();
	}

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<Produtos> getAlProdutos() {
		return alProdutos;
	}

	public void setAlProdutos(List<Produtos> alProdutos) {
		this.alProdutos = alProdutos;
	}

// 	Operações com o Banco

	public void buscarTodos() {
		setAlProdutos(produtoDAO.buscarTodos(produtos));
	}

	public void add() {
		if (produtos.getCodigo() != null) {
			setMensagem("Codigo preenchido, não é possivel cadastrar!");
			return;
		}

		Produtos prodRetorno = produtoDAO.add(produtos);
		if (prodRetorno == null) {
			setMensagem("Erro ao cadastrar produto!");
		} else {
			setMensagem("Produto cadastrado com sucesso!");
			buscarTodos();
		}
	}

	public void selecionar(Produtos prodSel) {
		setProdutos(prodSel);
	}

	public void filtrar() {
		if (produtos.getCodigo() == null) {
			setMensagem("Codigo vazio, informe o codigo para buscar!");
			return;
		}
		produtos = produtoDAO.filtrar(produtos, produtos.getCodigo());
		setMensagem(null);
	}

	public void update() {
		if (produtos.getCodigo() == null) {
			setMensagem("Código não preenchido, favor informar para a atualizar!");
			return;
		}
		produtos = produtoDAO.update(produtos);
		setProdutos(produtos);
		this.produtos = new Produtos();
		setMensagem(null);
	}

	public void delete() {
		produtoDAO.delete(produtos, produtos.getCodigo());
		this.produtos = new Produtos();
		setMensagem("Produto Deletado!");
		buscarTodos();
	}
}
