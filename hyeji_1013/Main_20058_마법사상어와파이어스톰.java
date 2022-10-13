package hyeji_1013;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_20058_마법사상어와파이어스톰 {
	
	static int N,Q,L;
	static int sum = 0;
	static int max = 0;
	static int[][] map;
	static int[] magic;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = (int)Math.pow(2,sc.nextInt());
		Q = sc.nextInt();
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		magic = new int[Q];
		
		for(int i=0; i<Q; i++) {
			magic[i] = sc.nextInt();
		}
		
		
		//파이어스톰 시전 
		for(int i=0; i<Q; i++) {
			//부분격자별 90도 회전
			turn(magic[i]);
			//얼음체크 해당 칸이 3개이상 얼음과 인접하지 않으면 얼음양 감소
			fire();
		}
		
		//남아있는 얼음의 합
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==0) continue;
				sum += map[i][j];
			}
		}
		
		//인접한 얼음이 차지한 개수중에 가장 큰수
		bfs();
		
		System.out.println(sum);
		System.out.println(max);
		
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visit = new boolean[N][N];
	
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != 0 && !visit[i][j]) {
					queue.offer(new int[] {i,j});
					visit[i][j] = true;
				
					int cnt = 1;
					while(!queue.isEmpty()) {
						int[] c = queue.poll();
						int x = c[0];
						int y = c[1];
						
						for(int k=0; k<4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							if(nx >= 0 && nx < N && ny >=0 && ny < N && !visit[nx][ny]) {
								if(map[nx][ny] != 0) {						
									cnt++;
									visit[nx][ny] = true;
									queue.offer(new int[] {nx,ny});
								}
							}
							
						}
					}
					
					max = Math.max(max, cnt);
					
					
				}
			}
		}
	
		
	}

	private static void fire() {
		int[][] temp = new int[N][N];
		for(int k=0; k<N; k++) {
			temp[k] = map[k].clone();
 		} 
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					continue;
				}
				
				int cnt = 0;
				for(int k=0; k<4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if(nx >= 0 && nx < N && ny >=0 && ny < N && map[nx][ny] != 0) cnt++;
				}
				
				if(cnt < 3) temp[i][j]--;

			}
		}
		map = temp;
		
	}

	private static void turn(int L) {
		int[][] temp = new int[N][N];
		L = (int)Math.pow(2, L);

		for (int r = 0; r < N; r += L) {
			for (int c = 0; c < N; c += L) { 
				for (int i = 0; i < L; i++) {
					for (int j = 0; j < L; j++) {
						temp[r+i][c+j] = map[r + L - 1 - j][c+i];
					}
				}
			}
		}
		map = temp;
		
//		int R = L;
//		int C = L;
//		for (int r = 0; r < N; r += L) {
//			for (int c = 0; c < N; c += L) {
//				for (int i = r; i < R; i++) {
//					for (int j = c; j < C; j++) {
//						temp[i][j] = map[r + C - 1 - j][c+i-r];
//					}
//				}
//				C += L;
//				if(C > N) {
//					C = L;
//					break;
//				}
//			}
//			R += L;
//			if(R > N) {
//				R = L;
//				break;
//			}
//		}
		
		
		
		
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					System.out.print(temp[i][j] + " ");
//				}
//				System.out.println();
//			}

		
	}

}
