package tw.pan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.pan.model.Commodity;
import tw.pan.model.CommodityService;

@Controller
public class DemoCommdityController {
	
	@Autowired
	private CommodityService cService;
	
	@RequestMapping(path="/jumtoResult.controller",method=RequestMethod.GET)
	public String pcocessTestMainGo() {
		return "resultPage";
	}
	
	@RequestMapping(path="/insertAction",method=RequestMethod.POST)
	public String processInsert(@RequestParam(name="comname") String comname,			
			@RequestParam(name="price") int price) {
		Commodity cBean = new Commodity();
		cBean.setComName(comname);
		cBean.setPrice(price);
		cService.insert(cBean);
		
		return "resultPage";
	}
	
	@RequestMapping(path="/selectAction")
	public String processSelectAll(HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Commodity> lists = cService.selectAll();
		
		for(Commodity dept:lists) {
			out.write(dept.getComId() +" "+ dept.getComName() +" "+ dept.getPrice()+"<br/>");
		}
		out.close();
		return "resultPage";
	}
	
	@RequestMapping(path="/deleteAction",method=RequestMethod.POST)
	public String processDelete(@RequestParam(name="comname") String comname) {
		cService.delete(comname);
		return "resultPage";
	}
	
	@RequestMapping(path="/updateAction",method=RequestMethod.POST)
	public String processUpdate(@RequestParam(name="comid") int comId,@RequestParam(name="comname") String comName,
			@RequestParam(name="price") int price) {
		Commodity cBean = new Commodity();
		cBean.setComId(comId);
		cBean.setComName(comName);
		cBean.setPrice(price);
		cService.update(cBean);
		return "resultPage";
	}
}











