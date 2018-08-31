package com.springserver.controller;

import com.springserver.po.HelloEntity;
import com.springserver.service.HelloService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class HelloController {

    static public Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Resource(name="helloService")
    private HelloService helloService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Welcome SpringServer!");
        return "hello";
    }

    @RequestMapping(value="/getJson", method = RequestMethod.GET)
    public @ResponseBody HelloEntity getJson() {
        HelloEntity entity = new HelloEntity();
        entity.setPkid(11);
        entity.setName("hanson");
        entity.setAge(32);
        return entity;
    }

	@RequestMapping(value="/getEntity", method = RequestMethod.GET)
	public String getEntity(ModelMap model) {
        HelloEntity entity = helloService.getHelloEntity();
        System.out.println(entity.getPkid() + ":" + entity.getName() + ":" + entity.getAge());
        model.addAttribute("message", entity.toString());
        return "hello";
	}

    @RequestMapping(value="/getJsonEntity", method = RequestMethod.GET)
    public @ResponseBody HelloEntity getJsonEntity() {
        HelloEntity entity = helloService.getHelloEntity();
        System.out.println(entity.getPkid() + ":" + entity.getName() + ":" + entity.getAge());
        return entity;
    }

    @RequestMapping(value="/insertEntity",method = RequestMethod.GET)
    public String insertEntity(ModelMap model) {
        HelloEntity entity = new HelloEntity();
        Random random = new Random();
        int rand = random.nextInt();
        entity.setPkid(rand);
        entity.setName("name + " + rand);
        entity.setAge(rand);

        int i = helloService.insertHelloEntity(entity);
        System.out.println("affect : " + i);

        String message = "insert:" + entity;
        model.addAttribute("message", message);
        return "hello";
    }

    @RequestMapping(value="/deleteEntity",method = RequestMethod.GET)
    public String deleteEntity(ModelMap model) {

        HelloEntity entity = helloService.getHelloEntity();

        int i = helloService.deleteHelloEntity(entity);
        System.out.println("affect : " + i);

        String message = "delete:" + entity;
        model.addAttribute("message", message);

        return "hello";
    }

    @RequestMapping(value="/updateEntity",method = RequestMethod.GET)
    public String updateEntity(ModelMap model) {
        HelloEntity entity = helloService.getHelloEntity();
        entity.setName(entity.getName() + " has update");
        int i = helloService.updateEntity(entity);
        System.out.println("affect : " + i);

        String message = "update:" + entity;
        model.addAttribute("message", message);
        return "hello";
    }

    @RequestMapping(value = "/logtest", method = RequestMethod.GET)
    public String logtest(ModelMap model) {
        System.out.println("system log");
        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");
//        logger.fatal("fatal message");
        System.out.println("Hello World!");
        model.addAttribute("message", "watch console:[log file is under the directory of tomcat ]");
        return "hello";
    }

    @RequestMapping(value="/cache", method = RequestMethod.GET)
    public String cache(ModelMap model) {
        HelloEntity ret = helloService.getHelloEntityDelay();
        System.out.println(ret.getPkid());
        model.addAttribute("message",ret.getPkid());
        return "hello";
    }
}

