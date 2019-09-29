package LD3;

public class Solution {
	
	public static boolean palindrome(String s) {
		String tmp = reverse(s);
		return (s.equals(tmp));
	}
	
	private static String reverse(String s) {	
		if (s == null) {
			return null;
		}
		if (s.length() <= 1) {
			return s;
		}
		return reverse(s.substring(1)) + s.charAt(0);
	}

}
