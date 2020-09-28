package sliding_window;

/*
 Given a string, find the length of the longest substring 
 in it with no more than K distinct characters
 */

public class LongestSubstringKDistinct {
	public static int findLength(String str, int k) {
		int[] flag = new int[26];
		int start = 0;
		int maxLen = -1;
		int length = 0;
		int disChar = 0;
		for (int end=0;end<str.length();end++) {
			int ch = (int)str.charAt(end)-(int)'a';
			if (flag[ch]==0) {
				disChar ++;
			}
			flag[ch] ++;
			length ++;
			// System.out.println("distinct character:"+disChar);
			while (disChar>k) {
				ch = (int)str.charAt(start)-(int)'a';
				flag[ch] --;
				if (flag[ch]==0) {
					disChar --;
				}
				length --;
				start ++;
			}
			maxLen = maxLen<length?length:maxLen;
			// System.out.println("max length:"+maxLen);
		}
		return maxLen;
	}
	public static void main(String[] args) {
		int res = findLength("araaci",2);
		System.out.println(res);
	}
}
