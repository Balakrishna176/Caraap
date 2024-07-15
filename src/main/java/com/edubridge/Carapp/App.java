package com.edubridge.Carapp;

import java.util.List;
import java.util.Scanner;

import com.edubridge.Carapp.dao.CarDao;
import com.edubridge.Carapp.dao.CarDaoImpl;

public class App 
{
    public static void main( String[] args )
    {
    	CarDao dao=new CarDaoImpl();
    	Scanner in =new Scanner(System.in);
    	while(true) {
    		System.out.println("MY CAR APP");
    		System.out.println("--------------");
    		System.out.println("1.ADD NEW CAR");
    		System.out.println("2.VIEW ALL CARS");
    		System.out.println("3.SEARCH CARS");
    		System.out.println("4.UPDATE CAR");
    		System.out.println("5.DELETE CAR");
    		System.out.println("6.DELETE ALL CARS");
    		System.out.println("0. EXIT");
    		System.out.println("PLEASE CHOOSE OPTION:");
    		 int option=in.nextInt();
    		 switch(option) {
    		 case 1:
    			 System.out.println("please enter car model");
    		      String model=in.next();
    		      System.out.println("please enter car company");
    		      String company=in.next();
    		      System.out.println("please enter car colour");
    		      String colour =in.next();
    		      System.out.println("please enter car fuel_type");
    		      String fuel_type=in.next();
    		     System.out.println("please enter car engine_cc");
    		     int engine_cc =in.nextInt();
    		     System.out.println("please enter car prace");
    		     float price =in.nextFloat();
    		     Car newCar=new Car();
    		     newCar.setCompany(company);
    		     newCar.setModel(model);
    		     newCar.setColour(colour);
    		     newCar.setFuel_type(fuel_type);
    		     newCar.setEngine_cc(engine_cc);
    		     newCar.setPrice(price);
    		   int status=dao.addCar(newCar);
    		   if(status>=1) {
    			   System.out.println("new car is added");
    		   }else {
    			   System.out.println("something is wrong!!!!");
    		   }
    		   break;
    		 case 2:
    			 List<Car> cars=dao.getAllCars();
    			 if(cars.size()!=0) {
    				 for(Car c:cars) {
    					 System.out.println(c.getId()+"\t"+c.getModel()+"\t"+ c.getCompany()+"\t"+ c.getColour()+"\t"+c.getFuel_type()+"\t"+c.getEngine_cc()+"\t"+c.getPrice());
    				 }	 
    				 }else {
    					 System.out.println("no car found");
    				 }
    				break;
    				case 3:
    					System.out.println("please enter car model to search:");
    					String searchModel=in.next();
    					Car searchCar=dao.getCar(searchModel);
    					if(searchModel !=null) {
    						System.out.println(searchCar.getId()+"\t"+searchCar.getCompany()+"\t"+searchCar.getModel()+"\t"+searchCar.getColour()+"\t"+searchCar.getFuel_type()+"\t"+searchCar.getEngine_cc()+"\t"+searchCar.getPrice());
    						
    					}else {
    						System.out.println("car not found");
    					}
    					break;
    				case 4:
    					System.out.println("please enter car name to update:");
    					String UpdateModel=in.next();
    					Car updateCar=dao.getCar(UpdateModel);
    					if(updateCar !=null) {
    						System.out.println("please enter new car model name:");
    						String newModel=in.next();
    						System.out.println("please enter new car company name:");
    						String newCompany=in.next();
    						System.out.println("please enter new car colour name:");
    						String newColour=in.next();
    						System.out.println("please enter new car fuel_type :");
    						String newFuel_type=in.next();
    						System.out.println("please enter new car engine_cc :");
    						int newEngine_cc=in.nextInt();
    						System.out.println("please enter new car price:");
    						float newPrice=in.nextFloat();
    						updateCar.setCompany(newCompany);
    						updateCar.setModel(newModel);
    						updateCar.setColour(newColour);
    						updateCar.setFuel_type(newFuel_type);
    						updateCar.setEngine_cc(newEngine_cc);
    						updateCar.setPrice(newPrice);
    						int status1=dao.updateCar(updateCar);
							if(status1>=1) {
    							System.out.println("car update successfully");
    							
    						}else {
    							System.out.println("update failed");
    						}
    						}else {
    							System.out.println("carnot found");
    						}
    						break;
    				case 5:
    					System.out.println("please enter car name to delete");
    					String DeleteModel=in.next();
    					int status2=dao.deleteCar(DeleteModel);
    					if(status2>=1) {
    						System.out.println("car delete successfully");
    					}else {
    						System.out.println("car dalete failed");
    					}
    					break;
    				case 6:
    					dao.deleteAllCars();
    					System.out.println("All car  deleted");
    					break;
    				case 0:
    					System.out.println("byee!!!");
    					System.exit(0);
    					default:
    						System.out.println("invalide option !!!!");
    						break;
    					}
    			 }
    		 }
    	}
    
    

