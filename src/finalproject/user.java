package finalproject;
import java.util.Scanner;
import java.io.*;

public class user {
	private String name, d;
	private boolean car1, car2, car3, car4, car5, car6, car7, car8;
	public user (String data) {
		d = data; 
		name = data.substring(1, data.indexOf(':'));
		car1 = true;
		car2 = true;
		car3 = true;
		car4 = true;
		car5 = true;
		car6 = true;
		car7 = true;
		car8 = true;
	}
	public user () {
		name = "";
	}
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	public void set1 (boolean b) {
		car1 = b;
	}
	public void set2 (boolean b) {
		car2 = b;
	}
	public void set3 (boolean b) {
		car3 = b;
	}
	public void set4 (boolean b) {
		car4 = b;
	}
	public void set5 (boolean b) {
		car5 = b;
	}
	public void set6 (boolean b) {
		car6 = b;
	}
	public void set7 (boolean b) {
		car7 = b;
	}
	public void set8 (boolean b) {
		car8 = b;
	}
	public boolean get1 () {
		return car1;
	}
	public boolean get2 () {
		return car2;
	}
	public boolean get3 () {
		return car3;
	}
	public boolean get4 () {
		return car4;
	}
	public boolean get5 () {
		return car5;
	}
	public boolean get6 () {
		return car6;
	}
	public boolean get7 () {
		return car7;
	}
	public boolean get8 () {
		return car8;
	}
}
