package hyeji_1014;

import java.util.Scanner;

public class Main_14890_경사로2 {
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
		
		for(int i=0; i<N; i++) {
			if(pathCheck(i,0,true)) ans++;
			if(pathCheck(0,i,false)) ans++;
		}
		System.out.println(ans);

	}

	private static boolean pathCheck(int x, int y, boolean flag) {
		int[] temp = new int[N];
		boolean[] check = new boolean[N];
		
		for(int i=0; i<N; i++) {
			if(flag) temp[i] = map[x][i];
			else temp[i] = map[i][y];
		}
		
		for(int i=0; i<N-1; i++) {
			if(temp[i] == temp[i+1]) {
				continue;
			}
			else if(temp[i] - temp[i+1] == 1) { //내려가기
				for(int j=i+1; j<=i+L; j++) {
					//범위 넘어가거나 칸의 높이가 다르거나 이미 경사로가 있는 경우
					if(j>=N || temp[i+1] != temp[j] || check[j]) return false;
					check[j] = true;
				}
			}
			else if(temp[i] - temp[i+1] == -1) { //올라가기
				for(int j=i; j>i-L; j--) {
					if(j<0 || temp[i] != temp[j] || check[j]) return false;
					check[j] = true;
				}
			}else { //높이가 2칸 이상 차이 날때 
				return false;
			}
		}
		
		return true;
		
	}

	

}
