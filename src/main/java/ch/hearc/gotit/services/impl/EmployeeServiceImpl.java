package ch.hearc.gotit.services.impl;

import ch.hearc.gotit.daos.BasicDao;
import ch.hearc.gotit.daos.EmployeeDao;
import ch.hearc.gotit.entities.EmployeeEntity;
import ch.hearc.gotit.services.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("employeeService")
public class EmployeeServiceImpl extends BasicServiceImpl<EmployeeEntity, Integer> implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	protected BasicDao<EmployeeEntity, Integer> getDao() {
		return employeeDao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<EmployeeEntity> findRangeWithSchool(Integer schoolPk, int offset, int limit) {
		return employeeDao.findRangeWithSchool(schoolPk, offset, limit);
	}
}
