package com.xigege.ssm.service;

import com.xigege.ssm.domain.Role;
import com.xigege.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll() throws Exception;

    void svae(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String userid) throws  Exception;

    void addRoleToUser(String userId, String[] roleIds);
}
