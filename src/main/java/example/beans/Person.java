package example.beans;

public class Person {
	private String name;
	private int height;
	private float weight;
	
	public Person() {
		System.out.println("Inside person.");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public int getHeight() {
		System.out.println("Getting Height.");
		return height;
	}

	public void setHeight(int height) {
		System.out.println("Setting Height.");
		this.height = height;
	}

	
	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	
}
