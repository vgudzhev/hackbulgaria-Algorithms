package com.vgudzhev.tasks.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vgudzhev.tasks.EncryptedMessage;

public class EncryptedMessageTests {

	@Test
	public void testSliceAndSwap() {
		String expression = "vrItommseIal vihack~416~Ilocveakgrithms he";
		String actual = "16~Ilocveakgrithms hevrItommseIal vihack~4";

		assertEquals(EncryptedMessage.sliceAndSwap(expression), actual);
	}

	@Test
	public void testGetExtendedKey() {
		String actualString = "I love algorithms";
		String key = "hack";
		String expected = EncryptedMessage.getExtendedKey(key,
				actualString.length());
		assertEquals(expected.length(), actualString.length());
	}

	@Test
	public void testIndexes() {
		int[] keyIndexes = { 12, 6, 3, 7, 12, 6, 3, 7, 12, 6, 3, 7, 12, 6, 3,
				7, 12 };
		int[] encryptedIndexes = { 12, 5, 4, 9, 0, 11, 2, 13, 13, 14, 5, 0, 6,
				1, 15, 4, 10 };

		int[] actuals = { 0, 15, 1, 2, 4, 5, 15, 6, 1, 8, 2, 9, 10, 11, 12, 13,
				14 };
		int alphabetLength = 16;

		assertArrayEquals(EncryptedMessage.getRealMessageIndexes(keyIndexes,
				encryptedIndexes, alphabetLength), actuals);
	}

	@Test
	public void testAlphabetMapping() {
		String alphabet = "Ilocveakgrithms ";
		int[] messageIndexes = { 0, 15, 1, 2, 4, 5, 15, 6, 1, 8, 2, 9, 10, 11,
				12, 13, 14 };
		String actual = "I love algorithms";

		assertEquals(
				EncryptedMessage.getActualMessage(alphabet, messageIndexes),
				actual);
	}

	@Test
	public void testExample1() {
		String actual = "this is a secret.";
		String encoded = "rc hscesi tcrest~410~thisaecr .rcese";
		assertEquals(EncryptedMessage.solve(encoded), actual);
	}

	@Test
	public void testExample2() {
		String actual = "I love freckles.";
		String encoded = "fl k.ccfsIolskv.~312~ .Ifrckslovelvo";
		assertEquals(EncryptedMessage.solve(encoded), actual);
	}

	@Test
	public void testExample3() {
		String actual = "is this fun or what?";
		String encoded = "o?uin uw?stutnfwat?~413~orwa? thfuisnnrsiu";

		assertEquals(EncryptedMessage.solve(encoded), actual);
	}

	@Test
	public void testSecretText() {
		String encryptedMessage = "TJKUMbUUJTIREuKOXD'HR.sTOVSWU!KSJ(O.sVYtWZTTZVULsNOBdYONXFsvEu(PgWJsRTSVsYKOfDZOJSNVWu(IU!yAaMs?OW.tYaVET.A IQXTMQURJ.HLs'VHa'OTYUSzCQ!SePzsuMTzYQ!SM!NOdOH SuPMa)yA!LsKOPEUM,VAaMs.SuKOkDJEcIIStHACKBULGARIA~1260~abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ .',!?()rEPNtg,yTYMsJOFOtkZ sd EKsVYtXPIOUMs HK't(PYSROEAsq.JfPyAJ HVRVCUYaZsPITzMQ'UMZTEJXANEBCUYWRI!Os.Su(IkD!OdADLCKNFXDZOJ THRVCQdZMRRUMPNIDtISGTJQSz";
		String expected = EncryptedMessage.solve(encryptedMessage);
		System.out.println(expected);
		String actual = "Send us the code you used to decode this message. Write a short text (at most one page) telling us why you decided to start programming. What is that you like and what motivates you to continue learning? We would also want to know what are your expectations for the Algorithms course. Let your thoughts flow and don't spare us any detail.";
		assertEquals(expected, actual);
	}

}
