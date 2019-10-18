package cn.ltx.activiti7.controller;

import cn.ltx.activiti7.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * Created by admin on 17/6/16.
 */

@RestController
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/index")
    public Object index() {
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        return "success";
    }

    @RequestMapping("/login1")
    @ResponseBody
    public Map<String,Object> login1() {
        User user = new User("","","");
        return null;
    }

    @RequestMapping("/login2")
    @ResponseBody
    public Map<String,Object> login2() {
        return null;
    }
}