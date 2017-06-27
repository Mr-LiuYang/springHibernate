package springHibernate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springHibernate.domain.Student;
import springHibernate.service.StudentService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value="/view")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}

	@RequestMapping("/find")
	@ResponseBody
	public List<Student> findAllStudent(){
		return studentService.findAllStudent();
	}
}
