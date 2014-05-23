package com.springserver.service;

import com.springserver.po.HelloEntity;

/**
 * @author hanson Created on 14-4-25.
 */
public interface HelloService {

    public HelloEntity getHelloEntity();
    public int insertHelloEntity(HelloEntity entity);
    public int deleteHelloEntity(HelloEntity entity);
    public int updateEntity(HelloEntity entity);
    public HelloEntity getHelloEntityDelay();
}
