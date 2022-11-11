package hyeji_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_21610_마법사상어와비바라기 {
	static class Pos{
		int x,y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	
	static int N,M;
	static List<Pos> cloud;
	static int[][] map;
	static int[] dx = {0,0,-1,-1,-1,0,1,1,1};
	static int[] dy = {0,-1,-1,0,1,1,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		cloud = new ArrayList<Pos>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cloud.add(new Pos(N-1,0));
		cloud.add(new Pos(N-1,1));
		cloud.add(new Pos(N-2,0));
		cloud.add(new Pos(N-2,1));
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			move(d,s);
		}
		
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sum += map[i][j];
			}
		}
		
		System.out.println(sum);

	}
	private static void move(int d, int s) {
		List<Pos> newCloud = new ArrayList<Pos>();
		boolean[][] check = new boolean[N][N];
		for(Pos p : cloud) {
			p.x = (N + p.x + dx[d]*(s % N)) % N;
			p.y = (N + p.y + dy[d]*(s % N)) % N;
			map[p.x][p.y]++;
			check[p.x][p.y] = true;
		}
		
		for(Pos p : cloud) {
			int cnt = 0;
			for(int i=2; i<=8; i+=2) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != 0) cnt++;
			}
			map[p.x][p.y] += cnt;
			
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] >= 2 && !check[i][j]) {
					newCloud.add(new Pos(i,j));
				    map[i][j] -= 2;   
				}
			}
		}
		
		cloud = newCloud;
		
	}

}
