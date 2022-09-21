package hyeji_0915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken()); //행(세로길이)
		int M = Integer.parseInt(st.nextToken());//열(가로길이)
		
		String[][] arr = new String[N][M];
		int rx = 0, ry = 0; 
		int bx = 0, by = 0;
		int gx = 0, gy = 0;
		
		
		for(int i=0; i < N; i++) {
			String str = br.readLine();
			String[] stp = str.split("");
			for(int j=0; j <stp.length; j++) {
				arr[i][j] = stp[j];
			}			
		}
		
		for(int i=0; i < arr.length; i++) {
			for(int j=0; j < arr[i].length; j++) {
				if(arr[i][j].equals("R")) {
					rx = i; 
					ry = j; 
				}
				if(arr[i][j].equals("B")) {
					bx = i;
					by = j;
				}
				if(arr[i][j].equals("0")) {
					gx = i;
					gy = j;
				}
			}
		}
		
		Queue<String> q = new LinkedList<String>();
		String[][] visited = new String[10][10];
		
		int dir = 0;
		int nx= 0, ny = 0;
		q.offer(rx+","+ry);
	
		while(!q.isEmpty()){
			String x = q.poll();
			String[] sq = x.split(",");
			
			nx = Integer.parseInt(sq[0]);
			ny = Integer.parseInt(sq[1]);
			
			if(arr[nx][ny].equals("0"))
			
			while(!arr[nx][ny-1].equals("#")) {
		
				if(arr[nx][ny-1].equals("0"))
				ny--;
				
			}
				
				
				
				
		}
		
		
		
		

	}

}
