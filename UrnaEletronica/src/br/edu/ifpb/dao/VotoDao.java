package br.edu.ifpb.dao;

import java.util.List;
import org.hibernate.Session;

import javax.management.Query;

import org.hibernate.HibernateException;


import br.edu.ifpb.entidades.Voto;
import br.edu.ifpb.urnaeletronica.hibernate.HibernateUtil;


public class VotoDao extends GenericDao<Integer, Voto>{

	private static VotoDao instance;

	public static VotoDao getInstance() {	

		instance = new VotoDao();	

		return instance;

	}

	@Override
	public Voto find(Voto entity) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public java.util.List<Voto> getAll() {

		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		   List votos = null;

		try {
			   session.beginTransaction();
			   Query query = (Query) session.getNamedQuery("Voto.getAll");
			   votos = (List) ((org.hibernate.Query) query).list();
			   session.getTransaction().commit();

		} catch (HibernateException hexp) {
			session.getTransaction().rollback();

		} finally {
			session.clear();
			session.close();
		}

		   return  votos;
	}

	@Override
	public Class<?> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public Voto getById(Integer pk) {

		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		Voto voto = null;

		try {

			session.beginTransaction();
			voto = (Voto) session.get(Voto.class, pk);
			session.getTransaction().commit();

		} catch (HibernateException hexp) {
			session.getTransaction().rollback();

		} finally {

			session.close();

		}

		return voto;
	}
	@SuppressWarnings("unchecked")
	public List<Voto> getByVoto(int id) {

		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();

		List <Voto> votos = null;

		try {

			String hql = "from Voto where eleitor.id = :id";

			Query query =  (Query) session.createQuery(hql);
			((org.hibernate.Query) query).setParameter("id", id);

			votos = (List) ((org.hibernate.Query) query).list();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

		} finally {

			session.close();
		}

		return votos;
	}
	@SuppressWarnings("unchecked")
	public int getVotosCandidato(int numero, String cargo) {

		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();


		List <Voto> votos = null;

		try {

			String hql = "from Voto where voto_candidato = :numero and cargo_candidato = :cargo";

			Query query = (Query) session.createQuery(hql);
			((org.hibernate.Query) query).setParameter("numero", numero);
			((org.hibernate.Query) query).setParameter("cargo", cargo);
			
			votos = (List) ((org.hibernate.Query) query).list();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

		} finally {

			session.close();
		}
		if (votos ==  null)
			return 0;

		return ((java.util.List<Voto>) votos).size();
	}

	@SuppressWarnings("unchecked")
	public int getVotosEmBranco(){

		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();

		List votos = null;

		try {

			String hql = "from Voto where voto_candidato = :numero";

			Query query = (Query) session.createQuery(hql);
			((org.hibernate.Query) query).setParameter("numero", 0);

			votos = (List) ((org.hibernate.Query) query).list();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

		} finally {

			session.close();
		}
		if (votos ==  null)
			return 0;

		return ((java.util.List<Voto>) votos).size();
	}
}

