package cn.ltx.activiti7.dao;

import cn.ltx.activiti7.entity.Verification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationDao extends JpaRepository<Verification, Long> {

}
