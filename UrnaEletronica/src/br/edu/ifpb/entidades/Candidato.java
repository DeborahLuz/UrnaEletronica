package br.edu.ifpb.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Candidato.getAll", query = "from Candidato")
public class Candidato extends Eleitor{
	@Column
	private String nomePartido;
	@Column
	private int numero;
	@Column
	private String Cargo;
	
	public String getNomePartido() {
		return nomePartido;
	}
	public void setNomePartido(String nomePartido) {
		this.nomePartido = nomePartido;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCargo() {
		return Cargo;
	}
	public void setCargo(String cargo) {
		Cargo = cargo;
	}
	
}
