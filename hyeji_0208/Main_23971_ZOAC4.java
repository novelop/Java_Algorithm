package hyeji_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_23971_ZOAC4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int height = (H-1)/(N+1) + 1;
		int width =	(W-1) / (M+1) + 1;
		
//		for(int h=0; h<H; h+=N+1) {
//			for(int w=0; w<W; w+=M+1) {
//				ans++;
//			}
//		}
		
		System.out.println(height * width);

	}

}
