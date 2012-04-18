package br.com.usjt.aeroporto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;


@SuppressWarnings("unchecked")
@Transactional
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

	protected Class<T> classe;

	@PersistenceContext
	protected EntityManager entityManager;
	
	public GenericDAOImpl(Class<T> classe) {
		this.classe = classe;
	}

	public void save(T t) {
		
		getCurrentSession().persist(t);

	}

	public void update(T t) {
		getCurrentSession().merge(t);

	}

	public void delete(T t) {
		entityManager.remove(t);

	}

	public T findById(Long id) {
		return (T) getCurrentSession().find(classe, id);
	}

	public List<T> findByAll() {
		String jpql = "select * from :pClasse";
		Query query = (Query) this.getCurrentSession().createQuery(jpql);
		query.setParameter(":pClasse", classe);
		return query.getResultList();
	}

	public EntityManager getCurrentSession() {
		return entityManager;
	}

}
