package ch.hearc.gotit.entities;

import ch.hearc.gotit.entities.pks.StudentTrainingPK;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@Table(name = "students_trainings")
@XmlRootElement
public class StudentTrainingEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected StudentTrainingPK studentTrainingPK;
    
    @Column(name = "starting_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startingDatetime;
    
    @Column(name = "ending_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endingDatetime;
    
    @Column(name = "training_complete")
    private Boolean trainingComplete;
    
    @JoinColumn(name = "id_training", referencedColumnName = "id_training", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TrainingEntity training;
    
    @JoinColumn(name = "id_student", referencedColumnName = "id_student", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private StudentEntity student;

    /**
     * TODO CONSTRUCTORS JAVADOC    
     */
    public StudentTrainingEntity() {
    }

    public StudentTrainingEntity(StudentTrainingPK studentTrainingPK) {
        this.studentTrainingPK = studentTrainingPK;
    }

    public StudentTrainingEntity(int idStudent, int idTraining) {
        this.studentTrainingPK = new StudentTrainingPK(idStudent, idTraining);
    }

    public StudentTrainingPK getStudentTrainingPK() {
        return studentTrainingPK;
    }

    public void setStudentTrainingPK(StudentTrainingPK studentTrainingPK) {
        this.studentTrainingPK = studentTrainingPK;
    }

    public Date getStartingDatetime() {
        return startingDatetime;
    }

    public void setStartingDatetime(Date startingDatetime) {
        this.startingDatetime = startingDatetime;
    }

    public Date getEndingDatetime() {
        return endingDatetime;
    }

    public void setEndingDatetime(Date endingDatetime) {
        this.endingDatetime = endingDatetime;
    }

    public Boolean getTrainingComplete() {
        return trainingComplete;
    }

    public void setTrainingComplete(Boolean trainingComplete) {
        this.trainingComplete = trainingComplete;
    }

    public TrainingEntity getTraining() {
        return training;
    }

    public void setTraining(TrainingEntity training) {
        this.training = training;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (studentTrainingPK != null ? studentTrainingPK.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof StudentTrainingEntity)) {
            return false;
        }
        
        StudentTrainingEntity other = (StudentTrainingEntity) object;
        
        if ((this.studentTrainingPK == null && other.studentTrainingPK != null) || (this.studentTrainingPK != null && !this.studentTrainingPK.equals(other.studentTrainingPK))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "StudentTrainingEntity[studentTrainingPK=" + studentTrainingPK + "]";
    }
}