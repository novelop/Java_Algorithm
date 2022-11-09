package hyeji_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {

	static int[][] map;
	static int N;
	static int ans = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0,0,1);
		
		System.out.println(ans);

	}
	private static void dfs(int x, int y, int p, int q) {
		
		if(p == N-1 && q == N-1) {
			ans++;
			return;
		}
		
		
		if(x == p) {
			if( q+1 < N && map[p][q+1] == 0) {
				dfs(x,y+1,p,q+1);
			}
			if(p+1 < N && q+1 < N && map[p][q+1] == 0 && map[p+1][q+1] == 0 && map[p+1][q] == 0) {
				dfs(x,y+1,p+1,q+1);
			}

		}else if(y == q) {
			if(p+1 < N  && map[p+1][q] == 0) {
				dfs(x+1,y,p+1,q);				
			}
			if(p+1 < N && q+1 < N && map[p][q+1] == 0 && map[p+1][q+1] == 0 && map[p+1][q] == 0) {
				dfs(x+1,y,p+1,q+1);
			}
			
		}else {
			if(q+1 < N && map[p][q+1] == 0) {
				dfs(x+1,y+1,p,q+1);
			}
			if(p+1 < N && map[p+1][q] == 0) {
				dfs(x+1,y+1,p+1,q);
			}
			if(p+1 < N && q+1 < N && map[p][q+1] == 0 && map[p+1][q+1] == 0 && map[p+1][q] == 0) {
				dfs(x+1,y+1,p+1,q+1);
			}
			
		}
		
		
	}

}
