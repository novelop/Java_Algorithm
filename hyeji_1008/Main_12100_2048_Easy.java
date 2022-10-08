package hyeji_1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_12100_2048_Easy {
	static int N,Max=0;
	static int[][] board;
	static int[][] temp;
	static int count;
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	
		
//		temp = new int[N][N];
//		for(int i=0; i<N; i++) {
//			temp[i] = board[i].clone();
// 		}
//		
//		Stack<Integer> st = new Stack<>();
//		for(int i=0; i < N; i++) {
//			for(int j=N-1; j>=0; j--) {
//				st.push(temp[i][j]);
//				temp[i][j] = 0;
//			}
//			sum(st,i,0,1);
//		}
//		
//		for(int i=0; i < N; i++) {
//			for(int j=N-1; j>=0; j--) {
//				if(temp[i][j] == 0) continue;
//				st.push(temp[i][j]);
//				temp[i][j] = 0;
//			}
//			sum(st,i,0,1);
//		}
//		for(int i=0; i < N; i++) {
//			for(int j=0; j<N; j++) {	
//				if(temp[i][j] == 0) continue;
//				st.push(temp[i][j]);
//				temp[i][j] = 0;
//			}
//			sum(st,i,N-1,0);
//		}
		dfs(0);
		System.out.println(Max);
	
		
		for(int i=0; i<N; i++) {

			System.out.println(Arrays.toString(temp[i]));

		}
		

	}
	
	private static void dfs(int cnt) {
		if(cnt == 5) {
			count++;
			return;
		}
		
		
		for(int i=0; i<4; i++) {
			confirm(i);
			dfs(cnt+1);
		}
		
	}
	
	public static void confirm(int index) {
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<N; i++) {
			temp[i] = board[i].clone();
 		}
		
		if(index == 0) { //right
			for(int i=0; i < N; i++) {
				for(int j=0; j<N; j++) {
					if(temp[i][j] == 0) continue;
					st.push(temp[i][j]);
					temp[i][j] = 0;
				}
				sum(st,i,N-1,0);
			}
		}else if(index == 1) { //left
			for(int i=0; i < N; i++) {
				for(int j=N-1; j>=0; j--) {
					if(temp[i][j] == 0) continue;
					st.push(temp[i][j]);
					temp[i][j] = 0;
				}
				sum(st,i,0,1);
			}
		}else if(index == 2) { //top
			for(int i=0; i < N; i++) {//열
				for(int j=N-1; j>=0; j--) {
					if(temp[j][i] == 0) continue;
					st.push(temp[j][i]);
					temp[j][i] = 0;
				}
				sum(st,0,i,2);
			}
		}else { //bottom
			for(int i=0; i < N; i++) {
				for(int j=0; j<N; j++) {
					if(temp[j][i] == 0) continue;
					st.push(temp[j][i]);
					temp[j][i] = 0;
				}
				sum(st,N-1,i,3);
			}
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				Max = Math.max(Max, temp[i][j]);
			}
		}
		

	}
	
	public static void sum(Stack<Integer> st, int x, int y, int idx) {
		while(!st.isEmpty()) {
			temp[x][y] = st.pop();

			if(!st.isEmpty()) {
				int tmp = st.pop();
				
				if(temp[x][y] == 0 || temp[x][y] == tmp ) {
					temp[x][y] += tmp;
				}else {
					x += dx[idx];
					y += dy[idx];
					temp[x][y] = tmp;
				}

			}
			x += dx[idx];
			y += dy[idx];
		}

	}
	
	

}
