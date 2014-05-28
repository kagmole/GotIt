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
public class StudentTrainingPk implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
    @NotNull
    @Column(name = "pk_student")
    private int studentPk;
	
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_training")
    private int trainingPk;

    /**
     * TODO CONSTRUCTORS JAVADOC    
     */
    public StudentTrainingPk() {
    }

    public StudentTrainingPk(int studentPk, int trainingPk) {
        this.studentPk = studentPk;
        this.trainingPk = trainingPk;
    }

    public int getStudentPk() {
        return studentPk;
    }

    public void setStudentPk(int studentPk) {
        this.studentPk = studentPk;
    }

    public int getTrainingPk() {
        return trainingPk;
    }

    public void setTrainingPk(int trainingPk) {
        this.trainingPk = trainingPk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (int) studentPk;
        hash += (int) trainingPk;
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof StudentTrainingPk)) {
            return false;
        }
        
        StudentTrainingPk other = (StudentTrainingPk) object;
        
        if (this.studentPk != other.studentPk) {
            return false;
        }
        
        if (this.trainingPk != other.trainingPk) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "StudentTrainingPK[idStudent=" + studentPk + ", idTraining=" + trainingPk + "]";
    }
    
}
