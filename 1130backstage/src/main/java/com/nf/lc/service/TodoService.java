package com.nf.lc.service;

import com.nf.lc.dao.TodoMapper;
import com.nf.lc.entity.Todo;
import com.nf.lc.service.imp.TodoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService implements TodoServiceImp {

    @Autowired
    private TodoMapper todoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return todoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Todo record) {
        return todoMapper.insert(record);
    }

    @Override
    public Todo selectByPrimaryKey(Integer id) {
        return todoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Todo> selectAll() {
        return todoMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Todo record) {
        return todoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Todo> selectByState(String state){
        return todoMapper.selectByState(state);
    }

}
