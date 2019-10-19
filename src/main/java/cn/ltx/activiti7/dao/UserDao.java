package cn.ltx.activiti7.dao;

import cn.ltx.activiti7.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUserGuid(String userGuid);
}
