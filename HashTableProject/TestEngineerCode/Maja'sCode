
public class TestHashTableP1 {
  /**
   * Tests that the HashTable.put() method is working correctly. Makes sure that when adding pairs,
   * the size updates correctly and the course was added properly.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testPut() {
    // Create a new empty hash table
    HashTableMap<String, Double> table = new HashTableMap<String, Double>();
    boolean test; // initiates boolean that will be used to identify whether tests are passed
    // adds one pair to the hash table
    table.put("ab", 0.00);
    // checks if size is correct after adding a pair
    if (table.size() != 1) {
      test = false;
      System.out.print("Size method does not return correct number when size is 1.");
    }
    // checks if the key was added correctly
    if (!table.containsKey("class1")) {
      test = false;
      System.out.print("First key was not properly added.");

    }
    // adds a pair with the same index as the previous to the table
    table.put("ba", 0.00);
    // checks that the HashTable.size() method returns the correct number/element was added
    // correctly
    if (table.size() != 2) {
      test = false;
      System.out.print("Size method does not return correct number when adding a value to an index"
          + "that already contains a value.");
    }
    /**
     * Tries to add an already existing value to table and ensures that the HashTable.put() method
     * returns false
     */
    if (table.put("ba", 0.00)) {
      test = false;
      System.out.println(
          "Put method does not return false when a repeat" + " key is attempted to be added.");
    }
    /**
     * checks that the HashTable.size() method returns the correct number after trying to add a
     * repeat key.
     */
    if (table.size() != 2) {
      test = false;
      System.out.print("Size method does not return correct number when adding a value to an index"
          + "that already contains a value.");
    }
    // Ensures that HashTable.put() method returns false and does not add a null key.
    if (table.put("null", 0.00)) {
      test = false;
      System.out.println(
          "Put method does not return false when a null" + " key is attempted to be added.");
    }
    return test;
  }

  /**
   * Tests that the HashTable.remove() method works correctly and updates the size
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemove() {
    // Create a new empty hash table
    HashTableMap<String, Double> table = new HashTableMap<String, Double>();
    boolean test; // initiates boolean that will be used to identify whether tests are passed
    // Adds 4 pairs to the table
    table.put("a", 1.00);
    table.put("b", 2.00);
    table.put("c", 3.00);
    table.put("d", 0.00);
    // checks that correct value is returned when a class is removed
    if (!table.remove("a").equals(1.00)) {
      test = false;
      System.out.println("Incorrect value was removed from the table");
    }
    // checks that the table's size updated correctly
    if (table.size() != 3) {
      test = false;
      System.out.print("Size method does not return correct number after a value was removed.");
    }
    // assures that the key is no longer in the table
    if (table.containsKey("a")) {
      test = false;
      System.out.print("The key was not removed properly.");
    }
    /**
     * checks that the HashTable.remove() method returns null when the key being sent to the method
     * does not exist
     */
    if (!table.remove("a").equals(null)) {
      test = false;
      System.out
          .print("HashTable.remove() method did not return null when trying to remove a key that "
              + "does not exist");
    }
    // assures that size did not change after trying to remove a key that doesn't exist
    if (table.size() != 3) {
      test = false;
      System.out.print("HashTable.size() method does not return correct number after trying to"
          + " remove a key that does not exist");
    }
    return test;
  }

  /**
   * Tests that the HashTable.clear() method works correctly and updates the size properly
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testClear() {
    // Create a new empty hash table
    HashTableMap<String, Double> table = new HashTableMap<String, Double>();
    boolean test; // initiates boolean that will be used to identify whether tests are passed
    // Adds 2 pairs to the table
    table.put("a", 1.00);
    table.put("b", 2.00);
    // clears the table
    table.clear();
    // checks that size is 0 after calling clear method
    if (table.size() != 0) {
      test = false;
      System.out.println("Size is not 0 after calling the HashTable.clear() method");
    }
    // Assures that all keys were correctly removed
    if (table.containsKey("a") || table.containsKey("b")) {
      test = false;
      System.out.println(
          "The keys were not successfully removed by calling the HashTable.clear()" + " method.");
    }
    return test;
  }

  /**
   * Tests that the HashTable.getClass() method works correctly
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetClass() {
    // Create a new empty hash table
    HashTableMap<String, Double> table = new HashTableMap<String, Double>();
    boolean test; // initiates boolean that will be used to identify whether tests are passed
    // Adds a pair to the table
    table.put("a", 1.00);
    Double val = table.getClass("a");
    // checks that the correct value was retrieved when calling HashTable.getClass().
    if (!val.equals(1.00)) {
      test = false;
      System.out.println("The wrong value was retrieved when calling HashTable.getClass()");
    }
    val = table.getClass("b");
    // checks that HashTable.getClass() returns null when passed a non-existing key
    if (!val.equals(null)) {
      test = false;
      System.out
          .println("HashTable.getClass() does not return null when passed a non-existing key");
    }
    val = table.getClass(null);
    if (!val.equals(null)) {
      test = false;
      System.out.println("HashTable.getClass() does not return null when passed a null value");
    }
    return test;
  }

  /**
   * Tests that the HashTable.updateClass() method works correctly
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testUpdateClass() {
    // Create a new empty hash table
    HashTableMap<String, Double> table = new HashTableMap<String, Double>();
    boolean test; // initiates boolean that will be used to identify whether tests are passed
    // Adds a pair to the table
    table.put("a", 1.00);
    // changes the name of key "a" to "b"
    table.UpdateClass("a", "b");
    // checks that the new name is now in the table
    if (!table.containsKey("b")) {
      test = false;
      System.out.println("The table does not contain a key with the updated name.");
    }
    // checks that the old name is no longer in the table
    if (!table.containsKey("a")) {
      test = false;
      System.out
          .println("The table still contains a key with the name that was supposed to be updated.");
    }
    // attempt to update the name of a key that does not exist
    table.UpdateClass("c", "d");
    // checks that no key name is changed when a value that doesn't exist is passed
    if (table.containsKey("d")) {
      test = false;
      System.out
          .println("The HashTable.updateClass() method added the new value name when the old value "
              + "did not exist in the table");
    }
    return test;
  }

  /**
   * Tests that the HashTable.containsKey() method works correctly
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testContainsKey() {
    // Create a new empty hash table
    HashTableMap<String, Double> table = new HashTableMap<String, Double>();
    boolean test; // initiates boolean that will be used to identify whether tests are passed
    // Adds 4 pairs to the table
    table.put("ab", 1.00);
    table.put("ba", 2.00);
    table.put("c", 3.00);
    table.put("d", 0.00);
    // checks that HashTable.containsKey() returns true when passed values that are in the table
    if (!table.ContainsKey("c") || !table.ContainsKey("d")) {
      test = false;
      System.out
          .println("HashTable.containsKey() method did not return true when passed values that"
              + " are in the table");
    }
    // checks that HashTable.containsKey() handles collisions properly
    if (!table.ContainsKey("ab") || !table.ContainsKey("ba")) {
      test = false;
      System.out.println("HashTable.containsKey() method doesn't handle collisions properly");
    }
    // checks that the HashTable.containsKey() method returns false when passed a string that isn't
    // in the table
    if (table.ContainsKey("ad")) {
      test = false;
      System.out.println("HashTable.containsKey() method returned true when passed a value that"
          + " is not in the table");
    }
    // checks that HashTable.containsKey() returns false when passed a null value
    if (table.ContainsKey(null)) {
      test = false;
      System.out.println("HashTable.containsKey() method returned true when passed a null value");
    }
    return test;
  }

  /**
   * Tests that the HashTable.size() method works correctly
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSize() {
    // Create a new empty hash table
    HashTableMap<String, Double> table = new HashTableMap<String, Double>();
    boolean test; // initiates boolean that will be used to identify whether tests are passed
    // Adds 4 pairs to the table including collisions
    table.put("ab", 1.00);
    table.put("ba", 2.00);
    table.put("c", 3.00);
    table.put("d", 0.00);
    if (table.size() != 4) {
      test = false;
      System.out.println("HashTable.size() did not return the correct number");
    }
  }

  public static void main(String[] args) {
    System.out.println(testSize());
    System.out.println(testContainsKey());
    System.out.println(testUpdateClass());
    System.out.println(testGetClass());
    System.out.println(testClear());
    System.out.println(testRemove());
    System.out.println(testPut());

  }

}
