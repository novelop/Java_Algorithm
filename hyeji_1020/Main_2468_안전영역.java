package hyeji_1020;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2468_안전영역 {
	static int N;
	static int[][] map;
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

		for(int i=min; i<=max; i++) {
			bfs(i);
		}
		System.out.println(ans);

	}

	private static void bfs(int m) {
		boolean[][] visit = new boolean[N][N];
		Queue<int[]> que = new LinkedList<>();
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] <= m || visit[i][j]) continue;
				que.offer(new int[] {i,j});
				visit[i][j] = true;
				
				while(!que.isEmpty()) {
					int[] c = que.poll();
					int x = c[0];
					int y = c[1];
					
					for(int k=0; k<4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] > m && !visit[nx][ny]) {
							que.offer(new int[] {nx,ny});
							visit[nx][ny] = true;
						}
					}
				}
				cnt++;
			}
		}
		ans = Math.max(cnt, ans);
		
	}

}
