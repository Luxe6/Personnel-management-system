package com.example.service;

import com.example.domain.TbPosition;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
* @author Luxe
* @description 针对表【tb_position】的数据库操作Service
* @createDate 2023-07-11 09:35:42
*/
public interface TbPositionService extends IService<TbPosition> {

    PageInfo queryList(int pageNum, int pageSize, String name, String mark);
}
