package dynamicProgramingSnapsack;

import java.util.ArrayList;

public class DynamicProgramingSnapsack {

	public static void main(String[] args) {
		Item guitar = new Item("guitar", 1.0, 1500.00);
		Item stereo = new Item("stereo", 4.0, 3000.00);
		Item laptop = new Item("laptop", 3.0, 2000.00);
		Item Iphone = new Item("iphone", 1.0, 2000.00);

		ArrayList<Item> items = new ArrayList<>();
		items.add(guitar);
		items.add(stereo);
		items.add(laptop);
		items.add(Iphone);

		Item[][] table = new Item[4][4];
		
		for (int primeiraLinha = 0; primeiraLinha == 0; primeiraLinha++) {
			Item item = items.get(primeiraLinha);
			for (int coluna = 0; coluna < 4; coluna++) {
				if (item.getLbs() <= coluna + 1) {
					table[primeiraLinha][coluna] = item;
				}
			}

		}

		for (int linha = 1; linha < 4; linha++) {
			Item item = items.get(linha);
			for (int coluna = 0; coluna < 4; coluna++) {
				if (item.getLbs() <= coluna + 1) {
					if (item.getValue() > table[linha - 1][coluna].getValue() && coluna - item.getLbs() < 0) {
						table[linha][coluna] = item;
					} else if (coluna - item.getLbs() > -1) {
						if (item.getValue() + table[linha-1][(int) (coluna-item.getLbs())].getValue() > table[linha - 1][coluna].getValue()) {
							table[linha][coluna] = new Item(item.getName() + " " + table[linha-1][(int) (coluna-item.getLbs())].getName(), 
									item.getLbs() + table[linha-1][(int) (coluna-item.getLbs())].getLbs(),
									item.getValue() + table[linha-1][(int) (coluna-item.getLbs())].getValue());
						}
					}
				}
				if (table[linha][coluna] == null) {
					table[linha][coluna] = table[linha - 1][coluna];
				}
			}
		}

		for (int linha = 0; linha < 4; linha++) {
			for (int coluna = 0; coluna < 4; coluna++) {
				System.out.printf("%s  %s   |", table[linha][coluna].getName(), table[linha][coluna].getValue());
			}
			System.out.println();
		}
	}
}
