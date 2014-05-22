package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.EmployeeSchoolDao;
import ch.hearc.gotit.entities.EmployeeSchoolEntity;
import ch.hearc.gotit.entities.pks.EmployeeSchoolPK;

import org.springframework.stereotype.Repository;

@Repository("employeeSchoolDao")
public class EmployeeSchoolDaoImpl extends BasicDaoImpl<EmployeeSchoolEntity, EmployeeSchoolPK> implements EmployeeSchoolDao {

	public EmployeeSchoolDaoImpl() {
		super(EmployeeSchoolEntity.class);
	}
}
