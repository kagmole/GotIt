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
@Table(name = "modules")
@XmlRootElement
public class ModuleEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_module")
    private Integer id;
    
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    
    @JoinTable(name = "modules_dependencies", joinColumns = {
        @JoinColumn(name = "id_module", referencedColumnName = "id_module")}, inverseJoinColumns = {
        @JoinColumn(name = "id_dependency", referencedColumnName = "id_module")})
    @ManyToMany
    private List<ModuleEntity> dependencyModulesList;
    
    @ManyToMany(mappedBy = "dependencyModulesList")
    private List<ModuleEntity> dependentModulesList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<CourseEntity> coursesList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "module")
    private List<ModuleTrainingEntity> modulesTrainingsList;

    /**
     * TODO CONSTRUCTORS JAVADOC    
     */
    public ModuleEntity() {
    }

    public ModuleEntity(Integer id) {
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

    @XmlTransient
    public List<ModuleEntity> getDependencyModulesList() {
        return dependencyModulesList;
    }

    public void setDependencyModulesList(List<ModuleEntity> dependencyModulesList) {
        this.dependencyModulesList = dependencyModulesList;
    }

    @XmlTransient
    public List<ModuleEntity> getDependentModulesList() {
        return dependentModulesList;
    }

    public void setDependentModulesList(List<ModuleEntity> dependentModulesList) {
        this.dependentModulesList = dependentModulesList;
    }

    @XmlTransient
    public List<CourseEntity> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<CourseEntity> coursesList) {
        this.coursesList = coursesList;
    }

    @XmlTransient
    public List<ModuleTrainingEntity> getModulesTrainingsList() {
        return modulesTrainingsList;
    }

    public void setModulesTrainingsList(List<ModuleTrainingEntity> modulesTrainingsList) {
        this.modulesTrainingsList = modulesTrainingsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (id != null ? id.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ModuleEntity)) {
            return false;
        }
        
        ModuleEntity other = (ModuleEntity) object;
        
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "ModuleEntity[id=" + id + "]";
    }
    
}
