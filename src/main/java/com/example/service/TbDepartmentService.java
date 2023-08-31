package com.example.service;

import com.example.domain.TbDepartment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
* @author Luxe
* @description 针对表【tb_department】的数据库操作Service
* @createDate 2023-07-11 09:34:40
*/
public interface TbDepartmentService extends IService<TbDepartment> {
    PageInfo queryList(int pageNum, int pageSize, String name, String mark);

}
