package hyeji_1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5014_스타트링크 {
	static int F,S,G,U,D;
	static int[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		visit = new int[F+1];
		for(int i=1; i<=F; i++) {
			visit[i] = -1;
		}
		//0을 더하거나 뺄 수 있어서 초기화 해주기 
		
		if(S == G) {
			System.out.println(0);
		}else {
			int ans = bfs();
			if(ans == -1) {
				System.out.println("use the stairs");
			}else {
				System.out.println(ans);
			}
		}
		
	}
	private static int bfs() {
		Queue<Integer> que = new LinkedList<>();
		que.offer(S);
		visit[S] = 0;
		while(!que.isEmpty()) {
			int x = que.poll();
			if(x == G) {
				return visit[G];
			}
			
			if(x+U <= F && visit[x+U] == -1) {
				que.offer(x+U);
				visit[x+U] = visit[x] + 1;
			}
			
			if(x-D >= 1 && visit[x-D] == -1) {
				que.offer(x-D);
				visit[x-D] = visit[x] + 1;
			}
		}
		return -1;
		
	}


}
