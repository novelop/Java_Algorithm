package hyeji_1011;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_14503_로봇청소기 {
	static int N,M,ans;
	static int[][] map;
	static boolean[][] visit;
	static Queue<Pos> que;

	static int[] dx = {-1,0,1,0}; //북동남서
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //세로
		M = sc.nextInt(); //가로
		
		map = new int[N][M];
		visit = new boolean[N][M];
		que = new LinkedList<Pos>();
		
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int dir = sc.nextInt();
		que.offer(new Pos(x,y,dir));
		visit[x][y] = true;
		ans++;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		bfs();

	}
	
	private static void bfs() {
		while(!que.isEmpty()) {
			Pos pos = que.poll();
			
			int x = pos.x;
			int y = pos.y;
			int dir = pos.dir;
			boolean flag = false;
			
			for(int i=0; i<4; i++){
				dir--; //왼쪽으로 반향전환
				if(dir < 0) dir += 4;
				
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(nx >= 0 && nx < N && ny >=0 && ny < M && map[nx][ny] != 1 && !visit[nx][ny]) {
					visit[nx][ny] = true;
					ans++;
					que.offer(new Pos(nx,ny,dir));
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				int nx = x - dx[dir];
				int ny = y - dy[dir];
				if(nx >= 0 && nx < N && ny >=0 && ny < M ) {
					if(map[nx][ny] != 1) {
						que.offer(new Pos(nx,ny,dir));
					}else {
						System.out.println(ans);
						break;
					}
				}
			}
			
		}
		
	}

	static class Pos{
		int x,y,dir;

		public Pos(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		
	}

}
