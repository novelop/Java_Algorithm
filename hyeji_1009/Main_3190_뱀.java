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
	static int indexH=0, indexT=0, delay=0;
	
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
		
		while(true) {
			
			int nhx = hx + dx[dirH];
			int nhy = hy + dy[dirH];
			int ntx = tx + dx[dirT];
			int nty = ty + dy[dirT];
			
			T++;
			
			if( (dirH==3 && nhx<0) || (dirH==2 && nhy<0) || (dirH==1 && nhx > N-1) || (dirH==0 && nhy>N-1)) {
				break;
			}

			if( map[nhx][nhy] == 1 ) break;
			
			hx = nhx;
			hy = nhy;
			
			if(map[hx][hy] == 2) {
				delay++;
			}else {
				//꼬리이동
				map[tx][ty] = 0; 
				tx = ntx;
				ty = nty;
			}
			
			map[hx][hy] = 1;
			

			if(indexH < list.size()) {
				Dir d = list.get(indexH);
				
				if(T == d.x) {
					if(d.c.equals("D")) {
						dirH++;
						if(dirH > 3) dirH -= 4;
					}else if(d.c.equals("L")){
						dirH--;
						if(dirH < 0) dirH += 4;
					}
					
					indexH++;
				}
			}
			
			if(indexT < list.size()) {
				Dir d = list.get(indexT);
				if(d.x + delay == T) {
					if(d.c.equals("D")) {
						dirT++;
						if(dirT > 3) dirT -= 4;
					}else if(d.c.equals("L")){
						dirT--;
						if(dirT < 0) dirT += 4;
					}
					indexT++;
				}

			}
			
		}
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
