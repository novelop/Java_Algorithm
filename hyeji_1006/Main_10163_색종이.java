package hyeji_1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10163_색종이 {
	private static final int WIDTH = 1000, HEIGHT = 1000;
	private static int[][] map = new int[WIDTH + 1][HEIGHT + 1];
	private static int[] ans = new int[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for(int i=1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());//열
			int y = Integer.parseInt(st.nextToken());//행
			int w = Integer.parseInt(st.nextToken());//가로
			int h = Integer.parseInt(st.nextToken());//세로
			
			func(x,y,w,h,i);
		}

		for(int i=0; i<WIDTH + 1; i++) {
			for(int j=0; j<HEIGHT + 1; j++) {
				if(map[i][j] == 0) continue;
				ans[map[i][j]]++;
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.println(ans[i]);
		}
		
		
	}
	
	private static void func(int x, int y, int w, int h, int n) {
		for(int i=x; i<x+w; i++) {
			for(int j=y; j<y+h; j++) {
				map[i][j] = n;
			}
		}
	}
	

}
