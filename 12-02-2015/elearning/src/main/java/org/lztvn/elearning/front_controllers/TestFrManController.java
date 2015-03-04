package org.lztvn.elearning.front_controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.lztvn.elearning.controllers.AppController;
import org.lztvn.elearning.entities.Course;
import org.lztvn.elearning.entities.Question;
import org.lztvn.elearning.entities.Test1;
import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.service.ICategryService;
import org.lztvn.elearning.service.ICourseService;
import org.lztvn.elearning.service.IQuestionService;
import org.lztvn.elearning.service.ITestService;
import org.lztvn.elearning.service.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("userFLogin")
public class TestFrManController extends AppController {
	@Autowired
	ITestService serviceTest;
	 @Autowired
    IQuestionService serviceQuest;
	Utility util;

	private void init() { // khoi tao
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		this.util = (Utility) context.getBean("util");
	}

	@RequestMapping(value = "/test_management", method = RequestMethod.GET)
	// load list test
	public ModelAndView testMan(Model model, HttpSession session) {
		init();
		if (util.checkFrontSession(session) == false) {
			return new ModelAndView("redirect:lstcourses/login");
		} else {
			User u = (User) session.getAttribute("userFLogin");
			model.addAttribute("createtest", new Test1());
			model.addAttribute("listtest", serviceTest.getlistTestbyId(u.getIdUser()));
			
			return new ModelAndView("test_management");
		}
	}
	
	
	@RequestMapping(value = "/savef", method = RequestMethod.POST)
	// update test
	public String save(Test1 test, Model model,
			HttpSession session, MultipartFile file, MultipartFile filepdf)
			throws IOException {

		if (test.getTitle().length() < 4) {
			String fff = "do dai khong du";
			model.addAttribute("ds", fff);
			model.addAttribute("createtest", new Test1());
			model.addAttribute("listtest", serviceTest.getlistTest());
			return "test_management";
		}
		Long idT = null;
		String path = System.getProperty("java.io.tmpdir");
		if (test.getId() == null) {// add test
//			User u = (User) session.getAttribute("userLogin");
//			test.setUser(u);

			idT = serviceTest.addTest(test);

			if (!file.isEmpty()) { // co photo
				test.setPhoto(file.getOriginalFilename());
				file.transferTo(new File(path + "/" + "TEST_" + idT + "_"
						+ file.getOriginalFilename()));
			}
			if (!filepdf.isEmpty()) {
				test.setVideolink(filepdf.getOriginalFilename());
				filepdf.transferTo(new File(path + "/" + "PDF_" + idT + "_"
						+ filepdf.getOriginalFilename()));
			}
			serviceTest.editTest1(test);

		} else {
			idT = test.getId();
			if (!file.isEmpty()) {
				test.setPhoto(file.getOriginalFilename());
				serviceTest.editTest1(test);
				file.transferTo(new File(path + "/" + "TEST_" + idT + "_"
						+ file.getOriginalFilename()));
			} else {
				test.setPhoto(serviceTest.getTestbyID(idT).getPhoto());
			}
			if (!filepdf.isEmpty()) {// in case of change pdf
				test.setVideolink(filepdf.getOriginalFilename());
				file.transferTo(new File(path + "/" + "PDF_" + idT + "_"
						+ filepdf.getOriginalFilename()));
			} else {
				test.setVideolink(serviceTest.getTestbyID(idT).getVideolink());
			}
			serviceTest.editTest1(test);
		}
		User u = (User) session.getAttribute("userFLogin");
		model.addAttribute("createtest", new Test1());
		model.addAttribute("listtest", serviceTest.getlistTestbyId(u.getIdUser()));
		return "test_management";
	}

	@RequestMapping(value = "/delTestf", method = RequestMethod.GET)
	public String delete(Long idTest, Locale locale, Model model,HttpSession session) {

		serviceTest.deleteTest(idTest);
		model.addAttribute("createtest", new Test1());
		User u = (User) session.getAttribute("userFLogin");
		model.addAttribute("listtest", serviceTest.getlistTestbyId(u.getIdUser()));
		return "test_management";
	}

	@RequestMapping(value = "/editTestf", method = RequestMethod.GET)
	public String edit(Long idTest, Model model, HttpSession session) {
		init();
		if (util.checkFrontSession(session) == false) {
			return ("redirect:lstcourses/login");
		}
		else{
		Test1 t = serviceTest.getTestbyID(idTest);
		// service.editTest1(t);
		model.addAttribute("createtest", t);
		User u = (User) session.getAttribute("userFLogin");
		model.addAttribute("listtest", serviceTest.getlistTestbyId(u.getIdUser()));
		model.addAttribute("listques", serviceQuest.getlistQuestionbyTestId(idTest));
		
		return "test_management";
		}
	}
	
	@RequestMapping(value="/question",method=RequestMethod.GET)
	public String editQuestion(Long idT,Long idQ, Model model, HttpSession session){
		init();
		if (util.checkFrontSession(session) == false) {
			return ("redirect:lstcourses/login");
		}else{
			Long idt = idT;
			Long idq = idQ;
			Question q = serviceQuest.getQuestion(idq);
			model.addAttribute("question_edit", q);
			model.addAttribute("testid", idt);
			return "edit_question";	
		}
		
	}

	@RequestMapping(value = "/photoTestf/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoTestF(@PathVariable Long id) throws IOException {
		Test1 t = serviceTest.getTestbyID(id);
		File f = new File(System.getProperty("java.io.tmpdir") + "/TEST_" + id
				+ "_" + t.getPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}

	@ModelAttribute("question")
	public Question constructQuestion(){
		return new Question();	
	}
	
	@RequestMapping(value="/addQuestion",method=RequestMethod.POST)
	public String doAddQuestion(@ModelAttribute Question q){
		serviceQuest.addQuest(q);
		Long idT = q.getTest().getId();
		return "redirect:/editTestf?idTest="+idT;
	}
	
	@RequestMapping(value="/question/remove/{idT}/{idQ}",method=RequestMethod.GET)
	public String doDelQuestion(@PathVariable("idT") Long idT,@PathVariable("idQ") Long idQ){
		Long idt = idT;
		Long idq = idQ;
		serviceQuest.delQuest(idq);
		return  "redirect:/editTestf?idTest="+idt;
	}
	
	@RequestMapping(value = "/saveq", method = RequestMethod.POST)
	// update test
	public String saveq(Question q, Model model,HttpSession session, BindingResult bindingResult, WebRequest webRequest)
			throws IOException {
		if (bindingResult.hasErrors()) {
			return ("test_management");
		}
		Long testid = Long.valueOf(webRequest.getParameter("testid"));
		serviceQuest.editQuest(q);
		
		
		return "redirect:/editTestf?idTest="+testid;
	}
	
	
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("createtest", new Test1());
		mv.addObject("listtest", serviceTest.getlistTest());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("createtest");
		return mv;
	}

}
