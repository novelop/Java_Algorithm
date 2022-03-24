package 혜지0324;

import java.util.Scanner;

public class Main_11721열개씩끊어출력하기 {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String str = sc.nextLine();
	    for(int i=0; i<str.length(); i++) {
	    	if(i >= 10 && i%10 == 0) {
	    		System.out.println();
	    	}
	    	System.out.print(str.charAt(i));
	    }

	}

}
