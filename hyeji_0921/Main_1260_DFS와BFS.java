package hyeji_0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
	static int N; //정점 개수 
	static int V; //시작할 정점의 번호
	static boolean adjMatrix[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 adjMatrix = new boolean[N][N];
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()) - 1; // 시작할 정점의 번호
		
		for(int i=0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			adjMatrix[from][to] = adjMatrix[to][from] = true;
		}
		
		dfs(V,new boolean[N]);
		System.out.println();
		bfs();
		
	}
	
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(V);
		visited[V] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			System.out.print(current + 1 + " ");
			
			for(int i=0; i < N; i++) {
				if(!visited[i] && adjMatrix[current][i]) { //방문하지 않았을 때,i가 인접행렬 인경우 
					queue.offer(i);
					visited[i] = true;
				}
			}
			
		}
		
	}
	
	private static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		System.out.print(current + 1 + " ");
		
		for(int i = 0; i < N; i++){
			if(!visited[i] && adjMatrix[current][i]) {
				dfs(i, visited);
			}
		}
		
		
	}
	

}
