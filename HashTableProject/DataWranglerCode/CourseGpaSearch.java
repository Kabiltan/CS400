// --== CS400 File Header Information ==--
// Name: Stephen Zhao
// Email: szhao239@wisc.edu
// Team: MB
// Role: Data Wrangler
// TA: Harit Vishwakarma
// Lecturer: Florian Heimerl
// Notes to Grader: None

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class acts a driver application to run the functions of our implemented hash table based on
 * the needs of the user.
 * 
 * @author Stephen Zhao
 *
 */
public class CourseGpaSearch extends HashTableMap<String, String> {

  private Scanner reader; // an instance of a Scanner object to read in the data from a file
  private File classData; // A file containing the data manually received from madgrades.com
                          // following a csv format of class_name,gpa_value

  /**
   * Initializes the hash table and the file of data.
   */
  public CourseGpaSearch() {
    classData = new File("data.txt");
  }

  /**
   * Retrieves the data from the file, "classData", and fills the data into the table.
   */
  public void getData() {
    try {
      reader = new Scanner(classData);
    } catch (FileNotFoundException e) {
      System.out.println("The file contianing the data was not found.");
    } catch (NullPointerException e) {
      System.out.println("The file was null.");
    }
    String[] data; // splitting the data into an array of size two. The first element represents the
                   // class name (the key) and the second element represents the class's average GPA
                   // (the value)
    while (reader.hasNext()) {
      data = reader.nextLine().split(",");
      this.put(data[0], data[1]);
    }
    if (reader != null) {
      reader.close();
    }
  }

  /**
   * Initializes the hash table and automatically inputs the data into the table.
   * 
   * @param args - input arguments, if any
   */
  public static void main(String[] args) {
    CourseGpaSearch table = new CourseGpaSearch(); // the hash table of some UW courses and their
                                                   // average GPAs
    table.getData();

    // a couple of quick tests to verify the data was added
    System.out.println(table.size());
    System.out.println(table.get("CS 400"));
    System.out.println(table.put("CS 400", "3.8"));
    System.out.println(table.get("CS 400"));
    System.out.println(table.containsKey("ENGL 140"));
    table.remove("ENGL 140");
    try {
      System.out.println(table.get("ENGL 140"));
    } catch (NoSuchElementException e) {
      System.out.println("Expected error caught.");
    }
  }
}
