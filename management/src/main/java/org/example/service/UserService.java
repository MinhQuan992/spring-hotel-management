package org.example.service;



import org.example.entity.Role;
import org.example.entity.User;


public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);

}
