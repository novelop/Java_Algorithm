package hyeji_0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1303_전투 {
	static int N, M;
	static int cnt;
	static int now_x,now_y;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int wCnt,bCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 열
		M = Integer.parseInt(st.nextToken()); // 행
		map = new char[M][N];
	    visited = new boolean[M][N];
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					char color = map[i][j];
					cnt = 0;
					dfs(i,j,color);
					
					if(color == 'W') {
						wCnt += (int) Math.pow(cnt,2);
					}else {
						bCnt += (int) Math.pow(cnt,2);
					}
				}
					
			}
		}
		
		System.out.println(wCnt + " " + bCnt);
		
	}
	
	private static void dfs(int x, int y, char color) {
		visited[x][y] = true;
		cnt++;
		
		for(int i=0; i<4; i++) {
			now_x = x + dx[i];
			now_y = y + dy[i];
			
			if(rangeCheck() && map[now_x][now_y] == color && !visited[now_x][now_y]) {
				dfs(now_x, now_y, map[now_x][now_y]);
			}
			
		}
	
	}
	
	private static boolean rangeCheck() {
		return (0 <= now_x && now_x < M && 0 <= now_y && now_y < N);
	}

}


