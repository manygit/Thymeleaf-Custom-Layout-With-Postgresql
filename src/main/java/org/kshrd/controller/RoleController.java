package org.kshrd.controller;

import java.util.UUID;

import org.kshrd.model.RoleModel;
import org.kshrd.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class RoleController {

	private RoleService roleService;
	
	@Autowired
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@RequestMapping("/role-list")
	public String roleList(ModelMap map){
		map.put("ROLE", roleService.getAllRole());
		map.put("URL","/admin/role-list");
		return "/admin/role-list";
	}
	
	@RequestMapping("/role-form")
	public String roleForm(ModelMap map){
		RoleModel roleModel = new RoleModel();
		map.put("ROLE", roleModel);
		map.put("URL","/admin/role-form");
		map.put("ACTION", "/admin/add-role");
		return "/admin/role-cu";
	}
	
	@RequestMapping("/role-update-form/{roleHash}")
	public String roleUpdateForm(@PathVariable("roleHash") String roleHash, ModelMap map){
		map.put("ROLE", roleService.findRoleByHash(roleHash));
		map.put("URL","/admin/role-update-form/"+roleHash);
		map.put("ACTION", "/admin/update-role");
		return "/admin/role-cu";
	}
	
	@RequestMapping("/add-role")
	public String addUser(@ModelAttribute RoleModel roleModel, ModelMap map){
		String uuid = UUID.randomUUID().toString();
		roleModel.setRole_hash(uuid);
		roleService.addRole(roleModel);
		map.put("ROLE", roleService.getAllRole());
		map.put("URL","/admin/role-list");
		return "redirect:/admin/role-list";
	}
	
	@RequestMapping("/update-role")
	public String updateRole(@ModelAttribute RoleModel role, ModelMap map){
		roleService.updateRole(role);
		map.put("ROLE", roleService.getAllRole());
		map.put("URL","/admin/role-list");
		return "redirect:/admin/role-list";
	}
	
	@RequestMapping("/delete-role")
	public String deleteUser(@RequestParam String roleHash, ModelMap map){
		roleService.deleteRole(roleHash);
		map.put("ROLE", roleService.getAllRole());
		map.put("URL","/admin/role-list");
		return "redirect:/admin/role-list";
	}
	
}
