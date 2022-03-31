import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Subjects {
	public Object[][] getArray() {
	      Scanner sc = null;
	      int rows = 0;
		try {
			sc = new Scanner(new BufferedReader(new FileReader(new File(System.getProperty("user.dir"),"\\Students\\"+Home.Student.studentID+"_Subjects"))));
			BufferedReader reader = new BufferedReader(new FileReader(new File(System.getProperty("user.dir"),"\\Students\\"+Home.Student.studentID+"_Subjects")));
				rows = 0;
		      while (reader.readLine() != null) rows++;
		      reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      int columns = 2;
	      Object [][] myArray = new Object[rows][columns];
	      while(sc.hasNextLine()) {
	         for (int i=0; i<myArray.length; i++) {
	            String[] line = sc.nextLine().trim().split(" ");
	            for (int j=0; j<line.length; j++) {
	               myArray[i][j] = (line[j]);
	            }
	         }
	      }
		return myArray;
		
	}
	public void saveArray(Object[][] array) {
		try {
			FileWriter tempFile = new FileWriter(new File(System.getProperty("user.dir"),"\\Students\\"+Home.Student.studentID+"_Subjects"));
			for (int i=0 ; i<array.length;i++) {
				tempFile.write(array[i][0]+" "+array[i][1]+System.lineSeparator());
			}
			tempFile.close();
		} catch (IOException e) {}
	}
	public Object[][] getTableData (JTable table) {
	    DefaultTableModel dtm = (DefaultTableModel) table.getModel();
	    int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
	    Object[][] tableData = new Object[nRow][nCol];
	    for (int i = 0 ; i < nRow ; i++)
	        for (int j = 0 ; j < nCol ; j++)
	            tableData[i][j] = dtm.getValueAt(i,j);
	    return tableData;
	}
	
}
