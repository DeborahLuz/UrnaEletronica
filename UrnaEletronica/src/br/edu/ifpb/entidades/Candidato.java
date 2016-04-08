package br.edu.ifpb.entidades;

public class Candidato extends Pessoa{
	private String nomePartido;
	private int numeroPartido;
	private String Cargo;
	
	public String getNomePartido() {
		return nomePartido;
	}
	public void setNomePartido(String nomePartido) {
		this.nomePartido = nomePartido;
	}
	public int getNumeroPartido() {
		return numeroPartido;
	}
	public void setNumeroPartido(int numeroPartido) {
		this.numeroPartido = numeroPartido;
	}
	public String getCargo() {
		return Cargo;
	}
	public void setCargo(String cargo) {
		Cargo = cargo;
	}

}
