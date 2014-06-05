package ch.hearc.gotit.services.impl;

import ch.hearc.gotit.daos.BasicDao;
import ch.hearc.gotit.daos.SchoolDao;
import ch.hearc.gotit.entities.EmployeeSchoolTypeEntity;
import ch.hearc.gotit.entities.EmployeeTypeEntity;
import ch.hearc.gotit.entities.SchoolEntity;
import ch.hearc.gotit.entities.TrainingEntity;
import ch.hearc.gotit.entities.UserEntity;
import ch.hearc.gotit.services.EmployeeTypeService;
import ch.hearc.gotit.services.SchoolService;
import ch.hearc.gotit.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("schoolService")
public class SchoolServiceImpl extends BasicServiceImpl<SchoolEntity, Integer> implements SchoolService {
	
	@Autowired
	private EmployeeTypeService employeeTypeService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SchoolDao schoolDao;
	
	@Override
	protected BasicDao<SchoolEntity, Integer> getDao() {
		return schoolDao;
	}
	
	@Override
	@Transactional(readOnly = false)
	public void createWithUser(SchoolEntity schoolEntity, UserEntity userEntity) {
		EmployeeSchoolTypeEntity employeeSchoolTypeEntity = new EmployeeSchoolTypeEntity();
		employeeSchoolTypeEntity.setEmployee(userEntity.getEmployee());
		employeeSchoolTypeEntity.setSchool(schoolEntity);
		employeeSchoolTypeEntity.setEmployeeType(employeeTypeService.findOneWithName("founder"));
		
		schoolEntity.getEmployeesSchoolsTypesList().add(employeeSchoolTypeEntity);;
		
		schoolDao.create(schoolEntity);
	}
	
	@Override
	@Transactional(readOnly = false)
	public void addEmployeeWithType(SchoolEntity schoolEntity, UserEntity userEntity, EmployeeTypeEntity employeeTypeEntity) {
		EmployeeSchoolTypeEntity employeeSchoolTypeEntity = new EmployeeSchoolTypeEntity();
		employeeSchoolTypeEntity.setEmployee(userEntity.getEmployee());
		employeeSchoolTypeEntity.setSchool(schoolEntity);
		employeeSchoolTypeEntity.setEmployeeType(employeeTypeEntity);
		
		schoolEntity.getEmployeesSchoolsTypesList().add(employeeSchoolTypeEntity);
		
		schoolDao.update(schoolEntity);
	}
	
	@Override
	@Transactional(readOnly = false)
	public void addStudent(SchoolEntity schoolEntity, UserEntity userEntity) {
		schoolEntity.getStudentsList().add(userEntity.getStudent());
		
		schoolDao.update(schoolEntity);
	}
	
	@Override
	@Transactional(readOnly = false)
	public void addTraining(SchoolEntity schoolEntity, TrainingEntity trainingEntity) {
		schoolEntity.getTrainingsList().add(trainingEntity);
		
		schoolDao.update(schoolEntity);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isUpdateAuthorized(SchoolEntity schoolEntity, UserEntity userEntity) {		
		for (EmployeeSchoolTypeEntity employeeSchoolTypeEntity : userEntity.getEmployee().getEmployeesSchoolsTypesList()) {
			if (employeeSchoolTypeEntity.getSchool().equals(schoolEntity)) {
				if (employeeSchoolTypeEntity.getEmployeeType().getName().equals("founder")) {
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isDestroyAuthorized(SchoolEntity schoolEntity, UserEntity userEntity) {
		for (EmployeeSchoolTypeEntity employeeSchoolTypeEntity : userEntity.getEmployee().getEmployeesSchoolsTypesList()) {
			if (employeeSchoolTypeEntity.getSchool().equals(schoolEntity)) {
				if (employeeSchoolTypeEntity.getEmployeeType().getName().equals("founder")) {
					return true;
				}
			}
		}
		
		return false;
	}
}
