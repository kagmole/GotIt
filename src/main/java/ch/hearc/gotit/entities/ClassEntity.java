package ch.hearc.gotit.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@NamedQueries({
	@NamedQuery(
			name = "ClassQuery.findRangeWithCourse",
			query = "SELECT classEntity"
					+ " FROM ClassEntity classEntity"
					+ " WHERE classEntity.course.coursePk = :coursePk")
})
@Table(name = "classes")
public class ClassEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_class")
    private Integer classPk;
    
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classEntity")
    private List<SlideEntity> slidesList = new ArrayList<>();
    
    @JoinColumn(name = "fk_course", referencedColumnName = "pk_course")
    @ManyToOne(optional = false)
    private CourseEntity course;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public ClassEntity() {
    }

    public ClassEntity(Integer classPk) {
        this.classPk = classPk;
    }

    public Integer getClassPk() {
        return classPk;
    }

    public void setClassPk(Integer classPk) {
        this.classPk = classPk;
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
    
    public List<SlideEntity> getSlidesList() {
    	return slidesList;
    }
    
    public void setSlidesList(List<SlideEntity> slidesList) {
    	this.slidesList = slidesList;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (classPk != null ? classPk.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ClassEntity)) {
            return false;
        }
        
        ClassEntity other = (ClassEntity) object;
        
        if ((this.classPk == null && other.classPk != null) || (this.classPk != null && !this.classPk.equals(other.classPk))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "ClassEntity[id=" + classPk + "]";
    }
}
