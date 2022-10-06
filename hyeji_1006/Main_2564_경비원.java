package hyeji_1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2564_경비원 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer  st = new StringTokenizer(br.readLine());
		
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int total = (W + H) * 2;
		
		int shopCount = Integer.parseInt(br.readLine());
		
		List<Integer> shops = new ArrayList<>();
		
		for(int i=0; i < shopCount + 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int dir = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
            if (dir == 1) {
            	shops.add(K);
            } else if (dir == 2) {
            	shops.add(W + H + (W - K));
            } else if (dir == 3) {
            	shops.add(2 * W + H + (H - K));
            } else if (dir == 4) {
            	shops.add(W + K);
			}
		}
		
		int myPos = shops.get(shops.size()-1);
		int sum = 0;
		for(int value : shops) {
			int temp = Math.abs(myPos - value);
			sum += Math.min(total-temp, temp);
		}
		System.out.println(sum);
		

	}

}
