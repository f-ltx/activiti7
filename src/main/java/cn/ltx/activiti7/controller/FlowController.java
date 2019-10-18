package cn.ltx.activiti7.controller;

import cn.ltx.activiti7.entity.User;
import cn.ltx.activiti7.entity.Verification;
import cn.ltx.activiti7.service.FlowService;
import cn.ltx.activiti7.service.VerificationService;
import org.activiti.engine.repository.Deployment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    public String apply(ModelMap map, HttpServletRequest request) {
        String vfId = request.getParameter("vfId");
        Verification vf = vfService.findByVfId(Long.parseLong(vfId));

//        flowService.apply();
        return "/flow/apply";
    }

    @RequestMapping("/deploy")
    @ResponseBody
    public Map<String, Object> deploy() {
        Deployment deploy = flowService.deploy();
        Map<String, Object> map = new HashMap<>();
        map.put("deploy", deploy);
        return map;
    }

}