package com.springserver.service.impl;

import com.springserver.dao.HelloDao;
import com.springserver.po.HelloEntity;
import com.springserver.service.HelloService;
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

    @Override
    public int insertHelloEntity(HelloEntity entity) {
        return helloDao.insertHello(entity);
    }

    @Override
    public int deleteHelloEntity(HelloEntity entity) {
        return helloDao.deleteHello(entity);
    }
}
