package hyeji_0922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {
	static int M,N;
	static int answer;
	static int[][] map;
	static Queue<Tomato> que = new LinkedList<>();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					que.add(new Tomato(i,j,0));

				}
			}
		}
		
		bfs();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					answer = -1;
					break;
				}
			}
		}
		
		System.out.println(answer);
		
	}
	
	static void bfs() {
		while(!que.isEmpty()) {
			Tomato to = que.poll();
			
			int x = to.x;
			int y = to.y;
			answer = to.cnt;
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny< M && map[nx][ny] == 0) {
					map[nx][ny] = 1;
					que.add(new Tomato(nx,ny,answer+1));
				}
			}
		}
	}
	

}

class Tomato{
	int x,y,cnt;
	public Tomato(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
