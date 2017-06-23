package org.kshrd.services;

import java.util.List;
import org.kshrd.model.UserModel;

public interface UserService {
	public List<UserModel> getAllUser();
	public boolean deleteUser(String userHash);
	public boolean addUser(UserModel user);
	public UserModel findUserByHashCode(String userHash);
	public UserModel findUserById(int id);
	public boolean updateUser(UserModel user);
	public List<UserModel> findAllUserByName(String name);
}
