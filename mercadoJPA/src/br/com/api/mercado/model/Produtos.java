package br.com.api.mercado.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produtos")
public class Produtos implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_produto", nullable=false)
	private Integer codigo;
	
	@Column(name="marca_produto")
	private String marca;
	
	@Column(name="nome_produto")
	private String nome;
	
	@Column(name="preco_produto")
	private Float preco;
		
	
	@Column(name="id_fornecedor")
	private Integer codigoFornecedor;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Integer getcodigoFornecedor() {
		return codigoFornecedor;
	}

	public void setcodigoFornecedor(Integer codigoFornecedor) {
		this.codigoFornecedor = codigoFornecedor;
	}
	
	@Override
	    public String toString() {
	        return "Produtos {" + "codigo=" + codigo + ", nome=" + nome + ", marca=" + marca+ ", preço = "+preco+", codigo fornecedor = "+codigoFornecedor+" }";
	    }

	@Override
	    public int hashCode() {
	        int hash = 5;
	        hash = 97 * hash + Objects.hashCode(this.codigo);
	        return hash;
	    }

	@Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final Produtos other = (Produtos) obj;
	        if (!Objects.equals(this.nome, other.nome)) {
	            return false;
	        }
	        if (!Objects.equals(this.marca, other.marca)) {
	            return false;
	        }
	        if (!Objects.equals(this.codigo, other.codigo)) {
	            return false;
	        }
	        if (!Objects.equals(this.preco, other.preco)) {
	            return false;
	        }
	        if (!Objects.equals(this.codigoFornecedor, other.codigoFornecedor)) {
	            return false;
	        }
	        return true;
	    }
   
}
