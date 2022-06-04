package grokking_algorithmsTest;

import static org.junit.jupiter.api.Assertions.*;
import grokking_algorithms.LongestCommonSubsequence;
import org.junit.jupiter.api.Test;
class LongestCommonSubsequenceTest {

	@Test
	void deveriaRetornar3letrasEmComum() {
		String word1 = "fish";
		String word2 = "fosh";
		
		int commonLetters = LongestCommonSubsequence.longestCommonSubsequence(word1, word2);
		assertEquals(3, commonLetters);
	}
	
	@Test
	void deveriaRetornar2letrasEmComum() {
		String word1 = "fort";
		String word2 = "fosh";
		
		int commonLetters = LongestCommonSubsequence.longestCommonSubsequence(word1, word2);
		assertEquals(2, commonLetters);
	}

}
