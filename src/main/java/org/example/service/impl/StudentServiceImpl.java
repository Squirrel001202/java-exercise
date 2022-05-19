package org.example.service.impl;

import org.example.mapper.StudentMapper;
import org.example.pojo.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*
    业务逻辑层实现类
 */
@Service
public class StudentServiceImpl implements StudentService {
    //Mapper层对象
    @Autowired
    StudentMapper studentMapper;
    //查询学生
    @Override
    public List<Student> selectStudent() {
        return studentMapper.selectStudent();
    }

    @Override
    public int insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    @Override
    public int deleteStudent(int sno) {
        return studentMapper.deleteStudent(sno);
    }

    @Override
    public Student detailStudent(int sno) {
        return studentMapper.detailStudent(sno);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }
}
