package hyeji_1019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_2667_단지번호붙이기 {
	static int N;
	static int dangi = 0;
	static char[][] map;
	static List<Integer> list;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		map = new char[N][N];
		list = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			String input = sc.next();
			for(int j=0; j<input.length(); j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		bfs();
		Collections.sort(list);
		System.out.println(dangi);
		for(int n : list) {
			System.out.println(n);
		}
		


	}
	private static void bfs() {
		boolean[][] visit = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if( map[i][j] == '0' || visit[i][j]) continue;
				Queue<int[]> que = new LinkedList<int[]>();
				que.offer(new int[] {i,j});
				visit[i][j] = true;
				int cnt = 1;
				while(!que.isEmpty()) {
					int[] c = que.poll();
					int x = c[0];
					int y = c[1];
					
					for(int k=0; k<4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == '1' && !visit[nx][ny]) {
							que.offer(new int[] {nx,ny});
							visit[nx][ny] = true;
							cnt++;
						}
					}
				}
				list.add(cnt);
				
				dangi++;
			}
			
		}
		
	}

}
