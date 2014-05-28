package ch.hearc.gotit.entities.pks;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Embeddable
public class ModuleTrainingPk implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
    @NotNull
    @Column(name = "pk_training")
    private int trainingPk;
	
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_module")
    private int modulePk;
    
    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public ModuleTrainingPk() {
    }

    public ModuleTrainingPk(int trainingPk, int modulePk) {
        this.trainingPk = trainingPk;
        this.modulePk = modulePk;
    }

    public int getTrainingPk() {
        return trainingPk;
    }

    public void setTrainingPk(int trainingPk) {
        this.trainingPk = trainingPk;
    }

    public int getModulePk() {
        return modulePk;
    }

    public void setModulePk(int modulePk) {
        this.modulePk = modulePk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (int) trainingPk;
        hash += (int) modulePk;
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ModuleTrainingPk)) {
            return false;
        }
        
        ModuleTrainingPk other = (ModuleTrainingPk) object;
        
        if (this.trainingPk != other.trainingPk) {
            return false;
        }
        
        if (this.modulePk != other.modulePk) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "ModuleTrainingPK[idTraining=" + trainingPk + ", idModule=" + modulePk + "]";
    }
}
