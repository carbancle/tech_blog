package tech_blog.service;

import tech_blog.dao.UserDAO;
import tech_blog.dao.UserDAOImpl;
import tech_blog.model.User;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO = new UserDAOImpl();

	@Override
	public User authenticate(String userId, String password) {
		User user = userDAO.findByUserId(userId);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	@Override
	public boolean registerUser(User user) {
		if (userDAO.findByUserId(user.getUserId()) == null) {
			return userDAO.save(user);
		}
		return false;
	}

	@Override
	public User getUserInfo(String userId) {
		return userDAO.findByUserId(userId);
	}

	@Override
	public boolean updateUser(User user) {
		return userDAO.update(user);
	}

	@Override
	public boolean deleteUser(String userId) {
		return userDAO.delete(userId);
	}

}
