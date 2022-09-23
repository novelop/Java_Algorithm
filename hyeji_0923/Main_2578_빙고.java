package hyeji_0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2578_빙고 {
	static int[][] board = new int[5][5];
	static int answer = 0;
	static boolean[][] visited = new boolean[5][5];
	static int[][] dx = {{1,-1},{0,0},{1,-1},{1,-1}};
	static int[][] dy = {{1,-1},{1,-1},{0,0},{-1,1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {				
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				answer++;
				int input = Integer.parseInt(st.nextToken());
				for(int ii=0; ii<5; ii++) {
					for(int jj=0; jj<5; jj++) {
						if(board[ii][jj] == input) board[ii][jj] = -1;
						if(bingo() >= 3) {
							System.out.println(answer);
							return;
						}
					}
				}
				
			}
		}
		
		
		
	
	}
	
	static int bingo() {
		int count = 0;
		//가로
		for(int i=0; i<5; i++) {
			int zeroCount = 0;
			for(int j=0; j<5; j++) {
				if(board[i][j] == -1) zeroCount++;
			}
			if(zeroCount == 5) count++;
		}
		//세로
		for(int i=0; i<5; i++) {
			int zeroCount = 0;
			for(int j=0; j<5; j++) {
				if(board[j][i] == -1) zeroCount++;
			}
			if(zeroCount == 5) count++;
		}
		//왼오 대각선
		int zeroCount = 0;
		for(int i=0; i<5; i++) {
			if(board[i][i] == -1) zeroCount++;
			if(zeroCount == 5) count++;
		}
		//오왼대각선
		zeroCount = 0;
		for(int i=0; i<5; i++) {
			if(board[i][4-i] == -1) zeroCount++;
			if(zeroCount == 5) count++;
		}

		return count;
	}
	
	

}

