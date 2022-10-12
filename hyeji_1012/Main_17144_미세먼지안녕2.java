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

public class Main_17144_미세먼지안녕2 {
	static int R,C,T;
	static int[][] map;
	static List<Integer> air;
	
	static int[] dx = {0,1,0,-1};//우하좌상 시계방향
	static int[] dy = {1,0,-1,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
	
		map = new int[R][C];
		air = new ArrayList<Integer>();
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1){
					air.add(i);
				}
			}
		}
		for(int i=0; i<T; i++) {
			bfs();			
		}
		
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
			int[][] copyMap = new int[R][C];
			for(int i = 0; i < R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j] == -1) {
						copyMap[i][j] = -1;
						continue;
					}
					
					copyMap[i][j] += map[i][j];
					
					for(int k = 0; k < 4; k++){
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if(nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != -1) {
							copyMap[nx][ny] += (map[i][j] / 5);
							copyMap[i][j] -= (map[i][j] / 5);
						}
					}
				}
			}
			map = copyMap;
			
			airClean();
			
		}

	private static void airClean() {
		int top = air.get(0);
		
		for(int x = top - 1; x > 0; x--) {
			map[x][0] = map[x-1][0];
		}
		
		for(int y = 0; y < C - 1; y++) {
			map[0][y] = map[0][y+1];
		}
		
		for(int x = 0; x < top; x++) {
			map[x][C-1] = map[x+1][C-1];
		}
		
		for(int y = C - 1; y > 1; y--) {
			map[top][y] = map[top][y-1];
		}
		
		map[top][1] = 0; //공기청정기로 나가는 곳이므로 먼지는 0이다.
		
		int bottom = air.get(1);
		
		for(int x = bottom + 1; x < R - 1; x++) {
			map[x][0] = map[x+1][0];
		}
		
		for(int y = 0; y < C - 1; y++) {
			map[R-1][y] = map[R-1][y+1];
		}
		
		for(int x = R - 1; x > bottom ; x--) {
			map[x][C-1] = map[x-1][C-1];
		}
		
		for(int y = C - 1; y > 1; y--) {
			map[bottom][y] = map[bottom][y-1];
		}
		
		map[bottom][1] = 0;
		
		
	}
}
