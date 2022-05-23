package dynamicProgramingSnapsack;

public class Item {
	
	private String name;
	private Double lbs;
	private Double value;
	
	public Item(String name, Double lbs, Double value) {
		super();
		this.name = name;
		this.lbs = lbs;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public Double getLbs() {
		return lbs;
	}
	public Double getValue() {
		return value;
	}
	
	
}
