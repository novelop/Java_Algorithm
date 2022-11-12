package hyeji_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링 {
	static class Node{
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int N;
	static int[] pCnt;
	static boolean[][] map;
	static boolean[] check;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new boolean[N+1][N+1];
		pCnt = new int[N+1];
		check = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			pCnt[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for(int j=0; j<m; j++) {
				int x = Integer.parseInt(st.nextToken());
				map[i][x] = true;
			}
		}
		
		for(int i=1; i<=N-1; i++) {
			check = new boolean[N+1];
			dfs(0,1,i);
		}
		
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
		
		
	}
	private static void dfs(int depth, int start, int m) {
		if(depth == m) {
			List<Integer> first = new ArrayList<>();
			List<Integer> second = new ArrayList<>();
			
			for(int i=1; i<=N; i++) {
				if(check[i]) first.add(i);
				else second.add(i);
			}
			
			if(bfs(first) && bfs(second)) {
				int sum1 = 0;
				int sum2 = 0;
				for(int n : first) {
					sum1 += pCnt[n];
				}
				for(int n : second) {
					sum2 += pCnt[n];
				}
				ans = Math.min(ans, Math.abs(sum1-sum2));
			}
			
			return;
		}
		
		for(int i=start; i<=N; i++) {
			check[i] = true;
			dfs(depth+1,i+1,m);
			check[i] = false;
			
		}
		
	}
	private static boolean bfs(List<Integer> list) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(list.get(0));
		int cnt = 0;
		while(!que.isEmpty()) {
			int current = que.poll();
			
			for(int i=1; i<=N; i++) {
				if(map[current][i] && list.contains(i)) {
					que.offer(i);
					cnt++;
				}
			}

		}
		
		if(list.size() == cnt) return true;
		
		return false;
	}

}
