package hyeji_1014;

import java.util.Scanner;

public class Main_14890_경사로 {
	static int N,L;
	static int ans;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		//가로길 구하기 
		for(int i=0; i<N; i++) {
			
				width(i);
				hight(i);

		}
		
		//세로길 구하기 
		for(int i=0; i<N; i++) {
			int cnt = 1;
			for(int j=1; j<N; j++) {
				
				if(map[j-1][i] == map[j][i]) { //다음위치랑 같은 경우
					cnt++;
					if(j == N-1) ans++;
					continue;
				}
				if(map[j-1][i] < map[j][i]) { //다음위치가 큰 경우
					if(cnt >= L) {
						cnt = 0;
						if(j == N-1) ans++;
						continue;
					}else {
						break;
					}
					
				}else if(map[j-1][i] > map[j][i]) { //다음위치가 작은 경우
					if(j+L-1 >= N) break;	
					if(check2(i,j) >= L) {
						if(j == N-1 && j+L >= N) ans++;
						j = j+L;
						continue;
					}else {
						break;
					}
				}
				
			}
		}
		System.out.println(ans);

	}

	private static void hight(int i) {
		int cnt = 0;
		boolean[] check = new boolean[N];
		for(int j=0; j<N; j++) {
			if(map[i][j-1] == map[i][j]) { //다음위치랑 같은 경우
				cnt++;
				if(j == N-1) ans++;
				continue;
			}
			if( map[i][j] - map[i][j-1] == 1 ) { //다음위치가 큰 경우
				if(cnt >= L) {
					cnt = 0;
					if(j == N-1) ans++;
					continue;
				}else {
					break;
				}
					
			}else if( map[i][j] - map[i][j-1] == -1) { //다음위치가 작은 경우
				if(j+L-1 >= N) break;	
				if(check(i,j) >= L) {
					j = j+L-1;
					if(j == N-1) ans++;
					continue;
				}else {
					break;
				}
			}
		}
	}

	private static void width(int x) {
		// TODO Auto-generated method stub
		
	}

	private static int check(int i, int j) {
		int cnt = 1;
		for(int c = 1;  c < L; c++) {
			if(map[i][j+c-1] == map[i][j+c]) {
				cnt++;
			}
		}
		
		return cnt;
		
	}
	private static int check2(int i, int j) {
		int cnt = 1;
		for(int c = 1;  c < L; c++) {
			if(map[j+c-1][i] == map[j+c][i]) {
				cnt++;
			}
		}
		
		return cnt;
		
	}

}
