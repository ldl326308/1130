package com.nf.lc.dao;

import com.nf.lc.entity.Todo;
import java.util.List;

public interface TodoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Todo record);

    Todo selectByPrimaryKey(Integer id);

    List<Todo> selectAll();

    int updateByPrimaryKey(Todo record);

    List<Todo> selectByState(String state);


}