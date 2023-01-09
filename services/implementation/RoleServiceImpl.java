package com.example.bookingmt.services.implementation;

import com.example.bookingmt.entities.Role;
import com.example.bookingmt.repositories.RoleRepository;
import com.example.bookingmt.services.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void updateRole(Role role , Long id) {
        Role role1 = roleRepository.findById(id).orElse(null);
        role1.setRoleName(role.getRoleName());
        roleRepository.save(role1);
    }

    @Override
    public Boolean DeleteRole(Long id) {
        roleRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public List<Role> GetAllRoles() {
        return roleRepository.findAll();
    }
}
