package cn.ltx.activiti7.entity;

import javax.persistence.*;

@Entity
@Table(name = "T_APPROVE")
public class Approve {
    private Long approveId;
    private User approveUser;
    private Boolean approveFlag;
    private String approveComment;
    private Apply apply;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getApproveId() {
        return approveId;
    }

    public void setApproveId(Long approveId) {
        this.approveId = approveId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approveUserGuid")
    public User getApproveUser() {
        return approveUser;
    }

    public void setApproveUser(User approveUser) {
        this.approveUser = approveUser;
    }

    public Boolean getApproveFlag() {
        return approveFlag;
    }

    public void setApproveFlag(Boolean approveFlag) {
        this.approveFlag = approveFlag;
    }

    public String getApproveComment() {
        return approveComment;
    }

    public void setApproveComment(String approveComment) {
        this.approveComment = approveComment;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applyId")
    public Apply getApply() {
        return apply;
    }

    public void setApply(Apply apply) {
        this.apply = apply;
    }

    @Override
    public String toString() {
        return "Approve{" +
                "approveId=" + approveId +
                ", approveUser=" + approveUser +
                ", approveFlag=" + approveFlag +
                ", approveComment='" + approveComment + '\'' +
                ", apply=" + apply +
                '}';
    }
}