package hyeji_1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2527_직사각형 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			int col = 0;
			int row = 0;
			
			if(x2 >= x || p2 >= p || x2 >= p || p2 >= x) {
				col =  Math.min(p, p2) - Math.max(x, x2);				
			}
			if(y2 >= y || q2 >= q || y2 >= q || q2 >= y) {
				row =  Math.min(q, q2) - Math.max(y, y2);				
			}

			
			if(col > 1 && row > 1) {
				System.out.println("a");
			}else if(col == 1 || row == 1) {
				System.out.println("b");
			}else if(col == 1 && row == 1) {
				System.out.println("c");
			}else if(col <= 0 || row <= 0){
				System.out.println("d");
			}
			
			
		}


	}
}
