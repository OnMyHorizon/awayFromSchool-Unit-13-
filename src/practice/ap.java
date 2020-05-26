package practice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
public class ap {
	public static String changeKey(String letter, String key){
		String result = letter;
		if (key.indexOf(letter) != -1){
			result = key.substring(0, key.indexOf(letter)) + key.substring(key.indexOf(letter) + 1, key.length());
	}
	return result;
	}

	public static void main(String [] args) {
		System.out.println(changeKey("M", "GXAD"));
		}
}
