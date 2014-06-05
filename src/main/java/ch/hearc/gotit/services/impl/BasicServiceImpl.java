package ch.hearc.gotit.services.impl;

import ch.hearc.gotit.daos.BasicDao;
import ch.hearc.gotit.services.BasicService;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public abstract class BasicServiceImpl<E, K> implements BasicService<E, K> {
	
	protected abstract BasicDao<E, K> getDao();

	@Override
	@Transactional(readOnly = false)
	public void create(E entity) {
		getDao().create(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(E entity) {
		getDao().update(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void destroy(E entity) {
		getDao().destroy(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public E findOne(K key) {
		return getDao().findOne(key);
	}

	@Override
	@Transactional(readOnly = true)
	public List<E> findRange(int offset, int limit) {
		return getDao().findRange(offset, limit);
	}

	@Override
	@Transactional(readOnly = true)
	public List<E> findAll() {
		return getDao().findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return getDao().count();
	}
}
