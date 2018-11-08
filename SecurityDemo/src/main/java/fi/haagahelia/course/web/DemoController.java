package fi.haagahelia.course.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {

    @RequestMapping(value={"/", "/home"})
	public String homeSecure() {
		return "home";
	}  
    
    @RequestMapping(value="/hello")
	public String helloSecure() {
		return "hello";
	}
    
    @RequestMapping(value="/login")
	public String login() {
		return "login";
	}    
}
