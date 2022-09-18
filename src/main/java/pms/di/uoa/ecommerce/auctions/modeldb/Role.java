package pms.di.uoa.ecommerce.auctions.modeldb;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "role_id", nullable = false)
    private int roleId;
    @Basic
    @Column(name = "role_description", nullable = true, length = 55)
    private String roleDescription;
    @OneToMany(mappedBy = "roleByRoleRoleId")
    private Collection<Users> usersByRoleId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return roleId == role.roleId && Objects.equals(roleDescription, role.roleDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleDescription);
    }

    public Collection<Users> getUsersByRoleId() {
        return usersByRoleId;
    }

    public void setUsersByRoleId(Collection<Users> usersByRoleId) {
        this.usersByRoleId = usersByRoleId;
    }
}
