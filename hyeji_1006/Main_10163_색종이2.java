package hyeji_1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10163_색종이2 {
	static int[][] map = new int[1001][1001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());//열
			int y = Integer.parseInt(st.nextToken());//행
			int w = Integer.parseInt(st.nextToken());//가로
			int h = Integer.parseInt(st.nextToken());//세로
			
			for(int j=y; j<y+h; j++) {
				for(int k=1000-x; k>1000-x-w ; k--) {
					map[j][k] = i+1;
				}
			}
		}
		int sum[] = new int[N];
		for(int i=0; i<1001; i++) {
			for(int j=0; j<1001; j++) {
				for(int k=0; k < N; k++) {
					if(map[i][j] == k+1) sum[k]++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			System.out.println(sum[i]);
		}
		
		
	}

}
