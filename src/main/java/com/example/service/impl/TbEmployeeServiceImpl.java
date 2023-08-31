package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.TbDepartment;
import com.example.domain.TbEmployee;
import com.example.domain.TbPosition;
import com.example.domain.TbTitle;
import com.example.mapper.TbDepartmentMapper;
import com.example.mapper.TbEmployeeMapper;
import com.example.mapper.TbPositionMapper;
import com.example.mapper.TbTitleMapper;
import com.example.service.TbEmployeeService;
import com.example.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author Luxe
* @description 针对表【tb_employee】的数据库操作Service实现
* @createDate 2023-07-11 09:35:36
*/
@Service
public class TbEmployeeServiceImpl extends ServiceImpl<TbEmployeeMapper, TbEmployee>
    implements TbEmployeeService {

    @Autowired
    private TbEmployeeMapper employeeMapper;
    @Autowired
    private TbDepartmentMapper departmentMapper;
    @Autowired
    private TbPositionMapper positionMapper;
    @Autowired
    private TbTitleMapper titleMapper;

    @Override
    public Result queryList(int pageNum, int pageSize, String name, String departmentId, String positionId, String startDate, String endDate){

        PageHelper.startPage(pageNum,pageSize);


        LambdaQueryWrapper<TbEmployee> wrapper = new LambdaQueryWrapper<>();

        if(!StringUtils.isBlank(name)){
            wrapper.like(TbEmployee::getName,name);
        }
        if(!StringUtils.isBlank(departmentId)){
            wrapper.eq(TbEmployee::getDepartmentId,departmentId);
        }
        if(!StringUtils.isBlank(positionId)){
            wrapper.eq(TbEmployee::getPositionId,positionId);
        }
        if(!StringUtils.isBlank(startDate) && !StringUtils.isBlank(endDate)){
            wrapper.le(TbEmployee::getHireDate,endDate);
        }
        if(!StringUtils.isBlank(startDate) && !StringUtils.isBlank(endDate)) {
            wrapper.ge(TbEmployee::getHireDate, endDate);
        }
        if(!StringUtils.isBlank(startDate) && !StringUtils.isBlank(endDate)) {
            wrapper.between(TbEmployee::getHireDate,startDate, endDate);
        }

        List<TbEmployee> list = employeeMapper.selectList(wrapper);

        list.forEach(employee ->{
            TbDepartment department = departmentMapper.selectById(employee.getDepartmentId());
            employee.setDepartment(department);
            TbPosition position = positionMapper.selectById(employee.getPositionId());
            employee.setPosition(position);
            TbTitle title = titleMapper.selectById(employee.getTitleId());
            employee.setTitle(title);
        });
        PageInfo pageInfo = new PageInfo(list);
        return new Result(1,"查询成功",pageInfo);
    }

}




