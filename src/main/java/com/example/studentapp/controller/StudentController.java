package com.example.studentapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.studentapp.entity.Student;
import com.example.studentapp.repository.StudentRepository;

@Controller
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String showForm() {
        return "student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@RequestParam String name, Model model) {
        Student student = new Student();
        student.setName(name);

        repo.save(student);

        model.addAttribute("message", "Student saved successfully!");
        return "student";
    }
}

