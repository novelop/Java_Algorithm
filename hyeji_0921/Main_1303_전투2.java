package hyeji_0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1303_전투2 {
	static int N, M;
	static int cnt;
	static int now_x,now_y;
	static char[][] map;
	static boolean[][] visited;
	
	static Queue<Node> que = new LinkedList<>();
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int wCnt,bCnt;
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
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
					if(map[i][j] == 'W') {
						int num = bfs(i,j,'W');
						wCnt += num * num;
					}else {
						int num = bfs(i,j,'B');
						bCnt += num * num;
					}
				}
					
			}
		}
		
		System.out.println(wCnt + " " + bCnt);
		
	}
	
	private static int bfs(int x, int y, char ch) {
		que.offer(new Node(x, y));
		cnt = 1;
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			rangeCheck(ch);
		}
		
		
		return cnt;
	}
	
	private static void rangeCheck(char ch) {
		Node now = que.poll();
		
		for(int i=0; i<4; i++) {
			
			int now_x = now.x + dx[i];
			int now_y = now.y + dy[i];
			
			if(now_x >= 0 && now_x < M && now_y >= 0 && now_y < N) {
				if(!visited[now_x][now_y] && ch == map[now_x][now_y]) {
					que.offer(new Node(now_x, now_y));
					visited[now_x][now_y] = true;
					cnt++;
				}
			}
		}
	}

}


