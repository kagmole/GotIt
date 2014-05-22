package ch.hearc.gotit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@Table(name = "events")
@XmlRootElement
public class EventEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_event")
    private Integer id;
    
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    
    @Column(name = "event_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDatetime;
    
    @Column(name = "importance")
    private Integer importance;
    
    @ManyToMany(mappedBy = "eventsList")
    private List<TrainingEntity> trainingsList;
    
    @ManyToMany(mappedBy = "eventsList")
    private List<SchoolEntity> schoolsList;
    
    @ManyToMany(mappedBy = "eventsList")
    private List<CourseEntity> coursesList;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public EventEntity() {
    }

    public EventEntity(Integer id) {
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

    public Date getEventDatetime() {
        return eventDatetime;
    }

    public void setEventDatetime(Date eventDatetime) {
        this.eventDatetime = eventDatetime;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    @XmlTransient
    public List<TrainingEntity> getTrainingsList() {
        return trainingsList;
    }

    public void setTrainingsList(List<TrainingEntity> trainingsList) {
        this.trainingsList = trainingsList;
    }

    @XmlTransient
    public List<SchoolEntity> getSchoolsList() {
        return schoolsList;
    }

    public void setSchoolsList(List<SchoolEntity> schoolsList) {
        this.schoolsList = schoolsList;
    }

    @XmlTransient
    public List<CourseEntity> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<CourseEntity> coursesList) {
        this.coursesList = coursesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (id != null ? id.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EventEntity)) {
            return false;
        }
        
        EventEntity other = (EventEntity) object;
        
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "EventEntity[id=" + id + "]";
    }
}
