package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.BasicDao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public abstract class BasicDaoImpl<E, K extends Serializable> implements BasicDao<E, K> {

	private SessionFactory sessionFactory;
	
    protected Class<E> entityClass;
    
	public BasicDaoImpl(Class<E> entityClass) {
		this.entityClass = entityClass;
    }
    
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
    protected Session getCurrentSession() {
    	return sessionFactory.getCurrentSession();
    }
	
	@Override
	public void create(E entity) {
		getCurrentSession().save(entity);
	}

	@Override
	public void update(E entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public void destroy(E entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E findOne(K key) {
		return (E) getCurrentSession().get(entityClass, key);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<E> findRange(int offset, int limit) {
		return getCurrentSession().createCriteria(entityClass)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> findAll() {
		return getCurrentSession().createCriteria(entityClass).list();
	}
}
