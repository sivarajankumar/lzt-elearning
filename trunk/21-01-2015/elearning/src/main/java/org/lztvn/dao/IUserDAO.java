package org.lztvn.dao;

import java.util.List;

import org.lztvn.entity.Role;
import org.lztvn.entity.User;



public interface IUserDAO {
    public List<User> findByLastName(String lastName);
    public User login(String name, String pass);
    public Long addUser(User u);
    public List<Role> getRoles(User user);
}
