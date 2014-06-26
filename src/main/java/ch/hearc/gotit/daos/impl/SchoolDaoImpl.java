package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.SchoolDao;
import ch.hearc.gotit.entities.SchoolEntity;
import ch.hearc.gotit.entities.UserEntity;

import org.springframework.stereotype.Repository;

@Repository("schoolDao")
public class SchoolDaoImpl extends BasicDaoImpl<SchoolEntity, Integer> implements SchoolDao {

	public SchoolDaoImpl() {
		super(SchoolEntity.class);
	}

	@Override
	public UserEntity getFounderOf(SchoolEntity schoolEntity) {
		return (UserEntity) getCurrentSession()
				.getNamedQuery("SchoolQuery.getFounderOf")
				.setInteger("schoolPk", schoolEntity.getSchoolPk())
				.uniqueResult();
	}
}
