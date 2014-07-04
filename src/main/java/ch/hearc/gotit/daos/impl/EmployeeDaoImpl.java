package ch.hearc.gotit.daos.impl;

import java.util.List;

import ch.hearc.gotit.daos.EmployeeDao;
import ch.hearc.gotit.entities.EmployeeEntity;

import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDaoImpl extends BasicDaoImpl<EmployeeEntity, Integer> implements EmployeeDao {

	public EmployeeDaoImpl() {
		super(EmployeeEntity.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeEntity> findRangeWithSchool(Integer schoolPk, int offset, int limit) {
		return getCurrentSession()
				.getNamedQuery("EmployeeQuery.findRangeWithSchool")
				.setInteger("schoolPk", schoolPk)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.list();
	}
}
