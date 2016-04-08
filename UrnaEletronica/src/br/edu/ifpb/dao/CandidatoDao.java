package br.edu.ifpb.dao;

import java.util.List;

import org.hibernate.HibernateException;

import br.edu.ifpb.entidades.Candidato;

public class CandidatoDao extends GenericDao<Integer, Candidato> {

	private static CandidatoDao instance;
	
	public static CandidatoDao getInstance() {	
		
		instance = new CandidatoDao();		
		return instance;
	}

	@Override
	public List<Candidato> getAll() throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Candidato find(Candidato entity) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

}
