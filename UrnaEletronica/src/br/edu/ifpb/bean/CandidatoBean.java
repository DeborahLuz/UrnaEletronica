package br.edu.ifpb.bean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.edu.ifpb.dao.CandidatoDao;
import br.edu.ifpb.entidades.Candidato;


@ManagedBean
@RequestScoped
public class CandidatoBean {
	private Candidato candidato;
	
	public CandidatoBean(){
		this.candidato = new Candidato();
		
	}
	
	public String cadastrarCandidato(){
		
		CandidatoDao candidatoDao = new CandidatoDao();
		candidatoDao.insert(candidato);
		return "http://localhost:8080/UrnaEletronica/index.xhtml";
	}
	
	
	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}


}


