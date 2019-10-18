package cn.ltx.activiti7.controller;

import cn.ltx.activiti7.entity.Verification;
import cn.ltx.activiti7.service.VerificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by admin on 17/6/16.
 */

@Controller
@RequestMapping("/vf")
public class VerificationController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private VerificationService vfService;

    @RequestMapping("/list")
    public String list(ModelMap map) {
        List<Verification> vfList = vfService.findAll();
        map.put("vfList",vfList);
        return "/vf/list";
    }

    @RequestMapping("/insertUI")
    public String insertUI(ModelMap map) {
        Verification verification = new Verification();
        verification.setName("name");
        verification.setReason("reason");
        map.put("verification",verification);
        return "/vf/insert";
    }

    @RequestMapping("insert")
    public String insert(@ModelAttribute Verification verification) {
        logger.warn(" ==  {}",verification);
        vfService.save(verification);
        return "redirect:/vf/list";
    }

}