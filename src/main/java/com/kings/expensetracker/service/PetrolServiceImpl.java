package com.kings.expensetracker.service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.kings.expensetracker.model.Petrol;
import com.kings.expensetracker.repository.PetrolRepository;

@Service
public class PetrolServiceImpl implements PetrolService {

	
	@Autowired
	private PetrolRepository petrolRepository;
	
	@Override
	public List<Petrol> listAll() {
		return (List<Petrol>)petrolRepository.findAll(new Sort(Sort.Direction.DESC,"id"));
	}
			
	public boolean makeNewPetrolEntry(Petrol petrol) {
		petrol.setKilometersRan(kilometersRun(petrol.getTotalKilometers()));
		petrol.setAverage(Double.parseDouble(new DecimalFormat("#.##").format(getAverage(petrol.getTotalKilometers(),petrol.getQuantity()))));
		petrol.setDaysBetweenRefuel(getDaysBetweenRefuel(petrol.getRefuelDate()));
		petrol.setNextRefuelDate(nextRefuelDate(petrol.getRefuelDate()));
		petrol.setPredictedKmToRun(nextPredictedRun(petrol.getTotalKilometers()));
		petrol.setPredictedTotalKilometers(nextPredictedTotalKm(petrol.getPredictedKmToRun()));
		petrol.setCreatedDate();
		return (petrolRepository.save(petrol)!=null);
	}
	
	public Petrol nextRefuelPrediction() {
		Petrol petrol = new Petrol();
		Petrol prevData = petrolRepository.findFirstByOrderByIdDesc();
		petrol.setNextRefuelDate(prevData.getNextRefuelDate());
		petrol.setPredictedTotalKilometers(prevData.getTotalKilometers()+prevData.getPredictedKmToRun());
		petrol.setPredictedKmToRun(prevData.getPredictedKmToRun());
		return petrol;
	}
	
	private int kilometersRun(int lastKm) {
		Petrol petrol = petrolRepository.findFirstByOrderByIdDesc();
		return lastKm-petrol.getTotalKilometers();
	}
	
	private double getAverage(int lastKm, double liters) {
		return kilometersRun(lastKm)/liters;
	}
		
	private int getDaysBetweenRefuel(Date currentDate) {
		new SimpleDateFormat("yyyy-MM-dd").format(currentDate);
		Petrol petrol = petrolRepository.findFirstByOrderByIdDesc();
		long difference = currentDate.getTime() - petrol.getRefuelDate().getTime();
		long days = (difference/(1000*60*60*24));
		return (int)days;
	}
	
	private Date nextRefuelDate(Date currentDate) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String from = format.format(currentDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(format.parse(from));
			cal.add(Calendar.DAY_OF_MONTH, petrolRepository.getAvgDaysBetweenRefuelDays());
			String date = format.format(cal.getTime());
			return format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();

		}
		return null;
	}
	
	private int nextPredictedRun(int totalKm) {
		int avge = petrolRepository.getAverageKilometersRun();
		return avge;
	}
	
	private int nextPredictedTotalKm(int avge) {
		Petrol petrol = petrolRepository.findFirstByOrderByIdDesc();	
		return petrol.getTotalKilometers()+avge;
	}

}
