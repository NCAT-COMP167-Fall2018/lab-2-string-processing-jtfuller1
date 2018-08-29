/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg2.string.parsing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jtfuller1
 */
public class Lab2StringParsing {

    private static ArrayList<String> records = new ArrayList(); 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fileName = args[0];
        readFile(fileName);
        printRecords();
    }
    
    private static void readFile(String fileName){
       try(Scanner scanner = new Scanner(new File(fileName))){
            //int lineNumber = 1;
            while(scanner.hasNextLine()){
                String[] line = scanner.nextLine().split(",");
                records.add(formatEntry(line));
                //lineNumber++;
            }
        }catch(FileNotFoundException exception){
            System.err.println("The file \"" + fileName + "\" was not found!");
        } 
    }
    
    private static String formatEntry(String[] line){
        
        String firstName = line[0].trim();
        String lastName = line[1].trim();
        String gender = line[2].trim();
        String age = line[3].trim();
        String phoneNumber = line[4].trim();
        String email = line[5].trim();
        
        
        
         
        return String.format("%-11s%-12s%-8s%-4s%-15s%-20s", firstName, lastName, gender, age, phoneNumber, email);
    }
    
    private static void printRecords(){
        for(String entry : records)
            System.out.println(entry);
    }
    
}
