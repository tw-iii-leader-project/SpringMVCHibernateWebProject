package tw.pan.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.pan.model.LoginService;
import tw.pan.model.Userdata;

@Controller
public class LoginController {
	
	@Autowired
	LoginService lService = new LoginService();

	@RequestMapping(path = "/login.mainPageController", method = RequestMethod.GET)
	public String processMainPage() {
		return "login_";
	}

	@RequestMapping(path = "/login.checkController", method = RequestMethod.POST)
	public String processAction(
			@RequestParam(name = "user_acc") String user_acc,
			@RequestParam(name = "user_pwd") String password,
			Model m) {
		
		Userdata uBean = new Userdata();

		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);

		if (user_acc == null || user_acc.length() == 0) {
			errors.put("msg_acc", "Please Enter Account!!");
		}

		if (password == null || password.length() == 0) {
			errors.put("msg_pwd", "Please Enter Password!!");
		}

		if (errors != null && !errors.isEmpty()) {
			return "login_";
		}
		

		m.addAttribute("user", user_acc);
		m.addAttribute("pwd", password);
		
		uBean.setUser_acc(user_acc);
		uBean.setUser_pwd(password);
		
		boolean loginResult = lService.check(uBean);
		
		if (loginResult) {
			//SUCCESS
			return "resultPage";
		}else {
			return "login_";
		}
		
		
	}
}
