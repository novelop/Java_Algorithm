package 혜지_0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3985롤케이크 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int len = Integer.parseInt(br.readLine());
		int cnt = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int A = 0;
		int B = 0;
		int[] cake = new int[len];
		int[] ex = new int[2]; // 기대값 높은 방청객 번호, 실;
		int[] M = new int[2];
		
		for(int i=1; i<=cnt; i++) {
			int count = 0;
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			if(M[0] < B-A) {
				M[0] = B-A;
				ex[0] = i;
			}
			for(int j=0; j<cake.length; j++) {
				if(cake[j] == 0 &&  j >= A-1 && j <= B-1 ) {
					cake[j]= i;
					count ++;
					//System.out.println(Arrays.toString(cake));
				}
			}
			if(M[1] < count) {
				M[1] = count;
				ex[1] = i;
			}
			if(i == cnt) {
				break;
			}
			st = new StringTokenizer(br.readLine()," ");
			
		}
		//System.out.println(Arrays.toString(cake));
		System.out.println(ex[0]);
		System.out.println(ex[1]);
		
		
	}

}
