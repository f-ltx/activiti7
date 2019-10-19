package cn.ltx.activiti7.controller;

import cn.ltx.activiti7.entity.Apply;
import cn.ltx.activiti7.entity.User;
import cn.ltx.activiti7.entity.Verification;
import cn.ltx.activiti7.service.FlowService;
import cn.ltx.activiti7.service.VerificationService;
import com.alibaba.fastjson.JSON;
import org.activiti.engine.repository.Deployment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


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

    @RequestMapping("/apply")
    public String apply(HttpServletRequest request, ModelMap modelMap) {
        String vfId = request.getParameter("vfId");
        Verification vf = vfService.findByVfId(Long.parseLong(vfId));
        User user = (User) request.getSession().getAttribute("user");
//        if(user == null){
//            return "";
//        }
        Apply apply = new Apply();
        apply.setApplyDate(new Date());
        apply.setApplyName(vf.getName() + "-" + "申请" + user.getDisplayName());
        apply.setApplyUser(user);
        apply.setStatus(Apply.STATUS_APPROVING);
        apply.setVerification(vf);
        flowService.apply(apply);
        return "/flow/apply";
    }

    @RequestMapping("/deploy")
    public String deploy() {
        Deployment deploy = flowService.deploy();
        logger.warn("deploy = {}", JSON.toJSONString(deploy));
        return "index";
    }

}