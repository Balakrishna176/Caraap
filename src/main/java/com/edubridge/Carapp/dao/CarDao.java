package com.edubridge.Carapp.dao;

import java.util.List;

import com.edubridge.Carapp.Car;


public interface CarDao {
	int addCar(Car c) ;
	List<Car>getAllCars();
	Car getCar(String name);
	int updateCar(Car c);
	int deleteCar(String name);
	void deleteAllCars();


}
