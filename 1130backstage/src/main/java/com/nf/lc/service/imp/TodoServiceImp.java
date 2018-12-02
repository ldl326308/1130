package com.nf.lc.service.imp;

import com.nf.lc.entity.Todo;

import java.util.List;

public interface TodoServiceImp {
    int deleteByPrimaryKey(Integer id);

    int insert(Todo record);

    Todo selectByPrimaryKey(Integer id);

    List<Todo> selectAll();

    int updateByPrimaryKey(Todo record);

    List<Todo> selectByState(String state);

}
