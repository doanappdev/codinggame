import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        // allocate space for array with 8 elements
        int[] mhArray = new int[8];
        int maxHeight = 0;
        int mPos = 0;

        // game loop
        while (true) {
            int SX = in.nextInt();
            int SY = in.nextInt();
            for (int i = 0; i < 8; i++) {
                int MH = in.nextInt(); // represents the height of one mountain, from 9 to 0. Mountain heights are provided from left to right.
                
                System.err.println("Debug: MH = " + MH);
                // add each mountain height to the array
                mhArray[i] = MH;
                
            }
            
            // find the highest mountain
            maxHeight = mhArray[0];
            for(int i = 1; i < 8; i++) {
                if(mhArray[i] > maxHeight) {
                    maxHeight = mhArray[i];
                    mPos = i;
                    System.err.println("Debug: maxHeight = " + maxHeight);
                    System.err.println("Debug: mPos =" + mPos);
                }
            }
            
            // fire when ship position above highest mountain
            if(SX == mPos) {
                System.out.println("FIRE");
            } else {
                System.out.println("HOLD");
            }
            

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            //System.out.println("HOLD"); // either:  FIRE (ship is firing its phase cannons) or HOLD (ship is not firing).
        }
    }
}