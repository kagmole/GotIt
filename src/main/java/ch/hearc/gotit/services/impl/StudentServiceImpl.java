package ch.hearc.gotit.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.hearc.gotit.daos.BasicDao;
import ch.hearc.gotit.daos.StudentDao;
import ch.hearc.gotit.entities.StudentEntity;
import ch.hearc.gotit.services.StudentService;

@Service("studentService")
public class StudentServiceImpl extends BasicServiceImpl<StudentEntity, Integer> implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Override
	protected BasicDao<StudentEntity, Integer> getDao() {
		return studentDao;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<StudentEntity> findRangeWithSchool(Integer schoolPk, int offset, int limit) {
		return studentDao.findRangeWithSchool(schoolPk, offset, limit);
	}
}
