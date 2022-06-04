package grokking_algorithms;

public class LongestCommonSubstringFirstResolution {

	static String word1 = "fish";
	static String word2 = "hish";
	static int[][] grid = new int[word1.length()][word2.length()];

	public static void main(String[] args) {

		for (int row = 0; row < word1.length(); row++) {
			for (int column = 0; column < word2.length(); column++) {
				Character charWord1 = word1.charAt(row);
				Character charWord2 = word2.charAt(column);
				if (charWord1.equals(charWord2) && row == column) {
					grid[row][column] = 1;
				} else if (row > 0 && grid[row - 1][column] == 1) {
					grid[row][column] = 1;
				} else {
					grid[row][column] = 0;
				}
			}
		}

		String commonLetters = commonLetters(grid);
		int substringLenght = maxSubstringLenght(commonLetters);
		System.out.println(substringLenght);

	}

	public static String commonLetters(int[][] grid) {
		String commonLetters = "";
		for (int row = word1.length() - 1; row == word1.length() - 1; row++) {
			for (int column = 0; column < word2.length(); column++) {
				commonLetters += grid[row][column];
			}
		}
		return commonLetters;
	}

	public static int maxSubstringLenght(String commonLetters) {
		int largeLenght = 0;
		int lenght = 0;
		for (int index = 0; index < commonLetters.length(); index++) {
			Character cha = commonLetters.charAt(index);
			if (cha == '1') {
				lenght++;
			} else if (cha == '0') {
				if (lenght > largeLenght) {
					largeLenght = lenght;
				}
				lenght = 0;
			}
			if (lenght > largeLenght) {
				largeLenght = lenght;
			}
		}
		return largeLenght;
	}

}
