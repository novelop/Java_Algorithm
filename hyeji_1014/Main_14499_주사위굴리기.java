package hyeji_1014;

import java.util.Scanner;

public class Main_14499_주사위굴리기{
	static int N,M,K;
	static int x,y;
	static int[][] map;
	static int[] diceMap;
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N][M];
		diceMap = new int[7];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
	
		for(int i=0; i<K; i++) {
			//주사위 굴리기
			turn(sc.nextInt());
		}
		

	}

	private static void turn(int i) {
		int nx = x + dx[i-1];
		int ny = y + dy[i-1];	
		if(nx < 0 || nx >= N || ny < 0 || ny >= M) return;
		x = nx;
		y = ny;
		
		int[] temp = diceMap.clone();
		
		switch(i) {
		case 1: // 동쪽
			diceMap[1] = temp[4];
			diceMap[3] = temp[1];
			diceMap[4] = temp[6];
			diceMap[6] = temp[3];
			break;
		case 2: //서쪽
			diceMap[1] = temp[3];
			diceMap[3] = temp[6];
			diceMap[4] = temp[1];
			diceMap[6] = temp[4];
			break;
		case 3: //북쪽
			diceMap[1] = temp[5];
			diceMap[2] = temp[1];
			diceMap[5] = temp[6];
			diceMap[6] = temp[2];
			break;
		case 4: //남쪽
			diceMap[1] = temp[2];
			diceMap[2] = temp[6];	
			diceMap[5] = temp[1];
			diceMap[6] = temp[5];
			break;
		}
		
		 if (map[x][y] == 0) {
             map[x][y] = diceMap[6];
         } else {
        	 diceMap[6] = map[nx][ny];
             map[x][y] = 0;
         }
		
		System.out.println(diceMap[1]);
		
	}

}
