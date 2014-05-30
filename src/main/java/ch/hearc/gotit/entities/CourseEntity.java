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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@Table(name = "courses")
public class CourseEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_course")
    private Integer coursePk;
    
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    
    @Column(name = "duration")
    private Integer duration;
    
    @Column(name = "weight")
    private Float weight;
    
    @JoinTable(name = "assessments_courses", joinColumns = {
        @JoinColumn(name = "pk_course", referencedColumnName = "pk_course")}, inverseJoinColumns = {
        @JoinColumn(name = "pk_assessment", referencedColumnName = "pk_assessment")})
    @ManyToMany
    private List<AssessmentEntity> assessmentsList;
    
    @ManyToMany(mappedBy = "coursesList")
    private List<EmployeeEntity> employeesList;
    
    @JoinTable(name = "events_courses", joinColumns = {
        @JoinColumn(name = "pk_course", referencedColumnName = "pk_course")}, inverseJoinColumns = {
        @JoinColumn(name = "pk_event", referencedColumnName = "pk_event")})
    @ManyToMany
    private List<EventEntity> eventsList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<ClassEntity> classesList;
    
    @JoinColumn(name = "fk_module", referencedColumnName = "pk_module")
    @ManyToOne(optional = false)
    private ModuleEntity module;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<StudentCourseEntity> studentsCoursesList;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public CourseEntity() {
    }

    public CourseEntity(Integer coursePk) {
        this.coursePk = coursePk;
    }

    public Integer getCoursePk() {
        return coursePk;
    }

    public void setCoursePk(Integer coursePk) {
        this.coursePk = coursePk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public List<AssessmentEntity> getAssessmentsList() {
        return assessmentsList;
    }

    public void setAssessmentsList(List<AssessmentEntity> assessmentsList) {
        this.assessmentsList = assessmentsList;
    }

    public List<EmployeeEntity> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<EmployeeEntity> employeesList) {
        this.employeesList = employeesList;
    }

    public List<EventEntity> getEventsList() {
        return eventsList;
    }

    public void setEventsList(List<EventEntity> eventsList) {
        this.eventsList = eventsList;
    }

    public List<ClassEntity> getClassesList() {
        return classesList;
    }

    public void setClassesList(List<ClassEntity> classesList) {
        this.classesList = classesList;
    }

    public ModuleEntity getModule() {
        return module;
    }

    public void setModule(ModuleEntity module) {
        this.module = module;
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
        
        hash += (coursePk != null ? coursePk.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CourseEntity)) {
            return false;
        }
        
        CourseEntity other = (CourseEntity) object;
        
        if ((this.coursePk == null && other.coursePk != null) || (this.coursePk != null && !this.coursePk.equals(other.coursePk))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "CourseEntity[id=" + coursePk + "]";
    }
}
