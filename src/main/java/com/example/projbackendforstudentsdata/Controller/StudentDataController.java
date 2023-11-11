package com.example.projbackendforstudentsdata.Controller;

import com.example.projbackendforstudentsdata.Service.StudentServiceLayer;
import com.example.projbackendforstudentsdata.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "https://arjunportal-2evxhp6kr-niranjan-anr.vercel.app/")
@RestController
@RequestMapping("Data")
public class StudentDataController {
    @Autowired
    StudentServiceLayer service;
    @GetMapping("All")
    public List<Student> AllStudentsData(){
        return service.getAllSudents();
    }
    @GetMapping("Home")
    public String Home(){
        return "Hola ,Hare Krishna!";
    }
    @PostMapping("Add")
    public String AddStudent(@RequestBody Student student){
        return service.AddStudentData(student);
    }
}
