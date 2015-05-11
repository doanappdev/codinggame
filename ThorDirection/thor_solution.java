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
        int LX = in.nextInt(); // the X position of the light of power
        int LY = in.nextInt(); // the Y position of the light of power
        int TX = in.nextInt(); // Thor's starting X position
        int TY = in.nextInt(); // Thor's starting Y position
        
        String moveDirection = null;

        // game loop
        while (true) {
            int E = in.nextInt(); // The level of Thor's remaining energy, representing the number of moves he can still make.
            System.err.println("Debug: remaining energy = " + E);
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            
            // if TX == LX position is on the same line direction of move can
            // be moved in straight line
            // if TX < or > LX position is not on same line direction of move can
            // 
            
            // check if thor position is on the same line as light 
            if(TX != LX && TY != LY) {
                // thor position not on same line as light,
                // move in diagonal direction
                if(LX > TX && LY > TY) {
                    // move thor direction SE
                    TX++;
                    TY++;
                    moveDirection = "SE";
                }
                
                if(LX < TX && LY < TY) {
                    // move thor direction NW
                    TX--;
                    TY--;
                    moveDirection = "NW";
                }
                
                if(LX > TX && LY < TX) {
                    TX++;
                    TY--;
                    moveDirection = "NE";
                }
                
                if(LX < TX && LY > TY) {
                    TX--;
                    TY++;
                    moveDirection = "SW";
                }
                
            } else {
                // move thor towards light in straight line
                if(TX < LX) { 
                
                TX++;
                moveDirection = "E";
                } 
            
                if(TX > LX) {
                    TX--;
                    moveDirection = "W";
                }
                
                if(TY < LY) {
                    TY++;
                    moveDirection = "S";
                } 
                
                if(TY > LY) {
                    TY--;
                    moveDirection = "N";
                }
                
            }
            
            System.out.println(moveDirection); // A single line providing the move to be made: N NE E SE S SW W or NW
        }
    }
}