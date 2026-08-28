package Service;


import Entity.Student;
import Pojo.StudentRequests;
import Repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
    @Autowired
    private StudentRepository studentRepository;

//    Map<Integer, Student> studentList = new HashMap<>();

//    public void getStudentById(int studentId){
//    }


    Student studentEntity = new Student();

    public void signup(StudentRequests STR){



        studentEntity.setName(STR.getName());
        studentEntity.setAge(STR.getAge());
        studentEntity.setEmail(STR.getEmail());
        studentEntity.setPassword(STR.getPassWord());
        studentEntity.setPhoneNumber(STR.getPhoneNumber());

        studentRepository.save(studentEntity);

        logger.info("{}{}");
    }

    public List<Student> studentList(){

        return studentRepository.findAll();
    }

    public void Login(){



    }


}
