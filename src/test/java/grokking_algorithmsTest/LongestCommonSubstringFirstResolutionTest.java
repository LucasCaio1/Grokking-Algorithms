package grokking_algorithmsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import grokking_algorithms.LongestCommonSubstringFirstResolution;

class LongestCommonSubstringFirstResolutionTest {

	@Test
	void deveriaResultarNumaSubstringDeTamanho3() {
		String commonLetters = "0111";
		int substringLenght = LongestCommonSubstringFirstResolution.maxSubstringLenght(commonLetters);
		assertEquals(3, substringLenght);
	}
	
	@Test
	void deveriaResultarNumaSubstringDeTamanho2() {
		String commonLetters = "0110";
		int substringLenght = LongestCommonSubstringFirstResolution.maxSubstringLenght(commonLetters);
		assertEquals(2, substringLenght);
	}

}
