package hyeji_1004;

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
		
		int temp = 0; 
		for(int i = 0; i < K; i++) { //배열의 첫번째부터 K까지의 합 
			temp += input[i];
		}
		
		int result = temp;
		
		for(int i = 1; i <= N-K; i++) {
			temp = temp - input[i-1] + input[i+K-1]; //temp의 첫번째값 빼고 k다음번재 수 더하기 
			if(result < temp) {
				result = temp; //temp 결과값보다 크면 result에 저장  
			}
		}
		
		System.out.println(result);
	}

}
