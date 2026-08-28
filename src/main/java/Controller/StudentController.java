package Controller;


import Entity.Student;
import Pojo.LoginRequest;
import Pojo.StudentRequests;
import Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

@Autowired
  private StudentService studentService;


    @PostMapping("/signup")
    public String signup(@Valid @RequestBody StudentRequests STR){
        studentService.signup(STR);

        return "You have succesfully Created a Student";
    }


    @GetMapping("/StudentList")
    public List<Student> GetAlltheListOfStudents(){

        return studentService.studentList();
    }




    @PostMapping("/login")
    public String Login(@RequestBody LoginRequest loginRequest){

        studentService.Login(loginRequest);
        return "Login Successfull";
    }


}
