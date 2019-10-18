package cn.ltx.activiti7.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Description:
 *
 * @author litianxiang
 */
@Entity
@Table(name = "T_USER", indexes = {
        @Index(name = "PK_USER_GUID", columnList = "USER_GUID", unique = true),
        @Index(name = "IND_USER_DISPLAYNAME", columnList = "USER_DISPLAYNAME")}
)
public class User implements Serializable {
    private String userGuid;
    private String allPathName;
    private String displayName;
    private Set<Role> roles;

    public User(String userGuid, String allPathName, String displayName) {
        this.userGuid = userGuid;
        this.allPathName = allPathName;
        this.displayName = displayName;
    }

    /**
     * Description:
     * <p>
     * Oracle:
     *
     * @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TestSequence")
     * @SequenceGenerator(name = "TestSequence", sequenceName = "SEQ_Test", allocationSize=1) <p>
     * Mysql:
     * @GeneratedValue(strategy=GenerationType.IDENTITY) <p>
     * UUID:
     * @Id
     * @GenericGenerator(name = "idGenerator", strategy = "uuid")
     * @GeneratedValue(generator = "idGenerator")
     */
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "USER_GUID", nullable = false)
    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }

    public String getAllPathName() {
        return allPathName;
    }

    public void setAllPathName(String allPathName) {
        this.allPathName = allPathName;
    }

    @Column(name = "USER_DISPLAYNAME", nullable = false)
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Description:多对多关系，维护关系的一端，name=中间表，定义外键关系
     */
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "T_USER_ROLE",
            joinColumns = {@JoinColumn(name = "USER_GUID", referencedColumnName = "user_guid")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "role_id")})
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "userGuid='" + userGuid + '\'' +
                ", allPathName='" + allPathName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", roles=" + roles +
                '}';
    }
}
