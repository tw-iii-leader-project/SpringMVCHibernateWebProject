package tw.bobbyko.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.bobbyko.model.RegisterService;
import tw.bobbyko.model.Userdata;

@Controller
public class RegisterController {

	@Autowired
	RegisterService rService = new RegisterService();

	@RequestMapping(path = "/register.mainPageController", method = RequestMethod.GET)
	public String processMainPage() {
		return "register";
	}

	@RequestMapping(path = "/register.checkController", method = RequestMethod.POST)
	public String processAction(
			@RequestParam(name = "userName") String user_acc,
			@RequestParam(name = "userPwd") String user_pwd,
			@RequestParam(name = "name") String username,
			@RequestParam(name = "phone") String phone,
			@RequestParam(name = "birthday") String birthday,
			@RequestParam(name = "email") String email,
			@RequestParam(name = "authcode") String authcode,
			Model m) {

		Userdata uBean = new Userdata();

		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);

		// check value at every column.

		if (user_acc == null || user_acc.length() == 0) {
			errors.put("msg_acc", "You Should Enter Account.");

		}

		if (user_pwd == null || user_pwd.length() == 0) {
			errors.put("msg_pwd", "You Should Enter Password.");

		}

		if (username == null || username.length() == 0) {
			errors.put("msg_name", "You Should Enter Name.");

		}

		if (phone == null || phone.length() == 0) {
			errors.put("msg_phone", "You Should Enter Phone.");

		}

		if (birthday == null || birthday.length() == 0) {
			errors.put("msg_birth", "You Should Enter Birthday.");

		}

		if (email == null || email.length() == 0) {
			errors.put("msg_email", "You Should Enter Email.");

		}

		if (authcode == null || authcode.length() == 0) {
			errors.put("msg_authcode", "You Should Choose.");

		}

		if (errors != null && !errors.isEmpty()) {
			return "register";
		}

		uBean.setUser_acc(user_acc);
		boolean result = rService.checkExist(uBean);
		
		if (result) {
			// execute register
			System.out.println("Account is OK for use");
		} else {
			errors.put("msg_acc", "Account You Entered Has Already Exist" + ", Please Choose Another One");
			System.out.println("check point 2");
			return "register";
		}
		;

		m.addAttribute("userAccount", user_acc);
		m.addAttribute("userPassword", user_pwd);
		m.addAttribute("userName", username);
		m.addAttribute("phone", phone);
		m.addAttribute("birthday", birthday);
		m.addAttribute("email", email);
		m.addAttribute("authcode", authcode);

		// Now get a object called "m" with all register data
		// and no duplicate account number
		// next step is execute the REGISTER.

		uBean.setUser_pwd(user_pwd);
		uBean.setUsername(username);
		uBean.setUser_phone(phone);
		uBean.setBirthday(birthday);
		uBean.setEmail(email);
		uBean.setAutocode(authcode);

		rService.insert(uBean);

		return "registerResult";
		
		//Unsolved:
		//1.specify the data type of phone, birthday.
		//2.form data pattern for email.
	}
}
