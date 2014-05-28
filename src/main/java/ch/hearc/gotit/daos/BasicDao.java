package ch.hearc.gotit.daos;

import java.util.List;

public interface BasicDao<E, K> {
	
	public void create(E entity);
	public void update(E entity);
	public void destroy(E entity);
	
	public E find(K key);
	public List<E> findRange(int offset, int limit);
	public List<E> findAll();
	
	public int count();
}
