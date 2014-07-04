package ch.hearc.gotit.entities;

import java.io.Serializable;

import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
	@NamedQuery(
			name = "SlideQuery.findRangeWithClass",
			query = "SELECT slideEntity"
					+ " FROM SlideEntity slideEntity"
					+ " WHERE slideEntity.classEntity.classPk = :classPk")
})
@Table(name = "slides")
public class SlideEntity implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_slide")
    private Integer slidePk;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "content")
    private String content;
    
    @JoinColumn(name = "fk_class", referencedColumnName = "pk_class")
    @ManyToOne(optional = false)
    private ClassEntity classEntity;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public SlideEntity() {
    }

    public SlideEntity(Integer slidePk) {
        this.slidePk = slidePk;
    }

    public Integer getSlidePk() {
        return slidePk;
    }

    public void setSlidePk(Integer slidePk) {
        this.slidePk = slidePk;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (slidePk != null ? slidePk.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SlideEntity)) {
            return false;
        }
        
        SlideEntity other = (SlideEntity) object;
        
        if ((this.slidePk == null && other.slidePk != null) || (this.slidePk != null && !this.slidePk.equals(other.slidePk))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "SlideEntity[id=" + slidePk + "]";
    }
}
