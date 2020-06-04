package finalproject;

import java.awt.Component;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;

public class main extends JFrame{
	public main () {
		setSize(800,600);

		screen r = new screen();
		((Component)r).setFocusable(true);

		getContentPane().add(r);
		setVisible(true);
	}
	public static void main(String [] args){
		main m = new main();
	}
}
