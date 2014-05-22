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
public class StudentCoursePK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
    @NotNull
    @Column(name = "id_student")
    private int idStudent;
	
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_course")
    private int idCourse;
    
    /**
     * TODO CONSTRUCTORS JAVADOC
     */

    public StudentCoursePK() {
    }

    public StudentCoursePK(int idStudent, int idCourse) {
        this.idStudent = idStudent;
        this.idCourse = idCourse;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (int) idStudent;
        hash += (int) idCourse;
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof StudentCoursePK)) {
            return false;
        }
        
        StudentCoursePK other = (StudentCoursePK) object;
        
        if (this.idStudent != other.idStudent) {
            return false;
        }
        
        if (this.idCourse != other.idCourse) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "StudentCoursePK[idStudent=" + idStudent + ", idCourse=" + idCourse + "]";
    }
    
}
