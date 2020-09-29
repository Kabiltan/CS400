import java.util.Scanner;

// --== CS400 File Header Information ==--
// Name: Aaron Stephenson
// Email: astephenson2@ewisc.edu
// Team: MB
// TA: Harit Vishwakarma
// Lecturer: Florian Heimerlr
// Notes to Grader: <optional extra notes>

public class FrontEndInterface {
	private static HashTableMap hashTable = new HashTableMap();

	/**
	 * prints all possible commands that the user can input into the application
	 */
	public static void printCommands() {
		System.out.println("Commands are as follows: ");
		System.out.println("createClass: creates a class based off the name and the average GPA you enter for it ");
		System.out.println("updateGPA: updates a class's GPA that is alreadty stored in the interface");
		System.out.println("getClassGPA: returns a class's GPA based off the class name you enter");
		System.out.println("Type commands whenever to display the list of commands again");
		System.out.println("Type quit to quit the application");
	}

	/**
	 * creates a class that the user inputs and stores it within the HashTableMap
	 * 
	 * @param className - the name of the class the user entered
	 * @param classGPA  - the GPA that correlates with the class
	 */
	public static void createClass(String className, Double classGPA) {
		if (hashTable.containsKey(className)) {
			System.out.println(
					"The class you're trying to add already exists within the database, try using getGPA or updateGPA instead:");
			return;
		}

		if (classGPA > 4.0 || classGPA < 0.0) {
			System.out.println("The GPA you entered is outside of the range. Enter a GPA between 0.0 and 4.0:");
			return;
		}

		hashTable.put(className, classGPA);
		System.out.println("Added " + className + " with a GPA of " + classGPA);
	}

	/**
	 * gets the class GPA that the user is looking for according to the input class
	 * name
	 * 
	 * @param className
	 */
	public static void getClassGPA(String className) {
		if (!hashTable.containsKey(className)) {
			System.out.println(
					"There is not class within the database that has that name. Try using createClass instead:");
			return;
		}

		System.out.println("The average GPA for " + className + " is " + hashTable.get(className));
	}

	/**
	 * updates a class's GPA that is already stored within the database
	 * 
	 * @param className
	 * @param classGPA
	 */
	public static void updateClass(String className, Double classGPA) {
		if (!hashTable.containsKey(className)) {
			System.out.println(
					"There is not class within the database that has that name. Try using createClass instead:");
			return;
		}

		if (classGPA > 4.0 || classGPA < 0.0) {
			System.out.println("The GPA you entered is outside of the range. Enter a GPA between 0.0 and 4.0:");
			return;
		}

		hashTable.remove(className);
		hashTable.put(className, classGPA);

		System.out.println("Updated " + className + "'s average GPA to " + classGPA);
	}

	/**
	 * the main diver for the application that takes in the user's commands
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Double classGPA;
		String className;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the class GPA application!");
		System.out.println("Enter a command: ");
		printCommands();

		while (!scanner.hasNext("quit")) {
			String userInput = scanner.next();
			if (userInput.equals("createClass")) {
				System.out.println("Enter the course you want to add and the GPA that correlates with it:");
				className = scanner.next();
				classGPA = scanner.nextDouble();
				createClass(className, classGPA);

			} else if (userInput.equals("updateClass")) {
				System.out.println("Enter course name and GPA that you want to update:");
				className = scanner.next();
				classGPA = scanner.nextDouble();
				updateClass(className, classGPA);

			} else if (userInput.equals("getClassGPA")) {
				System.out.println("Enter course name that you're looking for:");
				className = scanner.next();
				getClassGPA(className);

			} else if (userInput.equals("commands")) {
				printCommands();

			} else {
				System.out.println("Invalid command, enter one from the list:");
			}
		}
		System.out.println("Thank you for using the database.");
		scanner.close();

	}

}
