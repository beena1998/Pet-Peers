package com.dao;

import com.model.Pet;

public interface PetDao {
	public Pet savePet();
	public Pet getAllPets();
	public Pet fetchAll();
}
