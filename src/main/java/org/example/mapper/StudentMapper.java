package org.example.mapper;

import org.example.pojo.Student;

import java.util.List;
/*
    数据访问层
 */
public interface StudentMapper {
    //查询学生
    List<Student> selectStudent();
    //增加学生
    int insertStudent(Student student);
    //删除学生
    int deleteStudent(int sno);
    //详情信息
    Student detailStudent(int sno);
    //修改学生
    int updateStudent(Student student);
}
