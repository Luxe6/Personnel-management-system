package com.example.service;

import com.example.domain.TbTitle;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
* @author Luxe
* @description 针对表【tb_title】的数据库操作Service
* @createDate 2023-07-11 09:35:49
*/
public interface TbTitleService extends IService<TbTitle> {

    PageInfo queryList(int pageNum, int pageSize, String name, String mark);
}
