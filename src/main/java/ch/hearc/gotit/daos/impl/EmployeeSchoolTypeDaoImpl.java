package ch.hearc.gotit.daos.impl;

import java.util.List;

import ch.hearc.gotit.daos.EmployeeSchoolTypeDao;
import ch.hearc.gotit.entities.EmployeeSchoolTypeEntity;
import ch.hearc.gotit.entities.pks.EmployeeSchoolTypePk;

import org.springframework.stereotype.Repository;

@Repository("employeeSchoolTypeDao")
public class EmployeeSchoolTypeDaoImpl extends BasicDaoImpl<EmployeeSchoolTypeEntity, EmployeeSchoolTypePk> implements EmployeeSchoolTypeDao {

	public EmployeeSchoolTypeDaoImpl() {
		super(EmployeeSchoolTypeEntity.class);
	}
}
