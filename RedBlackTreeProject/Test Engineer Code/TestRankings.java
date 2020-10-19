// --== CS400 File Header Information ==--
// Name: Stephen Zhao
// Email: szhao239@wisc.edu
// Team: MB
// TA: Harit Vishwakarma
// Lecturer: Florian Heimerl
// Notes to Grader: None

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * This class acts as a test suite to ensure various implemented operations of our song billboard
 * ranking function as intended.
 * 
 * @author Stephen Zhao
 *
 */
public class TestRankings {

  private RedBlackTree<Integer> ranking = null; // the song ranking list

  /**
   * Creates an instance of a billboard ranking used to test different operations.
   */
  @BeforeEach
  public void createInstance() {
    ranking = new RedBlackTree<>();
  }

  /**
   * Test adding various songs into the billboards ranking and ensure after each insert, the song is
   * added to the correct location, allowing for an optimized search. Although our list will always
   * contain consecutive numbers starting at 1 to some number n, this test case is used to represent
   * a potential small input sequence for the list.
   */
  @Test
  public void testCreateSong() {
    // Adding songs in a consecutive ordering. A restructure is needed for optimization
    ranking.insert(2, "Mood");
    ranking.insert(3, "Lemonade");
    ranking.insert(4, "Wonder");
    assertEquals(ranking.toString(), "[Lemonade 3, Mood 2, Wonder 4]");
    ranking.clearTree();

    // Adding songs but no restructure is needed
    ranking.insert(2, "Mood");
    ranking.insert(1, "Your Man");
    ranking.insert(3, "Lemonade");
    ranking.insert(4, "Wonder");
    assertEquals(ranking.toString(), "[Mood 2, Your Man 1, Lemonade 3, Wonder 4]");
    ranking.clearTree();

    // Adding a long sequence of songs. Ensure the structure is optimized for searching for a
    // ranking
    ranking.insert(14, "Wishing Well");
    ranking.insert(7, "POPSTAR");
    ranking.insert(20, "Summer Girl");
    ranking.insert(11, "Wonder");
    ranking.insert(1, "First Time");
    ranking.insert(18, "All I want");
    ranking.insert(23, "The Spins");
    ranking.insert(25, "Weekend");
    ranking.insert(26, "Blinding Lights");
    ranking.insert(24, "Knock Knock");
    assertEquals(ranking.toString(),
        "[Summer Girl 20, Wishing Well 14, Weekend 25, POPSTAR 7, All I want 18, The Spins 23, Blinding Lights 26, First Time 1, Wonder 11, Knock Knock 24]");
  }

  /**
   * Test to make sure the get method returns the correct song for a searched ranking.
   */
  @Test
  public void testGetSong() {
    ranking.insert(5, "Mood");
    ranking.insert(1, "Lemonade");
    assertEquals(ranking.get(ranking.root, 1), "Lemonade");
    ranking.insert(4, "Wonder");
    ranking.insert(2, "ROCKSTAR");
    ranking.insert(3, "WAP");
    assertEquals(ranking.get(ranking.root, 5), "Mood");
  }

  /**
   * Test the contains method before inserting, after inserting, and after clearing the song ranking
   * list.
   */
  @Test
  public void testContainsSong() {
    // testing contains on an empty true
    assertEquals(ranking.containsKey(ranking.root, 1), false);

    // testing after inserting songs
    ranking.insert(23, "The Spins");
    ranking.insert(15, "Knock Knock");
    assertEquals(ranking.containsKey(ranking.root, 23), true);
    assertEquals(ranking.containsKey(ranking.root, 15), true);
    
    // testing after clearing all songs
    ranking.clearTree();
    assertEquals(ranking.containsKey(ranking.root, 23), false);
    assertEquals(ranking.containsKey(ranking.root, 15), false);
  }

  /**
   * Tests to make sure the size is correct after adding and clearing the list.
   */
  @Test
  public void testSize() {
    // Ensure size is 0 when the list is empty
    assertEquals(ranking.size(), 0);

    // Tests the size after adding 5 songs.
    ranking.insert(5, "Mood");
    ranking.insert(1, "Lemonade");
    ranking.insert(4, "Wonder");
    ranking.insert(2, "ROCKSTAR");
    ranking.insert(3, "WAP");
    assertEquals(ranking.size(), 5);
    
    // Tests the size after clearing the list
    ranking.clearTree();
    assertEquals(ranking.size(), 0);
  }

  /**
   * Clears the ranking of the list. Makes sure there are no more songs stored with in the ranking
   * chart.
   */
  @Test
  public void testClearSongs() {
    // Testing on an empty list
    ranking.clearTree();
    assertEquals(ranking.size(), 0);

    // Testing after adding various songs
    ranking.insert(5, "Mood");
    ranking.insert(1, "Lemonade");
    ranking.insert(4, "Wonder");
    ranking.insert(2, "ROCKSTAR");
    ranking.insert(3, "WAP");
    ranking.clearTree();
    assertEquals(ranking.size(), 0);
    assertEquals(ranking.containsKey(ranking.root, 1), false);
    assertEquals(ranking.containsKey(ranking.root, 5), false);
  }
}
