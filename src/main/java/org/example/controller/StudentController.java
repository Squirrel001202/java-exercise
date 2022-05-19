package org.example.controller;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
    控制层
 */
@Controller
public class StudentController {
    //业务逻辑层对象
    @Autowired
    StudentService studentService;
    //查询学生
    @RequestMapping("/selectStudent")
    public String selectStudent(HttpServletRequest request) {
        List<Student> students = studentService.selectStudent();
        request.setAttribute("students",students);
        return "list";
    }
    //增加学生
    @RequestMapping("/insertStudent")
    public String insertStudent(int sno, String name, String sex, int age){
        Student student = new Student(sno,name,sex,age);
        int count = studentService.insertStudent(student);
        return "redirect:/selectStudent";
    }
    //增加学生页面跳转
    @RequestMapping("/insertStudentList")
    public String insertStudentList(){
        return "add";
    }
    //删除学生
    @RequestMapping("/deleteStudent")
    public String deleteStudent(int sno){
        int count = studentService.deleteStudent(sno);
        return "redirect:/selectStudent";
    }
    //学生详情
    @RequestMapping("/detailStudent")
    public String detailStudent(int sno,HttpServletRequest request){
        Student student = studentService.detailStudent(sno);
        request.setAttribute("student",student);
        return "detail";
    }
    //修改学生页面跳转
    @RequestMapping("/updateStudent")
    public String updateStudent(int sno,HttpServletRequest request){
        Student student = studentService.detailStudent(sno);
        request.setAttribute("student",student);
        return "edit";
    }
    //修改学生
    @RequestMapping("/updateFinish")
    public String updateFinish(int sno, String name, String sex, int age){
        Student student = new Student(sno,name,sex,age);
        int count = studentService.updateStudent(student);
        return "redirect:/selectStudent";
    }
}
