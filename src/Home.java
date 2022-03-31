import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class Home {
    public static String userName;
    public static String password;
    public static Students Student;
    public static GUI frame;
	public static void main(String[] args) throws IOException {
		ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"\\Icon.png");
		frame.Admin.setIconImage(icon.getImage());
		frame.login.setIconImage(icon.getImage());
		frame.Main.setIconImage(icon.getImage());
		File init1=new File(System.getProperty("user.dir"),"\\Students\\");
		if(!init1.exists()) init1.mkdirs();
		File init2=new File(System.getProperty("user.dir"),"\\Users.txt");
		if(!init2.exists()) {
			init2.createNewFile();
			FileWriter init3=new FileWriter(init2);
			init3.write(System.lineSeparator());
			init3.close();
		}
		GUI frame=new GUI(); 
		frame.admin(false);
		frame.Login(true);

	}
		
	public static String searchStudentID(String studentName) throws IOException {
		String ID="";
		File temp1 = new File(System.getProperty("user.dir"),"\\Students\\");
		for(String a : temp1.list()) {
			if(Files.readAllLines(Paths.get(System.getProperty("user.dir"),"\\Students\\"+a)).get(0).intern()==studentName.intern())
				ID = a;
		}
			return ID;
	
	}
}