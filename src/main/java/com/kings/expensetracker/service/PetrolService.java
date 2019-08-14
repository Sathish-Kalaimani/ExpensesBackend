package com.kings.expensetracker.service;

import java.util.List;

import com.kings.expensetracker.model.Petrol;

public interface PetrolService {

	
	public List<Petrol> listAll();
	
	public boolean makeNewPetrolEntry(Petrol petrol);
	
	public Petrol nextRefuelPrediction();
	
	
}
