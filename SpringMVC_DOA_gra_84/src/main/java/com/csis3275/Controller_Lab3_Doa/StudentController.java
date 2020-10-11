package com.csis3275.Controller_Lab3_Doa;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.Doa_gra_84.StudentDAOImpl_gra_84;
import com.csis3275.Model_gra_84.Student_gra_84;

@Controller
public class StudentController {

 @Autowired
 StudentDAOImpl_gra_84 studentDaoImpl;

 //We need a blank student for the add form
 @ModelAttribute("student")
 public Student_gra_84 setupAddForm() {
 return new Student_gra_84();
 }

 //Thats a GET request from the browser to the URL below
 @GetMapping("/showStudents")
 public String showStudents(HttpSession session, Model model) {
 //Get a list of students from the controller
 List<Student_gra_84> students = studentDaoImpl.getAllStudents();


 //Add the results to the model
 model.addAttribute("students", students);
 return "showStudents";
 }

 //Handle Form Post
 @PostMapping("/createStudent")
 public String createStudent(@ModelAttribute("student") Student_gra_84
createStudent, Model model) {

 //Create the student pass the object in.
 studentDaoImpl.createStudent(createStudent);

 //Get a list of students from the controller
 List<Student_gra_84> students = studentDaoImpl.getAllStudents();
 model.addAttribute("students", students);

 return "showStudents";
 }
//Get the student and display the form
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam(required = true) int id, Model model)	{
				
		//Get the student
		studentDaoImpl.deleteStudent(id);
		
		//Get a list of students from the controller
		List<Student_gra_84> students = studentDaoImpl.getAllStudents();
		model.addAttribute("studentList", students);
	
		model.addAttribute("message", "Deleted Student: " + id);
			
		return "showStudents";
	}	
}