package hyeji_1013;

import java.util.Scanner;

public class Main_20057_마법사상어와토네이도 {
	static int N;
	static int outSand = 0;
	static int[][] map;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		map = new int[N][N];
		
		for(int i=0; i<N;i++) {
			for(int j=0; j<N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		int x = N/2;
		int y = N/2;
		int dir = 2;
		
		for(int i=1; i<= N-1; i++) {
			int e = 2;
			if(i == N-1)  e = 3;
				for(int j=0; j<e; j++) {
					for(int k=0; k<i; k++) {
						
						int Y = map[x+dx[dir]][y+dy[dir]];
						
						int one = (int) (Y * 0.01);
						int two = (int) (Y * 0.02);
						int five = (int)(Y * 0.05);
						int seven = (int)(Y * 0.07);
						int ten = (int)(Y * 0.1);
						
						Y -=(one*2+two*2+five+seven*2+ten*2);
						
						diff(x+(dx[dir]*2),y+(dy[dir]*2),Y); //a에 저장
						
						map[x+dx[dir]][y+dy[dir]] = 0;
						
						diff(x + dx[dir+1 > 3 ? dir+1-4 : dir+1],y + dy[dir+1 > 3 ? dir+1-4 : dir+1],one);
						diff(x + dx[dir-1 < 0 ? dir-1 +4 : dir-1],y + dy[dir-1 < 0 ? dir-1 +4 : dir-1],one);
						
						diff(x + dx[dir] + (dx[dir+1 > 3 ? dir+1-4 : dir+1] * 2),y + dy[dir]+ (dy[dir+1 > 3 ? dir+1-4 : dir+1] * 2),two);
						diff(x + dx[dir] + (dx[dir-1 < 0 ? dir-1+4 : dir-1] * 2),y + dy[dir]+ (dy[dir-1 < 0 ? dir-1+4 : dir-1] * 2),two);
						
						diff(x + dx[dir] + dx[dir+1 > 3 ? dir+1-4 : dir+1],y + dy[dir]+ dy[dir+1 > 3 ? dir+1-4 : dir+1],seven);
						diff(x + dx[dir] + dx[dir-1 < 0 ? dir-1+4 : dir-1],y + dy[dir]+ dy[dir-1 < 0 ? dir-1+4 : dir-1],seven);
						
						diff(x+(dx[dir]*2) + dx[dir+1 > 3 ? dir+1-4 : dir+1],y+(dy[dir]*2) + dy[dir+1 > 3 ? dir+1-4 : dir+1],ten);
						diff(x+(dx[dir]*2) + dx[dir-1 < 0 ? dir-1+4 : dir-1],y+(dy[dir]*2) + dy[dir-1 < 0 ? dir-1+4 : dir-1],ten);
						
						diff(x+(dx[dir]*3),y+(dy[dir]*3),five);
						
						x += dx[dir];
						y += dy[dir];

					}
					
					dir--;
					if(dir < 0) dir += 4;
					
				}
				
				
			
		}
		System.out.println(outSand);
		

	}

	private static void diff(int x, int y,int sum) {
		if(x < 0 || x >= N || y < 0|| y >= N) { //범위 밖 모래 저장
			outSand += sum;
		}else {
			map[x][y] += sum;
		}
		
	}

}
