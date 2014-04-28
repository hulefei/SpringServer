package com.springserver.dao.impl;

import com.springserver.dao.HelloDao;
import com.springserver.po.HelloEntity;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by hanson on 14-4-25.
 */
@Repository("helloDao")
public class HelloDaoImpl implements HelloDao {

    @Resource(name="sqlSession")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public HelloEntity selectHello() {
        return sqlSessionTemplate.selectOne("getHello");
    }

    @Override
    public int insertHello(HelloEntity entity) {
        int insert = sqlSessionTemplate.insert("insertHello", entity);
        return insert;
    }

    @Override
    public int deleteHello(HelloEntity entity) {
        return sqlSessionTemplate.delete("deleteHello", entity);
    }

    @Override
    public int updateHello(HelloEntity entity) {
        return sqlSessionTemplate.update("updateHello", entity);
    }
}
