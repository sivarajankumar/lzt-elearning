package org.lztvn.dao;

import java.util.List;

import org.lztvn.entity.User;



public interface IUserDAO {
    public List<User> findByLastName(String lastName);
    public void login(String name, String pass);
    public Long addUser(User u);
}
