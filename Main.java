/**
 * Written by Durim Miziraj
 * 2023-04-01
 * 
 * This is an excercise that was done at LTU.
 * 
 * The values are all in binary, this is to make it as efficient as I know how.
 */

import static java.lang.System.out;
import java.util.Scanner;
import java.util.Random;

/**
 * The class takes an input from a user via the 'Scanner' class and generates random numbers ranging from 1 to 6.
 * It outputs the number of generations, each generated number and the amount of each number that was generated.
 */
public class Main {

    private final static char POINT_MARKER = 0b00100011; // 0b00100011 = '#'
    private final static byte MIN_VAL    = 0b00000001;
    private final static byte MAX_VAL    = 0b00000110;
    private final static byte IS_ONE     = 0b00000001;
    private final static byte IS_TWO     = 0b00000010;
    private final static byte IS_THREE   = 0b00000011;
    private final static byte IS_FOUR    = 0b00000100;
    private final static byte IS_FIVE    = 0b00000101;
    private final static byte IS_SIX     = 0b00000110;
 
    private static long numberOfThrows;
    private static StringBuilder numberOfOnes   = new StringBuilder();
    private static StringBuilder numberOfTwos   = new StringBuilder();
    private static StringBuilder numberOfThrees = new StringBuilder();
    private static StringBuilder numberOfFours  = new StringBuilder();
    private static StringBuilder numberOfFives  = new StringBuilder();
    private static StringBuilder numberOfSixes  = new StringBuilder();
    private static StringBuilder outputBuilder  = new StringBuilder("\n");

    private static int result = 0b00000000;
    


    // Declare a private, static object of type 'Scanner' and name it 'in'. 
    private static Scanner in = new Scanner(System.in);

    // Declare a private, static object of type 'Random' and name it 'dice'. 
    private static Random dice = new Random();
    
    public static void main(String[] args) {
        
        // Output a message to the user, prompting him/her for an amount of dice throws that he/she wishes to make.
        out.print("Number of throws: ");

        // Take that number and set it to the variable 'numberOfThrows'
        numberOfThrows = in.nextLong();

        // Closing the scanner, as it is not needed anymore.
        in.close();

        // For the amount in 'numberOfThrows', set a hash sign the variable that corresponds to the random number generated by 'dice'.
        for (long i = 0b00000000; i < numberOfThrows; i++) { 
            
            result = dice.nextInt(MAX_VAL) + MIN_VAL;

            switch (result) {
                case IS_ONE -> numberOfOnes.append(POINT_MARKER);
                case IS_TWO -> numberOfTwos.append(POINT_MARKER);
                case IS_THREE -> numberOfThrees.append(POINT_MARKER);
                case IS_FOUR -> numberOfFours.append(POINT_MARKER);
                case IS_FIVE -> numberOfFives.append(POINT_MARKER);
                case IS_SIX -> numberOfSixes.append(POINT_MARKER);
                default -> {}
            }

            // At the end of each loop, output the value of the 'dice'.
            outputBuilder.append(result + " ");
        }

        // Format a string with the output template and all the variables holding pointmarkers and set it to the variable 'finalOutput'.
        outputBuilder.append("\n");
        outputBuilder.append("1: ").append(numberOfOnes).append("\n");
        outputBuilder.append("2: ").append(numberOfTwos).append("\n");
        outputBuilder.append("3: ").append(numberOfThrees).append("\n");
        outputBuilder.append("4: ").append(numberOfFours).append("\n");
        outputBuilder.append("5: ").append(numberOfFives).append("\n");
        outputBuilder.append("6: ").append(numberOfSixes).append("\n");

        // Print the 'finalOutput'.
        out.println(outputBuilder.toString());

        // Exit the program.
        System.exit(0);
    }
}