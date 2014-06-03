package ch.hearc.gotit.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
	@NamedQuery(
			name = "AuthorityQuery.findByRole",
			query = "SELECT a FROM AuthorityEntity a WHERE a.role = :role")
})
@Table(name = "authorities")
public class AuthorityEntity implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_authority")
    private Integer authorityPk;
    
    @Size(max = 50)
    @Column(name = "role")
    private String role;
    
    @OneToMany(mappedBy = "authority")
    private List<UserEntity> usersList = new ArrayList<>();

    public AuthorityEntity() {
    }

    public AuthorityEntity(Integer authorityPk) {
        this.authorityPk = authorityPk;
    }

    public Integer getAuthorityPk() {
        return authorityPk;
    }

    public void setAuthorityPk(Integer authorityPk) {
        this.authorityPk = authorityPk;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<UserEntity> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<UserEntity> usersList) {
        this.usersList = usersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (authorityPk != null ? authorityPk.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AuthorityEntity)) {
            return false;
        }
        
        AuthorityEntity other = (AuthorityEntity) object;
        
        if ((this.authorityPk == null && other.authorityPk != null) || (this.authorityPk != null && !this.authorityPk.equals(other.authorityPk))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "ch.hearc.gotit.entities.Authorities[ pkAuthority=" + authorityPk + " ]";
    }
}
