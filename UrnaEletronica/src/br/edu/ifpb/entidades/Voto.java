package br.edu.ifpb.entidades;

import java.sql.Date;

public class Voto {
	private Eleitor eleitor;
	private int numeroCandidato;
	private Date data;
	private Urna urna;
	
	public Eleitor getEleitor() {
		return eleitor;
	}
	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}
	public int getNumeroCandidato() {
		return numeroCandidato;
	}
	public void setNumeroCandidato(int numeroCandidato) {
		this.numeroCandidato = numeroCandidato;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Urna getUrna() {
		return urna;
	}
	public void setUrna(Urna urna) {
		this.urna = urna;
	}
	
	
}
