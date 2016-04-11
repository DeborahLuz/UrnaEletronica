package br.edu.ifpb.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.ifpb.entidades.Candidato;
import br.edu.ifpb.urnaeletronica.hibernate.HibernateUtil;

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
	

public Candidato getByNumero(int numero) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Candidato candidato = null;
		
		try {
			
			String hql = "from Candidato as a"
					+ " where a.numero = :numero";
			
			Query query = session.createQuery(hql);
			query.setParameter("numero", numero);
			
			candidato = (Candidato) query.uniqueResult();
	        
		} catch (HibernateException hibernateException) {
			
			session.getTransaction().rollback();
			
		} finally {
		
			session.close();
		}
		
		return candidato;
	}
	
	@SuppressWarnings("unchecked")
	public List <Candidato> getAllCandidatos() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List <Candidato> candidatos = null;
		String candidato = "Candidato";
		
		try {
			
			String hql = "from Pessoa "
					+ " where DTYPE = :candidato";
			
			Query query = session.createQuery(hql);
			query.setParameter("candidato", candidato);
			
			candidatos = (List<Candidato>) query.list();
	        
		} catch (HibernateException hibernateException) {
			
			session.getTransaction().rollback();
			
		} finally {
		
			session.close();
		}
		
		return candidatos;
	}
	
	@SuppressWarnings("unchecked")
	public int getNumCandidatos(String cargo) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List <Candidato> candidatos = null;
		
		try {
			
			String hql = "from Pessoa as a"
					+ " where a.cargo = :cargo";
			
			Query query = session.createQuery(hql);
			query.setParameter("cargo", cargo);
			
			candidatos = (List<Candidato>) query.list();
	        
		} catch (HibernateException hibernateException) {
			
			session.getTransaction().rollback();
			
		} finally {
		
			session.close();
		}
		if(candidatos == null)
			return 0;
		
		return candidatos.size();
	}


	@Override
	public Candidato getById(Integer pk) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Candidato candidato = null;

		try {
			session.beginTransaction();
			candidato = (Candidato) session.get(Candidato.class, pk);
			session.getTransaction().commit();

		} catch (HibernateException hexp) {
			session.getTransaction().rollback();

		} finally {
			session.close();
		}

		return candidato;
	}
}
