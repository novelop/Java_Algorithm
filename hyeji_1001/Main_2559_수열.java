package hyeji_1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2559_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] input = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i=0; i<=N-K; i++) {
			sum = 0;
			for(int j=i; j<i+K; j++) {
				sum += input[j];
			}
			max = Math.max(max, sum);
		}
			
		System.out.println(max);
		
	}

}
