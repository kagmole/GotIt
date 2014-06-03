package ch.hearc.gotit.services;

import ch.hearc.gotit.daos.TrainingDao;
import ch.hearc.gotit.entities.ModuleEntity;
import ch.hearc.gotit.entities.TrainingEntity;

public interface TrainingService extends BasicService<TrainingEntity, Integer>, TrainingDao {
	
	public void addModuleWithWeight(TrainingEntity trainingEntity, ModuleEntity moduleEntity, Float weight);
}
