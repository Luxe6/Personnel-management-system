package com.example.controller;

import com.example.domain.TbEmployee;
import com.example.domain.TbUser;
import com.example.service.TbDepartmentService;
import com.example.service.TbEmployeeService;
import com.example.service.TbPositionService;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private TbEmployeeService employeeService;

    @Autowired
    private TbDepartmentService departmentService;
    @Autowired
    private TbPositionService positionService;



    @GetMapping
    public Result list(
            @RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize",required = false,defaultValue = "5") int pageSize,
            @RequestParam(value = "name",required = false,defaultValue = "")String name,
            @RequestParam(value = "departmentId",required = false,defaultValue = "")String departmentId,
            @RequestParam(value = "positionId",required = false,defaultValue = "")String positionId,
            @RequestParam(value = "startDate",required = false,defaultValue = "")String startDate,
            @RequestParam(value = "endDate",required = false,defaultValue = "")String endDate
    ){
        Result result = employeeService.queryList(pageNum,pageSize,name,departmentId,positionId,startDate,endDate);
        return result;
    }

    @GetMapping("/{id}")
    public Result queryById(@PathVariable int id){
        TbEmployee employee = employeeService.getById(id);

        return new Result(1,"查询成功",employee);
    }

    /**
     * 用户的增加信息
     * @param employee
     * @return boolean
     */
    @PostMapping
    public Result save(@RequestBody TbEmployee employee){


        boolean b = employeeService.save(employee);
        if(b){
            return new Result(1,"增加用户成功");
        }
        return new Result(0,"增加用户失败");
    }

    /**
     * 修改用户
     * @param employee
     * @return boolean
     */
    @PutMapping
    public Result update(@RequestBody TbEmployee employee){

        boolean b = employeeService.updateById(employee);
        if(b){
            return new Result(1,"修改用户成功");
        }
        return new Result(0,"修改用户失败");
    }

    /**
     * 删除用户
     * @param employee
     * @return boolean
     */
    @DeleteMapping("/{id}")
    public Result delete(@RequestBody TbEmployee employee){

        boolean b = employeeService.removeById(employee);
        if(b){
            return new Result(1,"删除用户成功");
        }
        return new Result(0,"删除用户失败");

    }
}
