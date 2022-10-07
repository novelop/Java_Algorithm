package hyeji_1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2116_주사위쌓기 {
	
	static int[] dice = {5,3,4,1,2,0};
	static int[] sum = new int[6];
	static int[] arr = new int[6];
	static int[][] top = new int[6][2];
	static int max;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<6; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			findTop();
			for(int j=0; j<6; j++) {
				System.out.print(Arrays.toString(top[j]));
			}
			System.out.println();
			sum();
		}
		
		Arrays.sort(sum);
		System.out.println(sum[5]);
		
	}
	
	public static void findTop() {
		for(int i=0; i<6; i++) {
			if(top[i][0] == 0) {
				top[i][0] = arr[dice[i]];
				top[i][1] = arr[i];
			}else {
				for(int j=0; j<6; j++) {
					if(top[i][0] == arr[j]) {
						top[i][0] = arr[dice[j]];
						top[i][1] = arr[j];
					}
				}
			}
		}
	}

	public static void sum() {
		int max = Integer.MIN_VALUE;
		for(int j=0; j<6; j++) {
			for(int i=0; i<6; i++) {
				if(arr[i] == top[j][0] || arr[i] == top[j][1]) continue;
				max = Math.max(max, arr[i]);
			}
			sum[j] += max;
		}
	}

}
