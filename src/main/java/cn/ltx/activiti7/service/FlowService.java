package cn.ltx.activiti7.service;

import cn.ltx.activiti7.dao.ApplyDao;
import cn.ltx.activiti7.entity.Apply;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class FlowService {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @Autowired
    private ApplyDao applyDao;

    @Transactional(rollbackFor = Exception.class)
    public Deployment deploy() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        deploymentBuilder.addClasspathResource("processes/applyProcess.bpmn");
        deploymentBuilder.addClasspathResource("processes/applyProcess.png");
        deploymentBuilder.name("申请流程");
        Deployment deploy = deploymentBuilder.deploy();
        return deploy;
    }

    @Transactional(rollbackFor = Exception.class)
    public void apply(Apply apply) {
        //保存审批实体
        applyDao.save(apply);
        String processDefinitionKey = "applyProcess";
        Map<String, Object> variables = new HashMap<>();
        variables.put("apply",apply);
        //根据流程变量，流程定义key启动流程实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, variables);
        //提交任务
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.processInstanceId(processInstance.getId());
        Task task = taskQuery.singleResult();
        taskService.complete(task.getId());
    }
}
