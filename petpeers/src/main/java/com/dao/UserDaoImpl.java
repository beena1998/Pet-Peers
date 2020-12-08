package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User addUser(User user) {
		Session session	=sessionFactory.openSession();
		session.save(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User listUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByID(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User removeUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User buyPet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getMyPets() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String authenticateUser(User user) {
		 Session currentSession = sessionFactory.getCurrentSession();

	        Query theQuery = currentSession.createQuery("from pet_user u where u.USER_NAME=username AND u.USER_PASSWD=pass");
	        theQuery.setParameter("username", user.getUsername());
	        theQuery.setParameter("pass", user.getUserPassword());

	        List<User> results = ((org.hibernate.query.Query) theQuery).list();

	        if ((results!=null) && (results.size()>0)){
	            return "success";
	        }
	        else {
	        return "failed";
	    }
		
	}

	

}
