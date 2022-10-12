package hyeji_1011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_15686_치킨배달2 {
	static int n,m;
	static int[][] map;
	static ArrayList<int[]> house = new ArrayList<int[]>();
	static ArrayList<int[]> chicken = new ArrayList<int[]>();
	static ArrayList<int[]> choice = new ArrayList<int[]>();
	static int result = Integer.MAX_VALUE;
	static boolean[] visit;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
				
				if(map[i][j] == 1) {
					house.add(new int[]{i,j});
				}
				if(map[i][j] == 2) {
					chicken.add(new int[]{i,j});
				}
			}
		}
		
		visit = new boolean[chicken.size()];
		
		back(0,0);
		
		System.out.println(result);
		
		

		
	}


	private static void back(int depth, int start) {
		if(depth == m) {
//			for(int[] c : choice) {
//				System.out.println(c[0] + " " + c[1]);
//			}
			
			int sum = 0;
			for(int[] h : house) {
				int min = Integer.MAX_VALUE;
				for(int[] c : choice) {
					int d = Math.abs(h[0]-c[0]) + Math.abs(h[1]-c[1]);
					min = Math.min(d, min);
				}
				sum += min;
			}
			result = Math.min(result, sum);
			return;
		}
		
		for(int i=start; i < chicken.size(); i++) {
			choice.add(chicken.get(i));
			back(depth + 1, i + 1);
			System.out.println(i + " " + depth);
			//시간초과는 start를 매개변수로 사용해서 가지치기 수
			//백트래킹에서 시간초과는 가지치기를 수행해 해결한다.
			choice.remove(choice.size() - 1); 
		}
		
	}

	
}
