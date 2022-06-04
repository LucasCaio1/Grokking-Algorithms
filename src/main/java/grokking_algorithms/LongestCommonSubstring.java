package grokking_algorithms;

public class LongestCommonSubstring {
	static String word1 = "fish";
	static String word2 = "hish";
	static int[][] grid = new int[word1.length()][word2.length()];

	public static void main(String[] args) {

		longestCommonSubstring(word1, word2);

	}

	private static void longestCommonSubstring(String word1, String word2) {
		for (int row = 0; row < word1.length(); row++) {
			for (int column = 0; column < word2.length(); column++) {
				Character charWord1 = word1.charAt(row);
				Character charWord2 = word2.charAt(column);
				if (charWord1.equals(charWord2) && row == column) {
					if (row == 0) {
						grid[row][column] = 1;
					} else {
						grid[row][column] = grid[row - 1][column - 1] + 1;
					}
				} else {
					grid[row][column] = 0;
				}
			}
		}

		int longestCommonSUbstring = maxValue(grid);
		System.out.println(longestCommonSUbstring);
	}

	private static int maxValue(int[][] grid) {
		int maxValue = 0;
		for (int row = 0; row < word1.length(); row++) {
			for (int column = 0; column < word2.length(); column++) {
				if (grid[row][column] > maxValue) {
					maxValue = grid[row][column];
				}
			}
		}
		return maxValue;
	}
}
