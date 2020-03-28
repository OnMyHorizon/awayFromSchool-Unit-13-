package FinalProject;

public class car {
	private int weight, speed;
	private double zerosixty;
	private String name;
	public car (int w, int spd, double zs, String n) {
		weight = w;
		speed = spd;
		zerosixty = zs;
		name = n;
	}
	public int getWeight () {
		return weight;
	}
	public int getSpeed () {
		return speed;
	}
	public double getZeroSixty () {
		return zerosixty;
	}
	public String getName () {
		return name;
	}
	public String toString () {
		return name + ":\nWeight: " + weight +" lbs | Top Speed: " + speed + " mph | Zero to Sixty Time: " + zerosixty + " s\n";
	}
}
