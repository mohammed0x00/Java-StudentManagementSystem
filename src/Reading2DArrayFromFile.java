import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Reading2DArrayFromFile {
   public static void m(String args[]) throws Exception {
      Scanner sc = new Scanner(new BufferedReader(new FileReader(new File(System.getProperty("user.dir"),"Users.txt"))));
      int rows = 2;
      int columns = 2;
      int [][] myArray = new int[rows][columns];
      while(sc.hasNextLine()) {
         for (int i=0; i<myArray.length; i++) {
            String[] line = sc.nextLine().trim().split(" ");
            for (int j=0; j<line.length; j++) {
               myArray[i][j] = Integer.parseInt(line[j]);
            }
         }
      }
      System.out.println(Arrays.deepToString(myArray));
   }
}