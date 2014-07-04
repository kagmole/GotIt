package ch.hearc.gotit.daos.impl;

import java.util.List;

import ch.hearc.gotit.daos.ClassDao;
import ch.hearc.gotit.entities.ClassEntity;

import org.springframework.stereotype.Repository;

@Repository("classDao")
public class ClassDaoImpl extends BasicDaoImpl<ClassEntity, Integer> implements ClassDao {

	public ClassDaoImpl() {
		super(ClassEntity.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClassEntity> findRangeWithCourse(Integer coursePk, int offset, int limit) {
		return getCurrentSession()
				.getNamedQuery("ClassQuery.findRangeWithCourse")
				.setInteger("coursePk", coursePk)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.list();
	}
}
