package FinalProject;
import java.util.*;
public class collectionCars {
	private ArrayList<car> allCar;
	private car fastestSpeed, fastestAcceleration, lowestWeight;
	private int number;
	public collectionCars () {
		allCar = new ArrayList<car>();
	}
	public void addCars (String carInfo) {
		String name = carInfo.substring(0, carInfo.indexOf("-") -1);
		String [] info = carInfo.substring(carInfo.indexOf("-") +2, carInfo.length()).split(" ");
		allCar.add(new car(Integer.parseInt(info[0]),Integer.parseInt(info[1]),Double.parseDouble(info[2]),name));
	}
	public int collectionSize() {
		return allCar.size();
	}
	public static boolean isInteger(String s) {
	    boolean isInteger = false;
	    try{
	       Integer.parseInt(s);
	       isInteger = true;
	    }
	    catch (NumberFormatException ex){
	    }
	    return isInteger;
	}
	public car getFastestSpeed() {
		fastestSpeed = allCar.get(0);
		for (car c: allCar) {
			if (c.getSpeed() > fastestSpeed.getSpeed()) {
				fastestSpeed = c;
			}
		}
		return fastestSpeed;
	}
	public car getLowestWeight() {
		lowestWeight = allCar.get(0);
		for (car c: allCar) {
			if (lowestWeight.getWeight() > c.getWeight()) {
				lowestWeight = c;
			}
		}
		return lowestWeight;
	}
	public car getFastestAcceleration() {
		fastestAcceleration = allCar.get(0);
		for (car c: allCar) {
			if (fastestAcceleration.getZeroSixty() > c.getZeroSixty()) {
				fastestAcceleration = c;
			}
		}
		return fastestAcceleration;
	}
	public String toString() {
		String output = "";
		output += "You have " + allCar.size() + " cars in this collection. Here are their names and statistics:\n\n";
		for (car c: allCar) {
			output += c;
		}
		return output;
	}
}
