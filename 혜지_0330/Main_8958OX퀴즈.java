package 혜지_0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_8958OX퀴즈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] sum = new int[N];
		int count = 0;
		for(int i=0; i<N; i++) {
			count = 0;
			String num = br.readLine();
			for(int j=0; j<num.length(); j++) {
				if(num.charAt(j) == 'O') {
					count++;
					sum[i]+=count;
				}else {
					count = 0;
				}
			}
		}
		
		for(int i=0; i<sum.length; i++) {
			System.out.println(sum[i]);
		}
	}

}
