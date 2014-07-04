package ch.hearc.gotit.daos.impl;

import java.util.List;

import ch.hearc.gotit.daos.StudentDao;
import ch.hearc.gotit.entities.StudentEntity;

import org.springframework.stereotype.Repository;

@Repository("studentDao")
public class StudentDaoImpl extends BasicDaoImpl<StudentEntity, Integer> implements StudentDao {

	public StudentDaoImpl() {
		super(StudentEntity.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentEntity> findRangeWithSchool(Integer schoolPk, int offset, int limit) {
		return getCurrentSession()
				.getNamedQuery("StudentQuery.findRangeWithSchool")
				.setInteger("schoolPk", schoolPk)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.list();
	}
}
