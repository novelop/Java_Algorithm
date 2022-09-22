package hyeji_0922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2567_색종이_2 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[][] map = new int[100][100];
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		int answer = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j=y; j<y+10; j++) {
				for(int k=x; k<x+10; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j] == 1) {
					for(int k=0; k<4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if(nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && map[nx][ny] == 0) {
							answer++;
						}
						if(nx < 0 || nx >= 100 || ny < 0 || ny >= 100) {
							answer++;
						}
					}
					
				}
			}
		}
		System.out.println(answer);
		
	}
	

}
