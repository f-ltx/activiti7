package cn.ltx.activiti7.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author Administrator
 */
@Entity
@Table(name = "T_APPLY")
public class Apply implements Serializable {
    private static final long serialVersionUID = 4655214207763277833L;
    private Long applyId;
    private String applyName;
    private User applyUser;
    private Date applyDate;
    private String status;
    private Verification verification;
    private Set<Approve> approves;

    public static final String STATUS_APPROVING = "审批中";
    public static final String STATUS_UNAPPROVED = "未通过";
    public static final String STATUS_APPROVED = "已通过";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "applyUserGuid")
//    @Transient
    @Column(name = "APPLY_USER_GUID")
    public User getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(User applyUser) {
        this.applyUser = applyUser;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Description:JoinColumn会在apply中生成字段，按照指定name生成
     */
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "vfId")
    @Transient
    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }

    /**
     * Description:
     * mappedBy 不会在apply表中生成字段
     */
//    @OneToMany(mappedBy = "apply", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Transient
    public Set<Approve> getApproves() {
        return approves;
    }

    public void setApproves(Set<Approve> approves) {
        this.approves = approves;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "applyId=" + applyId +
                ", applyName='" + applyName + '\'' +
                ", applyUser=" + applyUser +
                ", applyDate=" + applyDate +
                ", status='" + status + '\'' +
                ", verification=" + verification +
                ", approves=" + approves +
                '}';
    }
}