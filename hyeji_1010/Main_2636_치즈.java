package hyeji_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	static int H,W,T = 0,cnt = 0;
	static int[][] map;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];

		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		afterHour();
	}
	
	private static void afterHour() {
      int t = 0;
      int cnt = 0;
      int[][] visit = new int[H][W];
      Queue<Location> que = new LinkedList<Location>();
	  while(true) {
		    que.offer(new Location(0,0));
		    visit[0][0] = -1;
			while(!que.isEmpty()) {
				Location current = que.poll();

				int x = current.x;
				int y = current.y;

				for(int i=0; i<4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx >= 0 && nx <= H-1 && ny >= 0 && ny <= W-1 && visit[nx][ny] == 0) {
						if(map[nx][ny] == 1) {
							visit[nx][ny] = t + 1;
						}else {
							if(visit[nx][ny] != -1) visit[nx][ny] = -1;
							que.offer(new Location(nx,ny));
						}
					}
				}

			}
			t++;
			
			cnt = remove(visit,t);
			
			  for (int i = 0; i < H; i++) {
				  Arrays.fill(visit[i], 0); // 다음 시간에 치즈를 녹이기 위해 visited 배열 전부 false를 넣어줌
			  }

			
			
//			for(int i=0; i<H; i++) {
//				for(int j=0; j<W; j++) {
//					System.out.print(visit[i][j]);
//				}
//				System.out.println();
//			}
			
			int count = 0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j] == 0) continue;
					count++;
				}
			}
			
			
			if(count <= 0) {
				System.out.println(t);
				System.out.println(cnt);
				break;
			}
			
	  }

	}

	private static int remove(int[][] visit,int t) {
		int cnt = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(visit[i][j] == t) {
					map[i][j] = 0;
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x= x;
            this.y = y;
        }
    }
	


}
