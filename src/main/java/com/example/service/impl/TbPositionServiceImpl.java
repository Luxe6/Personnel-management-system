package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.TbPosition;
import com.example.mapper.TbPositionMapper;
import com.example.service.TbPositionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Luxe
* @description 针对表【tb_position】的数据库操作Service实现
* @createDate 2023-07-11 09:35:42
*/
@Service
public class TbPositionServiceImpl extends ServiceImpl<TbPositionMapper, TbPosition>
    implements TbPositionService {
    @Autowired
    private TbPositionMapper positionMapper;

    @Override
    public PageInfo queryList(int pageNum, int pageSize, String name, String mark) {

        PageHelper.startPage(pageNum, pageSize);
        LambdaQueryWrapper<TbPosition> wrapper = new LambdaQueryWrapper<>();
        //添加用户名查询
        if (!StringUtils.isBlank(name)) {
            wrapper.eq(TbPosition::getName, name);
        }
        if (!StringUtils.isBlank(mark)) {
            wrapper.like(TbPosition::getMark, mark);
        }

        //执行业务逻辑

        List<TbPosition> list = positionMapper.selectList(wrapper);

        //将数据list集合存放到PageInfo中
        return new PageInfo(list);
    }
}




