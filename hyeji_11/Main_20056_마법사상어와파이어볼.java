package hyeji_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20056_마법사상어와파이어볼 {

	static class Pos{
		int x,y,m,s,d;

		public Pos(int x,int y, int m, int s, int d) {
			super();
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}

	}
	
	static int N,M,K;
	static Queue<Pos>[][] map;
	static List<Pos> list;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new LinkedList[N][N];
		list = new ArrayList<Pos>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = new LinkedList<Pos>();
			}
		}

		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list.add(new Pos(r,c,m,s,d));
			ans += m;
		}
		
		for(int i=0; i<K; i++) {
			move();
			diff();
		}
		System.out.println(ans);
		
	}
	private static void diff() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].size() < 2) {
					map[i][j].clear();
					continue;
				}
				int cnt = map[i][j].size();
				int nm = 0;
				int ns = 0;
				boolean even = true;
				boolean odd = true;
				while(!map[i][j].isEmpty()) {
					Pos p = map[i][j].poll();
					nm += p.m;
					ns += p.s;
					if(p.d % 2 == 0) {
						odd = false;
					}else {
						even = false;
					}
					list.remove(p);
					ans -= p.m;
				}
				
				nm /= 5;
				ns /= cnt;
				
				if(nm == 0) continue;
				
				if(even || odd) {
					list.add(new Pos(i,j,nm,ns,0));
					list.add(new Pos(i,j,nm,ns,2));
					list.add(new Pos(i,j,nm,ns,4));
					list.add(new Pos(i,j,nm,ns,6));
				}else {
					list.add(new Pos(i,j,nm,ns,1));
					list.add(new Pos(i,j,nm,ns,3));
					list.add(new Pos(i,j,nm,ns,5));
					list.add(new Pos(i,j,nm,ns,7));
				}
				
				ans += nm * 4;
				
			}
		}
		
	}
	private static void move() {

		for(Pos p : list) {
			p.x = (N + p.x + dx[p.d]* (p.s % N)) % N;
			p.y = (N + p.y + dy[p.d]* (p.s % N)) % N;

			map[p.x][p.y].add(p);
			
		}
		
	}

}
