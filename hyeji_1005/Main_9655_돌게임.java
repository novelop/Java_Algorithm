package hyeji_1005;

import java.util.Scanner;

public class Main_9655_돌게임 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
	
		int[] D = new int[N+1];
		
		D[0] = 0;
		for(int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			if(i >= 1 && D[i-1]+1 < min) min = D[i-1] + 1;
			if(i >= 3 && D[i-3]+1 < min) min = D[i-3] + 1;
			
			D[i] = min;	
		}
		
		if(D[N] % 2 == 0) {
			System.out.println("CY");
		}else {
			System.out.println("SK");
		}
		
	
	}
	
	

}
