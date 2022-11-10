package hyeji_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_21608_상어초등학교 {
	static class Pos {
		int x,y,like,blank;

		public Pos(int x, int y, int like, int blank) {
			super();
			this.x = x;
			this.y = y;
			this.like = like;
			this.blank = blank;
		}
		
	}
	
	static int N;
	static int[][] numMap;
	static List<Integer>[] likeList;
	static List<Integer> seq;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		likeList = new ArrayList[N*N+1];
		seq = new ArrayList<Integer>();
		numMap = new int[N][N];
				
		for(int i=1; i<=N*N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			seq.add(num);
			likeList[num] = new ArrayList<Integer>();
			for(int j=0; j<4; j++) {
				likeList[num].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		
		for(int i=0; i<seq.size(); i++) {
			seatChange(seq.get(i));
		}
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int cnt = 0;
				for(int k=0; k<4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					
					if(nx >= 0 && nx < N && ny >=0 && ny < N) {
						if(numMap[i][j] == 0) continue;
						for(int num : likeList[numMap[i][j]]) {
							if(numMap[nx][ny] == num) {
								cnt++;
							}
						}
						
					}
				}
				
				if(cnt == 1) {
					ans += 1;
				}else if(cnt == 2){
					ans += 10;
				}else if(cnt == 3) {
					ans += 100;
				}else if(cnt == 4) {
					ans += 1000;
				}
				
				
			}
		
		}
		
		System.out.println(ans);
		
	}
	private static void seatChange(int index) {
		PriorityQueue<Pos> pq = new PriorityQueue<Pos>(new Comparator<Pos>() {
			@Override
			public int compare(Pos p1, Pos p2) {
				if(p1.like != p2.like) {
					return p2.like - p1.like;
				}else {
					if(p1.blank != p2.blank) {
						return p2.blank - p1.blank;					
					}else {
						if(p1.x != p2.x) {
							return p1.x - p2.x;
						}else {
							return p1.y - p1.y;
						}		
					}
				}
			}
		});
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(numMap[i][j] != 0) continue;
				int like = 0;
				int blank = 0;
				for(int k=0; k<4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					
					if(nx >= 0 && nx < N && ny >=0 && ny < N) {
						if(numMap[nx][ny] == 0) {
							blank++;
							continue;
						}
						
						for(int num : likeList[index]) {
							if(numMap[nx][ny] == num) {
								like++;
							}
						}
					}
				}
				
				 pq.add(new Pos(i,j,like,blank));
				
			}
		}
		
		
		Pos p = pq.poll();
		numMap[p.x][p.y] = index;

		
		
	}

}
