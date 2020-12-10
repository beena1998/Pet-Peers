package com.hcl.pp.dao;

import com.hcl.pp.model.Pet;

public interface PetDao {
	public abstract Pet savePet(Pet pet);
	public abstract Pet getAllPets();
	public abstract Pet fetchAll();
}
