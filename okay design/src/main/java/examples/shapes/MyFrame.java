package examples.shapes;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MyFrame extends JFrame {
    /**
     * @param args list of arguments put into our main class
     */
    public static void main(String[] args) throws ShapeException, IOException {
        new MyFrame();

    }
    public MyFrame() throws ShapeException, IOException {
        this.setSize(1000,1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Shape drawings");
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        final JPanel drawingPanel  = new JPanel();
        contentPane.add(drawingPanel,  BorderLayout.CENTER);
        this.add(contentPane);
        this.setVisible(true);
        Graphics G = drawingPanel.getGraphics();
        File script = new File("C:\\Users\\Kaleb\\Documents\\ObjectODesign\\CS5700HW3\\CS5700HW3\\script.txt");
        Scanner scnr = new Scanner(script);
        Client fileReader = new Client(scnr);
        fileReader.draw(G);
        File outPutScript = new File("C:\\Users\\Kaleb\\Documents\\ObjectODesign\\CS5700HW3\\CS5700HW3\\scriptOutput.txt");
        fileReader.saveAll(outPutScript);
    }
}




