package ch.hearc.gotit.entities;

import ch.hearc.gotit.entities.pks.StudentTrainingPk;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@Table(name = "students_trainings")
public class StudentTrainingEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected StudentTrainingPk studentTrainingPk = new StudentTrainingPk();
    
    @Column(name = "starting_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startingDatetime;
    
    @Column(name = "ending_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endingDatetime;
    
    @Column(name = "training_complete")
    private Boolean trainingComplete;
    
    @MapsId("trainingPk")
    @JoinColumn(name = "pk_training", referencedColumnName = "pk_training", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TrainingEntity training;
    
    @MapsId("studentPk")
    @JoinColumn(name = "pk_student", referencedColumnName = "pk_student", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private StudentEntity student;

    /**
     * TODO CONSTRUCTORS JAVADOC    
     */
    public StudentTrainingEntity() {
    }

    public StudentTrainingEntity(StudentTrainingPk studentTrainingPK) {
        this.studentTrainingPk = studentTrainingPK;
    }

    public StudentTrainingEntity(int studentPk, int trainingPk) {
        this.studentTrainingPk = new StudentTrainingPk(studentPk, trainingPk);
    }

    public StudentTrainingPk getStudentTrainingPk() {
        return studentTrainingPk;
    }

    public void setStudentTrainingPk(StudentTrainingPk studentTrainingPk) {
        this.studentTrainingPk = studentTrainingPk;
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
        
        hash += (studentTrainingPk != null ? studentTrainingPk.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof StudentTrainingEntity)) {
            return false;
        }
        
        StudentTrainingEntity other = (StudentTrainingEntity) object;
        
        if ((this.studentTrainingPk == null && other.studentTrainingPk != null) || (this.studentTrainingPk != null && !this.studentTrainingPk.equals(other.studentTrainingPk))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "StudentTrainingEntity[studentTrainingPK=" + studentTrainingPk + "]";
    }
}
