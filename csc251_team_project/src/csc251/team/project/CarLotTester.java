package csc251.team.project;

import java.sql.SQLException;

public class CarLotTester {
	public static void main(String[] args) throws SQLException {
		CarLot lot = new CarLot();
		lot.loadInventory();
		System.out.println("Inventory Loaded from Database: "); //SHOULD ONLY SHOW THE ONE CAR IN DATABASE!
		for (Car car: lot.getInventory()) {
			System.out.println(car);
		}
		lot.addCar("test1", 10000, 30, 12500.0D, 17500.0D);
		lot.addCar("test2", 10000, 10, 10000D, 10000D);
		lot.addCar("test3", 12000, 20, 12000D, 12000D);
		System.out.println("Inventory: ");
		for (Car car: lot.getInventory()) {
			System.out.println(car);
		}
		System.out.println("Average MPG: " + lot.getAverageMpg());
		System.out.println("Total Profit: " + lot.getTotalProfit());
		System.out.println("Car with the best MPG: " + lot.getCarWithBestMPG());
		System.out.println("Car with the highest mileage: " + lot.getCarWithHighestMileage());
		lot.sellCar("test1", 17000.0D);
		System.out.println("Total profit after selling one car: " + lot.getTotalProfit());
	}

}
