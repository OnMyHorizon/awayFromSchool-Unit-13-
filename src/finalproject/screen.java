package finalproject;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class screen extends JPanel{
	private JButton car1, car2, car3, car4, car5, car6, car7, car8, enter, newUser, back, continueButton;
	private JTextField username, password, confirmPassword;
	private JLabel errormsg, welcomemsg, car1lbl, car2lbl, car3lbl, car4lbl, car5lbl, car6lbl, car7lbl, car8lbl;
	private Image image;
	private user usr;
	private ArrayList<user> users;
	private imageButton imgButton;
	public screen () {
		super();
		usr = new user();
		this.setLayout(null);
		users = new ArrayList<user>();
		imgButton = new imageButton(100,100,100,100,"apolloIE");
		renderWelcome();
	}
	public void renderWelcome() {
		this.removeAll();
		this.repaint();
		errormsg = new JLabel("Car Wishlist Application By: Jensen McKenzie");
		errormsg.setBounds(150,50,500,50);
		JLabel j = new JLabel("Create an account and password, then select cars to add them to your wishlist.");
		j.setBounds(150,100, 800,50);
		JLabel f = new JLabel("Go to your wishlist to remove cars from it. Usernames, and passwords are persistant.");
		f.setBounds(150,120, 800,50);
		continueButton = new textButton(150,200,150,50,"Continue").renderButton();
		this.add(continueButton);
		this.add(errormsg);
		this.add(j);
		this.add(f);
		addListenersWelcome();
	}
	public void renderSignIn() {
		this.removeAll();
		this.repaint();
		username = new JTextField("Username");
		username.setBounds(this.getWidth()/2, 100, 100, 20);
		password = new JTextField("Password");
		password.setBounds(this.getWidth()/2, 150, 100, 20);
		JLabel j = new JLabel("Sign in here");
		j.setBounds(this.getWidth()/2,50, 100,50);
		enter = new textButton(this.getWidth()/2, 180, 100, 20, "Sign in").renderButton();
		newUser = new textButton(this.getWidth()/2, 210, 150, 20, "Create an account").renderButton();
		errormsg = new JLabel("");
		errormsg.setBounds(this.getWidth()/2,300, 300,50);
		this.add(errormsg);
		this.add(j);
		this.add(username);
		this.add(password);
		this.add(enter);
		this.add(newUser);
		addListenersSignIn();
	}
	public void renderNewUser() {
		this.removeAll();
		this.repaint();
		username = new JTextField("Username");
		username.setBounds(this.getWidth()/2, 100, 150, 20);
		password = new JTextField("Password");
		password.setBounds(this.getWidth()/2, 130, 150, 20);
		confirmPassword = new JTextField("Confirm Password");
		confirmPassword.setBounds(this.getWidth()/2, 160, 150, 20);
		JLabel j = new JLabel("Create a new username and password");
		j.setBounds(this.getWidth()/2,50, 250,50);
		enter = new textButton(this.getWidth()/2, 180, 150, 20, "Create Account").renderButton();
		back = new textButton(this.getWidth()/2, 210, 150, 20, "Back").renderButton();
		errormsg = new JLabel("");
		errormsg.setBounds(this.getWidth()/2,300, 300,50);
		this.add(j);
		this.add(username);
		this.add(password);
		this.add(enter);
		this.add(confirmPassword);
		this.add(errormsg);
		this.add(back);
		addListenersNewUser();

	}
	public void renderWishlist() {
		this.removeAll();
		this.repaint();
		boolean [] list = new wishlistCars(usr).getList();
		if (list[0]) {
			car1 = new imageButton(50,50,100,100,"apolloIE").renderButton();
			car1lbl = new JLabel("ApolloIE");
			car1lbl.setBounds(50, 160, 150, 20);
		}else {
			car1.setIcon(imgButton.getNewIcon("black"));
			car1lbl = new JLabel("NOT PURCHASED");
			car1lbl.setBounds(50, 160, 150, 20);
		}
		if (list[1]) {
			car2 = new imageButton(200,50,100,100,"fenyr").renderButton();
			car2lbl = new JLabel("Fenyr Supersport");
			car2lbl.setBounds(200, 160, 150, 20);
		}else {
			car2.setIcon(imgButton.getNewIcon("black"));
			car2lbl = new JLabel("NOT PURCHASED");
			car2lbl.setBounds(200, 160, 150, 20);
		}
		if (list[2]) {
			car3 = new imageButton(350,50,100,100,"gtr").renderButton();
			car3lbl = new JLabel("Nissan GTR");
			car3lbl.setBounds(350, 160, 150, 20);
		}else {
			car3.setIcon(imgButton.getNewIcon("black"));
			car3lbl = new JLabel("NOT PURCHASED");
			car3lbl.setBounds(350, 160, 150, 20);
		}
		if (list[3]) {
			car4 = new imageButton(500,50,100,100,"gwagon").renderButton();
			car4lbl = new JLabel("G Wagon");
			car4lbl.setBounds(500, 160, 150, 20);
		}else {
			car4.setIcon(imgButton.getNewIcon("black"));
			car4lbl = new JLabel("NOT PURCHASED");
			car4lbl.setBounds(500, 160, 150, 20);
		}
		if (list[4]) {
			car5 = new imageButton(50,250,100,100,"hellcat").renderButton();
			car5lbl = new JLabel("Dodge Hellcat");
			car5lbl.setBounds(50, 360, 150, 20);
		}else {
			car5.setIcon(imgButton.getNewIcon("black"));
			car5lbl = new JLabel("NOT PURCHASED");
			car5lbl.setBounds(50, 360, 150, 20);
		}
		if (list[5]) {
			car6 = new imageButton(200,250,100,100,"lamborghinihuracan").renderButton();
			car6lbl = new JLabel("Lamborghini Huracan");
			car6lbl.setBounds(200, 360, 150, 20);
		}else {
			car6.setIcon(imgButton.getNewIcon("black"));
			car6lbl = new JLabel("NOT PURCHASED");
			car6lbl.setBounds(200, 360, 150, 20);
		}
		if (list[6]) {
			car7 = new imageButton(350,250,100,100,"mclarenp1").renderButton();
			car7lbl = new JLabel("Mclaren P1");
			car7lbl.setBounds(350, 360, 150, 20);
		}else {
			car7.setIcon(imgButton.getNewIcon("black"));
			car7lbl = new JLabel("NOT PURCHASED");
			car7lbl.setBounds(350, 360, 150, 20);
		}
		if (list[7]) {
			car8 = new imageButton(500,250,100,100,"slr").renderButton();
			car8lbl = new JLabel("Mercedes SLR");
			car8lbl.setBounds(500, 360, 150, 20);
		}else {
			car8.setIcon(imgButton.getNewIcon("black"));
			car8lbl = new JLabel("NOT PURCHASED");
			car8lbl.setBounds(500, 360, 150, 20);
		}
		back = new textButton(this.getWidth()/2, 500, 150, 20, "Sign Out").renderButton();
		continueButton = new textButton(this.getWidth()/2, 470, 150, 20, "To Shop").renderButton();
		errormsg = new JLabel("Welcome "+ usr.getName());
		errormsg.setBounds((this.getWidth()/2) - 300, 450, 150, 20);
		this.add(errormsg);
		this.add(continueButton);
		this.add(back);
		this.add(car1lbl);
		this.add(car2lbl);
		this.add(car3lbl);
		this.add(car4lbl);
		this.add(car5lbl);
		this.add(car6lbl);
		this.add(car7lbl);
		this.add(car8lbl);
		this.add(car1);
		this.add(car2);
		this.add(car3);
		this.add(car4);
		this.add(car5);
		this.add(car6);
		this.add(car7);
		this.add(car8);
		addListenersWishlist();
	}
	public void renderShop() {
		this.removeAll();
		this.repaint();
		boolean [] list = new nonWishlistCars(usr).getList();
		if (list[0]) {
			car1 = new imageButton(50,50,100,100,"apolloIE").renderButton();
			car1lbl = new JLabel("ApolloIE");
			car1lbl.setBounds(50, 160, 150, 20);
		}else {
			car1.setIcon(imgButton.getNewIcon("black"));
			car1lbl = new JLabel("PURCHASED");
			car1lbl.setBounds(50, 160, 150, 20);
		}
		if (list[1]) {
			car2 = new imageButton(200,50,100,100,"fenyr").renderButton();
			car2lbl = new JLabel("Fenyr Supersport");
			car2lbl.setBounds(200, 160, 150, 20);
		}else {
			car2.setIcon(imgButton.getNewIcon("black"));
			car2lbl = new JLabel("PURCHASED");
			car2lbl.setBounds(200, 160, 150, 20);
		}
		if (list[2]) {
			car3 = new imageButton(350,50,100,100,"gtr").renderButton();
			car3lbl = new JLabel("Nissan GTR");
			car3lbl.setBounds(350, 160, 150, 20);
		}else {
			car3.setIcon(imgButton.getNewIcon("black"));
			car3lbl = new JLabel("PURCHASED");
			car3lbl.setBounds(350, 160, 150, 20);
		}
		if (list[3]) {
			car4 = new imageButton(500,50,100,100,"gwagon").renderButton();
			car4lbl = new JLabel("G Wagon");
			car4lbl.setBounds(500, 160, 150, 20);
		}else {
			car4.setIcon(imgButton.getNewIcon("black"));
			car4lbl = new JLabel("PURCHASED");
			car4lbl.setBounds(500, 160, 150, 20);
		}
		if (list[4]) {
			car5 = new imageButton(50,250,100,100,"hellcat").renderButton();
			car5lbl = new JLabel("Dodge Hellcat");
			car5lbl.setBounds(50, 360, 150, 20);
		}else {
			car5.setIcon(imgButton.getNewIcon("black"));
			car5lbl = new JLabel("PURCHASED");
			car5lbl.setBounds(50, 360, 150, 20);
		}
		if (list[5]) {
			car6 = new imageButton(200,250,100,100,"lamborghinihuracan").renderButton();
			car6lbl = new JLabel("Lamborghini Huracan");
			car6lbl.setBounds(200, 360, 150, 20);
		}else {
			car6.setIcon(imgButton.getNewIcon("black"));
			car6lbl = new JLabel("PURCHASED");
			car6lbl.setBounds(200, 360, 150, 20);
		}
		if (list[6]) {
			car7 = new imageButton(350,250,100,100,"mclarenp1").renderButton();
			car7lbl = new JLabel("Mclaren P1");
			car7lbl.setBounds(350, 360, 150, 20);
		}else {
			car7.setIcon(imgButton.getNewIcon("black"));
			car7lbl = new JLabel("PURCHASED");
			car7lbl.setBounds(350, 360, 150, 20);
		}
		if (list[7]) {
			car8 = new imageButton(500,250,100,100,"slr").renderButton();
			car8lbl = new JLabel("Mercedes SLR");
			car8lbl.setBounds(500, 360, 150, 20);
		}else {
			car8.setIcon(imgButton.getNewIcon("black"));
			car8lbl = new JLabel("PURCHASED");
			car8lbl.setBounds(500, 360, 150, 20);
		}
		back = new textButton(this.getWidth()/2, 500, 150, 20, "Sign Out").renderButton();
		continueButton = new textButton(this.getWidth()/2, 470, 150, 20, "To Wishlist").renderButton();
		errormsg = new JLabel("Welcome "+ usr.getName());
		errormsg.setBounds((this.getWidth()/2)-300, 450, 150, 20);
		this.add(errormsg);
		this.add(continueButton);
		this.add(back);
		this.add(car1lbl);
		this.add(car2lbl);
		this.add(car3lbl);
		this.add(car4lbl);
		this.add(car5lbl);
		this.add(car6lbl);
		this.add(car7lbl);
		this.add(car8lbl);
		this.add(car1);
		this.add(car2);
		this.add(car3);
		this.add(car4);
		this.add(car5);
		this.add(car6);
		this.add(car7);
		this.add(car8);
		addListenersShop();
	}
	public void update() {
		
	}
	public void addListenersSignIn() {
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				boolean correct = false;
				String data = "";
				File file = new File("C:/Users/Jensen/git/awayFromSchool-Unit-13-/awayFromSchool-Unit-13-/awayFromSchool-Unit-13-/src/finalproject/user.txt");
				try {
					Scanner sc = new Scanner (file);
					while (sc.hasNextLine()){
						String line = sc.nextLine();
						if (line.substring(1, line.indexOf(':')).equals(username.getText())) {
							if (line.substring(line.indexOf(':') + 1, line.indexOf('|')).equals(password.getText())) {
								correct = true;
								data = line;
							}
						}
					}
					sc.close();
				}catch (IOException e) {}
				if (correct) {
					boolean has = false;
					for (user u : users) {
						if (u.getName().equals(data.substring(1, data.indexOf(':')))) {
							has = true;
						}
					}
					if (has) {
						for (user u : users) {
							if (u.getName().equals(data.substring(1, data.indexOf(':')))) {
								usr = u;
							}
						}
					}else {
						usr = new user(data);
						users.add(usr);
					}
					renderShop();
				}else {
					errormsg.setText("Username or password is incorrect");
				}
			}
		});
		newUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				renderNewUser();
			}
		});
	}
	public void addListenersWelcome() {
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				renderSignIn();
			}
		});
	}
	public void addListenersNewUser() {
			enter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent mouseClick)
				{
					if (!username.getText().equals("Username") && password.getText().equals(confirmPassword.getText()) && !confirmPassword.getText().equals("Confirm Password")) {
						boolean alreadyHas = false;
						File file = new File("C:/Users/Jensen/git/awayFromSchool-Unit-13-/awayFromSchool-Unit-13-/awayFromSchool-Unit-13-/src/finalproject/user.txt");
						try {
							Scanner sc = new Scanner (file);
							while (sc.hasNextLine()){
								String line = sc.nextLine();
								if (line.substring(1, line.indexOf(':')).equals(username.getText())) {
									alreadyHas = true;
								}
							}
							sc.close();
						}catch (IOException e) {}
						if (!alreadyHas) {
							try {
								FileWriter fr = new FileWriter(file, true);
								fr.write("\n!"+username.getText() + ":" + confirmPassword.getText() + "|11111111" );
								fr.close();
							}catch (IOException e) {}
							renderSignIn();
						}else {
							errormsg.setText("Account already exists");
						}
					}else {
						errormsg.setText("Username or password is not valid");
					}
				}
			});
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent mouseClick)
				{
					renderSignIn();
				}
			});
	}
	public void addListenersShop() {
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				renderWishlist();
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				renderSignIn();
			}
		});
		car1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				car1.setIcon(imgButton.getNewIcon("black"));
				usr.set1(false);
				car1lbl.setText("PURCHASED");
			}
		});
		car2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				car2.setIcon(imgButton.getNewIcon("black"));
				usr.set2(false);
				car2lbl.setText("PURCHASED");
			}
		});
		car3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				car3.setIcon(imgButton.getNewIcon("black"));
				usr.set3(false);
				car3lbl.setText("PURCHASED");
			}
		});
		car4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				car4.setIcon(imgButton.getNewIcon("black"));
				usr.set4(false);
				car4lbl.setText("PURCHASED");
			}
		});
		car5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				car5.setIcon(imgButton.getNewIcon("black"));
				usr.set5(false);
				car5lbl.setText("PURCHASED");
			}
		});
		car6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				car6.setIcon(imgButton.getNewIcon("black"));
				usr.set6(false);
				car6lbl.setText("PURCHASED");
			}
		});
		car7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				car7.setIcon(imgButton.getNewIcon("black"));
				usr.set7(false);
				car7lbl.setText("PURCHASED");
			}
		});
		car8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				car8.setIcon(imgButton.getNewIcon("black"));
				usr.set8(false);
				car8lbl.setText("PURCHASED");
			}
		});
	}
	public void addListenersWishlist() {
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				renderShop();
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				renderSignIn();
			}
		});
		car1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				car1.setIcon(imgButton.getNewIcon("black"));
				usr.set1(true);
				car1lbl.setText("PURCHASED");
			}
		});
		car2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				car2.setIcon(imgButton.getNewIcon("black"));
				usr.set2(true);
				car2lbl.setText("PURCHASED");
			}
		});
		car3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				car3.setIcon(imgButton.getNewIcon("black"));
				usr.set3(true);
				car3lbl.setText("PURCHASED");
			}
		});
		car4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				car4.setIcon(imgButton.getNewIcon("black"));
				usr.set4(true);
				car4lbl.setText("PURCHASED");
			}
		});
		car5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				car5.setIcon(imgButton.getNewIcon("black"));
				usr.set5(true);
				car5lbl.setText("PURCHASED");
			}
		});
		car6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				car6.setIcon(imgButton.getNewIcon("black"));
				usr.set6(true);
				car6lbl.setText("PURCHASED");
			}
		});
		car7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				car7.setIcon(imgButton.getNewIcon("black"));
				usr.set7(true);
				car7lbl.setText("PURCHASED");
			}
		});
		car8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mouseClick)
			{
				car8.setIcon(imgButton.getNewIcon("black"));
				usr.set8(true);
				car8lbl.setText("PURCHASED");
			}
		});
	}
}
