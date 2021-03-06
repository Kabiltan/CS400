// --== CS400 File Header Information ==--
// Name: Nathaniel Tate
// Email: ntate@wisc.edu
// Team: MB
// Role: Front End Developer
// TA: Harit
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.*;

public class courseGPAUI {
    private static HashTableMap<String, Double> hashTable = new HashTableMap<>();

    public static void main(String[] args) {
        String className;
        Double classGPA;
        Scanner scanner = new Scanner(System.in);
        listCommands();
        System.out.println("Enter a command:");
        while (!scanner.hasNext("quit")) {  //Continue running until the user enters the command quit
            String userInput = scanner.next();
            if (userInput.equals("createClass")) {   //User entered the createClass command
                System.out.println("Enter course name and course GPA");
                className = scanner.next();
                classGPA = scanner.nextDouble();
                createClass(className, classGPA);
            } else if (userInput.equals("updateClass")) {    //User entered the updateClass command
                System.out.println("Enter course name and course GPA:");
                className = scanner.next();
                classGPA = scanner.nextDouble();
                updateClass(className, classGPA);
            } else if (userInput.equals("getClassGPA")) {    //User entered the getClassGPA command
                System.out.println("Enter course name:");
                className = scanner.next();
                getClassGPA(className);
            } else if (userInput.equals("commands")) {   //User entered the commands command
                listCommands();
            } else {    //User entered an invalid command
                System.out.println("Invalid command, please try again");
            }
        }
        System.out.println("Closing database, thank you.");
        scanner.close();
    }
    
    public static void createClass(String className, Double classGPA) {
        if (hashTable.containsKey(className)) {     //Inform the user if the className passed already exists within the database
            System.out.println("Error: The class name that was entered already exists within the database if you are looking" 
            + "to update the GPA associated to it use the updateClass command");
            return;
        }
        if (classGPA > 4.0 || classGPA < 0.0) {     //Inform the user that the GPA that they passed is out of bounds
            System.out.println("Error: The GPA entered is outside of possible range of GPAs at UW-Madison");
            return;
        }
        hashTable.put(className, classGPA);
        System.out.println("Added " + className + " with an average GPA of " + classGPA);
    }
    public static void updateClass(String className, Double classGPA) {
        if (!hashTable.containsKey(className)) {    //Inform the user that there is no class within the database that has that name
            System.out.println("Error: There is not class within the database that has that name, please check your spelling" 
            + "or use the command createClass instead");
            return;
        }
        if (classGPA > 4.0 || classGPA < 0.0) {     //Inform the user that the GPA that they passed is out of bounds
            System.out.println("Error: The GPA entered is outside of possible range of GPAs at UW-Madison");
            return;
        }
        hashTable.remove(className);
        hashTable.put(className, classGPA);
        System.out.println("Updated " + className + "'s average GPA to " + classGPA);
    }
    public static void getClassGPA(String className) {
        if (!hashTable.containsKey(className)) {   //Inform the user that there is no class within the database that has that name 
            System.out.println("Error: There is not class within the database that has that name, please check your spelling" 
            + "or use the command createClass instead");
            return;
        }
        System.out.println("The average GPA for " + className + " is " + hashTable.get(className));
    }

    public static void listCommands() {
        System.out.println("Commands:");
        System.out.println("createClass - Enter a course name and it's average GPA to be stored within the database");
        System.out.println("updateClass - Enter a course name and update it's average GPA that is stored within the database");
        System.out.println("getClassGPA - Enter a course name and receive it's average GPA that is stored within the database");
        System.out.println("commands - Displays the list of commands");
        System.out.println("quit - Quit");
    }
}
