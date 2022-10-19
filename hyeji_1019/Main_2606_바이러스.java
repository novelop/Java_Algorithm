package hyeji_1019;

import java.util.Scanner;

public class Main_2606_바이러스 {
	static int N,M;
	static int ans = 0;
	static boolean[][] map;
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new boolean[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = map[y][x] = true;
		}
		
		dfs(1);
		System.out.println(ans);
	}

	private static void dfs(int x) {
		 visit[x] = true;
		
		for(int i=1; i<=N; i++) {
			if(map[x][i] && !visit[i]) {
				ans++;
				dfs(i);
			}
		}
		
	}

}
