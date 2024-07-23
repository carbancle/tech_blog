package tech_blog.service;

import tech_blog.model.User;

public interface UserService {
	User authenticate(String userId, String password);
	boolean registerUser(User user);
	User getUserInfo(String userId);
	boolean updateUser(User user);
	boolean deleteUser(String userId);
}
