package hyeji_1020;

import java.util.Scanner;

public class Main_2644_촌수계산 {
	static int N,M;
	static int ans = -1;
	static boolean[][] map;
	static boolean[] visit;
	static int start,end;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new boolean[N+1][N+1];
		visit = new boolean[N+1];
		
		start = sc.nextInt();
		end = sc.nextInt();
		
		M = sc.nextInt();
		for(int i=0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = map[y][x] = true;
		}
		
		dfs(start,0);
		System.out.println(ans);

	}
	private static void dfs(int depth, int cnt) {
		visit[depth] = true;
		
		if(depth == end) {
			ans = cnt;
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(map[depth][i] && !visit[i]) {
				dfs(i,cnt+1);
			}
		}
		
	}

}
