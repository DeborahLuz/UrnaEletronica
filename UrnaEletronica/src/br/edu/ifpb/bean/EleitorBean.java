package br.edu.ifpb.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.ifpb.dao.EleitorDao;
import br.edu.ifpb.entidades.Eleitor;

@ManagedBean
@RequestScoped
public class EleitorBean {
	
	private Eleitor eleitor;
	
	public EleitorBean(){
		this.eleitor = new Eleitor();
		
	}
	
	public String cadastrarEleitor(){
		
		EleitorDao eleitorDao = new EleitorDao();
		eleitorDao.insert(eleitor);
		return "http://localhost:8080/UrnaEletronica/index.xhtml";
	}
	
	
	public Eleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}


}
