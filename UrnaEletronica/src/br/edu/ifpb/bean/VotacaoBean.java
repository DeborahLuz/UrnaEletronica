package br.edu.ifpb.bean;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.ifpb.dao.CandidatoDao;
import br.edu.ifpb.dao.EleitorDao;
import br.edu.ifpb.dao.VotoDao;
import br.edu.ifpb.entidades.Apuracao;
import br.edu.ifpb.entidades.Candidato;
import br.edu.ifpb.entidades.Eleitor;
import br.edu.ifpb.entidades.Voto;


@SessionScoped
@ManagedBean	
public class VotacaoBean {
	
	private Eleitor eleitor;
	private Candidato candidato;
	private Voto voto;
	private Apuracao apuracao;
	private int cont = 3;
	private String redirecionar;
	
	public VotacaoBean() {
		
		this.eleitor = new Eleitor();
		this.candidato = new Candidato();
		this.voto = new Voto();
		this.apuracao = new Apuracao();
	}
	
	public String verificarEleicao() throws IOException{
		CandidatoDao candidatoDAO = new CandidatoDao();
		
		if((candidatoDAO.getNumCandidatos("Prefeito")>=2)&& (candidatoDAO.getNumCandidatos("Governador")>=2)
			&& (candidatoDAO.getNumCandidatos("Presidente")>=2)){
				redirecionar = "entrar-eleicao.xhtml?faces-redirect=true&includeViewParams=true";
				return redirecionar;
			}else{
			FacesContext.getCurrentInstance().addMessage(
					"messages",
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Não é possível iniciar uma eleição, não há candidatos suficientes", null));

		}
		return null;
	}

	public String verificarTitulo() throws IOException{
		EleitorDao eleitorDAO = new EleitorDao();
		Eleitor eleitor_aux = eleitorDAO.getByTitulo(eleitor.getTituloVotacao());
			
		if(eleitor_aux!=null){

			VotoDao votoDAO = new VotoDao();
			List<Voto> voto_aux = votoDAO.getByVoto(eleitor_aux.getId());
			if(voto_aux.size()==0){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("eleitor", eleitor_aux);
				redirecionar = "votar.xhtml?faces-redirect=true&includeViewParams=true";
				return redirecionar;
			}else{
				FacesContext.getCurrentInstance().addMessage(
						"growl",
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Não é possível votar: Eleitor já votou", null));
			}
		}else{
			FacesContext.getCurrentInstance().addMessage(
					"growl",
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Não é possível votar: Eleitor não cadastrado", null));
		}
		return null;
	}
	
	public void votar() throws IOException{	
		
		Date data = new Date();
		CandidatoDao candidatoDAO = new CandidatoDao();
		VotoDao votoDAO = new VotoDao();
		
		eleitor = (Eleitor)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("eleitor");

		Candidato candidato = candidatoDAO.getByNumero(voto.getVotoCandidato());
		
		switch (cont) {
		case 3:
			
			voto.setData(data);
			voto.setEleitor(eleitor);
			voto.setCandidato(candidato);
			voto.setCargo("Prefeito");

			FacesContext.getCurrentInstance().getExternalContext().redirect("votar-governador.xhtml");
			cont--;
			break;
		case 2:
			
			voto.setData(data);
			voto.setEleitor(eleitor);
			voto.setCandidato(candidato);
			voto.setCargo("Governador");

			FacesContext.getCurrentInstance().getExternalContext().redirect("votar-presidente.xhtml");
			cont--;
			break;
		case 1:
			
			voto.setData(data);
			voto.setEleitor(eleitor);
			voto.setCandidato(candidato);
			voto.setCargo("Presidente");
	
			FacesContext.getCurrentInstance().getExternalContext().redirect("entrar-eleicao.xhtml");
			cont = 3;
			break;

		default:
			break;
		}
		
		votoDAO.insert(voto);
	}
	
	public void votarBranco() throws IOException{
		Date data = new Date();
		
		voto.setData(data);
		voto.setEleitor(null);
		voto.setCandidato(null);
		voto.setVotoCandidato(0);
			
		VotoDao votoDAO = new VotoDao();
		votoDAO.insert(voto);
		
		switch (cont) {
		case 3:
			FacesContext.getCurrentInstance().getExternalContext().redirect("votarGovernador.xhtml");
			cont--;
			break;
		case 2:
			FacesContext.getCurrentInstance().getExternalContext().redirect("votarPresidente.xhtml");
			cont--;
			break;
		case 1:
			FacesContext.getCurrentInstance().getExternalContext().redirect("entrar-eleicao.xhtml");
			cont = 3;
			break;

		default:
			break;
		}
	}
	
	public Eleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	public Apuracao getApuracao() {
		return apuracao;
	}

	public void setApuracao(Apuracao apuracao) {
		this.apuracao = apuracao;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

}
	

	

