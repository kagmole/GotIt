package ch.hearc.gotit.daos;

import java.util.List;

import ch.hearc.gotit.entities.StudentEntity;

public interface StudentDao extends BasicDao<StudentEntity, Integer> {
	
	public List<StudentEntity> findRangeWithSchool(Integer schoolPk, int offset, int limit);
}
