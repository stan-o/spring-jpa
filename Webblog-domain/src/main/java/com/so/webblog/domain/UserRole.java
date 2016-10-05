package com.so.webblog.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "user_role")
@NamedQueries({
    @NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u")})
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_role_name")
    private String idRoleName;
    @Column(name = "name_user_role")
    private String nameUserRole;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRole", fetch = FetchType.LAZY)
    private List<RoleName> roleNameList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRole", fetch = FetchType.LAZY)
    private List<User> userList;

    public UserRole() {
    }

    public UserRole(Integer id) {
        this.id = id;
    }

    public UserRole(Integer id, String idRoleName) {
        this.id = id;
        this.idRoleName = idRoleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdRoleName() {
        return idRoleName;
    }

    public void setIdRoleName(String idRoleName) {
        this.idRoleName = idRoleName;
    }

    public String getNameUserRole() {
        return nameUserRole;
    }

    public void setNameUserRole(String nameUserRole) {
        this.nameUserRole = nameUserRole;
    }

    public List<RoleName> getRoleNameList() {
        return roleNameList;
    }

    public void setRoleNameList(List<RoleName> roleNameList) {
        this.roleNameList = roleNameList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    @SuppressWarnings("PMD")
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRole)) {
            return false;
        }
        UserRole other = (UserRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.so.webblog.domain.UserRole[ id=" + id + " ]";
    }
    
}
