package com.springserver.service.impl;

import com.springserver.dao.HelloDao;
import com.springserver.po.HelloEntity;
import com.springserver.service.HelloService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author hanson Created on 14-4-25.
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService {

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

    @Override
    public int updateEntity(HelloEntity entity) {
        return helloDao.updateHello(entity);
    }

//    @Cacheable(value="defaultCache")
//    @Override
//    public HelloEntity getHelloEntityDelay() {
//        System.out.println("HelloServiceImpl::getHelloEntityDelay");
//        try {
//            //延时返回
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Random random= new Random();
//        HelloEntity entity = new HelloEntity();
//        entity.setName("aaa");
//        entity.setPkid(random.nextInt());
//        entity.setAge(random.nextInt());
//        return entity;
//    }
}
