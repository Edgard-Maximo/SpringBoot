package br.org.generation.farmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria_model")
public class CategoriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(min = 3, max = 100,message = "Campo obrigatório, inserir de 3 a 100 caracteres")
	private String descricao;
	
	@NotNull(message= "O atributo qntEstoque é obrigatório!")
	private Integer qntEstoque;
	
	@OneToMany(mappedBy = "categoriaModel", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoriaModel")
	private List<ProdutoModel> produtoModel;


	public List<ProdutoModel> getProdutoModel() {
		return produtoModel;
	}

	public void setProdutoModel(List<ProdutoModel> produtoModel) {
		this.produtoModel = produtoModel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQntEstoque() {
		return qntEstoque;
	}

	public void setQntEstoque(Integer qntEstoque) {
		this.qntEstoque = qntEstoque;
	}
	
	
	
}

	
