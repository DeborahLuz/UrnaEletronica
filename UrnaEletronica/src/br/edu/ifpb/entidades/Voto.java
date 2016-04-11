package br.edu.ifpb.entidades;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_voto")
@NamedQuery(name = "Voto.getAll", query = "from Voto")
public class Voto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa")
	private int id;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "eleitor_FK")
	private Eleitor eleitor;
	
	@ManyToOne
	@JoinColumn(name = "candidato_FK")
	private Candidato candidato;
	@Column
	private int numeroCandidato;
	@Column
	private Date data;
	@ManyToOne
	@JoinColumn(name = "urna_FK")
	private Urna urna;
	@Column
	private int votoCandidato;
	@Column
	private String cargo;
	
	public String getCargo() {
		return cargo;
	}
	public int getVotoCandidato() {
		return votoCandidato;
	}
	public void setVotoCandidato(int votoCandidato) {
		this.votoCandidato = votoCandidato;
	}
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
	public void setCargo(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setCandidato(Candidato candidato) {
		// TODO Auto-generated method stub
		
	}
	public void setData(java.util.Date data2) {
	
		// TODO Auto-generated method stub
		
	}
	
	
}
