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

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@Table(name = "events")
public class EventEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_event")
    private Integer eventPk;
    
    @Size(max = 50)
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

    public EventEntity(Integer eventPk) {
        this.eventPk = eventPk;
    }

    public Integer getEventPk() {
        return eventPk;
    }

    public void setEventPk(Integer eventPk) {
        this.eventPk = eventPk;
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

    public List<TrainingEntity> getTrainingsList() {
        return trainingsList;
    }

    public void setTrainingsList(List<TrainingEntity> trainingsList) {
        this.trainingsList = trainingsList;
    }

    public List<SchoolEntity> getSchoolsList() {
        return schoolsList;
    }

    public void setSchoolsList(List<SchoolEntity> schoolsList) {
        this.schoolsList = schoolsList;
    }

    public List<CourseEntity> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<CourseEntity> coursesList) {
        this.coursesList = coursesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (eventPk != null ? eventPk.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EventEntity)) {
            return false;
        }
        
        EventEntity other = (EventEntity) object;
        
        if ((this.eventPk == null && other.eventPk != null) || (this.eventPk != null && !this.eventPk.equals(other.eventPk))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "EventEntity[id=" + eventPk + "]";
    }
}
