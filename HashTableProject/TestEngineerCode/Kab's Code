// --== CS400 File Header Information ==--
// Name: Kabiltan Kalaichelvan
// Email: kalaichelvan@wisc.edu
// Team: MB
// TA: Harit Vishwakarma
// Lecturer: Gary Dahl
// Notes to Grader: 

import java.util.NoSuchElementException;

/**
 * TestHashTable.java is an application designed
 * to test the functionality of various methods 
 * implemented in HashTableMap.java
 * 
 * 
 * 
 * @author Kabiltan Kalaichelvan
 */
public class TestHashTableGPA {

  /**
   * This test method checks the 
   * functionality of the put() 
   * and size() methods implemented
   * in HashTableMap.java
   * 
   * @return True if the size() and put()
   * methods work as expected and false otherwise
   */
  public static boolean testAddCourseToDatabaseMethod() { 
    boolean passed = true;
    
    // Create a test Hash Table
    CourseGpaSearch testMap = new CourseGpaSearch();
   
 
    
    //Test 1 - Put one element into the Hash Table - 1 total element
    testMap.put("CS252", "3.0");
    if(testMap.size() != 1) {
      passed = false;
      System.out.println("testMap is not returning a size of 36 when 36 element is in the Hash Table");
    }
    
    //Test 2 - Put another element into the Hash Table - 2 total elements
    testMap.put("CS354", "3.0");
    if(testMap.size() != 2) {
      passed = false;
      System.out.println("testMap is not returning a size of 2 when 2 elements are in the Hash Table");
    }
    
    //Test 3 - Put another element into the Hash Table with the same index to test collisions- 3 total elements
    testMap.put("CS522", "3.1");
    if(testMap.size() != 3) {
      passed = false;
      System.out.println("testMap is not returning a size of 3 when 3 elements are in the Hash Table");
    }
    
    //Test 4 - Put another element into the Hash Table with the same index to test collisions with 3 elements - 4 total elements
    testMap.put("CS225", "4.0");
    if(testMap.size() != 4) {
      passed = false;
      System.out.println("testMap is not returning a size of 4 when 4 elements are in the Hash Table");
    }
    
    // Test 5 - Check that the put() method returns false for a null key input
    if(testMap.containsKey(null)) {
      passed = false;
      System.out.print("testMap's put() method is not returning false for a null key input");
    }
    
    // Test 6 - Check that the put() method returns false for a duplicate key
    testMap.put("CS252", "3.0");
    if(testMap.size() != 4) {
      passed = false;
      System.out.print("testMap's put() method is adding duplicate elements");
    }
    
    return passed;
  }
  
  /**
   * This test method checks the 
   * functionality of the remove()
   * method implemented in HashTableMap.java
   * 
   * 
   * @return True if the remove() method works as 
   * expected and false otherwise.
   */
  public static boolean testRemoveCourseFromDatabaseMethod() {
    boolean passed = true;
    
    // Create a test Hash Table
    CourseGpaSearch testMap = new CourseGpaSearch();
    
    // Add three elements to the Hash Table
    testMap.put("CS252", "3.5");
    testMap.put("CS354", "2.9");
    testMap.put("CS600", "2.5");
    
    // Test 1 - Remove one element from the Hash Table and check key of removed element - 2 total elements
    String removedElement = testMap.remove("CS252");
    if(testMap.size() != 2) {
      passed = false;
      System.out.println("testMap is not returning a size of 2 when 2 elements are in the Hash Table");
    }
    else if(!removedElement.equals("3.5")) {
      passed = false;
      System.out.println("testMap is not removing the correct Key-Value pair");
    }
    
    // Add a random element and an element of duplicate index to element already in testMap
    testMap.put("CS522", "3.1");
    testMap.put("MATH234", "3.0");

    // Test 2 - Remove the second element at an index to check for correct removal of collisions
    String removedElement2 = testMap.remove("CS522");
    if(testMap.size() != 3) {
      passed = false;
      System.out.println("testMap is not returning a size of 3 when 3 elements are in the Hash Table");
    }
    else if(!removedElement2.equals("3.1")) {
      passed = false;
      System.out.println("testMap is not removing the correct Key-Value pair - Test 2");
    }
       
    // Add an element of duplicate index to element already in testMap - 3 total collisions
    testMap.put("CS522", "1.5");
    testMap.put("CS255", "2.1");
    testMap.put("ECON101", "1.7");
    
    // Test 3 - Remove the third element at an index to check for correct removal of collisions
    String removedElement3 = testMap.remove("CS255");
    if(testMap.size() != 5) {
      passed = false;
      System.out.println("testMap is not returning a size of 4 when 4 elements are in the Hash Table");
    }
    else if(!removedElement3.equals("2.1")) {
      passed = false;
      System.out.println("testMap is not removing the correct Key-Value pair - Test 2");
    }
    
    // Test 4 - Check that the remove() method returns null for an element that does not exist in the Hash Table
    if(testMap.remove("MATH222") != null) {
      passed = false;
      System.out.print("testMap's remove() method is not returning null for an element that does not exist in the Hash Table");
    }
    
    // Test 5 - Check that the remove() method returns null for a null key input
    if(testMap.remove(null) != null) {
      passed = false;
      System.out.print("testMap's remove() method is not returning null for a null key input");
    }
    
    // Test 6 - Check that the remove() method returns null for a blank key input
    if(testMap.remove("") != null) {
      passed = false;
      System.out.print("testMap's remove() method is not returning null for a blank key input");
    }
    
    return passed;
  }
  
  /**
   * This test method checks the 
   * functionality of the containsKey()
   * method in HashTableMap.java
   * 
   * 
   * @return True if the containsKey()
   * method works as expected and false otherwise
   */
  public static boolean testContainsCourseInDatabaseMethod() {
    boolean passed = true;
    
    // Create a test Hash Table
    CourseGpaSearch testMap = new CourseGpaSearch();
    
    // Add three elements to the Hash Table
    testMap.put("CS252", "3.5");
    testMap.put("CS354", "2.9");
    testMap.put("CS600", "2.5");
    
    // Test 1 - Check if the ContainsKey method correctly identifies the three elements in the Hash Table
    if(!testMap.containsKey("CS252")  || !testMap.containsKey("CS354") || !testMap.containsKey("CS600")) {
      passed = false;
      System.out.print("testMap's containsKey() method is not correctly identifying the three elements in the Hash table");
    }
    else if(testMap.size() != 3) {
      passed = false;
      System.out.println("testMap's containsKey() method changes the size of the Hash Table when it should not");
    }
    
    // Add two elements with the same index with another element already in the Hash Table to check collisions
    testMap.put("CS522", "3.0");
    testMap.put("CS225", "3.2");
    
    // Test 2 - Check if the ContainsKey method handles multiple collisions correctly
    if(!testMap.containsKey("CS225")  || !testMap.containsKey("CS522")) {
      passed = false;
      System.out.print("testMap's containsKey() method is not correctly handling collisoins");
    }
    else if(testMap.size() != 5) {
      passed = false;
      System.out.println("testMap's containsKey() method changes the size of the Hash Table when it should not");
    }
    
    // Test 3 - Check that the containsKey() method returns false for an element that does not exist in the Hash Table
    if(testMap.containsKey("CS201")) {
      passed = false;
      System.out.print("testMap's containsKey() method is finding an element that does not exist in the Hash Table");
    }
    
    // Test 4 - Check that the containsKey() method returns false for a null key input
    if(testMap.containsKey(null)) {
      passed = false;
      System.out.print("testMap's containsKey() method is not returning false for a null key input");
    }
    
    return passed;
  }
  
  /**
   * This test method checks the 
   * functionality of the 
   * clear() method implemented
   * in HashTableMap.java
   * 
   * 
   * @return True if the clear() method
   * works as expected and false otherwise
   */
  public static boolean testClearDatabaseMethod() {
    boolean passed = true;
    
    // Create a test Hash Table
    CourseGpaSearch testMap = new CourseGpaSearch();
    
    // Add four elements to the Hash Table
    testMap.put("CS252", "3.5");
    testMap.put("CS354", "2.9");
    testMap.put("CS600", "2.5");
    testMap.put("MATH234", "2.1");
 
    // Clear testMap
    testMap.clear();
    
    // Test 1 - Test the size of testMap to make sure it is 0
    if(testMap.size() != 0) {
      passed = false;
      System.out.println("testMap's clear() method is not returning an empty Hash Map");
    }
    
    // Test 2 - Test to ensure the cleared testMap does not contain any elements    
    if(testMap.containsKey("CS252") || testMap.containsKey("CS354") || testMap.containsKey("CS600") || testMap.containsKey("MATH234")) {
      passed = false;
      System.out.print("testMap's clear() method results in a Hash table with remaning elements");
    }
    
    return passed;    
  }
  
  /**
   * This test method checks the 
   * functionality of the get()
   * method implemented in HashTableMap.java
   * 
   * 
   * @return True if the get()
   * method works as expected and false otherwise
   */
  public static boolean testGetCourseFromDatabaseMethod() {
    boolean passed = true;
    
    // Create a test Hash Table
    CourseGpaSearch testMap = new CourseGpaSearch();
    
    // Add three elements to the Hash Table
    testMap.put("CS252", "3.5");
    testMap.put("CS354", "2.9");
    testMap.put("CS600", "2.5");
    
    // Test 1 - Check that the get() method returns the correct value of the input key argument 
    if(!testMap.get("CS252").equals("3.5")) {
      passed = false;
      System.out.println("testMaps's get() method is not returning the correct value");
    }
    
    // Add an element with collision to another element already in the Hash table
    testMap.put("CS522", "3.1");
    
    // Test 2 - Check that the get() method returns the correct value of the input key argument when there is collision
    if(!testMap.get("CS522").equals("3.1")) {
      passed = false;
      System.out.println("testMaps's get() method is not returning the correct value for collison of two elements");
    }
       
    // Add an element with collision to another element already in the Hash table - collision of 3 elements
    testMap.put("CS225", "4.0");
    
    // Test 3 - Check that the get() method returns the correct value of the input key argument when there is three collisions
    if(!testMap.get("CS225").equals("4.0")) {
      passed = false;
      System.out.println("testMaps's get() method is not returning the correct value for collison of three elements");
    }
    
    // Test 4 - Check that the get() method throws an exception for an element that does not exist in the Hash Table
    try {
      testMap.get("CS201");
      passed = false;
      System.out.println("testMap's get() method did not throw the correct excepetion for a non existen element");
    }
    catch(NoSuchElementException e) {
      // get() method works correctly. Continue on with the rest of the test method 
    }
    
    // Test 5 - Check that the get() method returns null for a null key input
    try {
      testMap.get(null);
      passed = false;
      System.out.println("testMap's get() method did not throw the correct excepetion for a null key");
    }
    catch(NoSuchElementException e) {
      // get() method works correctly. Continue on with the rest of the test method 
    }
    
    return passed;   
  }
  
  /**
   * This test method checks the 
   * functionality of the resize()
   * method implemented in HashTableMap.java
   * 
   * 
   * @return True if the resize()
   * works as expected and false otherwise
   */
  public static boolean testSizeMethod() {
    boolean passed = true;
    
    // Create a test Hash Table with a capacity of 4
    // Create a test Hash Table
    CourseGpaSearch testMap = new CourseGpaSearch();
    

    
    // Add four elements to the Hash Table - Hash Table should automatically resize when 4th element is added
    testMap.put("CS252", "3.5");
    testMap.put("CS354", "2.9");
    testMap.put("CS600", "2.5");
    testMap.put("MATH234", "2.5");
    
    // Test 1 - Make sure resizing occurred correctly when fifth element is added to the Hash Table 
    testMap.put("CS522", "1.5");
    if(testMap.size() != 5) {
      passed = false;
      System.out.println("testMap is not returning a size of 5 when 5 elements are in the Hash Table");
    }
    
    return passed;
  }
  
  /**
   * This test method runs
   * all the tests defined above.
   * The results of each test are
   * printed to the console.
   *
   */
  public static void main(String[] args) {
    System.out.println("testAddCourseToDatabaseMethod(): " + testAddCourseToDatabaseMethod());
    System.out.println("testRemoveCourseFromDatabaseMethod(): " + testRemoveCourseFromDatabaseMethod());
    System.out.println("testContainsCourseInDatabaseMethod(): " + testContainsCourseInDatabaseMethod());
    System.out.println("testClearDatabaseMethod(): " + testClearDatabaseMethod());
    System.out.println("testGetCourseFromDatabaseMethod(): " + testGetCourseFromDatabaseMethod());
    System.out.println("testSizeMethod(): " + testSizeMethod());
  }
}
