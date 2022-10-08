package hyeji_1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2 {
	static int N,M;
	static boolean[][][][] visited;
	static char[][] map;
	static int holeX,holeY;
	static Pos blue,red;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		
		
		
		Pos pos = new Pos();
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'R') {
					red = new Pos(i,j,0,0,0);
				}else if(map[i][j] == 'B') {
					blue = new Pos(0,0,i,j,0);
				}
			}
		}
		System.out.println(bfs());

	}

	public static int bfs() {
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.offer(new Pos(red.rx,red.ry,blue.bx,blue.by,1));
		visited[red.rx][red.ry][blue.bx][blue.by] = true;
		while(!queue.isEmpty()) {
			Pos cur = queue.poll();
			
			int rx = cur.rx;
			int ry = cur.ry;
			int bx = cur.bx;
			int by = cur.by;
			int cnt = cur.cnt;
			
			if(cnt > 10) {
				return -1;
			}
					
			for(int i=0; i<4; i++) {
				int crx = rx;
				int cry = ry;
				int cbx = bx;
				int cby = by;

				boolean isRedHole = false;
				boolean isBlueHole = false;
				
				
				//파란구슬
				while(map[cbx+dx[i]][cby+dy[i]] != '#') {
					cbx += dx[i];
					cby += dy[i];

					if(map[cbx][cby] == 'O') {
						isBlueHole = true;
						break;
					}

				}

				while(map[crx+dx[i]][cry+dy[i]] != '#') {
					crx += dx[i];
					cry += dy[i];
					
					
					if(map[crx][cry] == 'O') {
						isRedHole = true;
						break;
					}
					
				}
				
				if(isBlueHole) continue;
				
				if(isRedHole && !isBlueHole) {
					return cnt;
				}
				

				
				if(crx == cbx && cry == cby) {
					if(i==0) { //위쪽으로 기울이기
						//더 큰 x값을 가지는 구슬이 아래로 감
						if(rx > bx) crx -= dx[i];
						else cbx -= dx[i];
					}else if(i==1) { //오른쪽으로 기울이기
						//더 작은 y값을 가지는 구슬이 왼쪽으로 감
						if(ry < by) cry -= dy[i];
						else cby -= dy[i];
					}else if(i==2) { //아래로 기울이기
						//더 작은 x값을 가지는 구슬이 위로감
						if(rx < bx) crx -= dx[i];
						else cbx -= dx[i];
					}else {//왼쪽으로 기울이기
						//더 큰 y값을 가지는 구슬이 오른쪽으로 감
						if(ry > by) cry -= dy[i];
						else cby -= dy[i];
					}
					
				}
				
				if(!visited[crx][cry][cbx][cby]) {
					visited[crx][cry][cbx][cby] = true;
					queue.offer(new Pos(crx,cry,cbx,cby,cnt+1));
				}

			}
		}
			
		
		
		return -1;
	}
	
	
}

class Pos{
	int rx,ry,bx,by,cnt;
	public Pos() {
		
	}
	public Pos(int rx, int ry, int bx, int by, int cnt) {
		super();
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.cnt = cnt;
	}
}
