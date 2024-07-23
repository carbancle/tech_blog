package tech_blog.dao;

import tech_blog.model.User;

public interface UserDAO {
	User findByUserId(String userId);
	boolean save(User user);
	boolean update(User user);
	boolean delete(String userId);
}
