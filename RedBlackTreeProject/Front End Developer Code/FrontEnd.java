// --== CS400 File Header Information ==--
// Name: Maja Velichkovich
// Email: mvelichkovic@wisc.edu
// Team: MB
// Role: Front End Developer
// TA: Harit Vishwakarma
// Lecturer: Florian
// Notes to Grader: <optional extra notes>


import java.util.Scanner;

/**
 * This class displays and controls commands for the user to interact with
 * 
 * @author Maja Velichkovich
 */
public class FrontEnd {

  private static RedBlackTree<Integer> songDatabase = new RedBlackTree<Integer>();

  /**
   * Prints a list of commands and calls methods that correspond to each command the user calls
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    listCommands();
    String songName;
    int songRanking;
    System.out.println("Enter a command:");
    while (!scanner.hasNext("quit")) {
      String userInput = scanner.next();
      if (userInput.equals("createSong")) {
        System.out.println("Enter song name and ranking.");
        songName = scanner.next();
        while (!scanner.hasNextInt()) {
          songName = songName + " " + scanner.next();
        }
        songRanking = scanner.nextInt();
        createSong(songName, songRanking);
      } else if (userInput.equals("getSong")) {
        System.out.println("Enter a song ranking.");
        songRanking = scanner.nextInt();
        getSong(songRanking);
      } else if (userInput.equals("containsSong")) {
        System.out.println("Enter a song ranking.");
        songRanking = scanner.nextInt();
        containsSong(songRanking);
      } else if (userInput.equals("clear")) {
        songDatabase.clearTree();
        System.out.println("The database has been cleared.");
      } else if (userInput.equals("commands")) {
        listCommands();
      } else if (userInput.equals("getSize")) {
        System.out.println(songDatabase.size());
      } else {
        System.out.println("Invalid command, please try again.");
        scanner.nextLine();
      }
    }
    System.out.println("Closing database, thank you.");
    scanner.close();
  }

  /**
   * Inserts a song with a corresponding ranking into the songDatabase
   * 
   * @param rank The ranking of a song
   * @param song The name of a song
   */
  private static void createSong(String song, int rank) {
    if (rank <= 0) {
      System.out.println("The rank entered was invalid. Please try again");
      return;
    }
    try {
      songDatabase.insert(rank, song);
    } catch (IllegalArgumentException e) {
      System.out.println("Error, a song with that ranking already exists in the database.");
      return;
    }
    System.out.println("Added song:" + song + " with ranking of: " + rank);
  }

  /**
   * Prints a message informing the user whether or not there is a song with the given ranking
   * within the database
   * 
   * @param rank The ranking of a song
   */
  private static void containsSong(Integer rank) {
    if (songDatabase.containsKey(songDatabase.root, rank)) {
      System.out.println("The database does contain a song with this ranking");
    } else {
      System.out.println("The database does not contain a song with this ranking");
    }
  }

  /**
   * Prints out the song at the ranking passed to the method is there is a song in the database with
   * the corresponding rank
   * 
   * @param rank The ranking of a song
   */
  private static void getSong(Integer rank) {
    if (songDatabase.containsKey(songDatabase.root, rank)) {
      String songName = songDatabase.get(songDatabase.root, rank);
      System.out.println("The song " + songName + " is currently ranked at " + rank);
    } else {
      System.out.println("There is no song with that ranking in the database");
    }
  }

  /**
   * Displays the command options and their usage
   */
  public static void listCommands() {
    System.out.println("Commands:");
    System.out.println(
        "createSong - Enter a song name and it's ranking on the Billboard Charts to be stored within the database.");
    System.out.println("getSong    - Enter a song name and recieve it's current ranking.");
    System.out
        .println("containsSong  - Enter a song name to see if it is stored within the database.");
    System.out
        .println("getSize - Recieve the amount of songs currently stored within the database");
    System.out.println("commands - Display the list of commands");
    System.out.println("clear - Clear all  songs in the database");
    System.out.println("quit - Quit");
    System.out.println();
  }

}
