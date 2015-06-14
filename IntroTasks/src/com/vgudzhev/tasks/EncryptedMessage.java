package com.vgudzhev.tasks;

public class EncryptedMessage {
	public static String solve(String expression){
		String originalExpression = sliceAndSwap(expression);
		String originalMessage = preprocessArguments(originalExpression);
		return originalMessage;
	}

	private static String preprocessArguments(String originalExprssion) {
		String[] arguments = originalExprssion.split("~");
		int alphabetLength = Integer.parseInt(arguments[0]);
		String alphabetMessageAndKey = arguments[1];
		String alphabet = alphabetMessageAndKey.substring(0, alphabetLength);
		int keyLength = Integer.parseInt(arguments[2]);
		String key = alphabetMessageAndKey.substring(alphabetMessageAndKey.length()-keyLength);
		String encryptedMessage = alphabetMessageAndKey.substring(alphabetLength,
									alphabetMessageAndKey.length()-keyLength);
		
		String extendedKey = getExtendedKey(key, encryptedMessage.length());
		int[] keyIndexes = getIndexes(alphabet, extendedKey);
		int[] encryptedMessageIndexes = getIndexes(alphabet, encryptedMessage);
		int[] realMessageIndexes = getRealMessageIndexes(keyIndexes, encryptedMessageIndexes, alphabetLength);
		String actualMessage = getActualMessage(alphabet, realMessageIndexes);
		
		return actualMessage;
	}
	
	public static String getActualMessage(String alphabet ,int[] realMessageIndexes) {
		StringBuilder message = new StringBuilder();
		for (int i = 0; i < realMessageIndexes.length; i++) {
			message.append(alphabet.charAt(realMessageIndexes[i]));
		}
		
		return message.toString();
	}

	public static int[] getRealMessageIndexes(int[] keyIndexes, int[] encryptedMessageIndexes, int alphabetLength) {
		int length = keyIndexes.length;
		int[] realMessageIndexes= new int[length];
		for (int i = 0; i < length; i++) {
			if (encryptedMessageIndexes[i] >= keyIndexes[i]) {
				realMessageIndexes[i] = encryptedMessageIndexes[i] - keyIndexes[i];
			}else{
				int sum = alphabetLength;
				while (true) {
					if (sum % alphabetLength == encryptedMessageIndexes[i]) {
						realMessageIndexes[i] = sum - keyIndexes[i];
						break;
					}
					++sum;
				}
			} 
		}
		
		return realMessageIndexes;
	}

	private static int[] getIndexes(String alphabet, String expression) {
		int[] keyIndexes = new int[expression.length()];
		char currentChar;
		for (int i = 0; i < keyIndexes.length; i++) {
			currentChar = expression.charAt(i);
			keyIndexes[i] = alphabet.indexOf(currentChar);
		}
		
		return keyIndexes;
	}

	public static String sliceAndSwap(String expression){
		String firstPart = expression.substring(0,expression.length()/2);
		String secondPart = expression.substring(expression.length()/2);
		
		return secondPart+firstPart;
	}
	
	public static String getExtendedKey(String key, int length){
		StringBuilder extendedKey = new StringBuilder();
		int index;
		for (int i = 0; i < length; i++) {
			index = i%key.length();
			extendedKey.append(key.charAt(index));
		}
		
		return extendedKey.toString();
	}
}