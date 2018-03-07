package com.user.service;

import java.sql.SQLException;
import java.util.List;

import com.user.dao.UserDao;
import com.user.dto.UserDTO;

public class UserService {

	public UserDao userDao;

	public UserService() {
		userDao = new UserDao();
	}

	public int saveUser(UserDTO userDTO) {
		if(userDTO.getId()==0)
		{
			return userDao.saveUser(userDTO);
	}
		return userDao.updateUser(userDTO);
	}

	public List<UserDTO> getAllUsers() throws SQLException {
		return userDao.getAllUsers();
	}

	public UserDTO getUsersById(int id) {
		return userDao.getUserById(id);
	}

	public int deleteUser(int id) {
		return userDao.deleteUser(id);
	}
}
