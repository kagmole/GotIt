package ch.hearc.gotit.entities;

import ch.hearc.gotit.entities.pks.StudentCoursePk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@Table(name = "students_courses")
@XmlRootElement
public class StudentCourseEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected StudentCoursePk studentCoursePk;
    
    @Size(max = 50)
    @Column(name = "grade")
    private String grade;
    
    @Column(name = "course_complete")
    private Boolean courseComplete;
    
    @JoinColumn(name = "pk_course", referencedColumnName = "pk_course", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CourseEntity course;
    
    @JoinColumn(name = "pk_student", referencedColumnName = "pk_student", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private StudentEntity student;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public StudentCourseEntity() {
    }

    public StudentCourseEntity(StudentCoursePk studentCoursePK) {
        this.studentCoursePk = studentCoursePK;
    }

    public StudentCourseEntity(int idStudent, int idCourse) {
        this.studentCoursePk = new StudentCoursePk(idStudent, idCourse);
    }

    public StudentCoursePk getStudentCoursePk() {
        return studentCoursePk;
    }

    public void setStudentCoursePk(StudentCoursePk studentCoursePk) {
        this.studentCoursePk = studentCoursePk;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Boolean getCourseComplete() {
        return courseComplete;
    }

    public void setCourseComplete(Boolean courseComplete) {
        this.courseComplete = courseComplete;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
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
        
        hash += (studentCoursePk != null ? studentCoursePk.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof StudentCourseEntity)) {
            return false;
        }
        
        StudentCourseEntity other = (StudentCourseEntity) object;
        
        if ((this.studentCoursePk == null && other.studentCoursePk != null) || (this.studentCoursePk != null && !this.studentCoursePk.equals(other.studentCoursePk))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "StudentCourseEntity[studentCoursePK=" + studentCoursePk + "]";
    }
}
