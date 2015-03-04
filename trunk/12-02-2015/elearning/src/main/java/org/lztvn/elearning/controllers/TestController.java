package org.lztvn.elearning.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

import javax.print.attribute.standard.Severity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.lztvn.elearning.entities.Test1;
import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("userLogin")
public class TestController extends AppController {
	@Autowired
	ITestService service;

	@RequestMapping(value = "/createtest", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		model.addAttribute("createtest", new Test1());
		model.addAttribute("listtest", service.getlistTest());
		return "addtest";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Test1 test, Locale locale, Model model,
			HttpSession session, MultipartFile file, MultipartFile filepdf)
			throws IOException {
		String path = System.getProperty("java.io.tmpdir");
		if (test.getTitle().length() < 4) {
			String fff = "do dai khong du";
			model.addAttribute("ds", fff);
			model.addAttribute("createtest", new Test1());
			model.addAttribute("listtest", service.getlistTest());
			return "addtest";
		}
		Long idT = null;

		if (test.getId() == null) {// add a new test
			User u = (User) session.getAttribute("userLogin");
			test.setUser(u);
			idT = service.addTest(test);
			if (!file.isEmpty()) { // in case of photo isnot empty
				test.setPhoto(file.getOriginalFilename());
				idT = service.addTest(test);
				file.transferTo(new File(path + "/" + "USER_" + idT + "_"
						+ file.getOriginalFilename()));
			}

			if (!filepdf.isEmpty()) { //in case of pdffilepath isnot empty
				test.setVideolink(filepdf.getOriginalFilename());
				filepdf.transferTo(new File(path + "/" + "PDF_" + idT + "_"
						+ filepdf.getOriginalFilename()));
			}
			service.editTest1(test);

		} else {// modify a test
			idT = test.getId();

			if (!file.isEmpty()) {// in case of photo isnot empty
				test.setPhoto(file.getOriginalFilename());
				file.transferTo(new File(path + "/" + "USER_" + idT + "_"
						+ file.getOriginalFilename()));
			} else {
				test.setPhoto(service.getTestbyID(idT).getPhoto());

			}
			if (!filepdf.isEmpty()) {
				test.setVideolink(filepdf.getOriginalFilename());
				filepdf.transferTo(new File(path + "/" + "PDF_" + idT + "_"
						+ filepdf.getOriginalFilename()));
			} else {
				test.setVideolink(service.getTestbyID(idT).getVideolink());
			}
			
			service.editTest1(test);

		}
		model.addAttribute("createtest", new Test1());
		model.addAttribute("listtest", service.getlistTest());
		return "addtest";
	}

	@RequestMapping(value = "/delTest", method = RequestMethod.GET)
	public String delete(Long idTest, Locale locale, Model model) {

		service.deleteTest(idTest);
		model.addAttribute("createtest", new Test1());
		model.addAttribute("listtest", service.getlistTest());
		return "addtest";

	}

	@RequestMapping(value = "/editTest", method = RequestMethod.GET)
	public String edit(Long idTest, Locale locale, Model model) {
		Test1 t = service.getTestbyID(idTest);
		// service.editTest1(t);
		model.addAttribute("createtest", t);
		model.addAttribute("listtest", service.getlistTest());
		return "addtest";
	}

	@RequestMapping(value = "/photoTest", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoTest(Long id) throws IOException { // USER_49_null
		Test1 t = service.getTestbyID(id);
		File f = new File(System.getProperty("java.io.tmpdir") + "/USER_" + id
				+ "_" + t.getPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("createtest", new Test1());
		mv.addObject("listtest", service.getlistTest());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("createtest");
		return mv;
	}
}
