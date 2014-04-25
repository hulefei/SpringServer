package com.springserver.controller;

import com.springserver.po.HelloEntity;
import com.springserver.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Random;

@Controller
public class HelloController {

    @Resource(name="helloService")
    private HelloService helloService;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
        HelloEntity entity = helloService.getHelloEntity();
        System.out.println(entity.getPkid() + ":" + entity.getName() + ":" + entity.getAge());
        model.addAttribute("message", entity.toString());
        return "hello";
	}

    @RequestMapping(value="/insertEntity",method = RequestMethod.GET)
    public String insertEntity(ModelMap model) {
        HelloEntity entity = new HelloEntity();
        Random random = new Random();
        int rand = random.nextInt();
        entity.setPkid(rand);
        entity.setName("name" + rand);
        entity.setAge(rand);

        int ret = helloService.insertHelloEntity(entity);
        model.addAttribute("message", ret);
        return "hello";
//        return helloService.insertHelloEntity(entity);
    }
}