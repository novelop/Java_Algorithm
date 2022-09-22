package hyeji_0922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2567_색종이2 {
	static int[][] map = new int[100][100];
	static final int dx[] = {-1,1,0,0};
	static final int dy[] = {0,0,1,-1};
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			for(int j = Y; j < Y + 10; j++) {
				for(int k = X; k < X + 10; k++) {
					map[j][k] = 1;
				}
			}
		}

		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				round_check(i,j);
			}
				
		}
		
		System.out.println(answer);

	}

	private static void round_check(int x, int y) {
		if(map[x][y] == 0) return;
		
		for(int i=0; i<4; i++) {
			if(0<=x+dx[i] && x+dx[i]<100 && 0<=y+dy[i] && y+dy[i]<100 && map[x+dx[i]][y+dy[i]] == 0) {
				answer++;
			}
			
			if(0>x+dx[i] || 0>y+dy[i] || 100<=x+dx[i] || 100<=y+dy[i]) {
				answer++;
			}
			
			
		}
		
		
	}

}
