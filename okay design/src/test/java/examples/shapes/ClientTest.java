package examples.shapes;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void constructorTest() throws ShapeException {
        String line = "circle,1,2,1";
        Scanner scnr = new Scanner(line);
        Client myClient = new Client(scnr);
        assertEquals(myClient,myClient);

    }

}