package org.kshrd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.kshrd.model.UserModel;
import org.kshrd.services.RoleService;
import org.kshrd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class UserController {
	
	private UserService userService;
	private RoleService roleService;
	
	@Autowired
	public UserController(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}
	
	@RequestMapping("/user-list")
	public String userList(ModelMap map){
		map.put("USER", userService.getAllUser());
		map.put("URL","/admin/user-list");
		return "/admin/user-list";
	}
	
	@RequestMapping("/user-form")
	public String userForm(ModelMap map){
		UserModel userModel = new UserModel();
		map.put("USER", userModel);
		map.put("URL","/admin/user-form");
		map.put("ROLE", roleService.getAllRole());
		map.put("ACTION", "/admin/add-user");
		return "/admin/user-cu";
	}
	
	@RequestMapping("/user-update-form/{userHash}")
	public String userUpdateForm(@PathVariable("userHash") String userHash, ModelMap map){
		map.put("USER", userService.findUserByHashCode(userHash));
		map.put("ROLE", roleService.getAllRole());
		map.put("URL","/admin//user-update-form/"+userHash);
		map.put("ACTION", "/admin/update-user");
		return "/admin/user-cu";
	}
	
	@RequestMapping(value="/add-user", method = RequestMethod.POST)
	public String addUser(@ModelAttribute UserModel userModel, ModelMap map){
		String uuid = UUID.randomUUID().toString();
		userModel.setUserHash(uuid);
		userModel.setStatus(true);
		
		userService.addUser(userModel);
		map.put("USER", userService.getAllUser());
		map.put("URL","/admin/user-list");
		return "redirect:/admin/user-list";
	}
	
	@RequestMapping(value="/update-user" , method = RequestMethod.POST)
	public String updateUser(@ModelAttribute UserModel user, ModelMap map){
		user.setStatus(true);
		userService.updateUser(user);
		map.put("USER", userService.getAllUser());
		map.put("URL","/admin/user-list");
		return "redirect:/admin/user-list";
	}
	
	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam String userHash, ModelMap map){
		userService.deleteUser(userHash);
		map.put("USER", userService.getAllUser());
		map.put("URL","/admin/user-list");
		return "redirect:/admin/user-list";
	}
	
	@RequestMapping(value="/search-user")
	public String findUser(@RequestParam(required=true,defaultValue="0") String idorname, ModelMap map){
		int isId = isId(idorname);
		if(isId>0 ){
			List<UserModel> userList = new ArrayList<>();
			userList.add(userService.findUserById(isId));
			map.put("USER", userList);
		}else{
			List<UserModel> userList = userService.findAllUserByName(idorname.trim()+"%");
			map.put("USER",userList );
		}
		map.put("URL","/admin/user-list");
		return "/admin/user-list";
	}
	
	@RequestMapping("/user-detail/{userHash}")
	public String userDetail(@PathVariable("userHash") String userHash, ModelMap map){
		map.put("USER", userService.findUserByHashCode(userHash));
		map.put("URL", "/admin/user-detail/"+userHash);
		return "/admin/user-detail";
	}
	
	private int isId(String id){
		try{
			return Integer.parseInt(id);
		}catch(Exception e){
			return -1;
		}
	}
	
}
