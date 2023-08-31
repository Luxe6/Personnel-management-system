package com.example.service;

import com.example.domain.TbEmployee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.utils.Result;
import com.github.pagehelper.PageInfo;

import java.util.Date;

/**
* @author Luxe
* @description 针对表【tb_employee】的数据库操作Service
* @createDate 2023-07-11 09:35:36
*/
public interface TbEmployeeService extends IService<TbEmployee> {
    Result queryList(int pageNum, int pageSize, String name, String departmentId, String positionId, String startDate, String endDate);

}
