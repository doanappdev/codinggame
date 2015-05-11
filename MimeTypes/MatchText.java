/*
 * MatchText can be used to compare the values from two text files.
 * For the MimeTypes problem input size is 10000. To quickly check
 * your results with the expected output use this class.
 *
 * Redirecting and Piping
 * redirecting from a file to standard input:
 * e.g. java Test2 < data.t
 * 
 * redirecting standard output to a file:
 * e.g. java Test1 > data.txt 
 *
 * piping the output of one program to the input of another
 * e.g. java Test1 | tee java Test2
 *
 */

import java.util.*;
import java.io.*;
import java.math.*;

public class MatchText {
	static private Scanner in1, in2;
	static String file1 = "correctResult5.txt";	// change file name as required
	static String file2 = "output5a.txt";		// change file name as required
	
	public static void main(String[] args) {
		LinkedList<String> listData1 = new LinkedList<>();
		LinkedList<String> listData2 = new LinkedList<>();

		openTextFile();

		System.out.println("Read data from file 1");
		listData1 = readData(in1);
		System.out.println("Read data from file 2");
		listData2 = readData(in2);

		checkDataMatch(listData1, listData2);
		
	}

	public static void openTextFile() {
		// enable user to open file
		try {
			in1 = new Scanner(new File(file1));
			in2 = new Scanner(new File(file2));
		} catch(FileNotFoundException ex) {
			System.err.println("Error opening file" + ex);
			System.exit(1);
		}
	}

	public static LinkedList<String> readData(Scanner in) {
		LinkedList list = new LinkedList<String>();
		// read records from files
		try {
			while(in.hasNext()) {
				//System.out.println("Debug: " + in.next());
				list.add(in.next());
			}
		} catch(NoSuchElementException elementException ) {
        	System.err.println( "File improperly formed." );
         	in.close();
         	System.exit( 1 );
      	} catch ( IllegalStateException stateException ){
         	System.err.println( "Error reading from file." );
         	System.exit( 1 );
      	} // end catch

		return list;
	}

	public static void checkDataMatch(
		LinkedList<String> l1, LinkedList<String> l2) {
		for(int i = 0; i < l1.size(); i++) {
			if(l1.get(i).equals(l2.get(i))) {
				//System.out.println(i + ": " + l1.get(i) + " == " + l2.get(i));
			} else {
				System.out.println(i + ": " + l1.get(i) + " != " + l2.get(i));
			}
		}

	}
}
