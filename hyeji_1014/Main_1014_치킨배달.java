package hyeji_1014;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1014_치킨배달 {
	static int N,M;
	static int ans = Integer.MAX_VALUE;
	static int[][] map;
	static List<int[]> chicken;
	static List<int[]> home;
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt(); //폐업시키지 않을 치킨집 갯수
		
		map = new int[N][N];
		home = new ArrayList<int[]>();
		chicken = new ArrayList<int[]>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) home.add(new int[] {i,j});
				if(map[i][j] == 2) chicken.add(new int[] {i,j});				
			}
		}
		
		visit = new boolean[chicken.size()];
		
		dfs(0,0);
		System.out.println(ans);
	}

	private static void dfs(int depth, int start) {
		if(depth == M) {
			//도시의 치킨거리 구하기
			int sum = sum();
			ans = Math.min(ans, sum);
			return;
		}
		for(int i=start; i<chicken.size(); i++) {
			if(visit[i] == false) {
				visit[i] = true;
				dfs(depth+1,i+1);
				visit[i] = false;
			}
		}
	}

	private static int sum() {
		int sum = 0;
		for(int[] h : home) {
			int min = Integer.MAX_VALUE;// 초기화 까먹지 말자!!
			for(int i=0; i<chicken.size(); i++) {
				if(visit[i]) {
					int[] c = chicken.get(i);
					min = Math.min(Math.abs(h[0] - c[0]) + Math.abs(h[1]- c[1]),min);
				}
			}
			sum += min;
		}
		
		return sum;
		
		
	}

}
