package com.pp3.Amigoscode_spring_boot_tutorial.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {


    private  final Student_service student_service;


    @Autowired
    public StudentController(Student_service student_service) {
        this.student_service = student_service;
    }

    @GetMapping
    public List<Student> getStudents(){
        return student_service.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        student_service.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(
            @PathVariable("studentId") Long studentId){
        student_service.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void  updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ){
        student_service.updateStudent(studentId,name ,email);
    }
}
