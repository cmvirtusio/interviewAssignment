package interviewAssignment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class fileReader {
	//file to read from, first argument;
	//file to write to, second argument;
	public static void main(String args[]) {
		SortedSet<String> set = new TreeSet<>();
		if(args.length != 2) {
			System.out.println("Requires 2 Arguments, file to read from and file to write to");
			System.exit(0);
		}
		//Read from file
		try {
			
			File file = new File(args[0]);
			Scanner sc = new Scanner(file);
			//Iterate through each line of the file.
			while(sc.hasNextLine()) {
				//Sanitize line
				String strLine = sc.nextLine().toString().replaceAll("[^\\w\\s]","").toLowerCase();
				//add eachword in strLine to SortedSet;
				set.addAll(Arrays.asList(strLine.split(" ")));
			}
			sc.close();
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		
		//Write to file
		try {
			PrintWriter writer = new PrintWriter(args[1], "UTF-8");
			for(String i : set) {
				writer.println(i);
			}
			writer.close();
		} catch (Exception  ex) {
			System.out.println(ex.getMessage());
		}
	}

}
