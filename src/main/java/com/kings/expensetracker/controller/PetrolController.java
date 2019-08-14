package com.kings.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kings.expensetracker.model.Petrol;
import com.kings.expensetracker.service.PetrolService;

@CrossOrigin
@RestController
@RequestMapping("/petrolApi")
public class PetrolController {

	@Autowired
	private PetrolService petrolService;
	
	@GetMapping(value="/getAllDetails")
	public ResponseEntity<List<Petrol>> getAllDetails(){
		return new ResponseEntity<List<Petrol>>(petrolService.listAll(), HttpStatus.OK);
	}
	
	@PostMapping(value="/createEntry")
	public ResponseEntity<Petrol> makeNewEntry(@RequestBody Petrol petrol){
		boolean isAdded = petrolService.makeNewPetrolEntry(petrol);
		if(isAdded) {
			return new ResponseEntity<Petrol>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Petrol>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getPrediction")
	public ResponseEntity<Petrol> getPredictedData(){
		return new ResponseEntity<Petrol>(petrolService.nextRefuelPrediction(), HttpStatus.OK);
	}
	
}
