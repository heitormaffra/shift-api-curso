package br.com.fiap.curso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_curso")
public class CursoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@Column(length=100)
	private String nome;

	@NotNull
	@Column(length=300)
	private String descricao;
	
	@NotNull
	@Column(length=100)
	private String url;
	
	public CursoEntity() {
		double teste = (Math.random() * 100);
		this.url = "www.siteshift.com.br/"+teste;
	}

	public CursoEntity(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
		double teste = (Math.random() * 100);
		this.url = "www.siteshift.com.br/"+teste;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	

}
