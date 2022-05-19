package org.example.service;

import org.example.mapper.StudentMapper;
import org.example.pojo.Student;

import java.util.List;

/*
    业务逻辑层接口
 */
public interface StudentService {
    //查询学生
    List<Student> selectStudent();
    //增加学生
    int insertStudent(Student student);
    //删除学生
    int deleteStudent(int sno);
    //学生详情
    Student detailStudent(int sno);
    //修改学生
    int updateStudent(Student student);
}
