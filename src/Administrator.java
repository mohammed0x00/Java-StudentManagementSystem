import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public abstract  class Administrator {
public static Object[] listIDs() {
	File temp = new File(System.getProperty("user.dir"),"\\Students\\");
	String[] tempArray = temp.list();
	ArrayList<Integer> list=new ArrayList<Integer>();
	for (String i : tempArray) {
		try {
		list.add(Integer.valueOf(i));
		}catch(Exception e) {}
	}
	Object[] tempIntArray =list.toArray();
	return tempIntArray;
}
}
