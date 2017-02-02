package com.niit;

import java.util.Map;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.CategoryInfo;
import com.niit.model.ProductInfo;
import com.niit.model.UserInfo;
import com.niit.services.CategoryService;
import com.niit.services.DataServices;
import com.niit.services.ProductService;

@Controller//which mark the class as controller.which automatically imported dependency injection
public class HomeController {
	@Autowired   //Autowiring the service class and model class
	DataServices dataservices;
	UserInfo user;
	@Autowired
	CategoryService cs;
	@Autowired
	ProductService ps;
	@RequestMapping(value = { "/", "/index" })//Setting url mapping for landing page
	public String getIndex(Map<String, Object> map ,@ModelAttribute CategoryInfo category) {
		System.out.println("home page");
		map.put("category", category);
		map.put("categoryList", cs.getAllCategory());
		System.out.println("getting values");
        return "index";
	}

	@RequestMapping("/allproduct")
	public String view(@RequestParam("pdt") String Id,Map<String ,Object>map){
		System.out.println("displaying image according to category");
		map.put("list", ps.getAllProductfromCategory(Id));
		map.put("categoryList", cs.getAllCategory());
		return "viewimg";
	}
@RequestMapping("/viewImg")
public String singlePage(@RequestParam("pdt") int id,Map<String ,Object>map){
	map.put("categoryList", cs.getAllCategory());
	ProductInfo prod=ps.getRowById(id);
	map.put("product", prod);
	return "viewdetails";
}
	@RequestMapping(value = { "/login", "/userLogin" }, method = RequestMethod.GET)//Setting url mapping foe login page 
	public ModelAndView getlog(@RequestParam(required = false) String authfailed, String logout, String denied) {
		String message = "";
		if (authfailed != null) {
			message = "Invalid username of password, try again !";
			return new ModelAndView("error", "message", message);
		} else if (logout != null) {
			message = "Logged Out successfully, login again to continue !";
			new ModelAndView("index", "message", message);
		} else if (denied != null) {
			message = "Access denied for this user !";
			new ModelAndView("403", "message", message);
		}

		return new ModelAndView("sign", "message", message);
	}

	@RequestMapping(value = "/logout")//setting url mapping for logout
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("in login logout method");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		HttpSession session=request.getSession();
		session.invalidate();
		return "redirect:index?logout";
	}

	@RequestMapping("/403")//setting url mapping for access denied page
	public String ge403denied() 
	{
		return "403";
	}

//	@RequestMapping(value = "/register")
//	public String getRegister(Map<String, Object> map) {
//		UserInfo user = new UserInfo();
//		map.put("user", user);
//		System.out.println("In register page");
//		return "register";
//	}
//
//	@RequestMapping("/RegisterIns")
//	public String doRegister(@ModelAttribute UserInfo user, BindingResult result, @RequestParam String action,
//			Map<String, Object> map) {
//
//		dataservices.insertRow(user);
//		return "register";
//	}

}
