package com.nf.lc.service;

import com.nf.lc.dao.TodoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration("/spring/spring-dao.xml")
public class TodoServiceTest {

    @Autowired
    private TodoMapper todoMapper;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void selectByPrimaryKey() {
        assert todoMapper.selectByPrimaryKey(1) != null;
    }

    @Test
    public void selectAll() {
        assert todoMapper.selectAll() != null;
        assert todoMapper.selectAll().size() > 0;
        System.out.println(todoMapper.selectAll());
    }

    @Test
    public void updateByPrimaryKey() {
    }
}