package com.hcl.pp.service;

//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.pp.controller.PetsAppController;
import com.hcl.pp.dao.UserDao;
import com.hcl.pp.model.User;

/**
 * @author Beena Kandpal
 *
 *
 *         Security Service Implementation
 *
 */
@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private UserDao userDao;

//	private static final Logger logger = LogManager.getLogger(SecurityServiceImpl.class);

	@Override
	@Transactional
	public boolean authenticateUser(String username, String userPassword) {
//		logger.info("Inside authenticateUser!!");

		System.out.println(username + userPassword);

		return userDao.authenticateUser(username, userPassword);
	}

	@Override
	@Transactional
	public User authenticateUser1(int userid) {

		return userDao.authenticateUser1(userid);
	}

}
