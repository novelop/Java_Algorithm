package hyeji_0922;

import java.util.Scanner;

public class Main_8320_직사각형을만드는방법 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		boolean[][] arr = new boolean[n+1][n+1];
		int answer = 0;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(!arr[i][j] && i*j <= n) {
					answer++;
					arr[i][j] = true;
					arr[j][i] = true;
					
				}
			}
		}
		
		System.out.println(answer);

	}

}
