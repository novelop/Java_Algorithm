package hyeji_1007;

import java.util.Scanner;

public class Main_10157_자리배정 {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();//가로
		int R = sc.nextInt();//세로
		int K = sc.nextInt();
		
		int[][] map = new int[R+2][C+2];
		
		for(int i=0; i<(C+2); i++) {
			map[0][i] = -1;
			map[R+1][i] = -1;
		}
		
		for(int i=0; i<(R+2); i++) {
			map[i][0] = -1;
			map[i][C+1] = -1;
		}
		
		if( K > C * R) {
			System.out.println(0);
			return;
		}
		
		
		int x = 1; //열
		int y = 1; //행
		int value = 1;
		int dir = 0; //방향(상우하좌 =>0123)
		
		while(true) {
			map[y][x] = value;
			if(value == K) {
				System.out.println( x + " " + y);
				break;
			}
			
			if(map[y+dy[dir]][x+dx[dir]] != 0) {
				dir = (dir+1) % 4;
			}
			
			x += dx[dir];
			y += dy[dir];
			
			value++;
			
		}
	

	}

}
