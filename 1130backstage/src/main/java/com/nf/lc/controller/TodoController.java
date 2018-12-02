package com.nf.lc.controller;

import com.nf.lc.entity.Todo;
import com.nf.lc.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin
public class TodoController {

    @Autowired
    private TodoService todoService;

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/todo/{id}" , method = RequestMethod.DELETE , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity deleteByPrimaryKey(@PathVariable("id") int id){
        return todoService.deleteByPrimaryKey(id) > 0 ? ResponseEntity.ok("删除成功！") : ResponseEntity.ok("删除失败！");
    }

    /**
     * 添加
     * @param todo
     * @return
     */
    @RequestMapping(value = "/todo" , method = RequestMethod.POST , produces = "application/json;charset=utf-8")
    @ResponseBody
    public String insert(@RequestBody Todo todo){
        todo.setState("未完成");
        return todoService.insert(todo) > 0 ? "{\"msg\":\"添加成功！\"}" : "{\"msg\":\"添加失败！\"}";
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/todo/{id}" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity selectByPrimaryKey(@PathVariable("id") int id){
        return ResponseEntity.ok(todoService.selectByPrimaryKey(id));
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/todo" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Todo> selectAll(){
        return todoService.selectAll();
    }

    /**
     * 修改
     * @param id
     * @return
     */
    @RequestMapping(value = "/todo/{id}" , method = RequestMethod.PUT , produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateByPrimaryKey(@PathVariable("id") int id){
        Todo todo = new Todo();
        todo.setId(id);
        todo.setFinishedAt(new Date());
        todo.setState("已完成");
        return todoService.updateByPrimaryKey(todo) > 0 ? "{\"msg\":\"修改成功！\"}" : "{\"msg\":\"修改失败！\"}";
    }

}
