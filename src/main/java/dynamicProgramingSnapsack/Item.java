package dynamicProgramingSnapsack;

public class Item {

	private String name;
	private Integer lbs;
	private Double value;

	public Item(String name, Integer lbs, Double value) {
		super();
		this.name = name;
		this.lbs = lbs;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Integer getLbs() {
		return lbs;
	}

	public Double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return name;
	}

}
