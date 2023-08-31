package com.example.controller;

import com.example.domain.TbTitle;
import com.example.service.TbPositionService;
import com.example.service.TbTitleService;
import com.example.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/title")
public class TitleController {
    @Autowired
    private TbTitleService titleService;

    @GetMapping("/queryTitleList")
    public Result queryTitleList(){
        return new Result(1,"查询成功",titleService.list());
    }
    /**
     * 修改用户
     * @param
     * @return boolean
     */
    @PutMapping
    public Result update(@RequestBody TbTitle title)
    {
        boolean b = titleService.updateById(title);
        if(b) {
            return new Result(1,"修改用户成功");
        }
        return new Result( 0,"修改用户失败，请联系管理员");
    }

    /**
     * 删除部门
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){
        boolean b = titleService.removeById(id);
        if(b){
            return new Result(1,"删除成功！");
        }
        return new Result(0,"删除失败!");
    }

    @PostMapping
    public Result save(@RequestBody TbTitle title){

        boolean b = titleService.save(title);
        if(b) {
            return new Result(1, "增加用户成功");
        }
        return new Result(0,"增加用户失败");

    }

    /**
     * 查询所有
     * @return List
     */
    @GetMapping("/query")
    public List<TbTitle> list(){
        List<TbTitle> list = titleService.list();
        return list;
    }



    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return PageInfo
     */
    @GetMapping
    public Result list(
            @RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize,
            @RequestParam(value = "name",required = false,defaultValue = "") String name,
            @RequestParam(value = "mark",required = false,defaultValue = "") String mark
    ){

        PageInfo pageInfo = titleService.queryList(pageNum,pageSize,name,mark);

        return new Result(1,"查询成功",pageInfo);
    }
}