package com.entity.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


//@Component("um") 不写这一行 userMapper 名称
public interface UserMapper {
    @Select("select * from db_user")
    public List<Map<String,Object>> query();
}
