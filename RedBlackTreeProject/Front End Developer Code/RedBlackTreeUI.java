// --== CS400 File Header Information ==--
// Name: Kabiltan Kalaichelvan
// Email: kalaichelvan@wisc.edu
// Team: MB
// Role: Front End Developer
// TA: Harit Vishwakarma
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>


import java.util.Scanner;

/**
 * This class creates a User 
 * Interface for the RedBlackTree Class
 * 
 * @author Kabiltan Kalaichelvan
 */
public class RedBlackTreeUI {

  private static RedBlackTree<Integer> songDataBase = new RedBlackTree<Integer>(); // Creating the Song Database
  
  /**
   * This method creates a user
   * interface in the console where 
   * the user can enter in the listed commands
   * in order to modify and display elements 
   * in the Song Database. 
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    listCommands();
    String songName;
    int songRanking;
    System.out.println("Welcome to the Song Database. Please enter in a command below:");
    while(!scanner.hasNext("quit")) { //Continue running until the user enters the command quit
      String userInput = scanner.next();
      if(userInput.equals("createSong")){ // Add a song and respective ranking to the database
        System.out.println("Please enter a song name and ranking");
        songName = scanner.next();
        while (!scanner.hasNextInt()) {
          songName = songName + " " + scanner.next();
        }
        songRanking = scanner.nextInt();      // Split song name and rank to check for any exceptions with rank
        createSong(songName, songRanking);
      }
      else if(userInput.equals("containsSong")) { // Check if a song with a user input ranking exists in the database
        System.out.println("Please enter the rank of a song and be notified if a song of that rank is in the Song Database");
        songRanking = scanner.nextInt();
        containsSong(songRanking);
      }
      else if(userInput.equals("getSong")) { // Get a song based on the user input ranking if it exists in the database
        System.out.println("Please enter in the rank of a song to retrieve it from the Song Database");
        songRanking = scanner.nextInt();
        getSong(songRanking);
      }
      else if(userInput.equals("commands")) { // List all user commands in console
        listCommands();      
      }
      else if(userInput.equals("clear")) {
        songDataBase.clearTree(); 
        System.out.println("All songs and their rankings have been cleared from the Song Database");
      }
      else {
        System.out.println("Sorry this command has not been added yet");
        scanner.nextLine();
      }
    }
    System.out.println("Thank you for using the Song Database.");
    scanner.close();
  }
  
  /**
   * Given a song and respective rank, 
   * this method will insert the song 
   * rank pair into the Song Database
   * 
   * @param rank The rank that will inserted into
   * the database (rank must be >0)
   * @param song The song that will be inserted
   * into the database
   */
  private static void createSong(String song, int rank) {
    if(rank <= 0) { // Check for an invalid ranking (rank <= 0) 
      System.out.println("The rank entered was invalid. Please try again later"); 
      return;
    }
    songDataBase.insert(rank, song); // Add the song and ranking to the Song Database
    System.out.println("Song was successfully added to the Song Database");
  }
  
  /**
   * Given a rank, this method will print out
   * a statement notifying the user if there is song
   * that corresponds to rank.
   * 
   * @param rank The rank that will be searched for
   * within the Song Database
   */
  private static void containsSong(Integer rank) { 
    if(songDataBase.containsKey(songDataBase.root, rank)) { // Check if the user input rank is contained in the Song Database
      System.out.println("A song associated with this rank is contained within the Song Database");
    }
    else {
      System.out.println("A song associated with this rank is not contained within the Song Database");
    }
  }
  
  /**
   * Given a rank, this method will print out
   * the song that corresponds with that rank. If
   * the song corresponding to the input rank is not
   * within the database, the method will print an
   * error message in the console
   * 
   * @param rank The rank that will be searched for
   * within the Song Database
   */ 
  private static void getSong(Integer rank) {
    if(songDataBase.containsKey(songDataBase.root, rank)) { // Check if the user input rank is contained in the Song Database
      System.out.println(songDataBase.get(songDataBase.root, rank));
    }
    else {
      System.out.println("A song associated with this rank is not contained within the Song Database");
    }
  }
  
  /**
   *This method lists out all the 
   *commands a user can execute 
   *in the console
   */
  public static void listCommands() {
    System.out.println("Commands:");
    System.out.println("createSong - Enter a song name and it's Billboard Ranking to be stored within the database");
    System.out.println("getSong    - Enter a song name and receive it's Billboard ranking stored within the database");
    System.out.println("containsSong  - Enter a song name be notified if it is within the database");
    System.out.println("commands - Displays the list of commands");
    System.out.println("clear - Clear all the songs in the database");
    System.out.println("quit - Quit");
    System.out.println();
}

}
