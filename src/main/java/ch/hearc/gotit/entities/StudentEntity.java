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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@Table(name = "students")
@XmlRootElement
public class StudentEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_student")
    private Integer id;
    
    @JoinTable(name = "students_schools", joinColumns = {
        @JoinColumn(name = "id_student", referencedColumnName = "id_student")}, inverseJoinColumns = {
        @JoinColumn(name = "id_school", referencedColumnName = "id_school")})
    @ManyToMany
    private List<SchoolEntity> schoolsList;
    
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @OneToOne(optional = false)
    private UserEntity user;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<AssessmentResultEntity> assessmentsResultsList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<StudentTrainingEntity> studentsTrainingsList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<StudentCourseEntity> studentsCoursesList;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    
    public StudentEntity() {
    }

    public StudentEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
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

    @XmlTransient
    public List<AssessmentResultEntity> getAssessmentsResultsList() {
        return assessmentsResultsList;
    }

    public void setAssessmentsResultsList(List<AssessmentResultEntity> assessmentsResultsList) {
        this.assessmentsResultsList = assessmentsResultsList;
    }

    @XmlTransient
    public List<StudentTrainingEntity> getStudentsTrainingsList() {
        return studentsTrainingsList;
    }

    public void setStudentsTrainingsList(List<StudentTrainingEntity> studentsTrainingsList) {
        this.studentsTrainingsList = studentsTrainingsList;
    }

    @XmlTransient
    public List<StudentCourseEntity> getStudentsCoursesList() {
        return studentsCoursesList;
    }

    public void setStudentsCoursesList(List<StudentCourseEntity> studentsCoursesList) {
        this.studentsCoursesList = studentsCoursesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (id != null ? id.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof StudentEntity)) {
            return false;
        }
        
        StudentEntity other = (StudentEntity) object;
        
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "StudentEntity[id=" + id + "]";
    }
}
