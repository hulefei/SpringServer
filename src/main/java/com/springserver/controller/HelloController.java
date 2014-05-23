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

    @RequestMapping(value="/deleteEntity",method = RequestMethod.GET)
    public String deleteEntity(ModelMap model) {

        HelloEntity entity = new HelloEntity();
        entity.setPkid(-770400629);
        int i = helloService.deleteHelloEntity(entity);
        model.addAttribute("message", i);

        return "hello";
    }

    @RequestMapping(value="/updateEntity",method = RequestMethod.GET)
    public String updateEntity(ModelMap model) {
        HelloEntity entity = new HelloEntity();
        entity.setPkid(1);
        entity.setName("name1_update1");
        int i = helloService.updateEntity(entity);
        model.addAttribute("message", i);
        return "hello";
    }


    @RequestMapping(value="/memcached", method = RequestMethod.GET)
    public String memcached(ModelMap model) {
        HelloEntity ret = helloService.getHelloEntityDelay();
        System.out.println(ret.getPkid());
        model.addAttribute("message",ret.getPkid());
        return "hello";
    }
}

