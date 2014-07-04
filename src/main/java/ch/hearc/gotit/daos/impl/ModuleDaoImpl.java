package ch.hearc.gotit.daos.impl;

import java.util.List;

import ch.hearc.gotit.daos.ModuleDao;
import ch.hearc.gotit.entities.ModuleEntity;

import org.springframework.stereotype.Repository;

@Repository("moduleDao")
public class ModuleDaoImpl extends BasicDaoImpl<ModuleEntity, Integer> implements ModuleDao {

	public ModuleDaoImpl() {
		super(ModuleEntity.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ModuleEntity> findRangeWithSchool(Integer schoolPk, int offset, int limit) {
		return getCurrentSession()
				.getNamedQuery("ModuleQuery.findRangeWithSchool")
				.setInteger("schoolPk", schoolPk)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.list();
	}
}
