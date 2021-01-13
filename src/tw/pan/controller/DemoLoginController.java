package tw.pan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.pan.model.UserInfo;
import tw.pan.model.UserInfoService;

@Controller
public class DemoLoginController {
	
	@Autowired
	private UserInfoService uService;
	
	@RequestMapping(path="/index.mainPageController",method=RequestMethod.GET)
	public String processMainPage() {
		return "index";
	}
	
	@RequestMapping(path="/userCheck",method=RequestMethod.POST)
	public String processCheckUser(@RequestParam(name="userName") String user,
			@RequestParam(name="passWord") String pwd,Model m){
		
		UserInfo uBean = uService.select(user);
		if(uBean != null && uBean.getPassword().equals(pwd)) {
			m.addAttribute("id",uBean.getUserid());
			m.addAttribute("name",uBean.getUsername());
			m.addAttribute("telephone",uBean.getTelephone());
			m.addAttribute("msg","Welcome!!!");
		}
		else {
			m.addAttribute("msg","no result");
		}
		return "resultPage";
	}
}
