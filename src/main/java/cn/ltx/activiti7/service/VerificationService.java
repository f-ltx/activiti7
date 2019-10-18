package cn.ltx.activiti7.service;

import cn.ltx.activiti7.dao.VerificationDao;
import cn.ltx.activiti7.entity.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VerificationService {
    @Autowired
    private VerificationDao vfDao;

    @Transactional(rollbackFor = Exception.class)
    public void save(Verification verification) {
        vfDao.save(verification);
    }

    public List<Verification> findAll() {
        return vfDao.findAll();
    }

    public Verification findByVfId(Long vfId) {
        return vfDao.findById(vfId).get();
    }
}
