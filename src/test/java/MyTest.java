import org.example.controller.StudentController;
import org.example.pojo.Student;
import org.example.service.StudentService;
import org.example.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)//启动Spring容器
@ContextConfiguration(locations = {"classpath:applicationContext_mapper.xml",
        "classpath:applicationContext_service.xml"})
public class MyTest {
    @Autowired
    StudentService studentService;
    @Test
    public void testSelectStudent(){
        List<Student> students = studentService.selectStudent();
        students.forEach(System.out::println);
    }
}
