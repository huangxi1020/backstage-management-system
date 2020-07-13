package com.xigege.ssm.service;

import com.xigege.ssm.domain.Permission;
import com.xigege.ssm.domain.Role;

import java.util.List;

public interface IRoleService {
public List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId)throws Exception;

    List<Permission> findOtherPermissions(String roleId) throws  Exception;

    void addPermissionToRole(String roleId, String[] permissionIds) throws  Exception;
}
