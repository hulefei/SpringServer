package com.springserver.dao;

import com.springserver.po.HelloEntity;

/**
 * Created by hanson on 14-4-25.
 */
public interface HelloDao {
    public HelloEntity selectHello();
}
