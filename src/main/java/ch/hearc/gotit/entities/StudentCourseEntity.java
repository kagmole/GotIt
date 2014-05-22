package ch.hearc.gotit.entities;

import ch.hearc.gotit.entities.pks.StudentCoursePK;

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
    protected StudentCoursePK studentCoursePK;
    
    @Size(max = 45)
    @Column(name = "grade")
    private String grade;
    
    @Size(max = 45)
    @Column(name = "course_complete")
    private String courseComplete;
    
    @JoinColumn(name = "id_course", referencedColumnName = "id_course", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CourseEntity course;
    
    @JoinColumn(name = "id_student", referencedColumnName = "id_student", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private StudentEntity student;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public StudentCourseEntity() {
    }

    public StudentCourseEntity(StudentCoursePK studentCoursePK) {
        this.studentCoursePK = studentCoursePK;
    }

    public StudentCourseEntity(int idStudent, int idCourse) {
        this.studentCoursePK = new StudentCoursePK(idStudent, idCourse);
    }

    public StudentCoursePK getStudentCoursePK() {
        return studentCoursePK;
    }

    public void setStudentCoursePK(StudentCoursePK studentCoursePK) {
        this.studentCoursePK = studentCoursePK;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCourseComplete() {
        return courseComplete;
    }

    public void setCourseComplete(String courseComplete) {
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
        
        hash += (studentCoursePK != null ? studentCoursePK.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof StudentCourseEntity)) {
            return false;
        }
        
        StudentCourseEntity other = (StudentCourseEntity) object;
        
        if ((this.studentCoursePK == null && other.studentCoursePK != null) || (this.studentCoursePK != null && !this.studentCoursePK.equals(other.studentCoursePK))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "StudentCourseEntity[studentCoursePK=" + studentCoursePK + "]";
    }
}
