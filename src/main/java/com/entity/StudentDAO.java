package com.entity;

import com.entity.mapper.StudentMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentdao")
@Data
public class StudentDAO {
    @Autowired
    private StudentMapper sm;

    public List<Student> query() {
        return sm.queryAll();
    }

    public Student queryById(int id){
        return sm.findById(id);
    }
}
