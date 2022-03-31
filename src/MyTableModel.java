import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.table.AbstractTableModel;

class MyTableModel extends AbstractTableModel  {
        private String[] columnNames = {"Subject","Degree"};
        Subjects temp = new Subjects();
         //Files.readAllLines(Paths.get(System.getProperty("user.dir"),"Users.txt")).toArray();
       private Object[][] data = temp.getArray();
//    	   {
//    {"Kathy", new Integer(5)},
//	    {"John", new Integer(3)},
//	    {"Sue", new Integer(2)},
//	    {"Jane", new Integer(20)},
//	    {"Joe", new Integer(10)}
//        };


        public int getColumnCount() { return columnNames.length; }
        
        public int getRowCount() { return data.length; }

        public String getColumnName(int col) { return columnNames[col]; }

        public Object getValueAt(int row, int col) { return data[row][col]; }

        public Class getColumnClass(int c) { return getValueAt(0, c).getClass(); }

        public boolean isCellEditable(int row, int col) {return true; }

    }
