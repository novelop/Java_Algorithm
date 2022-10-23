package hyeji_1022;

import java.util.Scanner;

public class Main_2079_팰린드롬 {
	static String input;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.next();
		StringBuilder sb = new StringBuilder(input);
		dp = new int[sb.length()];
		
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<sb.length(); i++) {
			int cnt = find(sb.substring(i),i);
			ans = Math.min(ans, cnt);
		}
		
		System.out.println(ans);

	}

	private static int find(String str, int index) {
		StringBuilder sb = new StringBuilder(str);
		boolean flag = false;
		int cnt = 0;
		while(true) {
			int len = sb.length();
			for(int i=0; i<len/2; i++) {
				if(sb.charAt(i) != sb.charAt(len-1 - i)) {
					len--;
					i = -1;
					flag = false;
				}
				else flag = true;
			}
			
			cnt++;
			System.out.println(sb.substring(0,len) + " " +index);
			
			sb.delete(0, len);
			
			if(sb.length() == 0) break;

		}
		System.out.println(cnt + index );
		return cnt + index;
	
	}

}
