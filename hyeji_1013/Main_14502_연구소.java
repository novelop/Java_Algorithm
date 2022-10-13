package hyeji_1013;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_14502_연구소 {
	static int N,M;
	static int[][] map;
	static int max = 0;
	static List<int[]> virus;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		virus = new ArrayList<int[]>();
		
		for(int i=0; i < N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) virus.add(new int[] {i,j});
			}
		}
		
		//벽설치하기
		stall(0);
		System.out.println(max);
	}

	private static void stall(int depth) {
		if(depth == 3) {
			diff();
			return;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					stall(depth+1);
					map[i][j] = 0;
				}
			}
		}
		
	}
	//바이러스 확산하기
	private static void diff() {
		boolean[][] visit = new boolean[N][M];
		Queue<int[]> que = new LinkedList<int[]>();
		
		for(int[] v : virus) {
			que.offer(v);
			visit[v[0]][v[1]] = true;
		}
		
		while(!que.isEmpty()) {
			int[] c = que.poll();
			int x = c[0];
			int y = c[1];
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >=0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny] && map[nx][ny] == 0 ) {
					visit[nx][ny] = true;
					que.offer(new int[] {nx,ny});
				}
			}
		}
		
		safe(visit);	
		
	}
	//빈칸갯수덩어리중 가장 큰 덩어리의 크기
	private static void safe(boolean[][] visit) {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0 && !visit[i][j]) cnt++;
			}
		}
		max = Math.max(max, cnt);
		
	}

}
