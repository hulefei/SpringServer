package com.hulefei.springserver.controller;

import com.hulefei.springserver.po.HelloEntity;
import com.hulefei.springserver.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
@RequestMapping("/")
public class HelloController {

    @Resource(name="helloService")
    private HelloService helloService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello Git");

        HelloEntity entity = helloService.getHelloEntity();
        System.out.println(entity.getName() + ":" + entity.getAge());
        return "hello";
	}
}