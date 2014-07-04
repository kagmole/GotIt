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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
			name = "ModuleQuery.findRangeWithSchool",
			query = "SELECT moduleEntity"
					+ " FROM ModuleEntity moduleEntity"
					+ " WHERE moduleEntity.school.schoolPk = :schoolPk")
})
@Table(name = "modules")
public class ModuleEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_module")
    private Integer modulePk;
    
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    
    @JoinColumn(name = "fk_school", referencedColumnName = "pk_school")
    @ManyToOne(optional = false)
    private SchoolEntity school;
    
    @JoinTable(name = "modules_dependencies", joinColumns = {
        @JoinColumn(name = "pk_module", referencedColumnName = "pk_module")}, inverseJoinColumns = {
        @JoinColumn(name = "pk_dependency", referencedColumnName = "pk_module")})
    @ManyToMany
    private List<ModuleEntity> dependencyModulesList = new ArrayList<>();
    
    @ManyToMany(mappedBy = "dependencyModulesList")
    private List<ModuleEntity> dependentModulesList = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "module")
    private List<CourseEntity> coursesList = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "module")
    private List<ModuleTrainingEntity> modulesTrainingsList = new ArrayList<>();

    /**
     * TODO CONSTRUCTORS JAVADOC    
     */
    public ModuleEntity() {
    }

    public ModuleEntity(Integer modulePk) {
        this.modulePk = modulePk;
    }

    public Integer getModulePk() {
        return modulePk;
    }

    public void setModulePk(Integer modulePk) {
        this.modulePk = modulePk;
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
    
    public SchoolEntity getSchool() {
    	return school;
    }
    
    public void setSchool(SchoolEntity school) {
    	this.school = school;
    }

    public List<ModuleEntity> getDependencyModulesList() {
        return dependencyModulesList;
    }

    public void setDependencyModulesList(List<ModuleEntity> dependencyModulesList) {
        this.dependencyModulesList = dependencyModulesList;
    }

    public List<ModuleEntity> getDependentModulesList() {
        return dependentModulesList;
    }

    public void setDependentModulesList(List<ModuleEntity> dependentModulesList) {
        this.dependentModulesList = dependentModulesList;
    }

    public List<CourseEntity> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<CourseEntity> coursesList) {
        this.coursesList = coursesList;
    }

    public List<ModuleTrainingEntity> getModulesTrainingsList() {
        return modulesTrainingsList;
    }

    public void setModulesTrainingsList(List<ModuleTrainingEntity> modulesTrainingsList) {
        this.modulesTrainingsList = modulesTrainingsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (modulePk != null ? modulePk.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ModuleEntity)) {
            return false;
        }
        
        ModuleEntity other = (ModuleEntity) object;
        
        if ((this.modulePk == null && other.modulePk != null) || (this.modulePk != null && !this.modulePk.equals(other.modulePk))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "ModuleEntity[id=" + modulePk + "]";
    }
    
}
