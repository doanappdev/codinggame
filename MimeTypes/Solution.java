import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) throws Exception {
        String[] displayResult;
        String[] fileNames;
        Map<String, String> mimeMap = new HashMap<String, String>();
        boolean SHORT = false;

        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        in.nextLine();
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        in.nextLine();

        displayResult = new String[Q];      // size of arrray = Q
        fileNames = new String[Q];
        
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            mimeMap.put(EXT, MT);
            in.nextLine();
        }

        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            // get length of file name
            int strLength = FNAME.length();
            if(strLength < 3) {
                SHORT = true;
            } else {
                SHORT = false;
            }

            if(!SHORT) {
                //System.err.println("Debug: FNAME.length()-3 = " + (FNAME.length()-4));
                //System.err.println("Debug: character =  " + FNAME.charAt(FNAME.length()-4));
                if(FNAME.contains(".")) {
                    int dotIndex = FNAME.lastIndexOf(".");
                    int dotPos0 = FNAME.length()-6;
                    int dotPos1 = FNAME.length()-5;
                    int dotPos2 = FNAME.length()-4;
                    int dotPos3 = FNAME.length()-3;
                    String subString = "n/a";
                    if(dotIndex == dotPos0) {
                        subString = FNAME.substring(FNAME.length()-5, FNAME.length());
                        //System.err.println("Debug: subString = " + subString);
                    } else if(dotIndex == dotPos1) {
                        subString = FNAME.substring(FNAME.length()-4, FNAME.length());
                        //System.err.println("Debug: subString = " + subString);
                        //fileNames[i] = subString;
                    } else if(dotIndex == dotPos2) {
                        subString = FNAME.substring(FNAME.length()-3, FNAME.length());
                        //System.err.println("Debug: subString = " + subString);
                    } else if(dotIndex == dotPos3) {
                        subString = FNAME.substring(FNAME.length()-2, FNAME.length());
                        //System.err.println("Debug: subString = " + subString);
                    }
                    //System.err.println("Debug: add " + subString + " to array");
                    fileNames[i] = subString;
                } else {
                    fileNames[i] = "n/a";
                }
            } else {
                fileNames[i] = "n/a";
            }
        }

       
        // testing
        for(int i = 0; i < fileNames.length; i++) {
            String s = fileNames[i];

            if(mimeMap.containsKey(s.toUpperCase())) {
                displayResult[i] = mimeMap.get(s.toUpperCase());  // get value that matches key = s
            } else if(mimeMap.containsKey(s.toLowerCase())) {
                displayResult[i] = mimeMap.get(s.toLowerCase());  // get value that matches key = s
            } else {
                displayResult[i] = "UNKNOWN";
            }

        } 
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        for(int j = 0; j < displayResult.length; j++) {
           
            System.out.println(displayResult[j]);
        }
        
        //System.out.println("UNKNOWN"); // For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.
    }
}