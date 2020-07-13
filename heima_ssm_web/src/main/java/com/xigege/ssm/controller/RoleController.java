package com.xigege.ssm.controller;


import com.xigege.ssm.domain.Permission;
import com.xigege.ssm.domain.Role;
import com.xigege.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

        @RequestMapping("/findAll.do")
        public ModelAndView findAll() throws Exception{
            ModelAndView mv = new ModelAndView();
            List<Role> roleList = roleService.findAll();

            mv.setViewName("role-list");

            mv.addObject("roleList",roleList);
            return mv;
        }

        @RequestMapping("/save.do")
            public String save(Role role) throws Exception {

        roleService.save(role);

        return "redirect:findAll.do";

        }

@RequestMapping("/findRoleByIdAndAllPermission")
public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) String roleId) throws Exception{
        ModelAndView mv = new ModelAndView();

            Role role =  roleService.findById(roleId);

       List<Permission> otherPermissions =  roleService.findOtherPermissions(roleId);


       mv.addObject("role",role);
       mv.addObject("permissionList",otherPermissions);
       mv.setViewName("role-permission-add");

       return mv;
        }

        @RequestMapping("/addPermissionToRole.do")
        public String addPermissionToRole(@RequestParam(name = "roleId",required = true) String roleId,@RequestParam(name = "ids" ,required = true)String [] permissionIds) throws Exception {
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll.do";
        }
    }
