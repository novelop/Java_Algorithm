package 혜지_0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_8320직사각형을만드는방법 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] check= new boolean [N+1][N+1];
		int count = 0;
		int result = 0;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(!check[i][j] && i*j <= N) {
					count++;
					check[i][j] = true;
					check[j][i] = true;
				}
			}
		}
		System.out.println(count);
	}

}
