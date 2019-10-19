package cn.ltx.activiti7.controller;

import cn.ltx.activiti7.entity.User;
import cn.ltx.activiti7.service.UserService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * Created by admin on 17/6/16.
 */

@Controller
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public Object index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, ModelMap modelMap) {
        String userGuid = request.getParameter("userGuid");
        String allPathName = request.getParameter("allPathName");
        String displayName = request.getParameter("displayName");
        User user = new User(userGuid,allPathName,displayName);
        request.getSession().setAttribute("user",user);

        return "redirect:/vf/list";
    }

}