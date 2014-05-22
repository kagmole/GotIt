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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@Table(name = "courses")
@XmlRootElement
public class CourseEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_course")
    private Integer id;
    
    @Size(max = 45)
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
        @JoinColumn(name = "id_course", referencedColumnName = "id_course")}, inverseJoinColumns = {
        @JoinColumn(name = "id_assessment", referencedColumnName = "id_assessment")})
    @ManyToMany
    private List<AssessmentEntity> assessmentsList;
    
    @ManyToMany(mappedBy = "coursesList")
    private List<EmployeeEntity> employeesList;
    
    @JoinTable(name = "events_courses", joinColumns = {
        @JoinColumn(name = "id_course", referencedColumnName = "id_course")}, inverseJoinColumns = {
        @JoinColumn(name = "id_event", referencedColumnName = "id_event")})
    @ManyToMany
    private List<EventEntity> eventsList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<ClassEntity> classesList;
    
    @JoinColumn(name = "id_module", referencedColumnName = "id_module")
    @ManyToOne(optional = false)
    private ModuleEntity module;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<StudentCourseEntity> studentsCoursesList;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public CourseEntity() {
    }

    public CourseEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @XmlTransient
    public List<AssessmentEntity> getAssessmentsList() {
        return assessmentsList;
    }

    public void setAssessmentsList(List<AssessmentEntity> assessmentsList) {
        this.assessmentsList = assessmentsList;
    }

    @XmlTransient
    public List<EmployeeEntity> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<EmployeeEntity> employeesList) {
        this.employeesList = employeesList;
    }

    @XmlTransient
    public List<EventEntity> getEventsList() {
        return eventsList;
    }

    public void setEventsList(List<EventEntity> eventsList) {
        this.eventsList = eventsList;
    }

    @XmlTransient
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
        if (!(object instanceof CourseEntity)) {
            return false;
        }
        
        CourseEntity other = (CourseEntity) object;
        
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "CourseEntity[id=" + id + "]";
    }
}
