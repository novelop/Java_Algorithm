package hyeji_1009;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_16236_아기상어 {
	static int N,T=0;
	static int[][] map;
	static Fish shark;
	static int fishIndex = 0;
	static int fishSize = 0; 
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 9) {
					shark = new Fish(i,j,2,0,0);
					map[i][j] = 0; //상어 위치 0으로 만들어주기!!! 중요 
				}
			}
		}

		updateDis();

	}

	
	
	
	private static void updateDis() {
		while(true) {
			List<Fish> fishList = new ArrayList<Fish>();
			boolean[][] visit = new boolean[N][N];
			Queue<Fish> que = new LinkedList<>();
			
			visit[shark.x][shark.y] = true;
			que.offer(shark);
			
			while(!que.isEmpty()) {
				Fish fish = que.poll();
				
				int sx = fish.x;
				int sy = fish.y;
				int size = fish.size;
				int dis = fish.dis;
	
				
				for(int i=0; i<4; i++){
					int nsx = sx + dx[i];
					int nsy = sy + dy[i];
					int nsize = size;
					int ndis = dis+1;
					
					
					if(nsx < 0 || nsx >= N || nsy < 0 || nsy >= N) continue;
					if(size < map[nsx][nsy]) continue;
					if(visit[nsx][nsy] == true) continue;
					
				
					if(map[nsx][nsy] != 0 && map[nsx][nsy] < nsize) {
						fishList.add(new Fish(nsx,nsy,map[nsx][nsy],ndis,0));
					}
						visit[nsx][nsy] = true;
						que.offer(new Fish(nsx,nsy,nsize,ndis,0));
	
				}
				
			}
	
				
				if(fishList.size() == 0) {
					System.out.println(T);
					break;
				}
					Collections.sort(fishList); // 거리순으로 정렬
					   //물고기중 아기상어보다 작은 물고기 먹기 
					Fish min = fishList.get(0);
					
					map[min.x][min.y] = 0;
					shark.x = min.x;
					shark.y = min.y;
					shark.cnt++;
					if(shark.size == shark.cnt) {
						shark.size++; 
						shark.cnt = 0;
					}
					T += min.dis;
				
			
		}

	}

}
class Fish implements Comparable<Fish>{
	int x,y,size,dis,cnt;

	@Override
	public String toString() {
		return "Fish [x=" + x + ", y=" + y + ", size=" + size + ", dis=" + dis + "]";
	}

	public Fish(int x, int y, int size, int dis,int cnt) {
		super();
		this.x = x;
		this.y = y;
		this.size = size;
		this.dis = dis;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Fish fish) {
		int ret = 0;
		if(this.dis < fish.dis) {
			ret = -1;
		}else if(this.dis > fish.dis) {
			ret = 1;
		}else {
			if(this.x < fish.x) {
				ret = -1;
			}else if(this.x > fish.x) {
				ret = 1;
			}else {
				if(this.y < fish.y) {
					ret = -1;
				}else {
					ret = 1;
				}
			}
		}
		
		return ret;
	}
	
}