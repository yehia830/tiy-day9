package tiyinc.noobs;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Created by Yehia830 on 8/18/16.
 */
public class Day9Runner {
    public static void main(String[] args) {
        System.out.println("running");
        Day9Runner myRunner = new Day9Runner();
        myRunner.testWriteFIle();
        myRunner.testReadFile();
    }

    public void testWriteFIle() {
        System.out.println("testWriteFile");
        FileWriter testWriter = null;

        try {
            File testFile = new File("noobs.txt");
            testWriter = new FileWriter(testFile);
            testWriter.write("java rocks! harder!!!");

            testWriter.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (testWriter != null) {
                try {
                    testWriter.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }

        }


    }

    public void testReadFile() {
        try {
            File testFile = new File("src/tiyinc/noobs/Day9Runner.java");
            Scanner fileScanner = new Scanner(testFile);
            int numline = 0;
            while (fileScanner.hasNext()) {
                String currentLine = fileScanner.nextLine();
                numline++;
                System.out.println(currentLine);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}