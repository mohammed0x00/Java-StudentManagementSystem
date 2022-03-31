import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Students {
	public int studentID;
	protected File studentFile;
	protected File studentSubjectsFile;
	protected File studentImageFile;
	public String studentName;
	public String birth;
	public String address;
	public String age;
	public String year;
	public String Class;
	public String phone;
	public String email;
	public String gender;
	public String totalMarks;
	public String Subjects;
	Students(int ID) throws IOException{
		studentID = ID;
		this.studentFile = new File(System.getProperty("user.dir"),"\\Students\\"+studentID);
		this.studentSubjectsFile = new File(System.getProperty("user.dir"),"\\Students\\"+studentID+"_Subjects");
		this.studentImageFile = new File(System.getProperty("user.dir"),"\\Students\\"+studentID+".png");
		studentName = Files.readAllLines(Paths.get(System.getProperty("user.dir"),"\\Students\\"+ID)).get(0);
		birth = Files.readAllLines(Paths.get(System.getProperty("user.dir"),"\\Students\\"+ID)).get(1);
		address = Files.readAllLines(Paths.get(System.getProperty("user.dir"),"\\Students\\"+ID)).get(2);
		age = Files.readAllLines(Paths.get(System.getProperty("user.dir"),"\\Students\\"+ID)).get(3);
		year = Files.readAllLines(Paths.get(System.getProperty("user.dir"),"\\Students\\"+ID)).get(4);
		Class = Files.readAllLines(Paths.get(System.getProperty("user.dir"),"\\Students\\"+ID)).get(5);
		phone = Files.readAllLines(Paths.get(System.getProperty("user.dir"),"\\Students\\"+ID)).get(6);
		email = Files.readAllLines(Paths.get(System.getProperty("user.dir"),"\\Students\\"+ID)).get(7);
		gender = Files.readAllLines(Paths.get(System.getProperty("user.dir"),"\\Students\\"+ID)).get(8);
		totalMarks = Files.readAllLines(Paths.get(System.getProperty("user.dir"),"\\Students\\"+ID)).get(9);
		Subjects = Files.readAllLines(Paths.get(System.getProperty("user.dir"),"\\Students\\"+ID)).get(10);
	}
	public void createNewStudent() throws IOException {
	studentFile.createNewFile();
	if (studentSubjectsFile.createNewFile()!=true);// throw new IOException("Already Exist");
	
	}
	public void saveToFile() throws IOException {
		FileWriter tempFile = new FileWriter(studentFile);
		String ls =System.lineSeparator();
		tempFile.write(studentName+ls+birth+ls+address+ls+age+ls+year+ls+Class+ls+phone+ls+email+ls+gender+ls+totalMarks+ls+Subjects+ls);
		tempFile.close();
		//for (String a : SubjectsArray) {
		//	FileWriter tempFile2 = new FileWriter(studentSubjectsFile);
		//	tempFile2.write(a+System.lineSeparator());
		//	tempFile.close();
		//}
	}
	public void deleteStudent() throws IOException {
		if (studentFile.delete()!=true) throw new IOException("Not Exist");
		if (studentSubjectsFile.delete()!=true) throw new IOException("Not Exist");
		if(studentImageFile.exists()==true) studentImageFile.delete();
	}
}
