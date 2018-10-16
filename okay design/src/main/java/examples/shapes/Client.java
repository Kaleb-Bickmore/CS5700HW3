package examples.shapes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Driver Class, simulates a client reading in a script file and using the shapes/composite shape.
 */
public class Client {
    /**
     *
     * @param args list of arguments put into our main class
     */
    public static void main(String[] args) {
        File script = new File("C:\\Users\\Kaleb\\Documents\\ObjectODesign\\CS5700HW3\\CS5700HW3\\script.txt");

        try (Scanner scnr = new Scanner(script)) {

            while (scnr.hasNextLine()) {
                String line = scnr.nextLine();
                String[] parsedLine = line.split(",");

                System.out.println(parsedLine[0]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}