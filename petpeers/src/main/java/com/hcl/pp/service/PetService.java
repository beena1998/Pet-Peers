package com.hcl.pp.service;

import com.hcl.pp.model.Pet;

public interface PetService {

	public abstract Pet savePet(Pet pet);

	public abstract Pet getAllPets();

}
