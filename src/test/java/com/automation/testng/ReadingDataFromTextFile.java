package com.automation.testng;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadingDataFromTextFile {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("src/test/resources/data/names.txt");
        BufferedReader bf = new BufferedReader(fr);
        //reads first line in txt file
        //System.out.println(bf.readLine());
        //System.out.println(bf.readLine());
        //System.out.println(bf.readLine());

        //to print full txt file
        String line = bf.readLine();
        while(line !=null){
            System.out.println(line);
            line = bf.readLine();
        }
    }
}
