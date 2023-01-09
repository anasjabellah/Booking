package com.example.bookingmt.services;

import com.example.bookingmt.entities.Hotel;
import com.example.bookingmt.entities.Role;

import java.util.List;

public interface RoleService {

    // add role
    void  addRole(Role role);
    // update Role
    void updateRole(Role role , Long id);
    // delete Role
    Boolean DeleteRole(Long id);

    List<Role> GetAllRoles();
}
