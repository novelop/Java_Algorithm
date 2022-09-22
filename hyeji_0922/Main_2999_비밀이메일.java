package hyeji_0922;

import java.util.Scanner;

public class Main_2999_비밀이메일 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int N = str.length();
		int R = 0,C = 0;
		
		for(int i=1; i <= N; i++) {
			for(int j= N; j >= i; j--) {
				int temp = i * j;
				if(temp == N) {
					if(R < temp) {
						R = i;
						C = j;
					}
				}
			}
		}
	
		char[][] map = new char[R][C];
            int cnt = 0;
	
			for(int i = 0; i < C; i++) {
				for(int j=0; j < R; j++) {
					map[j][i] = str.charAt(cnt++);
				}
			}

		

			for(int i = 0; i < R; i++) {
				for(int j=0; j < C; j++) {
					System.out.print(map[i][j]);
				}
			}

		

	}

}
