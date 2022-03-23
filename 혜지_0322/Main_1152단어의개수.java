package 혜지_0322;

import java.util.Scanner;

public class Main_1152단어의개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		String newStr = str.trim();
		if(newStr.equals("")) {
			System.out.println(0);
		}else {
			String[] word = newStr.split(" ");
			System.out.println(word.length);
		}
	
	}
}
