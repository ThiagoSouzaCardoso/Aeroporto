package br.com.usjt.aeroporto.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("unchecked")
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

	protected Class<T> classe;

	@Autowired
	protected SessionFactory sessionFactory;

	public GenericDAOImpl(Class<T> classe) {
		this.classe = classe;
	}

	@Override
	public void save(T t) {
		getCurrentSession().save(t);

	}

	@Override
	public void update(T t) {
		getCurrentSession().update(t);

	}

	@Override
	public void delete(T t) {
		getCurrentSession().delete(t);

	}

	@Override
	public T findById(Long id) {
		return (T) getCurrentSession().get(classe, id);
	}

	@Override
	public List<T> findByAll() {
		String jpql = "select * from :pClasse";
		Query query = (Query) this.getCurrentSession().createQuery(jpql);
		query.setParameter(":pClasse", classe);
		return query.getResultList();
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
