package hyeji_0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7568_덩치 {
	static int N;
	static int[][] arr;
	
	static void count(int x) {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(arr[i][0] > arr[x][0] &&  arr[i][1] > arr[x][1]) cnt++;
		}
		
		System.out.print(cnt + 1 + " ");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		
		for(int i=0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			count(i);
		}
		
		
	}
}
