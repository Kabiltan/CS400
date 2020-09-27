
public class testDataWrangler {
	
	public static boolean test1() {
		DataWrangle testData = new DataWrangle();
		testData.createHash();
		return true;
	}

	public static void main(String[] args) {
		System.out.println(test1());

	}

}
