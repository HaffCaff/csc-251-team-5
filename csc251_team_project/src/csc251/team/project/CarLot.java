package csc251.team.project;

import java.util.ArrayList;
import java.util.Collections;

public class CarLot {
	private ArrayList<Car> inventory;
//	private int numberOfCars = 0;
//	private int capacity = 0;
//	
	public CarLot() { 
		// this(100); This is no longer needed as ArrayLists grow dynamically 
		this.inventory = new ArrayList<Car>();
	}
	
//	public CarLot(int capacity) {
//		this.capacity = capacity;
//		this.inventory = new ArrayList<Car>(100);
//	} // Here, since the arraylist grows, do we need to set a capacity? not changing but feel like this could be removed. 
	
	public void addCar(String id, int mileage, int mpg, double cost, double salesPrice) {
//		if (numberOfCars < capacity) {
//			this.inventory[numberOfCars] = new Car(id, mileage, mpg, cost, salesPrice);
//			numberOfCars++;
//		}
		
		Car c = new Car(id, mileage, mpg, cost, salesPrice);
		inventory.add(c);
	}
	
	public ArrayList<Car> getInventory() {
//		Car[] allCars = new Car[numberOfCars];
//		for (int i = 0; i < numberOfCars; i++) {
//			allCars[i] = this.inventory[i];
//		}
//		return allCars;
		
		return inventory;
	}
	
	public Car findCarByIdentifier(String identifier) {
//		for (int x = 0; x < this.inventory.length; x++) {
//			Car aCar = this.inventory[x];
//			if (aCar.getId().equals(identifier)) {
//				return aCar;
//			}
//		}
//		return null;
		
		for (int x = 0; x < inventory.size(); x++) {
			Car aCar = inventory.get(x);
			if (aCar.getId().equals(identifier)) {
				return aCar;
			}
		}
		return null;
	}
	
	
	public void sellCar(String identifier, double priceSold) throws IllegalArgumentException {
		Car aCar = this.findCarByIdentifier(identifier);
		if (aCar != null) {
			aCar.sellCar(priceSold);
		} else {
			throw new IllegalArgumentException("No car with identifier " + identifier);
		}
	}
	
	public ArrayList<Car> getCarsInOrderOfEntry() { return inventory; }
	
	
	// The biggest change for the functions below was swapping any instance refering to numberOfCars, as its not needed when using a dynamic arraylist
	// for example:  for (int i = 0; i < this.numberOfCars; i++) became for (int i = 0; i < inventory.size(); i++) {
	// any reference or comparison to numberOfCars was swapped to inventory.size
	
	//Another change is instead of accessing the index like an array would: ArrayName[index], ArrayList has the get() method, which returns item at passed index. 
	//For exmaple: Car aCar = inventory[i], becomes Car aCar = inventory.get(i);
	// Any reference or usage of inventory[i] swapped to inventory.get(i);
	
	
	
	public ArrayList<Car> getCarsSortedByMPG() {
		ArrayList<Car> allCars = new ArrayList<>();
		for (int i = 0; i < inventory.size(); i++) {
			allCars.add(inventory.get(i));
		}
		Collections.sort(allCars, (Car c1, Car c2) -> c2.compareMPG(c1));
		return allCars;
	}
	
	public Car getCarWithBestMPG() {
		Car rtn = null;
		int bestMpg = -1;
		for (int i = 0; i < inventory.size(); i++) {
			Car aCar = inventory.get(i);
			if (aCar.getMpg() > bestMpg) {
				bestMpg = aCar.getMpg();
				rtn = aCar;
			}
		}
		return rtn;
	}
	
	public Car getCarWithHighestMileage() {
		Car rtn = null;
		int highestMileage = -1;
		for (int i = 0; i < inventory.size(); i++) {
			Car aCar = inventory.get(i);
			if (aCar.getMileage() > highestMileage) {
				highestMileage = aCar.getMileage();
				rtn = aCar;
			}
		}
		return rtn;
	}
	
	public double getAverageMpg() {
		double totalMpg = 0D;
		for (int i = 0; i < inventory.size(); i++) {
			Car aCar = inventory.get(i);
			totalMpg += aCar.getMpg();
		}
		return totalMpg / this.inventory.size();
	}
	
	public double getTotalProfit() {
		double profit = 0D;
		for (int i = 0; i < inventory.size(); i++) {
			Car aCar = inventory.get(i);
			profit += (aCar.isSold()?aCar.getProfit():0);
		}
		return profit;
	}
	
}
