package hyeji_1009;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_3190_뱀 {

	static int N,K,L;
	static int hx=0, hy=0; //뱀 초기 머리 위치
	static int tx=0, ty=0; //뱀 초기 꼬리 위치
	static int[][] map;
	static int T = 0; 
	static List<Dir> list = new ArrayList<Dir>();
	static int dirH = 0, dirT = 0;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); 
		map = new int[N][N];
		
		map[0][0] = 1; // 뱀 초기 위치 저장
		
		K = sc.nextInt(); //사과 갯수
		
		//사과 위치 저장
		for(int i=0; i<K; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			map[x][y] = 2;
		}

		L = sc.nextInt(); //뱀의 방향 변환 정보
		
		for (int i = 0; i < L; i++) {
			int x = sc.nextInt();
			String c = sc.next();
			list.add(new Dir(x,c));
		}
		
		start();
		
		System.out.println(T);
		
	}

	private static void start() {
		int index=0;
		while(true) {
			Dir d = new Dir();
			if(index < list.size()) {
				d = list.get(index);
			}
			
			int nhx = hx + dx[dirH];
			int nhy = hy + dy[dirH];
			int ntx = tx + dx[dirT];
			int nty = ty + dy[dirT];
			
			T++;
			
			if( (dirH==3 && nhx<0) || (dirH==2 && nhy<0) || (dirH==1 && nhx > N-1) || (dirH==0 && nhy>N-1)) {
				break;
			}

			if( map[nhx][nhy] == 1 || map[nhx][nhy] == 3 || map[nhx][nhy] == 4 ) break;
			
			hx = nhx;
			hy = nhy;
			
			if(map[hx][hy] == 2) {
				map[hx][hy] = 1;
			}else {
				map[hx][hy] = 1; //머리이동
				//꼬리이동
				map[tx][ty] = 0; 
				tx = ntx;
				ty = nty;
			
			}

			if(T == d.x) {
				map[hx][hy] = d.c.equals("L") ? 3 : 4;
				
				index++;
			}
			change();
			
			if(map[tx][ty] == 3 || map[tx][ty] == 4 ) {
				map[tx][ty] = 1;
			}
		}
	}
	
	private static void change() {
		
		if(dirH == 0 && map[hx][hy] == 3) dirH = 3; 
		else if(dirH == 0 && map[hx][hy] == 4) dirH = 1; 
		else if(dirH == 1 && map[hx][hy] == 3) dirH = 0; 
		else if(dirH == 1 && map[hx][hy] == 4) dirH = 2; 
		else if(dirH == 2 && map[hx][hy] == 3) dirH = 1; 
		else if(dirH == 2 && map[hx][hy] == 4) dirH = 3; 
		else if(dirH == 3 && map[hx][hy] == 3) dirH = 2; 
		else if(dirH == 3 && map[hx][hy] == 4) dirH = 0; 
		
		if(dirT == 0 && map[tx][ty] == 3) dirT = 3;
		else if(dirT == 0 && map[tx][ty] == 4) dirT = 1;
		else if(dirT == 1 && map[tx][ty] == 3) dirT = 0;
		else if(dirT == 1 && map[tx][ty] == 4) dirT = 2;
		else if(dirT == 2 && map[tx][ty] == 3) dirT = 1;
		else if(dirT == 2 && map[tx][ty] == 4) dirT = 3;
		else if(dirT == 3 && map[tx][ty] == 3) dirT = 2;
		else if(dirT == 3 && map[tx][ty] == 4) dirT = 0;
		
	}

}
class Dir{
	int x;
	String c;
	public Dir(){
		
	}
	public Dir(int x, String c) {
		super();
		this.x = x;
		this.c = c;
	}
}
