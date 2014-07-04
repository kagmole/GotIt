package ch.hearc.gotit.services.impl;

import java.util.List;

import ch.hearc.gotit.daos.BasicDao;
import ch.hearc.gotit.daos.TrainingDao;
import ch.hearc.gotit.entities.ModuleEntity;
import ch.hearc.gotit.entities.ModuleTrainingEntity;
import ch.hearc.gotit.entities.TrainingEntity;
import ch.hearc.gotit.services.TrainingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("trainingService")
public class TrainingServiceImpl extends BasicServiceImpl<TrainingEntity, Integer> implements TrainingService {

	@Autowired
	private TrainingDao trainingDao;
	
	@Override
	protected BasicDao<TrainingEntity, Integer> getDao() {
		return trainingDao;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<TrainingEntity> findRangeWithSchool(Integer schoolPk, int offset, int limit) {
		return trainingDao.findRangeWithSchool(schoolPk, offset, limit);
	}

	@Override
	public void addModuleWithWeight(TrainingEntity trainingEntity, ModuleEntity moduleEntity, Float weight) {
		ModuleTrainingEntity moduleTrainingEntity = new ModuleTrainingEntity();
		moduleTrainingEntity.setModule(moduleEntity);
		moduleTrainingEntity.setTraining(trainingEntity);
		moduleTrainingEntity.setWeight(weight);
		
		trainingEntity.getModulesTrainingsList().add(moduleTrainingEntity);
		
		trainingDao.update(trainingEntity);
	}
}
