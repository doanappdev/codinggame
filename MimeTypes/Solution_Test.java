import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution_Test {

    public static void main(String args[]) {
        String[] displayResult;
        String[] fileNames;
        Map<String, String> mimeMap = new HashMap<String, String>();
        boolean SHORT = false;

        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        in.nextLine();
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        in.nextLine();

        System.err.println("Debug: N = " + N);
        System.err.println("Debug: Q = " + Q);
        displayResult = new String[Q];      // size of arrray = Q
        fileNames = new String[Q];
        
        System.err.println("--------------- Create Mime Table ------------");
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            System.err.println("Debug: EXT = " + EXT);

            String MT = in.next(); // MIME type.
            System.err.println("Debug: MT = " + MT);
            mimeMap.put(EXT, MT);

            //if(MT.contains(EXT)) {
            //    System.err.println("Debug: "+ MT + " contains " + EXT);
            //}

            in.nextLine();
        }

        System.err.println("--------------- Split File Names ------------");
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            
            System.err.println("Debug: file name: " + FNAME);

            // get length of file name
            int strLength = FNAME.length();
            //System.err.println("Debug: length of FNAME " + FNAME.length());
            if(strLength <= 3) {
                // file only has one character
                SHORT = true;
            } else {
                SHORT = false;
            }

            if(!SHORT) {
                //System.err.println("Debug: FNAME.length()-3 = " + (FNAME.length()-4));
                //System.err.println("Debug: character =  " + FNAME.charAt(FNAME.length()-4));
                if(FNAME.contains(".")) {
                    int dotIndex = FNAME.lastIndexOf(".");
                    int dotPos0 = FNAME.length()-6;     // e.g file text.xhtml
                    int dotPos1 = FNAME.length()-5;     // e.g file text.html
                    int dotPos2 = FNAME.length()-4;     // e.g file text.png
                    int dotPos3 = FNAME.length()-3;     // e.g file text.ra
                    String subString = "n/a";
                    if(dotIndex == dotPos0) {
                        subString = FNAME.substring(FNAME.length()-6, FNAME.length());
                        System.err.println("Debug: subString = " + subString);
                    } else if(dotIndex == dotPos1) {
                        subString = FNAME.substring(FNAME.length()-4, FNAME.length());
                        System.err.println("Debug: subString = " + subString);
                        //fileNames[i] = subString;
                    } else if(dotIndex == dotPos2) {
                        subString = FNAME.substring(FNAME.length()-3, FNAME.length());
                        System.err.println("Debug: subString = " + subString);
                    } else if(dotIndex == dotPos3) {
                        subString = FNAME.substring(FNAME.length()-2, FNAME.length());
                        System.err.println("Debug: subString = " + subString);
                    }
                    System.err.println("Debug: add " + subString + " to array");
                    fileNames[i] = subString;
                } else {
                    fileNames[i] = "n/a";
                }
            } else {
                fileNames[i] = "n/a";
            }
        }

        System.err.println("--------------- Check if file names extension ------------");
        // testing
        for(int i = 0; i < fileNames.length; i++) {
            String s = fileNames[i];

            if(mimeMap.containsKey(s.toUpperCase())) {
                System.err.println("Debug: " + s + " matches " + mimeMap.get(s.toUpperCase()));
                displayResult[i] = mimeMap.get(s.toUpperCase());  // get value that matches key = s
            } else if(mimeMap.containsKey(s.toLowerCase())) {
                System.err.println("Debug: " + s + " matches " + mimeMap.get(s.toLowerCase()));
                displayResult[i] = mimeMap.get(s.toLowerCase());  // get value that matches key = s
            } else {
                System.err.println("Debug: " + s + " does not match " + mimeMap.get(s));
                displayResult[i] = "UNKNOWN";
            }

            /*
            if(mimeMap.containsKey(s.toUpperCase()) || 
               mimeMap.containsKey(s.toLowerCase())) {
                System.err.println("Debug: " + s + " matches " + mimeMap.get(s));
                displayResult[i] = mimeMap.get(s);  // get value that matches key = s
            } else {
                System.err.println("Debug: " + s + " does not match " + mimeMap.get(s));
                displayResult[i] = "UNKNOWN";
            }
            */
        } 
        



        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        for(int j = 0; j < displayResult.length; j++) {
            System.err.println("Debug: result[" + j + "] = " + displayResult[j]);
            System.out.println(displayResult[j]);
        }
        
        //System.out.println("UNKNOWN"); // For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.
    }
}