package com.example.projbackendforstudentsdata.Service;

import com.example.projbackendforstudentsdata.DAO.DAOLayer;
import com.example.projbackendforstudentsdata.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentServiceLayer {

    @Autowired
    DAOLayer Dao;
    public List<Student> getAllSudents() {
        return Dao.findAll();
    }

    public String AddStudentData(@RequestBody Student student) {
        Dao.save(student);
        return "Added Data";
    }
}
