package cn.ltx.activiti7.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Administrator
 */
@Entity
@Table(name = "T_ROLE", indexes = {
        @Index(name = "PK_ROLE_ID", columnList = "ROLE_ID", unique = true),
        @Index(name = "IND_ROLE_NAME", columnList = "ROLE_NAME"),
        @Index(name = "IND_ROLE_CODENAME", columnList = "ROLE_CODENAME", unique = true)})
public class Role implements Serializable {
    private static final long serialVersionUID = 4729745556865743855L;
    private String roleId;
    private String codeName;
    private String roleName;
    private Set<User> users;

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "ROLE_ID", nullable = false)
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Column(name = "ROLE_CODENAME", nullable = false)
    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }


    @Column(name = "ROLE_NAME", nullable = false)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Description:mappedBy属性定义了User为双向关系的维护端
     */
//    @JsonIgnoreProperties(value = {"users"})// 解决循环查找的问题
//    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    @Transient
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", codeName='" + codeName + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
