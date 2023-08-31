package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.TbDepartment;
import com.example.mapper.TbDepartmentMapper;
import com.example.mapper.TbUserMapper;
import com.example.service.TbDepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.util.List;

/**
* @author Luxe
* @description 针对表【tb_department】的数据库操作Service实现
* @createDate 2023-07-11 09:34:40
*/
@Service
public class TbDepartmentServiceImpl extends ServiceImpl<TbDepartmentMapper, TbDepartment>
    implements TbDepartmentService {
    @Autowired
    private TbDepartmentMapper departmentMapper;

    @Override
    public PageInfo queryList(int pageNum, int pageSize, String name, String mark) {

        PageHelper.startPage(pageNum, pageSize);
        LambdaQueryWrapper<TbDepartment> wrapper = new LambdaQueryWrapper<>();
        //添加用户名查询
        if (!StringUtils.isBlank(name)) {
            wrapper.eq(TbDepartment::getName, name);
        }
        if (!StringUtils.isBlank(mark)) {
            wrapper.like(TbDepartment::getMark, mark);
        }

        //执行业务逻辑
        List<TbDepartment> list = departmentMapper.selectList(wrapper);

        //将数据list集合存放到PageInfo中
        return new PageInfo(list);
    }

}




