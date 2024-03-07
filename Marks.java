/*
* This program generates student's marks
*
* @author  Cristiano Sellitto
* @version 1.0
* @since   2024-03-06
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
* This is the program.
*/
final class Marks {
    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException;
    * if this is ever called
    *
    * @throws IllegalStateException if this is ever called
    *
    */
    private Marks() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        // Character variables
        final String comma = ",";
        final String lineBreak = "\n";

        // Add first row
        String array = "Name,";
        final int maxAssignments = 5;
        for (int counter = 1; counter < maxAssignments; counter++) {
            array = array + ("Assignment" + counter) + comma;
        }
        array = array + lineBreak;

        // Normal Distribution numbers
        final Random random = new Random();
        // Generate marks
        final int totalMarks = 24;
        final int mean = 75;
        final int deviation = 10;
        final int maxLines = 3;
        int sum = 0;
        int listCount = 0;
        int totalNumbers = 0;
        int studentCount = 1;
        for (int counter = 0; counter < totalMarks; counter++) {
            final int mark = (int) Math.floor(
                            random.nextGaussian() * deviation + mean
            );
            sum = sum + mark;
            if (listCount == 0) {
                array = array + ("Student" + studentCount) + comma;
                studentCount++;
            }
            array = array + mark + comma;
            if (listCount == maxLines) {
                array = array + lineBreak;
                listCount = 0;
            } else {
                listCount++;
            }
            totalNumbers = counter;
        }

        // Create file
        try {
            final String fileName = "NormalNumbers.csv";
            final File textFile = new File(fileName);
            final FileWriter writeTextFile = new FileWriter(fileName);

            textFile.createNewFile();
            writeTextFile.write(array);
            writeTextFile.close();
        } catch (IOException nfe) {
            System.out.print("Failed to write to file.");
        }

        // Print results
        System.out.println("\nMark Average: "
                        + sum / totalNumbers + lineBreak
        );
        System.out.println(array);

        // Show the program as done
        System.out.println("\nDone.");
    }
}
