package br.edu.ifpb.entidades;

public class Apuracao {

	private int id;
	
	private Candidato prefeitoEleito;

	private Candidato governadorEleito;

	private Candidato presidenteEleito;

	private Candidato prefeitoMaisVotado;
	
	private Candidato governadorMaisVotado;
	
	private Candidato presidenteMaisVotado;
	
	private Candidato prefeitoMenosVotado;
	
	private Candidato governadorMenosVotado;
	
	private Candidato presidenteMenosVotado;
	
	private int quantVotos;

	private int quantBrancos;
	
	private int quantNulos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Candidato getPrefeitoEleito() {
		return prefeitoEleito;
	}

	public void setPrefeitoEleito(Candidato prefeitoEleito) {
		this.prefeitoEleito = prefeitoEleito;
	}

	public Candidato getGovernadorEleito() {
		return governadorEleito;
	}

	public void setGovernadorEleito(Candidato governadorEleito) {
		this.governadorEleito = governadorEleito;
	}

	public Candidato getPresidenteEleito() {
		return presidenteEleito;
	}

	public void setPresidenteEleito(Candidato presidenteEleito) {
		this.presidenteEleito = presidenteEleito;
	}

	public Candidato getPrefeitoMaisVotado() {
		return prefeitoMaisVotado;
	}

	public void setPrefeitoMaisVotado(Candidato prefeitoMaisVotado) {
		this.prefeitoMaisVotado = prefeitoMaisVotado;
	}

	public Candidato getGovernadorMaisVotado() {
		return governadorMaisVotado;
	}

	public void setGovernadorMaisVotado(Candidato governadorMaisVotado) {
		this.governadorMaisVotado = governadorMaisVotado;
	}

	public Candidato getPresidenteMaisVotado() {
		return presidenteMaisVotado;
	}

	public void setPresidenteMaisVotado(Candidato presidenteMaisVotado) {
		this.presidenteMaisVotado = presidenteMaisVotado;
	}

	public Candidato getPrefeitoMenosVotado() {
		return prefeitoMenosVotado;
	}

	public void setPrefeitoMenosVotado(Candidato prefeitoMenosVotado) {
		this.prefeitoMenosVotado = prefeitoMenosVotado;
	}

	public Candidato getGovernadorMenosVotado() {
		return governadorMenosVotado;
	}

	public void setGovernadorMenosVotado(Candidato governadorMenosVotado) {
		this.governadorMenosVotado = governadorMenosVotado;
	}

	public Candidato getPresidenteMenosVotado() {
		return presidenteMenosVotado;
	}

	public void setPresidenteMenosVotado(Candidato presidenteMenosVotado) {
		this.presidenteMenosVotado = presidenteMenosVotado;
	}

	public int getQuantVotos() {
		return quantVotos;
	}

	public void setQuantVotos(int quantVotos) {
		this.quantVotos = quantVotos;
	}

	public int getQuantBrancos() {
		return quantBrancos;
	}

	public void setQuantBrancos(int quantBrancos) {
		this.quantBrancos = quantBrancos;
	}

	public int getQuantNulos() {
		return quantNulos;
	}

	public void setQuantNulos(int quantNulos) {
		this.quantNulos = quantNulos;
	}
	
		


}
