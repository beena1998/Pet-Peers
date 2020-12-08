package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PetDao;
import com.model.Pet;
@Service
public class PetServiceImpl implements PetService {
@Autowired
private PetDao petDao;

	@Override
	public Pet savePet() {
		
		return petDao.getAllPets();
	}

	@Override
	public Pet getAllPets() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
