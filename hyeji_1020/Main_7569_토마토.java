package hyeji_1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_토마토 {
	static int M,N,H;
	static int count;
	static int ans = -1;
	static int[][][] map;
	static Queue<Tomato> que;
	
	static int[] dx = {0,1,0,-1,0,0};
	static int[] dy = {1,0,-1,0,0,0};
	static int[] dz = {0,0,0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); //가로
		N = Integer.parseInt(st.nextToken()); //세로
		H = Integer.parseInt(st.nextToken()); //높이
		
		map = new int[H][N][M];
		que = new LinkedList<Tomato>();
		
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++) {
					int input = Integer.parseInt(st.nextToken());
					if(input != 0) {
						map[i][j][k] = 1;
						if(input == 1) que.offer(new Tomato(i,j,k,0));
						continue;
					}
						count++;
				}
			}
		}
		
		if(count == 0) {
			System.out.println(0);
		}else {
			bfs();
			System.out.println(ans);
		}


	}
	
	private static void bfs() {
		int day = 0;
		while(!que.isEmpty()) {
			Tomato t = que.poll();
			int z = t.z;
			int x = t.x;
			int y = t.y;
			day = t.day;
			
			for(int i=0; i<6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M && nz>=0 && nz<H && 
						map[nz][nx][ny] == 0) {
					count--;
					if(count == 0) {
						ans = day+1;
						break;
					}
					map[nz][nx][ny] = 1;
					que.offer(new Tomato (nz,nx,ny,day+1));
				}
				
			}
			
		}
		
		
	}
	
	static class Tomato{
		int z,x,y,day;

		public Tomato(int z, int x, int y, int day) {
			super();
			this.z = z;
			this.x = x;
			this.y = y;
			this.day = day;
		}
		
	}

}
