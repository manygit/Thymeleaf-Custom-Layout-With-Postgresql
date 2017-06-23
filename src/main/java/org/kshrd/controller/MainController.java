package org.kshrd.controller;
import java.util.List;

import org.kshrd.model.UserModel;
import org.kshrd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class MainController {
	@Autowired
	private UserService userService;
	
	@RequestMapping({"/","/dashboard",""})
	public String dashboard(ModelMap map){
		List<UserModel> userList = userService.getAllUser();
		int totalUser = userList.size();
		long male = userList.stream().filter(u->u.getGender().toLowerCase().startsWith("m")).count();
		long female = totalUser - male;
		
		map.put("URL", "/admin");
		map.put("TOTAL", totalUser);
		map.put("MALE", male);
		map.put("FEMALE", female);
		return "/admin/dashboard";
	}
	
}
