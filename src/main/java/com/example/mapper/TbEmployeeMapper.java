package com.example.mapper;

import com.example.domain.TbEmployee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Luxe
* @description 针对表【tb_employee】的数据库操作Mapper
* @createDate 2023-07-11 09:35:36
* @Entity com.example.domain.TbEmployee
*/
@Mapper
public interface TbEmployeeMapper extends BaseMapper<TbEmployee> {

}




