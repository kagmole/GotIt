package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.EmployeeDao;
import ch.hearc.gotit.entities.EmployeeEntity;

import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDaoImpl extends BasicDaoImpl<EmployeeEntity, Integer> implements EmployeeDao {

	public EmployeeDaoImpl() {
		super(EmployeeEntity.class);
	}
}
