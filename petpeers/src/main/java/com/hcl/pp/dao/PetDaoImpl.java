package com.hcl.pp.dao;


//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.pp.controller.PetsAppController;
import com.hcl.pp.model.Pet;
/**
 * @author Beena Kandpal
 *
 *
 */
@Repository
public class PetDaoImpl implements PetDao {
	@Autowired
	private SessionFactory sessionFactory;
//	private static final Logger logger = LogManager.getLogger(PetDaoImpl.class);
	
	@Override
	public Pet savePet(Pet pet) {
		   Session session = sessionFactory.openSession();
	        session.save(pet);
	        return pet;
		
	}

	@Override
	public Pet getAllPets() {
//		Session session	=sessionFactory.openSession();
//		session.save();
		return null;
	}
	@Override
	public Pet fetchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	


}
