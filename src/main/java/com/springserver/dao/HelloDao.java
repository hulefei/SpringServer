package com.springserver.dao;

import com.springserver.po.HelloEntity;

/**
 * @author hanson Created on 14-4-25.
 */
public interface HelloDao {
    public HelloEntity selectHello();
    public int insertHello(HelloEntity entity);
    public int deleteHello(HelloEntity entity);
    public int updateHello(HelloEntity entity);
}
