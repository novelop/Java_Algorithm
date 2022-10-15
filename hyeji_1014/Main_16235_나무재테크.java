package hyeji_1014;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main_16235_나무재테크 {
	static int N,M,K;
	static ArrayList<Tree>[][] map;
	static int[][] plusA;
	static int[][] A;
	static List<int[]> deadTree;
	static List<int[]> breedTree;
	
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //배열크기
		M = sc.nextInt(); //심을나무갯수
		K = sc.nextInt(); 
		
		map = new ArrayList[N][N];
		A = new int[N][N];
		plusA = new int[N][N];
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				A[i][j] = 5; // 양분테이블에 기본 양분 저장
				plusA[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<M; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			int age = sc.nextInt();
			map[x][y] = new ArrayList<Tree>();
			map[x][y].add(new Tree(age));
			
		}
		
		for(int i=0; i<K; i++) { //k년 반복
			deadTree = new ArrayList<int[]>();
			breedTree = new ArrayList<int[]>();
			spring();
			if(deadTree.size() > 0) {
				summer();
			}
			if(breedTree.size() > 0) {
				fall();				
			}
			winter();
			
//			for(int k=0; k<N; k++) {
//				for(int j=0; j<N; j++) {
//					System.out.print(A[i][j] + " ");
//				}
//				System.out.println();
//			}
			
		}
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == null || map[i][j].size() == 0) continue;
				sum += map[i][j].size();
			}
		}
		
		System.out.println(sum);
		

	}
	
	private static void winter() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int a = plusA[i][j];
				A[i][j] += a;
			}
		}
		
	}

	private static void fall() {
		for(int[] c : breedTree) {
			int x = c[0];
			int y = c[1];
			
			for(int i=0; i<8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if(map[nx][ny] == null) {
						map[nx][ny] = new ArrayList<Tree>();
					}
					map[nx][ny].add(new Tree(1));
				}
			}
			
		}
		
	}

	private static void summer() {
		for(int i=0; i<deadTree.size(); i++) {
			int[] c = deadTree.get(i);
			A[c[0]][c[1]] += c[2];
		}
		
	}

	private static void spring() {
		List<int[]> kill = new ArrayList<int[]>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == null || map[i][j].size() == 0) continue;
				
				Collections.sort(map[i][j]);
				for(int k=0; k < map[i][j].size(); k++) {
					int age = map[i][j].get(k).age;
					if(A[i][j] >= age) {
						A[i][j] -= age;
						map[i][j].set(k,new Tree(age+1));
						if(map[i][j].get(k).age % 5 == 0) {
							breedTree.add(new int[] {i,j}); 
						}
					}else if(A[i][j] < age){
						//나무죽이기
						int a = age/2;
						deadTree.add(new int[] {i,j,a}); 
						map[i][j].get(k).die = true;
						//여기서 바로 삭제하면 인덱스 밀려서 삭제 안되는 것도있음
					}
				}
				
			//대박... 이거 신기
				map[i][j].removeIf(t -> t.die == true);
				
				
			}
		}
	
		
		
		
	}

	static class Tree implements Comparable<Tree>{
		int age;
		boolean die = false;
		
		public Tree(int age) {
			super();
			this.age = age;
		}
		public Tree() {

		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}

		
		
	}

}
