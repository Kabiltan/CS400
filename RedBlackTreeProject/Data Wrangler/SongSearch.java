// --== CS400 File Header Information ==--
// Name: Cameron Legrand
// Email: clegrand2@wisc.edu
// Team: MB
// Role: Data Wrangler
// TA: Harit Vishwakarma
// Lecturer: Gary Dahl
// Notes to Grader: None

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class gets the data from a .csv file and inserts it into our red black tree
 * 
 * @author Cameron Legrand
 *
 */
public class SongSearch extends RedBlackTree<String> {

  private File songData; // the csv data file of songs gathered from
                         // https://www.billboard.com/charts/hot-100 in the form of
                         // SONG_NAME,SONG_RANK
  private Scanner scan; // the scanner that reads the csv file
  private static RedBlackTree<String> tree; // the tree to insert the data into


  /**
   * Initializes the file of data and the tree
   */
  public SongSearch() {
    songData = new File("data.csv");
    tree = new RedBlackTree<String>();
  }

  /**
   * scans the data file and retrieves the data to put into the red black tree
   */
  public void getData() {
    try {
      scan = new Scanner(songData);
    } catch (FileNotFoundException e) {
      System.out.println("This file containing data was not found.");
    } catch (NullPointerException e) {
      System.out.println("This file is null/empty.");
    }
    while (scan.hasNext()) {
      String[] songVal = scan.nextLine().split(",");
      tree.insert(Integer.valueOf(songVal[0]), songVal[1]);
    }
    scan.close();
  }

  /**
   * inputs the data and checks to see if the red black tree properties are maintained in a series
   * of tests
   * 
   * @param args - input arguments, if any
   */
  public static void main(String[] args) {
    SongSearch testTree = new SongSearch();
    testTree.getData();
    System.out.println(testTree.get(tree.root, 2));
    System.out.println(tree.size());
    try {
      tree.insert(2 ,"Dynamite");
    } catch (IllegalArgumentException e) {
      System.out.println("Expected error caught");
    }
    try {
      tree.get(tree.root, 41);
    } catch (NoSuchElementException e1) {
      System.out.println("Expected error caught");
    }
    tree.clearTree();
    System.out.println(tree.size());
    tree.insert(2 ,"Dynamite");
    System.out.println(tree.size());
  }
}

