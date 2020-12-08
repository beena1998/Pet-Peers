package com.dao;

import com.model.Pet;

public interface PetDao {
	public abstract Pet savePet(Pet pet);
	public abstract Pet getAllPets();
	public abstract Pet fetchAll();
}
