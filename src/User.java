import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
	private int userID;
	private String userName;
	private String userPassword;
	private static File userFile = new File(System.getProperty("user.dir"),"\\Users.txt");
	User(String UName , String Password){
		userName = UName;
		userPassword = Password;
	}
	User(int UName , String Password){
		userName = Integer.toString(UName);
		userPassword = Password;
	}
	User(int UName){
		userName = Integer.toString(UName);
	}
	
	public void createNewUser() throws IOException {
		FileWriter tempFile = new FileWriter(userFile,true);
		tempFile.write(userName+"#"+userPassword+System.lineSeparator());
		tempFile.close();
	}
	public int searchUserID() throws IOException {
		   FileReader fr=new FileReader(userFile);
		   BufferedReader br=new BufferedReader(fr);
		   String s;
		   String keyword=userName+"#"+userPassword;
		   int temp=0;
		    int counter=0;
		   while ((s=br.readLine())!=null){
		      if(s.contains(keyword)) {
		    	 temp=counter;
		    	 break;
		      }else {
		    	  temp=0;
		      }
		      counter++;
		   }
		return temp;
	} 
	public void deleteUser() throws IOException {
		   FileReader fr=new FileReader(userFile);
		   BufferedReader br=new BufferedReader(fr);
		   String s;
		   String keyword=userName;
		   String temp="";
		    int counter=0;
		   while ((s=br.readLine())!=null){
		      if(s.contains(keyword)) {
		    	 temp=s;
		    	 break;
		      }
		      counter++;
		   }
	         BufferedReader reader = new BufferedReader(new FileReader(userFile));
	         String line = "", oldtext = "";
	         while((line = reader.readLine()) != null){
	             oldtext += line + "\r\n";
	         }
	         reader.close();
	         String newtext = oldtext.replaceAll(temp+System.lineSeparator(),"");
	         FileWriter writer = new FileWriter(userFile);
	         writer.write(newtext);writer.close();
	}
	public void editUserPassword(String newPassword) throws IOException {
	         BufferedReader reader = new BufferedReader(new FileReader(userFile));
	         String line = "", oldtext = "";
	         while((line = reader.readLine()) != null){
	             oldtext += line + "\r\n";
	         }
	         reader.close();
	         String newtext = oldtext.replaceAll(userName+"#"+userPassword,userName+"#"+newPassword);
	         FileWriter writer = new FileWriter(userFile);
	         writer.write(newtext);writer.close();
	}
	
	
}
