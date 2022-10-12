package hyeji_1011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_15686_치킨배달 {
	static int N,M,ans;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		map = new int[N][N];
		
		List<Pos> home = new ArrayList<>();
		List<Pos> shop = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) home.add(new Pos(i,j,0,0));
				else if(map[i][j] == 2) shop.add(new Pos(0,0,i,j));
			}
		}
		
		for(int i=0; i<home.size(); i++) {
			int min = Integer.MAX_VALUE;
			for(int j=0; j<shop.size(); j++) {
				int dis = Math.abs(home.get(i).hx - shop.get(j).sx) + Math.abs(home.get(i).hy - shop.get(j).sy);
				if(dis < min) {
					min = dis;
					home.get(i).dis = min;
					int x = shop.get(j).sx;
					int y = shop.get(j).sy;
					home.get(i).sx = x;
					home.get(i).sy = y;
				}
			}
		}
		
		for(int i=0; i<home.size(); i++) {
			int x = home.get(i).sx;
			int y = home.get(i).sy;
			for(int j=0; j<shop.size(); j++) {
				if(shop.get(j).sx == x && shop.get(j).sy == y) {
					shop.get(j).cnt++;
				}
			}
		}
		
		Collections.sort(shop);
		
		for(int i=0; i<M; i++) {
			int x = shop.get(i).sx;
			int y = shop.get(i).sy;
			
			if(shop.get(i).cnt == 0) break;
			
			for(int j=0; j<home.size(); j++) {
				if(home.get(j).sx == x && home.get(j).sy == y) {
					ans += home.get(j).dis;
				}
			}
		}
		
		for(Pos po : shop) {
			System.out.println(po.sx + " " + po.sy + " " + po.cnt);
		}
		
		
		
		System.out.println(ans);
		
	}

	static class Pos implements Comparable<Pos>{
		int hx,hy,dis;
		int sx,sy,cnt;


		public Pos(int hx, int hy,int sx, int sy) {
			super();
			this.hx = hx;
			this.hy = hy;
			this.sx = sx;
			this.sy = sy;
		}


		@Override
		public int compareTo(Pos o) {
			// TODO Auto-generated method stub
			return o.dis - this.dis;
		}
		
	}
}
