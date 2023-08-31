package com.example.service;

import com.example.domain.TbUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
* @author Luxe
* @description 针对表【tb_user】的数据库操作Service
* @createDate 2023-07-05 11:17:52
*/
public interface TbUserService extends IService<TbUser> {
    PageInfo queryList(int pageNum, int pageSize,String username,String nikeName);

}
