package com.automation.testng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingDataFromTextFileUsingScanner {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new FileInputStream("src/test/resources/data/names.txt"));
        //to read single line in txt file
        //System.out.println(sc.nextLine());

        //to read entire txt file
        //by using sc.next at last we get null pointer execption because of no line in end of the file so
        /*
        String line = sc.next();
        while(line != null){
            System.out.println(line);
            line = sc.nextLine();
        }
        */

        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
    }
}
