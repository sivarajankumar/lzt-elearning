package org.lztvn.dao;

import java.util.List;

import org.lztvn.entity.Role;
import org.lztvn.entity.User;
import org.lztvn.entity.UserRole;

public interface IUserRoleDAO {
    public UserRole addUserRole(UserRole u);
    public List<Role> getRoleByUser(User u);
}
