package ch.hearc.gotit.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@Table(name = "users")
@XmlRootElement
public class UserEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private Integer id;
    
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    
    @Size(max = 45)
    @Column(name = "firstname")
    private String firstname;
    
    @Size(max = 45)
    @Column(name = "lastname")
    private String lastname;
    
    @Email
    @Size(max = 45)
    @Column(name = "main_email")
    private String mainEmail;
    
    @Email
    @Size(max = 45)
    @Column(name = "secondary_email")
    private String secondaryEmail;
    
    @Size(max = 45)
    @Column(name = "location")
    private String location;
    
    @Size(max = 45)
    @Column(name = "home_phone")
    private String homePhone;
    
    @Size(max = 45)
    @Column(name = "private_phone")
    private String privatePhone;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "biography")
    private String biography;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private StudentEntity student;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private EmployeeEntity employee;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public UserEntity() {
    }

    public UserEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMainEmail() {
        return mainEmail;
    }

    public void setMainEmail(String mainEmail) {
        this.mainEmail = mainEmail;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getPrivatePhone() {
        return privatePhone;
    }

    public void setPrivatePhone(String privatePhone) {
        this.privatePhone = privatePhone;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployees(EmployeeEntity employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (id != null ? id.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UserEntity)) {
            return false;
        }
        
        UserEntity other = (UserEntity) object;
        
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "UserEntity[id=" + id + "]";
    }
}
