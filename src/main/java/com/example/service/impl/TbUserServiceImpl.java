package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.TbUser;
import com.example.service.TbUserService;
import com.example.mapper.TbUserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Luxe
* @description 针对表【tb_user】的数据库操作Service实现
* @createDate 2023-07-05 11:17:52
*/
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser>
    implements TbUserService{
    @Autowired
    private TbUserMapper TbUserMapper;

    @Override
    public PageInfo queryList(int pageNum, int pageSize,String username,String nikeName){
        PageHelper.startPage(pageNum,pageSize);

        LambdaQueryWrapper<TbUser> wrapper = new LambdaQueryWrapper<>();

        if(!StringUtils.isBlank(username)){
            wrapper.eq(TbUser::getUsername,username);
        }

        wrapper.in(TbUser::getState,0,1);

        if(!StringUtils.isBlank(nikeName)){
            wrapper.like(TbUser::getNikeName,nikeName);
        }

        List<TbUser> list = TbUserMapper.selectList(wrapper);
        return new PageInfo(list);
    }

}




