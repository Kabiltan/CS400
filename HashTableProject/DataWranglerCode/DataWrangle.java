import java.util.LinkedList;

/**
 * This class puts data about names and average GPA's of classes at UW-Madison
 * into a HashTable
 * 
 * @author codyknepprath
 *
 */
public class DataWrangle {
	/**
	 * the projectData field is a hashtable that is filled up with linkedlists of
	 * nodes that store class names and GPA
	 */
	private HashTableMap<Object, Object> projectData = new HashTableMap<Object, Object>();
	/**
	 * rawNameGpa is an array filled with manually inserted data from madgrapes.com
	 */
	private Object[] rawNameGpa = { "CS400", 3.37, "CS200", 2.99, "CS300", 3.17, "GEOSCI117", 3.46, "AFROAMER154", 3.82,
			"CHEM103", 2.98, "CHEM104", 2.94, "SOILSCI101", 3.83, "MATH710", 3.60, "PSYCH201", 2.69, "PSYCH210", 2.70,
			"ANTHRO102", 2.84, "MUSIC113", 3.95, "BIOLOGY151", 2.87, "BIOLOGY101", 2.54, "ART212", 3.70, "AFRICAN333",
			3.37, "FOODSCI550", 3.46, "DANCE2", 3.82, "LSC100", 3.64, "MUSIC103", 3.56 };

	/**
	 * this method takes the data from the private array field in the class and
	 * stores it in an organized, searchable structure which is the classes
	 * hashtable field
	 */
	public void createHash() {
		for (int i = 0; i < rawNameGpa.length; i += 2) {
			projectData.put(rawNameGpa[i], rawNameGpa[i + 1]);
		}
	}

	/**
	 * accessor method to get the projectData field
	 * @return projectData - hashtable with organized data
	 */
	public HashTableMap<Object, Object> getProjectData() {
		return this.projectData;
	}

}
