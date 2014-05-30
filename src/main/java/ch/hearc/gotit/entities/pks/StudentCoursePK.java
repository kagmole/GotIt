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
public class StudentCoursePk implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
    @NotNull
    @Column(name = "pk_student")
    private int studentPk;
	
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_course")
    private int coursePk;
    
    /**
     * TODO CONSTRUCTORS JAVADOC
     */

    public StudentCoursePk() {
    }

    public StudentCoursePk(int studentPk, int coursePk) {
        this.studentPk = studentPk;
        this.coursePk = coursePk;
    }

    public int getStudentPk() {
        return studentPk;
    }

    public void setStudentPk(int studentPk) {
        this.studentPk = studentPk;
    }

    public int getCoursePk() {
        return coursePk;
    }

    public void setCoursePk(int coursePk) {
        this.coursePk = coursePk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (int) studentPk;
        hash += (int) coursePk;
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof StudentCoursePk)) {
            return false;
        }
        
        StudentCoursePk other = (StudentCoursePk) object;
        
        if (this.studentPk != other.studentPk) {
            return false;
        }
        
        if (this.coursePk != other.coursePk) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "StudentCoursePK[idStudent=" + studentPk + ", idCourse=" + coursePk + "]";
    }
    
}
