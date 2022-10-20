package hyeji_1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {
	static int N,K;
	static int[] visit;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visit = new int[100001];
		
		bfs();
		System.out.println(ans);
	}
	private static void bfs() {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(N);
		while(!que.isEmpty()) {
			int X = que.poll();
			if(X == K) {
				ans = visit[K];
				break;
			}
			System.out.println(X +" "+ visit[X]);
			if(X+1 <= 100000 && visit[X+1] == 0) {
				que.offer(X+1);
				visit[X+1] = visit[X] + 1;
			}
			
			if(X-1 >= 0 && visit[X-1] == 0) {
				que.offer(X-1);
				visit[X-1] = visit[X] + 1;
			}
			
			if(2*X <= 100000 && visit[X*2] == 0) {
				que.offer(X*2);
				visit[X*2] = visit[X] + 1;
			}
		}
		
	}


}
