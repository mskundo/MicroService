package com.madhu.UserService.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madhu.UserService.entity.User;
import com.madhu.UserService.model.UserRecord;
import com.madhu.UserService.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private static final Logger logger = Logger.getLogger(UserService.class.getName());

	@Autowired
	public UserRepository userRepository;


	public User saveUser(UserRecord userRecord) {
		try {
			logger.info("saving data into user table");
			User user = new User();
			user.setFirstName(userRecord.firstName);
			user.setLastName(userRecord.lastName);
			user.setEmpId(userRecord.empId);
			return userRepository.save(user);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while saving data into user table", e.getMessage());
			throw e;
		}
	}

	public List<User> getAll() {
		try {
			logger.info("getting data from user table");
			return userRepository.findAll();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while getting data from user table", e.getMessage());
			throw e;
		}
	}

	public String deleteUser(Long userId) {
		try {
			logger.info("deleting data from user table");
			userRepository.deleteById(userId);
			return "user deleted successfully";
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while deleting data from user table", e.getMessage());
			throw e;
		}
	}

	public User updateUser(User user, Long userId) {
		try {
			logger.info("updating data to user table");
			user.setUserId(userId);
			return userRepository.save(user);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while updating data into user table", e.getMessage());
			throw e;
		}
	}

	public List<User> getUser(Long id) {
		return userRepository.findUser(id);
	}

}
