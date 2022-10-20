package hyeji_1020;

import java.util.Scanner;

public class Main_2468_안전영역2 {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int ans = 1;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				min = Math.min(min,map[i][j]);
				max = Math.max(max,map[i][j]);
			}
		}

		sol();
		System.out.println(ans);

	}

	private static void sol() {
		int cnt;
		for(int m=min; m<=max; m++) {
			
			visit = new boolean[N][N];
			cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] <= m || visit[i][j]) continue;
					dfs(i,j,m);
				
					cnt++;
				}
			}
			ans = Math.max(cnt, ans);
			
		}

		
	}

	private static void dfs(int x, int y, int m) {
		visit[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < N &&!visit[nx][ny] && map[nx][ny] > m) {
				dfs(nx,ny,m);
			}
		}
		
	}

	

}
