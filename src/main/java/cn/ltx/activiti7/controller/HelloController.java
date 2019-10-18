package cn.ltx.activiti7.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Created by admin on 17/6/16.
 */

@Controller
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/hello")
    public Object index() {
        logger.debug("hello");
        return "hello";
    }

}