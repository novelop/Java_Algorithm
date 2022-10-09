package hyeji_1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_12100_2048_Easy {
	static int N,Max=0;
	static int[][] board;
	static int index;
	
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
	
		
		

	}
	
	private static void dfs(int cnt) {
		if(cnt == 5) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					Max = Math.max(Max, board[i][j]);
				}
			}
			return;
		}

		//재귀할때마다 깊은 복사해주기
		int[][] temp = new int[N][N];
		for(int k=0; k<N; k++) {
			temp[k] = board[k].clone();
 		} 

		for(int i=0; i<4; i++) {
			index = i;
			confirm();
			dfs(cnt+1);
			//재귀끝나면 전의 배열 상태로 복원하기
			for(int k=0; k<N; k++) {
				board[k] = temp[k].clone();
	 		}

		}

		
	}

	
	public static void confirm() {
		Stack<Integer> st = new Stack<>();
		
		
		if(index == 0) { //right
			for(int i=0; i < N; i++) {
				for(int j=0; j<N; j++) {
					if(board[i][j] == 0) continue;
					st.push(board[i][j]);
					board[i][j] = 0;
				}
				sum(st,i,N-1,0);
			}
		}else if(index == 1) { //left
			for(int i=0; i < N; i++) {
				for(int j=N-1; j>=0; j--) {
					if(board[i][j] == 0) continue;
					st.push(board[i][j]);
					board[i][j] = 0;
				}
				sum(st,i,0,1);
			}
		}else if(index == 2) { //top
			for(int i=0; i < N; i++) {//열
				for(int j=N-1; j>=0; j--) {
					if(board[j][i] == 0) continue;
					st.push(board[j][i]);
					board[j][i] = 0;
				}
				sum(st,0,i,2);
			}
		}else { //bottom
			for(int i=0; i < N; i++) {
				for(int j=0; j<N; j++) {
					if(board[j][i] == 0) continue;
					st.push(board[j][i]);
					board[j][i] = 0;
				}
				sum(st,N-1,i,3);
			}
		}
		
		

	}
	
	public static void sum(Stack<Integer> st, int x, int y, int idx) {
		while(!st.isEmpty()) {
			board[x][y] = st.pop();

			if(!st.isEmpty()) {
				int tmp = st.pop();
				
				if(board[x][y] == 0 || board[x][y] == tmp ) {
					board[x][y] += tmp;
				}else {
					st.push(tmp);
				}

			}
			x += dx[idx];
			y += dy[idx];
		}

	}
	
	

}
