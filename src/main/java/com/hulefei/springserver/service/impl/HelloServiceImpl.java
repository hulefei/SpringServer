package com.hulefei.springserver.service.impl;

import com.hulefei.springserver.dao.HelloDao;
import com.hulefei.springserver.po.HelloEntity;
import com.hulefei.springserver.service.HelloService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by hanson on 14-4-25.
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService{

    @Resource(name="helloDao")
    private HelloDao helloDao;

    @Override
    public HelloEntity getHelloEntity() {
        return helloDao.selectHello();
    }
}
