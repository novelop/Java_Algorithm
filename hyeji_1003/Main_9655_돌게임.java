package hyeji_1003;

import java.util.Scanner;

public class Main_9655_돌게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
	
		boolean isSK = false;
		while (N != 0) {
			isSK = !isSK;
			if(N >= 3) {
				N -= 3;
			}else {
				N -= 1;
			}
		}
		
		System.out.println(isSK ? "SK" : "CY");
	
	}
	


}
