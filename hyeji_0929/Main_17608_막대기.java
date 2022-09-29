package hyeji_0929;

import java.util.Scanner;

public class Main_17608_막대기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int cnt = 1;
		int maxHight = arr[N-1];
		for(int i = N-1; i >= 0; i--) {
			if(arr[i] > maxHight) {
				cnt++;
				maxHight = arr[i];
			}
			
		}
		
		System.out.println(cnt);

	}

}
