package com.kings.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kings.expensetracker.model.Petrol;

public interface PetrolRepository extends JpaRepository<Petrol,String>{
	
	
	Petrol findFirstByOrderByIdDesc();
	
	@Query("select avg(p.kilometersRan) from Petrol p")
	int getAverageKilometersRun();
	
	@Query("select avg(p.daysBtwRefuel) from Petrol p")
	int getAvgDaysBetweenRefuelDays();
	
}
