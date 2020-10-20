
// --== CS400 File Header Information ==--
// Name: Cody Knepprath
// Email: cknepprath@ewisc.edu
// Team: MB
// Role: Testing Engineer
// TA: Harit Vishwakarma
// Lecturer: Gary Dahl
// Notes to Grader: N/A
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * A Junit Test Suite class that tests the implementation of a red black tree
 * used to hold info about songs
 * 
 * @author codyknepprath
 *
 */
class RedBlackTreeProjectTest {

	/**
	 * tests the method createKey - fails if outcome doesn't match expected outcome
	 */
	@Test
	public void testCreateKey() {
		RedBlackTree<Integer> testTree = new RedBlackTree<Integer>();
		testTree.insert(1, "testsong");
		if (testTree.containsKey(testTree.root, 1)) {
			return;
		} else {
			fail("containsKey returned false when the key was in the tree");
		}
	}

	/**
	 * tests the method getSong - fails if outcome doesn't match expected outcome
	 */
	@Test
	public void testGetSong() {
		RedBlackTree<Integer> testTree = new RedBlackTree<Integer>();
		testTree.insert(1, "bestSong");
		testTree.insert(15, "okaySong");
		testTree.insert(90, "badSong");
		String rankingString = testTree.get(testTree.root, 15);
		if (rankingString == "okaySong") {
			return;
		} else {
			fail("getSong did not return the correct ranking");
		}

	}

	/**
	 * tests the method size - fails if outcome doesn't match expected outcome
	 */
	@Test
	public void testSize() {
		RedBlackTree<Integer> testTree = new RedBlackTree<Integer>();
		testTree.insert(15, "okaySong");
		testTree.insert(1, "bestSong");
		testTree.insert(90, "badSong");
		if (testTree.size() == 3) {
			testTree.clearTree();
			if (testTree.size() == 0) {
				testTree.insert(7, "Mistletoe");
				if (testTree.size() == 1) {
					return;
				}
			}
		}
		fail("size did not update as expected");
	}

	/**
	 * checks to make sure the songs are in the right order - fails if outcome
	 * doesn't match expected outcome
	 */
	@Test
	public void testDisplayAllSongs() {
		RedBlackTree<Integer> testTree = new RedBlackTree<Integer>();
		testTree.insert(15, "okaySong");
		testTree.insert(1, "bestSong");
		testTree.insert(90, "badSong");
		testTree.insert(60, "monsterMash");
		String displayOrder = testTree.toString();
		String expectedOrder = "[15, 1, 90, 60]";
		System.out.println(displayOrder);
		if (displayOrder.contentEquals(expectedOrder)) {
			return;
		} else {
			fail("songs did not display as expedcted");
		}

	}

	/**
	 * tests the method clear - fails if outcome doesn't match expected outcome
	 */
	@Test
	public void testClearSongs() {
		RedBlackTree<Integer> testTree = new RedBlackTree<Integer>();
		testTree.insert(15, "okaySong");
		testTree.insert(1, "bestSong");
		testTree.insert(90, "badSong");
		testTree.insert(60, "monsterMash");
		testTree.clearTree();
		if (testTree.size() == 0 && testTree.root == null) {
			return;
		} else {
			fail("clear did not work properly");
		}
	}

}
