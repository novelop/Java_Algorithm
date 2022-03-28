package 혜지_0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2851슈퍼마리오 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] N = new int[10];
		int[] sum = new int[2];
		for(int i=0; i<N.length; i++) {
			N[i] = Integer.parseInt(br.readLine());
		}
		for(int j=0; j < N.length; j++) {
			 if(sum[0]+ N[j] > 100) {
				 sum[1] = sum[0] + N[j];
				 break;
			 }
				sum[0] += N[j];
			
		}
		
		if (sum[1] != 0) {
			if (100 - sum[0] < sum[1] - 100) {
				System.out.println(sum[0]);
			} else {
				System.out.println(sum[1]);
			}
		}else {
			System.out.println(sum[0]);
		}
		
		
	

	}

}
