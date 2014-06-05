package ch.hearc.gotit.services.impl;

import ch.hearc.gotit.daos.BasicDao;
import ch.hearc.gotit.daos.EmployeeTypeDao;
import ch.hearc.gotit.entities.EmployeeTypeEntity;
import ch.hearc.gotit.services.EmployeeTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeTypeService")
public class EmployeeTypeServiceImpl extends BasicServiceImpl<EmployeeTypeEntity, Integer> implements EmployeeTypeService {

	@Autowired
	EmployeeTypeDao employeeTypeDao;

	@Override
	protected BasicDao<EmployeeTypeEntity, Integer> getDao() {
		return employeeTypeDao;
	}
	
	@Override
	public EmployeeTypeEntity findOneWithName(String name) {
		return employeeTypeDao.findOneWithName(name);
	}
}
