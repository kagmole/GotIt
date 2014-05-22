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
public class StudentTrainingPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
    @NotNull
    @Column(name = "id_student")
    private int idStudent;
	
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_training")
    private int idTraining;

    /**
     * TODO CONSTRUCTORS JAVADOC    
     */
    public StudentTrainingPK() {
    }

    public StudentTrainingPK(int idStudent, int idTraining) {
        this.idStudent = idStudent;
        this.idTraining = idTraining;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdTraining() {
        return idTraining;
    }

    public void setIdTraining(int idTraining) {
        this.idTraining = idTraining;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (int) idStudent;
        hash += (int) idTraining;
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof StudentTrainingPK)) {
            return false;
        }
        
        StudentTrainingPK other = (StudentTrainingPK) object;
        
        if (this.idStudent != other.idStudent) {
            return false;
        }
        
        if (this.idTraining != other.idTraining) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "StudentTrainingPK[idStudent=" + idStudent + ", idTraining=" + idTraining + "]";
    }
    
}
