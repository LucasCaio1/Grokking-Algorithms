package dynamicProgramingSnapsack;

import java.util.ArrayList;

public class Items {

	private Double valueTotal = 0.00;
	private ArrayList<Item> arrayList = new ArrayList<>();

	public void add(Item item) {
		if (arrayList.isEmpty()) {
			arrayList.add(item);
			valueTotal += item.getValue();
			return;
		} else if (valueTotal == 0.00) {
			arrayList.remove(0);
			arrayList.add(item);
			valueTotal += item.getValue();
			return;
		}

		arrayList.add(item);
		valueTotal += item.getValue();
	}

	public void add(Items items) {
		for (Item i : items.arrayList) {
			if (!i.getName().equals("null"))
				add(i);
		}

	}

	public Double getValueTotal() {
		return valueTotal;
	}

	public ArrayList<Item> getItems() {
		return arrayList;
	}
}
