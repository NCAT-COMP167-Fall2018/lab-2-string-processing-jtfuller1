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
            while(scanner.hasNextLine()){
                String[] line = scanner.nextLine().split(",");
                if(validateRecord(line))
                    records.add(formatEntry(line));
            }
        }catch(FileNotFoundException exception){
            System.err.println("The file \"" + fileName + "\" was not found!");
        } 
    }
    
    private static boolean validateRecord(String[] line){
        String firstName = line[0].trim();
        String lastName = line[1].trim();
        String gender = line[2].trim();
        String age = line[3].trim();
        String phoneNumber = line[4].trim();
        String email = line[5].trim();
        
        if(validateName(firstName) &&
           validateName(lastName) &&
           validateGender(gender) &&
           validateAge(age) &&
           validatePhoneNumber(phoneNumber) &&
           validateEmail(email)
                )
            return true;
        return false;
    }
    
    private static boolean validateEmail(String email){
        boolean output = (email.matches("([A-z]+\\d*)+@[A-z]+\\.com") || email.matches("([A-z]+\\d*)+@[A-z]+\\.net"));
        if(!output){
            System.err.println("The email " + email + " was not valid!");
        }
        return output;
    }
    
    private static boolean validatePhoneNumber(String phoneNumber){
        boolean output = phoneNumber.matches("\\(\\d{3}\\)\\d{3}-\\d{4}");
        if(!output)
            System.err.println("The phoneNumber " + phoneNumber + " was not valid!");
        return output; 
    }
    
    private static boolean validateAge(String age){
        try{
            int ageNum = Integer.parseInt(age);
            boolean output = (0 < ageNum && ageNum <= 130);
            if(!output)
                System.err.println("The age " + age + " did not fall within the valid age range!");
            return output;
        }catch(NumberFormatException exception){
            System.err.println("The age " + age + " was not valid!");
            return false;
        }
    }
    
    private static boolean validateName(String name){
        if(!name.matches("(.*\\d+.*)") && !name.matches("(.*\\W+.*)") )
            return true;
        System.err.println("The name " + name + " was not valid.");
        return false;
    }
    
    private static boolean validateGender(String gender){
        if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))
            return true;
        System.err.println("The gender " + gender + " was not valid.");
        return false;
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
