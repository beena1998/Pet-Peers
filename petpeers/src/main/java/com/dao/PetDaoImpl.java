package com.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Pet;
@Repository
public class PetDaoImpl implements PetDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Pet savePet(Pet pet) {
		// TODO Auto-generated method stub
		return null;
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
