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
@Table(name="fornecedor")
public class Fornecedor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_fornecedor", nullable=false)
	private Integer codigo;
	
	@Column(name="cnpj_fornecedor", nullable=false)
	private String cnpj;
	
	@Column(name="nome_fornecedor", nullable=false)
	private String nome;
	
	@Column(name="fone_fornecedor", nullable=false)
	private String telefone;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	 @Override
	    public String toString() {
	        return "Fornecedor{" + "codigo=" + codigo + ", nome=" + nome + ", cnpj=" + cnpj + ", telefone=" + telefone + '}';
	    }

	    @Override
	    public int hashCode() {
	        int hash = 3;
	        hash = 31 * hash + Objects.hashCode(this.codigo);
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
	        final Fornecedor other = (Fornecedor) obj;
	        if (!Objects.equals(this.nome, other.nome)) {
	            return false;
	        }
	        if (!Objects.equals(this.cnpj, other.cnpj)) {
	            return false;
	        }
	        if (!Objects.equals(this.telefone, other.telefone)) {
	            return false;
	        }
	        if (!Objects.equals(this.codigo, other.codigo)) {
	            return false;
	        }
	        return true;
	    }
	
	
	

}
