package hyeji_0924;

import java.util.Scanner;

public class Main_2954_창영이의일기장 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ) {
				sb.append(str.charAt(i));
				i = i + 2;
			}else {
				sb.append(str.charAt(i));
			}
				
		}
		System.out.println(sb.toString());
		

	}

}
