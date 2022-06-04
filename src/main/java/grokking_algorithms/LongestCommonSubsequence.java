package grokking_algorithms;

public class LongestCommonSubsequence {
	static String word1 = "fort";
	static String word2 = "fosh";
	static int[][] grid = new int[word1.length()][word2.length()];

	public static void main(String[] args) {
		longestCommonSubsequence(word1, word2);
	}

	public static int longestCommonSubsequence(String word1, String word2) {
		for (int row = 0; row < word1.length(); row++) {
			for (int column = 0; column < word2.length(); column++) {
				Character charWord1 = word1.charAt(row);
				Character charWord2 = word2.charAt(column);
				if (charWord1.equals(charWord2)) {
					if (row == 0) {
						if (column == 0) { //primeira linha e primeira coluna;
							grid[row][column] = 1;
						} else {
							grid[row][column] = grid[row][column-1] + 1;
						}
					} else if (column == 0) { //primeira coluna de cada linha que não seha a primeira linha.
						grid[row][column] = grid[row][column-1] + 1;
					} else {
						grid[row][column] = grid[row-1][column-1] + 1;
					}
				} else {
					if (row == 0) { 
						if (column == 0) { //primeira linha e primeira coluna;
							grid[row][column] = 0;
						} else {
							grid[row][column] = grid[row][column-1];
						}
					} else if (column == 0) { //primeira coluna de cada linha que não seha a primeira linha.
						grid[row][column] = grid[row-1][column];
					} else {
						grid[row][column] = Math.max(grid[row-1][column], grid[row][column-1]);
					}
				}
			}
		}

		//saída console tabela
		for (int row = 0; row < word1.length(); row++) {
			for (int column = 0; column < word2.length(); column++) {
				System.out.print(grid[row][column] + " ");
			}
			System.out.println();
		}

		return grid[word1.length() - 1][word2.length() - 1];
	}
}
