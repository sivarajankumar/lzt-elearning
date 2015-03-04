package org.lztvn.elearning.dao;

import java.util.List;

import org.lztvn.elearning.entities.Role;
import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.entities.UserRole;


public interface IUserRoleDAO {
    public UserRole addUserRole(UserRole u);
    public List<Role> getRoleByUser(User u);
}
