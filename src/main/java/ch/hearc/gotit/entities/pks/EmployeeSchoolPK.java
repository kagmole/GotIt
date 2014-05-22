package ch.hearc.gotit.entities.pks;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Embeddable
public class EmployeeSchoolPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
    @NotNull
    @Column(name = "id_employee")
    private int idEmployee;
	
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_school")
    private int idSchool;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_employee_type")
    private int idEmployeeType;

    public EmployeeSchoolPK() {
    }

    public EmployeeSchoolPK(int idEmployee, int idSchool, int idEmployeeType) {
        this.idEmployee = idEmployee;
        this.idSchool = idSchool;
        this.idEmployeeType = idEmployeeType;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdSchool() {
        return idSchool;
    }

    public void setIdSchool(int idSchool) {
        this.idSchool = idSchool;
    }

    public int getIdEmployeeType() {
        return idEmployeeType;
    }

    public void setIdEmployeeType(int idEmployeeType) {
        this.idEmployeeType = idEmployeeType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (int) idEmployee;
        hash += (int) idSchool;
        hash += (int) idEmployeeType;
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EmployeeSchoolPK)) {
            return false;
        }
        
        EmployeeSchoolPK other = (EmployeeSchoolPK) object;
        
        if (this.idEmployee != other.idEmployee) {
            return false;
        }
        
        if (this.idSchool != other.idSchool) {
            return false;
        }
        
        if (this.idEmployeeType != other.idEmployeeType) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "EmployeeSchoolPK[idEmployee=" + idEmployee + ", idSchool=" + idSchool + ", idEmployeeType=" + idEmployeeType + "]";
    }
}
