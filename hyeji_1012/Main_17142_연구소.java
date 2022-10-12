package hyeji_1012;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_17142_연구소 {
	static int N,M;
	static int ans = Integer.MAX_VALUE;
	static int[][] map;
	static List<int[]> bairus;
	static boolean[] bairus_visit;
	static int blank = 0;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][N];
		bairus = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) {
					bairus.add(new int[] {i,j});
				}else if(map[i][j] == 0) {
					blank++;
				}
			}
		}
		
		bairus_visit = new boolean[bairus.size()];
		
		start(0,0);
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);			
		}

	}

	private static void start(int depth, int start) {
		if(depth == M) {		
			int t = bfs();
			if(t != -1) {
				ans = Math.min(t, ans);				
			}
			return;
		}
		for(int i=start; i<bairus.size(); i++) {
			if(bairus_visit[i] == false) {
				bairus_visit[i] = true;
				start(depth+1,i+1);
				bairus_visit[i] = false;			
			}
			
		}
	}

	private static int bfs() {
		Queue<int[]> que = new LinkedList<int[]>();
		boolean[][] visit = new boolean[N][N];
		
		for(int i=0; i<bairus.size(); i++) {
			if(bairus_visit[i] == true) {
				int[] b = bairus.get(i);
				que.offer(new int[]{b[0],b[1],0});
				visit[b[0]][b[1]] = true;
			}
		}
		
		int cnt = 0;
		int t = 0;
		int time = 0;
		while(!que.isEmpty()) {
			int[] c = que.poll();
			int x = c[0];
			int y = c[1];
			t = c[2];
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nt = t + 1;
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && visit[nx][ny] == false) {
					if(map[nx][ny] == 0) { // 빈칸일때 
						visit[nx][ny] = true;
						que.offer(new int[] {nx,ny,nt});
						cnt++;
						time = Math.max(time, nt);
					}else if(map[nx][ny] == 2) {
						visit[nx][ny] = true;
						que.offer(new int[] {nx,ny,nt});
					}	
				}
			}
		}

		if(cnt != blank) time = -1;
		return time;
		
	}

}
