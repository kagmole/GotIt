package ch.hearc.gotit.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@Table(name = "students")
public class StudentEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_student")
    private Integer studentPk;
    
    @JoinTable(name = "students_schools", joinColumns = {
        @JoinColumn(name = "pk_student", referencedColumnName = "pk_student")}, inverseJoinColumns = {
        @JoinColumn(name = "pk_school", referencedColumnName = "pk_school")})
    @ManyToMany
    private List<SchoolEntity> schoolsList;
    
    @JoinColumn(name = "fk_user", referencedColumnName = "pk_user")
    @OneToOne(optional = false)
    private UserEntity user;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<AssessmentStudentEntity> assessmentsStudentsList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<StudentTrainingEntity> studentsTrainingsList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<StudentCourseEntity> studentsCoursesList;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    
    public StudentEntity() {
    }

    public StudentEntity(Integer studentPk) {
        this.studentPk = studentPk;
    }

    public Integer getStudentPk() {
        return studentPk;
    }

    public void setStudentPk(Integer studentPk) {
        this.studentPk = studentPk;
    }

    public List<SchoolEntity> getSchoolsList() {
        return schoolsList;
    }

    public void setSchoolsList(List<SchoolEntity> schoolsList) {
        this.schoolsList = schoolsList;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<AssessmentStudentEntity> getAssessmentsStudentsList() {
        return assessmentsStudentsList;
    }

    public void setAssessmentsStudentsList(List<AssessmentStudentEntity> assessmentsStudentsList) {
        this.assessmentsStudentsList = assessmentsStudentsList;
    }

    public List<StudentTrainingEntity> getStudentsTrainingsList() {
        return studentsTrainingsList;
    }

    public void setStudentsTrainingsList(List<StudentTrainingEntity> studentsTrainingsList) {
        this.studentsTrainingsList = studentsTrainingsList;
    }

    public List<StudentCourseEntity> getStudentsCoursesList() {
        return studentsCoursesList;
    }

    public void setStudentsCoursesList(List<StudentCourseEntity> studentsCoursesList) {
        this.studentsCoursesList = studentsCoursesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (studentPk != null ? studentPk.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof StudentEntity)) {
            return false;
        }
        
        StudentEntity other = (StudentEntity) object;
        
        if ((this.studentPk == null && other.studentPk != null) || (this.studentPk != null && !this.studentPk.equals(other.studentPk))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "StudentEntity[id=" + studentPk + "]";
    }
}
