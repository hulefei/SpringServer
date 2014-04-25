package com.springserver.service;

import com.springserver.po.HelloEntity;

/**
 * Created by hanson on 14-4-25.
 */
public interface HelloService {

    public HelloEntity getHelloEntity();
    public int insertHelloEntity(HelloEntity entity);
    public int deleteHelloEntity(HelloEntity entity);
}
