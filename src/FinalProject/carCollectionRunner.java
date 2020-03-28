package FinalProject;
import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class carCollectionRunner {
	public static void main (String args []) throws IOException{
		ArrayList <collectionCars> collections = new ArrayList<collectionCars>();
		collectionCars collection = new collectionCars();
		Scanner doc = new Scanner(new File("C:/Users/Jensen/git/awayFromSchool-Unit-13-/awayFromSchool-Unit-13-/awayFromSchool-Unit-13-/src/CollectionListProject.txt"));
		String line = doc.nextLine();
		while (!line.equals("*")) {
			if (line.equals("-") && collection.collectionSize() != 0) {
				collections.add(collection);
				line = doc.nextLine();
			}
			else if (collection.isInteger(line)) {
				collection = new collectionCars();
				int times = Integer.parseInt(line);
				line = doc.nextLine();
				for (int i = 0; i <= times -1; i ++) {
					collection.addCars(line);
					line = doc.nextLine();
				}
				collections.add(collection);
			}
			if (doc.hasNextLine() && !line.equals("*")) {
				line = doc.nextLine();
			}
		}
		for (collectionCars cc: collections) {
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println(cc);
			System.out.println("The fastest car in this collection is the " +cc.getFastestSpeed().getName() +" with a top speed of "+cc.getFastestSpeed().getSpeed()+" mph");
			System.out.println("The car with the fastest acceleration in this collection is the " +cc.getFastestAcceleration().getName() +" with a top speed of "+cc.getFastestAcceleration().getZeroSixty() + " s");
			System.out.println("The lightest car in this collection is the " +cc.getLowestWeight().getName() +" with a top speed of "+cc.getLowestWeight().getWeight()+" lbs");
		}
		System.out.println("------------------------------------------------------------------------------------------");
	}
}
