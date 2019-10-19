package cn.ltx.activiti7.controller;

import cn.ltx.activiti7.entity.Apply;
import cn.ltx.activiti7.entity.TaskView;
import cn.ltx.activiti7.entity.User;
import cn.ltx.activiti7.entity.Verification;
import cn.ltx.activiti7.service.FlowService;
import cn.ltx.activiti7.service.UserService;
import cn.ltx.activiti7.service.VerificationService;
import com.alibaba.fastjson.JSON;
import org.activiti.engine.repository.Deployment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


/**
 * Created by admin on 17/6/16.
 */

@Controller
@RequestMapping("/flow")
public class FlowController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FlowService flowService;
    @Autowired
    private VerificationService vfService;
    @Autowired
    private UserService userService;

    @RequestMapping("/approve")
    public String approve(HttpServletRequest request, ModelMap modelMap){
        return "redirect:/flow/approveList";
    }

    @RequestMapping("/approveList")
    public String approveList(HttpServletRequest request, ModelMap modelMap){
        User user = (User) request.getSession().getAttribute("user");
        List<TaskView> taskList = flowService.findTaskList(user);
        modelMap.put("taskList",taskList);
        return "/vf/approveList";
    }

    @RequestMapping("/apply")
    public String apply(HttpServletRequest request, ModelMap modelMap) {
        String vfId = request.getParameter("vfId");
        Verification vf = vfService.findByVfId(Long.parseLong(vfId));
        User user = (User) request.getSession().getAttribute("user");
        Apply apply = new Apply();
        apply.setApplyDate(new Date());
        apply.setApplyName(vf.getName() + "-" + "申请" + user.getDisplayName());
        apply.setApplyUser(user);
        apply.setStatus(Apply.STATUS_APPROVING);
        apply.setVerification(vf);
        flowService.apply(apply);
        return "redirect:/vf/list";
    }

    @RequestMapping("/deploy")
    public String deploy() {
        Deployment deploy = flowService.deploy();
        logger.warn("deploy = {}", JSON.toJSONString(deploy));
        return "index";
    }

}