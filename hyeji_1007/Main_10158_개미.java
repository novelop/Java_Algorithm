package hyeji_1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10158_개미 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int w = Integer.parseInt(st.nextToken()); 
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int p = Integer.parseInt(st.nextToken()); //열
		int q = Integer.parseInt(st.nextToken()); //행
		int t = Integer.parseInt(br.readLine());
		
		int x = w - Math.abs(w - (p+t) % (w*2));
		int y = h - Math.abs(h - (q+t) % (h*2));
		
		System.out.println(x + " " + y);
		
		
//		int dir = 0; //0123 상하
//		int current = 0;
//		while(true) {
//			//System.out.println("current가 "+current + "일때 : " + x + " " + y);
//			if(current == t) {
//				System.out.println(x + " " + y);
//				break;
//			}
//			if(dir == 0 && (y+1 > h && x+1 <= w )) dir = 1;
//			else if(dir == 0 && (y+1 <= h && x+1 > w )) dir = 3;
//			else if(dir == 0 && (y+1 > h && x+1 > w )) dir = 2;
//			else if(dir == 1 && (y-1 < 0 && x+1 <= w)) dir = 1;
//			else if(dir == 1 && (y-1 >= 0 && x+1 > w)) dir = 2;
//			else if(dir == 1 && (y-1 < 0 && x+1 > w)) dir = 3;
//			else if(dir == 2 && (y-1 < 0 && x-1 >= 0)) dir = 3;
//			else if(dir == 2 && (y+1 >= 0 && x-1 < 0)) dir = 1;
//			else if(dir == 2 && (y+1 < 0 && x-1 < 0)) dir = 0;
//			else if(dir == 3 && (y+1 <= h && x-1 < 0)) dir = 0;
//			else if(dir == 3 && (y+1 > h && x-1 >= 0)) dir = 2;
//			else if(dir == 3 && (y+1 > h && x-1 < 0)) dir = 1;
//			
//			if(dir == 0) {//상우
//				x++;
//				y++;
//			}else if(dir == 1) { //하우
//				x++;
//				y--;
//			}else if(dir == 2) {//하좌
//				x--;
//				y--;
//			}else if(dir == 3) {//좌상
//				x--;
//				y++;
//			}
//
//			current++;
//		}
		
		
	}

}
