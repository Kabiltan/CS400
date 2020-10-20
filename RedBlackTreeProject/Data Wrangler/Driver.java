// --== CS400 File Header Information ==--
// Name: Sai Varadharajan
// Email: svaradharaja@wisc.edu
// Team: MB
//Role:Data Wrangler
// TA: Harit
// Lecturer: Florian
// Notes to Grader: <optional extra notes>

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
 * class to load csv file and create nodes for each song and then store them in
 * a static Arraylist called nodesList
 * 
 * You can call Driver.loadData() in your class to do this
 * 
 * @author svaradharaja
 *
 */
public class Driver {
	// ArrayList of Nodes
	static ArrayList<RedBlackTree.Node<Integer, String>> nodesList = new ArrayList<>();

	public static void loadData() {
		String fileName = "p2csv.csv";

		File file = new File(fileName);
		try {
			Scanner input = new Scanner(file);
			int skipFirstLine = 0;

			while (input.hasNext()) {
				String data = input.nextLine(); // gets whole line
				if (skipFirstLine == 0) {
					skipFirstLine = 1;
					continue;
				}

				String[] dataVal = data.split(",");

				Integer rank = Integer.valueOf(dataVal[0]);
				String song = dataVal[1];
				RedBlackTree.Node<Integer, String> node = new RedBlackTree.Node<>(rank, song);
				nodesList.add(node);
			}

			input.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
