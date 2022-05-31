package dynamicProgramingSnapsack;

import java.util.ArrayList;

public class DynamicProgramingSnapsack {

	public static void main(String[] args) {
		Item water = new Item("water", 3, 10.00);
		Item book = new Item("book", 1, 3.00);
		Item food = new Item("food", 2, 9.00);
		Item jacket = new Item("jacket", 2, 5.00);
		Item camera = new Item("camera", 1, 6.00);

		ArrayList<Item> items = new ArrayList<>();
		items.add(water);
		items.add(book);
		items.add(food);
		items.add(jacket);
		items.add(camera);

	
		Items[][] tableItems = new Items[5][4];

		for (int linha = 0; linha < items.size(); linha++) {
			for (int coluna = 0; coluna < 4; coluna++) {
				tableItems[linha][coluna] = new Items();
				tableItems[linha][coluna].add(new Item("null", 0, 0.00));
			}
		}

		for (int linha = 0; linha < items.size(); linha++) {
			Item item = items.get(linha);
			for (int coluna = 0; coluna < 4; coluna++) {
				if (coluna+1 >= item.getLbs()) { //se cabe
					int pesoRestante = 0;
					if (linha == 0) {
						tableItems[linha][coluna].add(item);
					} else if ((pesoRestante = (coluna+1) - item.getLbs()) > 0) { //se sobra peso
						if ((item.getValue() + tableItems[linha-1][pesoRestante-1].getValueTotal()) > tableItems[linha-1][coluna].getValueTotal()) { //se a soma dois novos items for maior que o item anterior
							tableItems[linha][coluna].add(item);
							tableItems[linha][coluna].add(tableItems[linha-1][pesoRestante-1]);
						} else {
							tableItems[linha][coluna].add(tableItems[linha-1][coluna]);
						}
					} else if (item.getValue() > tableItems[linha-1][coluna].getValueTotal()) { //se o novo item for maior que o item anterior
						tableItems[linha][coluna].add(item);
					} else {
						tableItems[linha][coluna].add(tableItems[linha-1][coluna]);
					}
				} else if (linha > 0) {
					tableItems[linha][coluna].add(tableItems[linha-1][coluna]);
				}
			}
		}

		for (int linha = 0; linha < items.size(); linha++) {
			for (int coluna = 0; coluna < 4; coluna++) {
				tableItems[linha][coluna].getItems().stream().forEach(item -> {System.out.print(item + " ");});
				System.out.print("|");
			}
			System.out.println();
		}
	}
}
