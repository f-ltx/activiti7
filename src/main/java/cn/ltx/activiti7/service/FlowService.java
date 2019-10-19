package cn.ltx.activiti7.service;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FlowService {
    @Autowired
    private RepositoryService repositoryService;

    @Transactional(rollbackFor = Exception.class)
    public Deployment deploy() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        deploymentBuilder.addClasspathResource("processes/applyProcess.bpmn");
        deploymentBuilder.addClasspathResource("processes/applyProcess.png");
        deploymentBuilder.name("申请流程");
        Deployment deploy = deploymentBuilder.deploy();
        return deploy;
    }
}
