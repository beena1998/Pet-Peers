package com.hcl.pp.service;

//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.pp.controller.PetsAppController;
import com.hcl.pp.dao.PetDao;
import com.hcl.pp.model.Pet;
@Service
public class PetServiceImpl implements PetService {
@Autowired
private PetDao petDao;
//private static final Logger logger = LogManager.getLogger(PetServiceImpl.class);
	@Override
	public Pet savePet(Pet pet) {
		
		return petDao.savePet(pet);
	}

	@Override
	public Pet getAllPets() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
