package com.entity.mapper;

import com.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface StudentMapper {
    @Select("select * from student where id = #{id}")
    public Student findById(int id);

    @Select("select * from student where 1=1 order by id desc")
    public List<Student> queryAll();

    public int insert(Student student);

    public int save(@Param("uname") String name, @Param("address") String address);

    //此方法已不可用
    public int add(String uname, String address);

    public List<Student> shows();
    
}
