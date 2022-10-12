package hyeji_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {
	static int R,C,T;
	static int[][] map;
	static int dustCnt = 0;
	static int diffCnt = 0;
	static Queue<int[]> que;
	static List<int[]> air;
	
	
	static int[] dx = {0,1,0,-1};//우하좌상 시계방향
	static int[] dy = {1,0,-1,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
	
		map = new int[R][C];
		que = new LinkedList<int[]>();
		air = new ArrayList<int[]>();
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0) {
					dustCnt++;
					que.offer(new int[] {i,j});
				}else if(map[i][j] == -1){
					air.add(new int[] {i,j});
				}
			}
		}
		
		bfs();
		
		int sum = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] > 0) {
					sum += map[i][j];
				}
			}
		}
		System.out.println(sum);
		
	}

	private static void bfs() {
		while(T > 0) {
			int[][] copyMap = new int[R][C];
			for(int i = 0; i < R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j] <= 0) {
						if(map[i][j] == -1) copyMap[i][j] = map[i][j];
						continue;
					}
					
					int cnt = 0;
					for(int k = 0; k < 4; k++){
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if(nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != -1) {
							copyMap[nx][ny] += map[i][j] / 5;
							cnt++;
						}
					}
					copyMap[i][j] += map[i][j] - (map[i][j] / 5) * cnt;
					
				}
			}
			map = copyMap;
			
			airClean();
			T--;
			
		}
		
	}

	private static void airClean() {
	
		int topRow = air.get(0)[0];
		int botRow = air.get(1)[0];
		int dir = 0;

			Stack<Integer> st = new Stack<Integer>();
			int tx = topRow;
			int ty = 1;
			st.push(map[tx][ty]);
			
			int ntx = tx + dx[dir];
			int nty = ty + dy[dir];
			
			while(map[ntx][nty] != -1) {
				//스택에 담기
				st.push(map[ntx][nty]);
				ntx += dx[dir];
				nty += dy[dir];
			
				if(ntx==0 && nty == C-1 || ntx == 0 && nty == 0 || ntx == topRow && nty == C-1) {
					dir--;
					if(dir < 0 ) dir += 4;
				}
			}
			
			st.pop();
			dir = 3;
			int x = ntx - dx[dir];
			int y = nty - dy[dir];
			while(!st.isEmpty()) {
				int s = st.pop();
				map[x][y] = s;
				x += dx[dir];
				y += dy[dir];
				
				if(x==0 && y == C-1 || x == 0 && y == 0 || x == topRow && y == C-1) {
					dir++;
					if(dir > 3) dir -= 4;
				}
			}

			int bx = botRow;
			int by = 1;
			
			st.push(map[bx][by]);
			dir = 0;
			int nbx = bx + dx[dir];
			int nby = by + dy[dir];
			
			while(map[ntx][nty] != -1) {
				//스택에 담기
				st.push(map[ntx][nty]);
				nbx += dx[dir];
				nby += dy[dir];
			
				if(nbx == R-1  && nby == 0 || nbx == R-1 && nby ==  C-1 || nbx == botRow && nby == C-1) {
					dir++;
					if(dir > 3) dir -= 4;
				}
			}
			
			st.pop();
			dir = 1;
			x = nbx - dx[dir];
			y = nby - dy[dir];
			while(!st.isEmpty()) {
				int s = st.pop();
				map[x][y] = s;
				x += dx[dir];
				y += dy[dir];
				
				if(x == R-1  && y == 0 || x == R-1 && y ==  C-1 || x == botRow && y == C-1) {
					dir--;
					if(dir < 0 ) dir += 4;
				}
			}

	}
}
