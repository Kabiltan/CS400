This file contains the code for the Front End Developers
public class Class {
	private String className;
	private double classGPA;
	
	public Class (String name, double GPA) throws Exception {
		if(GPA > 4.0 || GPA < 0) {
			throw new Exception("The GPA you're trying to correlate this class to is either too small or too large");
		}
		
		this.classGPA = GPA;
		this.className = name;
	}
	
	public double getGPA() {
		return this.classGPA;
	}
	
	public String getName() {
		return this.className;
	}
	
	public void setGPA(double GPA) {
		this.classGPA = GPA;
	}
	
	public void updateClass(Class c, double GPA) {
		c.setGPA(GPA);
	}
	
}
