package br.com.usjt.aeroporto.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("unchecked")
public abstract class GenericDAO<T> {

	protected Class<T> classe;

	@Autowired
	protected SessionFactory sessionFactory;

	public GenericDAO(Class<T> classe) {
		this.classe = classe;
	}

	protected void save(T t) {
		getCurrentSession().save(t);

	}

	protected void update(T t) {
		getCurrentSession().update(t);

	}

	protected void delete(T t) {
		getCurrentSession().delete(t);

	}

	protected T findById(Long id) {
		return (T) getCurrentSession().get(classe, id);
	}

	protected List<T> findByAll() {
		List<T> findObject = getCurrentSession().createQuery("from :classe")
				.list();
		return findObject;
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
