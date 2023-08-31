package com.example.mapper;

import com.example.domain.TbDepartment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Luxe
* @description 针对表【tb_department】的数据库操作Mapper
* @createDate 2023-07-11 09:34:40
* @Entity com.example.domain.TbDepartment
*/
@Mapper
public interface TbDepartmentMapper extends BaseMapper<TbDepartment> {

}




