package com.hcl.pp.dao;

import java.util.List;

import javax.persistence.Query;

//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.hcl.pp.model.User;

/**
 * @author Beena Kandpal
 *
 *
 *         User's Dao Implementation Layer
 *
 */
@Repository
public class UserDaoImpl implements UserDao {
	/*
	 * @Autowired private SessionFactory sessionFactory;
	 *
	 */
	@Autowired
	private SessionFactory sessionFactory;
//	private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);
	// @Autowired
	// private EntityManagerFactory entityManagerFactory;

	/*
	 * @Autowired private HibernateTemplate hibernateTemplate;
	 * 
	 * public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	 * this.hibernateTemplate = hibernateTemplate; } public HibernateTemplate
	 * getHibernateTemplate() { return hibernateTemplate; }
	 */

	@Override
	public User addUser(User user) {
//		logger.info("User Added!! " + user.getUsername());
		Session session = sessionFactory.openSession();
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
	public User findByUserName(String username) {

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
	public User authenticateUser1(int userid) {

		Session session = sessionFactory.openSession();

		User user = (User) session.load(User.class, new Integer(userid));
		return user;

	}

	@Override
	public boolean authenticateUser(String username, String userPassword) {

//		logger.info("Check in login");
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		String SQL_QUERY = "from pet_user as o where o.USER_NAME=? and o.USER_PASSWD=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, username);
		query.setParameter(1, userPassword);
		List list = ((org.hibernate.query.Query) query).list();

		if ((list != null) && (list.size() > 0)) {
			userFound = true;
		}


		return userFound;

		/*
		 * if(user.getUsername().equals(username) &&
		 * user.getUserPassword().equals(userPassword)) { return user; }
		 */

		// User user = new User();
		// System.out.println("Inside dao!!");
		// user = (User) sessionFactory.getCurrentSession().createQuery("from pet_user
		// where USER_NAME=:username and USER_PASSWD=:userPassword")
		// .setParameter("username", username).setParameter("userPassword",
		// userPassword);

	}

	@Override
	public User buyPet(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override
	 * 
	 * @SuppressWarnings("unchecked") public User authenticateUser(String username,
	 * String userPassword) { DetachedCriteria detachedCriteria =
	 * DetachedCriteria.forClass(User.class);
	 * detachedCriteria.add(Restrictions.eq("username", username));
	 * detachedCriteria.add(Restrictions.eq("userPassword", userPassword));
	 * List<User> findByCriteria = (List<User>)
	 * hibernateTemplate.findByCriteria(detachedCriteria); if (findByCriteria !=
	 * null && findByCriteria.size() > 0) return findByCriteria.get(0); else return
	 * null; }
	 */

	/*
	 * @Override public User authenticateUser(String username, String userPassword)
	 * { System.out.println("Inside userDao authenticateUser" + username + " " +
	 * userPassword);
	 * 
	 * Session session = sessionFactory.getCurrentSession();
	 * 
	 * // sessionFactory = new Configuration().configure().buildSessionFactory();
	 * 
	 * // SessionFactory sessionFactory = new //
	 * Configuration().addProperties(prop).buildSessionFactory(); // Transaction tx
	 * = null; String res = "home";
	 * 
	 * 
	 * 
	 * User user =jdbcTemplate.
	 * queryForObject("select USER_NAME, USER_PASSWD from pet_user where USER_PASSWD=?  and USER_NAME=?"
	 * , new Object[] {1l},new RowMapper<User>() {
	 * 
	 * @Override public User mapRow(ResultSet rs, int rowNo) throws SQLException {
	 * User user= new User(); user.setUsername(rs.getString("username"));
	 * user.setUserPassword(rs.getString("userPassword")); return user; }
	 * 
	 * });
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * // try {
	 * 
	 * // tx = session.beginTransaction();
	 * 
	 * EntityManager entityManager = entityManagerFactory.createEntityManager();
	 * User user = entityManager.find(User.class, username);
	 * System.out.println("in userdaoimp:" + username + user.getUsername()); if
	 * (user.getUsername().equals(username)) { res = "pet_home"; }
	 * 
	 * 
	 * List<?> list1 = session.createQuery("FROM pets_user").list(); for (Iterator
	 * iterator = list1.iterator(); iterator.hasNext();) { User user = (User)
	 * iterator.next(); System.out.print("Name     : " + user.getUsername());
	 * System.out.print("Password : " + user.getUserPassword()); if
	 * (user.getUsername().equals(username) &&
	 * user.getUserPassword().equals(userPassword)) { res = "pet_home"; } } //
	 * tx.commit(); } finally {
	 * 
	 * }
	 * 
	 * return res; }
	 */
	/*
	 * @Override public String authenticateUser(User user) { Transaction trns =
	 * null; Session session = HibernateUtil.getSessionFactory().openSession(); try
	 * { trns = session.beginTransaction(); List result = session.
	 * createQuery("select password from UserDetails where userName=:userName")
	 * .setParameter("userName", user.getUserName()) .list(); trns.commit(); } catch
	 * (RuntimeException e) { e.printStackTrace(); } finally { session.flush();
	 * session.close(); } return null; }
	 */

	/*
	 * @Override public String authenticateUser(User user) {
	 * System.out.println("Inside authenticateUser"); Session currentSession =
	 * sessionFactory.openSession();
	 * 
	 * Query theQuery = currentSession
	 * .createQuery("from pet_user u where u.USER_NAME=:username AND u.USER_PASSWD=:pass"
	 * ); theQuery.setParameter("username", user.getUsername());
	 * theQuery.setParameter("pass", user.getUserPassword());
	 * 
	 * String username = theQuery.getParameter(user.getUsername()).toString();
	 * String pass = theQuery.getParameter(user.getUserPassword()).toString();
	 * System.out.println(username + pass); String page = "pet_home";
	 * 
	 * if (username == null && pass == null) { page = "errorPage";
	 * 
	 * }
	 * 
	 *//**
		 * List<E> results = theQuery.list();
		 * 
		 * if ((results!=null) && (results.size()>0)){ return "success"; } else { return
		 * "failed"; }
		 *//*
			 * 
			 * return page;
			 * 
			 * }
			 */

}
