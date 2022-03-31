import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.multi.MultiListUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;




public class GUI {
    public static JFrame login = new JFrame("Login");
    public static JFrame Main = new JFrame("Students Management System");
    public static JFrame Admin = new JFrame("Students Management System: Admin Login");
    private static Font mainMenuFont =new Font(null, 20, 20);
    private static Font mainMenuFont_2 =new Font(null, 20, 20);
    private static int wrongPasswordCounter=0;

    public static void Login(boolean status) {
    	login.setSize(300, 200);
    	login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	login.setResizable(false);
    	login.setLocationRelativeTo(null);
    	//COMPONENTS.
    	JLabel username=new JLabel("User Name:");
    	username.setBounds(25,20,100,20);
    	JLabel password=new JLabel("Psaaword:");
    	password.setBounds(25,70,100,20);
    	JLabel wrongPasswd=new JLabel("Invalid Username or Password.");
    	wrongPasswd.setBounds(55,95,180,20);
    	wrongPasswd.setVisible(false);
    	JTextField user = new JTextField();
    	user.setBounds(100,20,150,20);
    	JPasswordField pass = new JPasswordField();
    	pass.setBounds(100,70,150,20);
    	JButton loginB= new JButton("login");
    	loginB.setBounds(110,125,70,30);
    	JButton resetB= new JButton("Reset");
    	resetB.setBounds(190,125,70,30);
    	JButton aboutB= new JButton("About");
    	aboutB.setBounds(30,125,70,30);
    	//ADD COMPONENTS TO THE FRAME.
    	login.setLayout(null);
    	login.add(username);
    	login.add(password);
    	login.add(wrongPasswd);
    	login.add(user);
    	login.add(pass);
    	login.add(loginB);
    	login.add(resetB);
    	login.add(aboutB);
    	login.setVisible(status);
    	//Actions.
    	resetB.addActionListener(new ActionListener(){
    	      public void actionPerformed(ActionEvent e){
    	    	  user.setText(null);
    	    	  pass.setText(null);
    	      }});
    	aboutB.addActionListener(new ActionListener(){
  	      public void actionPerformed(ActionEvent e){
  	    	JOptionPane.showMessageDialog(null,"Students Manangement System ( Version 1.0 )"+System.lineSeparator()+"Designed By:"+System.lineSeparator()+"* Mohammed Ali Mansour"+System.lineSeparator()+
  	      "* Mohammed Hamdy Abdel Samie"+System.lineSeparator()+"* Amr Mohammed Yehia"+System.lineSeparator()+"* Mohamed Abdel Hamid Hussein","About",3); 
  	      }});
    	loginB.addActionListener(new ActionListener(){
    	      public void actionPerformed(ActionEvent e){
    	    	  wrongPasswd.setVisible(false);
    	    	  User temp = new User(user.getText(),pass.getText());
    	    	  if ((user.getText().intern())!=("".intern())) try {
    	    		  if((user.getText().intern()=="admin".intern())&&(pass.getText().intern()=="admin".intern())) {
    					  Home.frame.admin(true);
    	    			  login.setVisible(false);
    					  Home.Student = new Students(Integer.valueOf(user.getText()));
    	    		  }else if(temp.searchUserID()!=0) {
						wrongPasswordCounter=0;
					  Home.userName = user.getText();
					  Home.password = pass.getText();
					  login.setVisible(false);
					  Home.Student = new Students( Integer.valueOf(user.getText()));
					  Home.frame.mainMenu(true);
					 }else {
						 wrongPasswd.setVisible(true);
						 if(wrongPasswordCounter>1)
							 System.exit(1);
						 wrongPasswordCounter++; 
					 }
    	    	  
    	    	  }catch (IOException e1) {
					e1.printStackTrace();
    	    	  }catch (Exception e2) {
						 if(wrongPasswordCounter>1)
							 System.exit(1);
						 wrongPasswordCounter++;
    	    	  }
    	    	  user.setText(null);
    	    	  pass.setText(null);
    	      }
    	});
    }
    public static void mainMenu(boolean F1) throws IOException {
    	//Frame and Buttons.
    	Main.setSize(500, 500);								  
    	Main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Main.setVisible(F1);
    	Main.setLocationRelativeTo(null);
    	JPanel Tab1 = new JPanel();
    	JPanel Tab2 = new JPanel();
    	JPanel Tab3 = new JPanel();
    	Tab1.setBounds(0,0,485,400);
    	Tab2.setBounds(0,0,485,400);
    	Tab2.setBounds(0,0,485,400);
    	JButton Tab1_Button =new JButton("Personal INFO.");
    	Tab1_Button.setBounds(25, 410, 140, 30);
    	JButton Tab2_Button =new JButton("Grades");
    	Tab2_Button.setBounds(220, 410, 100, 30);
    	JButton Tab3_Button =new JButton("Logout");
    	Tab3_Button.setBounds(375, 410, 100, 30);
    	////////////////////////////////////////////////////////
    	JLabel studentName=new JLabel("Name: "+Home.Student.studentName);
    	studentName.setBounds(25,30,400,25);
    	studentName.setFont(mainMenuFont);
    	JLabel birth=new JLabel("Date of Birth: "+Home.Student.birth);
    	birth.setBounds(25,60,400,25);
    	birth.setFont(mainMenuFont);
    	JLabel address=new JLabel("Address: "+Home.Student.address);
    	address.setBounds(25,90,400,25);
    	address.setFont(mainMenuFont);
    	JLabel age=new JLabel("Age: "+Home.Student.age);
    	age.setBounds(25,120,400,25);
    	age.setFont(mainMenuFont);
    	JLabel year=new JLabel("Year: "+Home.Student.year);
    	year.setBounds(25,150,400,25);
    	year.setFont(mainMenuFont);
    	JLabel Class=new JLabel("Class: "+Home.Student.Class);
    	Class.setBounds(25,180,400,25);
    	Class.setFont(mainMenuFont);
    	JLabel phone=new JLabel("Phone: "+Home.Student.phone);
    	phone.setBounds(25,210,400,25);
    	phone.setFont(mainMenuFont);
    	JLabel email=new JLabel("E-mail: "+Home.Student.email);
    	email.setBounds(25,240,400,25);
    	email.setFont(mainMenuFont);
    	JLabel gender=new JLabel("Gender: "+Home.Student.gender);
    	gender.setBounds(25,270,400,25);
    	gender.setFont(mainMenuFont);
    	File imagePath = new File(System.getProperty("user.dir"),"\\Students\\"+Home.Student.studentID+".png");
    	JLabel image = new JLabel(new ImageIcon(imagePath.getPath()));
    	image.setBounds(370,30,100,150);
    	///////////////////////////////////////
    	JTextArea Subj=new JTextArea();
    	Subj.setBackground(Color.LIGHT_GRAY);
    	Object[] temp = Files.readAllLines(Paths.get(System.getProperty("user.dir"),"\\Students\\"+Home.Student.studentID+"_Subjects")).toArray();
    	String text="";
    	for( int j=0;j< temp.length ;j++)
    		if (j==0)
    			text=text + temp[j];
    		else
    			text=text + System.lineSeparator() + temp[j];
    	Subj.setText(text);
    	Subj.setBounds(20,20,485,400);
    	Subj.setFont(mainMenuFont_2);
    	Subj.setEditable(false);
    	//////////////////////////////////////
    	
    	Tab1_Button.addActionListener(new ActionListener() {
  	      public void actionPerformed(ActionEvent e){
	    	  Tab1.setVisible(true);
	    	  Tab2.setVisible(false);
	      }});
    	Tab2_Button.addActionListener(new ActionListener() {
  	      public void actionPerformed(ActionEvent e){
	    	  Tab1.setVisible(false);
	    	  Tab2.setVisible(true);
	      }});
    	Tab3_Button.addActionListener(new ActionListener() {
  	      public void actionPerformed(ActionEvent e){
	    	  Home.frame.Login(true);
	    	  Main.setVisible(false);
	      }});
    	
    	
    	Tab1.setBackground(Color.LIGHT_GRAY);
    	Tab2.setBackground(Color.LIGHT_GRAY);
    	Tab1.setLayout(null);
    	Tab2.setLayout(null);
    	Tab1.setVisible(true);
    	Tab2.setVisible(false);
    	Tab1.add(studentName);
    	Tab1.add(birth);
    	Tab1.add(address);
    	Tab1.add(age);
    	Tab1.add(year);
    	Tab1.add(Class);
    	Tab1.add(phone);
    	Tab1.add(email);
    	Tab1.add(gender);
    	Tab1.add(image);
    	Tab2.add(Subj);
    	Main.add(Tab1_Button);
    	Main.add(Tab2_Button);
    	Main.add(Tab3_Button);
    	Main.add(Tab1);
    	Main.add(Tab2);
    	Main.setResizable(false);
    	Main.setLayout(null);
    	
    	
    }
    public static void admin(boolean F1) throws IOException {
    	JPanel adminTab1 = new JPanel();
    	JPanel adminTab2 = new JPanel();
    	//Frame and Buttons.
    	Admin.setSize(700, 250);								  
    	Admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Admin.setVisible(F1);
    	Admin.setLocationRelativeTo(null);
    	JComboBox chooseID=new JComboBox(Administrator.listIDs());
    	chooseID.setBounds(30, 30, 200, 20);
    	JButton selectButton=new JButton("Edit");
    	selectButton.setBounds(30, 60, 80, 20);
    	JButton deleteButton=new JButton("Delete");
    	deleteButton.setBounds(130, 60, 80, 20);
    	JButton imgButton= new JButton("Add/Change Image");
    	imgButton.setBounds(30, 90, 160, 20);
    	JButton subjectsButton= new JButton("Manage Subjects");
    	subjectsButton.setBounds(30, 120, 160, 20);
    	JLabel newUser_Label = new JLabel("User Name");
    	newUser_Label.setBounds(390,30,100,25);
    	JLabel newPassword_Label = new JLabel("Password");
    	newPassword_Label.setBounds(390,70,100,25);
    	JTextField newUser = new JTextField();
    	newUser.setBounds(470,30,200,25);
    	JTextField newPassword = new JTextField();
    	newPassword.setBounds(470,70,200,25);
    	JButton createUser= new JButton("Create User");
    	createUser.setBounds(500,110,130,20);
    	JButton logOut= new JButton("Logout");
    	logOut.setBounds(590,200,100,20);
    	////////////////////////////////////////////////////////
    	JLabel studentName=new JLabel("Name: ");
    	studentName.setBounds(25,30,200,25);
    	studentName.setFont(mainMenuFont);
    	JLabel birth=new JLabel("Date of Birth: ");
    	birth.setBounds(25,60,200,25);
    	birth.setFont(mainMenuFont);
    	JLabel address=new JLabel("Address: ");
    	address.setBounds(25,90,200,25);
    	address.setFont(mainMenuFont);
    	JLabel age=new JLabel("Age: ");
    	age.setBounds(25,120,200,25);
    	age.setFont(mainMenuFont);
    	JLabel year=new JLabel("Year: ");
    	year.setBounds(25,150,200,25);
    	year.setFont(mainMenuFont);
    	JLabel Class=new JLabel("Class: ");
    	Class.setBounds(25,180,200,25);
    	Class.setFont(mainMenuFont);
    	JLabel phone=new JLabel("Phone: ");
    	phone.setBounds(25,210,200,25);
    	phone.setFont(mainMenuFont);
    	JLabel email=new JLabel("E-mail: ");
    	email.setBounds(25,240,200,25);
    	email.setFont(mainMenuFont);
    	JLabel gender=new JLabel("Gender: ");
    	gender.setBounds(25,270,200,25);
    	gender.setFont(mainMenuFont);
    	JTextField studentName_Text=new JTextField();
    	studentName_Text.setBounds(155,30,500,25);
    	studentName_Text.setFont(mainMenuFont);
    	JTextField birth_Text=new JTextField();
    	birth_Text.setBounds(155,60,500,25);
    	birth_Text.setFont(mainMenuFont);
    	JTextField address_Text=new JTextField();
    	address_Text.setBounds(155,90,500,25);
    	address_Text.setFont(mainMenuFont);
    	JTextField age_Text=new JTextField();
    	age_Text.setBounds(155,120,500,25);
    	age_Text.setFont(mainMenuFont);
    	JTextField year_Text=new JTextField();
    	year_Text.setBounds(155,150,500,25);
    	year_Text.setFont(mainMenuFont);
    	JTextField Class_Text=new JTextField();
    	Class_Text.setBounds(155,180,500,25);
    	Class_Text.setFont(mainMenuFont);
    	JTextField phone_Text=new JTextField();
    	phone_Text.setBounds(155,210,500,25);
    	phone_Text.setFont(mainMenuFont);
    	JTextField email_Text=new JTextField();
    	email_Text.setBounds(155,240,500,25);
    	email_Text.setFont(mainMenuFont);
    	JTextField gender_Text=new JTextField();
    	gender_Text.setBounds(155,270,500,25);
    	gender_Text.setFont(mainMenuFont);
    	////////////////////////////////////////
    	
    	
    	DefaultTableModel model = new DefaultTableModel(); 
    	String[] columnNames = {"Subject","Degree"};
    	Object[] temp=null;
    	JTable subjectsTable = new JTable(model);
    	subjectsTable.setBounds(0, 0, 700, 300);
    	JButton saveSubButton= new JButton("Save");
    	saveSubButton.setBounds(250,330,70,30);
    	JButton closeSubButton= new JButton("Close");
    	closeSubButton.setBounds(340,330,70,30);
    	closeSubButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e){
  	    	  Admin.setSize(700, 250);
  	    	Admin.setLocationRelativeTo(null);
  	    	adminTab2.setVisible(false);
  	    	  chooseID.setEnabled(true);
  	  	    createUser.setEnabled(true);
	  	    deleteButton.setEnabled(true);
	  	    selectButton.setEnabled(true);
	  	    logOut.setEnabled(true);
	  	    subjectsButton.setEnabled(true);
	  	    imgButton.setEnabled(true);
  	      }});
    	saveSubButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e){
  	    	  Admin.setSize(700, 250);
  	    	Admin.setLocationRelativeTo(null);
  	    	  Subjects tmp = new Subjects();
  	    	  for (int i=0; i<model.getRowCount();i++) {
  	    		subjectsTable.editCellAt(i, 0);
  	    		subjectsTable.editCellAt(i, 1);
  	    		}
  	    	Object[][] data =  tmp.getTableData(subjectsTable);
  	    	System.out.println(data[0][0]);
  	    	tmp.saveArray(data);
  	    	adminTab2.setVisible(false);
  	    	chooseID.setEnabled(true);
  	  	    createUser.setEnabled(true);
	  	    deleteButton.setEnabled(true);
	  	    selectButton.setEnabled(true);
	  	    logOut.setEnabled(true);
	  	    subjectsButton.setEnabled(true);
	  	    imgButton.setEnabled(true);
  	      }});

    	////////////////////////////////////////

    	adminTab1.setBounds(0, 250,700, 400);
    	adminTab1.setBackground(Color.green);
    	adminTab1.setVisible(false);
    	adminTab2.setBounds(0, 250,700, 400);
    	adminTab2.setBackground(Color.green);
    	adminTab2.setVisible(false);
    	///////////////////////////////////////////////
    	logOut.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e){
  	    	  Home.frame.Login(true);
  	    	  Admin.setVisible(false);
    	     }});
    	selectButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e){
    	    	  try {
					Home.Student = new Students((int)(Administrator.listIDs()[chooseID.getSelectedIndex()]));
					Admin.setSize(700, 650);
					Admin.setLocationRelativeTo(null);
					adminTab1.setVisible(true);
	    	  	    chooseID.setEnabled(false);
	    	  	    createUser.setEnabled(false);
	    	  	    deleteButton.setEnabled(false);
	    	  	    selectButton.setEnabled(false);
	    	  	    logOut.setEnabled(false);
	    	  	    subjectsButton.setEnabled(false);
	    	  	    imgButton.setEnabled(false);
					studentName_Text.setText(Home.Student.studentName);
	    	  	    birth_Text.setText(Home.Student.birth);
	    	  	    address_Text.setText(Home.Student.address);
	    	  	    age_Text.setText(Home.Student.age);
	    	  	    year_Text.setText(Home.Student.year);
	    	  	    Class_Text.setText(Home.Student.Class);
	    	  	    phone_Text.setText(Home.Student.phone);
	    	  	    email_Text.setText(Home.Student.email);
	    	  	    gender_Text.setText(Home.Student.gender);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
    	     }});
    	deleteButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e){
    			try {
					Home.Student = new Students((int)(Administrator.listIDs()[chooseID.getSelectedIndex()]));
					User temp = new User((int)(Administrator.listIDs()[chooseID.getSelectedIndex()]));
					Home.Student.deleteStudent();
					temp.deleteUser();
					chooseID.removeItemAt(chooseID.getSelectedIndex());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
    			
    		}});
       	imgButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e){
    			try {
    				JFileChooser fc = new JFileChooser();
    				fc.setDialogTitle("Select Image File");
    				fc.setCurrentDirectory(new File(System.getProperty("user.home")));
    				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    				FileFilter filter = new FileNameExtensionFilter("png", "png");
    				fc.setFileFilter(filter);
    				fc.setMultiSelectionEnabled(false);
    				if(fc.showOpenDialog(fc)==1) throw new Exception();
    				File tempFile = new File(System.getProperty("user.dir"),"\\Students\\"+Administrator.listIDs()[chooseID.getSelectedIndex()]+".png");
    				if (tempFile.exists()) tempFile.delete();
    				Files.copy(fc.getSelectedFile().toPath(), new File(System.getProperty("user.dir"),"\\Students\\"+Administrator.listIDs()[chooseID.getSelectedIndex()]+".png").toPath());
				} catch (Exception e1) {
					
				}
    			
    		}});
    		createUser.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e){
    					try{
    						User temp = new User(Integer.valueOf(newUser.getText()));
    						if (temp.searchUserID()!=0) throw new Exception("User already exists.");
    						if (newPassword.getText().intern()=="") throw new Exception("There is no Password");
    						if (newUser.getText().intern()=="") throw new Exception("There is no UserName");
    						temp = new User(newUser.getText(),newPassword.getText());
    						temp.createNewUser();
    						FileWriter temp2=new FileWriter(new File(System.getProperty("user.dir"),"\\Students\\"+Integer.valueOf(newUser.getText())));
							String ls=System.lineSeparator();
    						temp2.write(ls+ls+ls+ls+ls+ls+ls+ls+ls+ls+ls+ls+ls);
    						temp2.close();
    						FileWriter temp3=new FileWriter(new File(System.getProperty("user.dir"),"\\Students\\"+Integer.valueOf(newUser.getText())+"_Subjects"));
    						temp3.write(ls+" "+" "+ls+" "+" "+ls+" "+" "+ls+" "+" "+ls+" "+" "+ls+" "+" "+ls+" "+" "+ls+" "+" "+ls+" "+" "+ls+" "+" "+ls+" "+" "+ls+" "+" "+ls+" "+" "+ls+" "+" "+ls+" "+" "+ls+" "+" "+ls+" "+" "+ls+" "+
    									" "+ls+" "+" "+ls+" "+" "+ls+" "+" "+ls+" "+" "+ls+" "+" "+ls+" "+" "+ls+" "+" "+ls);
    						temp3.close();
    		    	  	    studentName_Text.setText("");
    		    	  	    birth_Text.setText("");
    		    	  	    address_Text.setText("");
    		    	  	    age_Text.setText("");
    		    	  	    year_Text.setText("");
    		    	  	    Class_Text.setText("");
    		    	  	    phone_Text.setText("");
    		    	  	    email_Text.setText("");
    		    	  	   gender_Text.setText("");
    						Home.Student = new Students(Integer.valueOf(newUser.getText()));
							Home.Student.createNewStudent();
							Home.Student.saveToFile();
    						chooseID.addItem((Object) newUser.getText());
    						Admin.setSize(700, 650);
    						Admin.setLocationRelativeTo(null);
    						adminTab1.setVisible(true);
    		    	  	    chooseID.setEnabled(false);
    		    	  	    createUser.setEnabled(false);
    		    	  	    deleteButton.setEnabled(false);
    		    	  	    logOut.setEnabled(false);
    		    	  	    selectButton.setEnabled(false);
    		    	  	    subjectsButton.setEnabled(false);
    		    	  	    imgButton.setEnabled(false);
    					}catch(Exception e2) {
    						JOptionPane.showMessageDialog(null,e2.getMessage(),"Error",2);
    					}
    			}});
    			subjectsButton.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e){
        	    	  try {
    					Home.Student = new Students((int)(Administrator.listIDs()[chooseID.getSelectedIndex()]));
    			    	Subjects tempSubjects = new Subjects();
    			    	model.setDataVector(tempSubjects.getArray(),columnNames);
    					Admin.setSize(700, 650);
    					Admin.setLocationRelativeTo(null);
    					adminTab2.setVisible(true);
    	    	  	    chooseID.setEnabled(false);
    	    	  	    createUser.setEnabled(false);
    	    	  	    deleteButton.setEnabled(false);
    	    	  	    selectButton.setEnabled(false);
    	    	  	    subjectsButton.setEnabled(false);
    	    	  	    imgButton.setEnabled(false);
    					
    				} catch (IOException e1) {
    					e1.printStackTrace();
    				}
        	     }});
    	///////////////////////////////////////////////
    	Admin.add(adminTab1);
    	Admin.add(adminTab2);
    	Admin.add(chooseID);
       	Admin.add(selectButton);
       	Admin.add(deleteButton);
       	Admin.add(imgButton);
       	Admin.add(subjectsButton);
       	Admin.add(createUser);
       	Admin.add(newUser);
       	Admin.add(newPassword);
       	Admin.add(newPassword_Label);
       	Admin.add(newUser_Label);
       	Admin.add(logOut);
    	adminTab1.add(studentName);
    	adminTab1.add(birth);
    	adminTab1.add(address);
    	adminTab1.add(age);
    	adminTab1.add(year);
    	adminTab1.add(Class);
    	adminTab1.add(phone);
    	adminTab1.add(email);
    	adminTab1.add(gender);
    	adminTab1.add(studentName_Text);
    	adminTab1.add(birth_Text);
    	adminTab1.add(address_Text);
    	adminTab1.add(age_Text);
    	adminTab1.add(year_Text);
    	adminTab1.add(Class_Text);
    	adminTab1.add(phone_Text);
    	adminTab1.add(email_Text);
    	adminTab1.add(gender_Text);
    	adminTab2.add(subjectsTable);
    	adminTab2.add(saveSubButton);
    	adminTab2.add(closeSubButton);
    	//adminTab2.add(scrollPane);
    	//////////////////////////////////////
    	//Buttons in Tab 1
    	JButton saveButton= new JButton("Save");
    	saveButton.setBounds(250,330,70,30);
    	saveButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e){
    	  	    Home.Student.studentName=studentName_Text.getText();
    	  	    Home.Student.birth=birth_Text.getText();
    	  	    Home.Student.address=address_Text.getText();
    	  	    Home.Student.age=age_Text.getText();
    	  	    Home.Student.year=year_Text.getText();
    	  	    Home.Student.Class=Class_Text.getText();
    	  	    Home.Student.phone=phone_Text.getText();
    	  	    Home.Student.email=email_Text.getText();
    	  	    Home.Student.gender=gender_Text.getText();
    	  	    try {
					Home.Student.saveToFile();
					Admin.setSize(700, 250);
					Admin.setLocationRelativeTo(null);
					adminTab1.setVisible(false);
				} catch (IOException e1) {
					e1.printStackTrace();
			    	JOptionPane.showMessageDialog(null,"Access denied","Error",0);
				}
    	  	    chooseID.setEnabled(true);
    	  	    createUser.setEnabled(true);
    	  	    deleteButton.setEnabled(true);
    	  	    selectButton.setEnabled(true);
    	  	    logOut.setEnabled(true);
    	  	    subjectsButton.setEnabled(true);
    	  	    imgButton.setEnabled(true);
  	      }});
    	JButton closeButton= new JButton("Close");
    	closeButton.setBounds(340,330,70,30);
    	closeButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e){
  	    	  Admin.setSize(700, 250);
  	    	Admin.setLocationRelativeTo(null);
  	    	  adminTab1.setVisible(false);
  	    	  chooseID.setEnabled(true);
  	  	    createUser.setEnabled(true);
	  	    deleteButton.setEnabled(true);
	  	    selectButton.setEnabled(true);
	  	    logOut.setEnabled(true);
	  	    subjectsButton.setEnabled(true);
	  	    imgButton.setEnabled(true);
  	      }});
    	adminTab1.add(saveButton);
    	adminTab1.add(closeButton);
    	//////////////////////////////////////
    	adminTab1.setLayout(null);
    	adminTab2.setLayout(null);
    	Admin.setResizable(false);
    	Admin.setLayout(null);
    	
    	
    }
}