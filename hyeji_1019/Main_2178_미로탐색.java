package hyeji_1019;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2178_미로탐색 {
	static int N,M;
	static char[][] map;
	static int[][] visit;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new char[N][M];
		visit = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String input = sc.next();
			for(int j=0; j<input.length(); j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		bfs();
		System.out.println(visit[N-1][M-1]);

	}
	private static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {0,0});
		visit[0][0] = 1;
		while(!que.isEmpty()) {
			int[] c = que.poll();
			int x = c[0];
			int y = c[1];
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == '1' && visit[nx][ny] == 0) {
					que.offer(new int[] {nx,ny});
					visit[nx][ny] = visit[x][y] + 1;
				}
			}
		}
		
	}

}
