package br.edu.ifpb.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Eleitor.getAll", query = "from Eleitor")
public class Eleitor extends Pessoa {
	@Column
	private String tituloVotacao;
	@Column
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTituloVotacao() {
		return tituloVotacao;
	}

	public void setTituloVotacao(String tituloVotacao) {
		this.tituloVotacao = tituloVotacao;
	}

	
	
}