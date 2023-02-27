package fi.haagahelia.course.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {

    @RequestMapping(value={"/", "/home"})
	public String homeSecure() {
		return "home";
	}  
    
    @RequestMapping(value="/hello")
	public String helloSecure(Model model) {
		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		System.out.println("USERNAME: " + username);
    	model.addAttribute("name", username);
		return "hello";
	}
    
    @RequestMapping(value="/login")
	public String login() {
		return "login";
	}    
}
