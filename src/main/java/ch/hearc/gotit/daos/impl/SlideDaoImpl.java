package ch.hearc.gotit.daos.impl;

import java.util.List;

import ch.hearc.gotit.daos.SlideDao;
import ch.hearc.gotit.entities.SlideEntity;

import org.springframework.stereotype.Repository;

@Repository("slideDao")
public class SlideDaoImpl extends BasicDaoImpl<SlideEntity, Integer> implements SlideDao {

	public SlideDaoImpl() {
		super(SlideEntity.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SlideEntity> findRangeWithClass(Integer classPk, int offset, int limit) {
		return getCurrentSession()
				.getNamedQuery("SlideQuery.findRangeWithClass")
				.setInteger("classPk", classPk)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.list();
	}
}
