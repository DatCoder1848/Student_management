package com.example.controller;

import com.example.model.Student;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class HomeController {
    private final IStudentService iStudentService;

    @Autowired
    public HomeController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
        System.out.println("HomeController bean created");
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView showStudent(@RequestParam(value = "message", required = false) String message) {
        System.out.println("HomeController: Accessing showStudent method");
        ModelAndView model = new ModelAndView("home");
        List<Student> studentList = iStudentService.findAll();
        System.out.println("Student List: " + studentList);
        model.addObject("studentList", studentList);
        if (message != null) {
            model.addObject("message", message);
        }
        return model;
    }

    @RequestMapping(value = "/manageStudent", method = RequestMethod.POST)
    public String manageStudent(HttpServletRequest request) {
        try {
            String type = request.getParameter("btnManageStudent");
            int studentID = Integer.parseInt(request.getParameter("txtID"));
            String firstName = request.getParameter("txtFirstName");
            String lastName = request.getParameter("txtLastName");
            double mark = Double.parseDouble(request.getParameter("txtMark"));
            Student student = new Student(studentID, firstName, lastName, mark);
            String message = "";
            switch (type) {
                case "add":
                    iStudentService.save(student);
                    message = "Student added successfully!";
                    break;
                case "update":
                    student.setId(studentID);
                    iStudentService.update(student);
                    message = "Student updated successfully!";
                    break;
                case "delete":
                    iStudentService.delete(studentID);
                    message = "Student deleted successfully!";
                    break;
                default:
                    break;
            }
            return "redirect:/?message=" + URLEncoder.encode(message, StandardCharsets.UTF_8);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "redirect:/?message=" + URLEncoder.encode("Invalid input! Please enter valid numbers for ID and Mark.", StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/?message=" + URLEncoder.encode("An error occurred: " + e.getMessage(), StandardCharsets.UTF_8);
        }
    }
}