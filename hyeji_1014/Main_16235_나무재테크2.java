package hyeji_1014;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_16235_나무재테크2 {
	static int N,M,K;
	static int[][] plusA;
	static int[][] A;
	static Queue<Tree> deadTree;
	static Queue<Tree> breedTree;
	static List<Tree> tree;
	
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //배열크기
		M = sc.nextInt(); //심을나무갯수
		K = sc.nextInt(); 
		
		A = new int[N][N];
		plusA = new int[N][N];
		deadTree = new LinkedList<Tree>();
		breedTree = new LinkedList<Tree>();
		tree = new LinkedList<Tree>();
		
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
			tree.add(new Tree(x,y,age));
			
		}
		
		for(int i=0; i<K; i++) { //k년 반복
			
			spring();
			
			summer();
				
			fall();				
			
			winter();	
			
		}
		
	
		
		System.out.println(tree.size());
		

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
		while(!breedTree.isEmpty()) {
			Tree t = breedTree.poll();
			int x = t.x;
			int y = t.y;
			
			for(int i=0; i<8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					tree.add(new Tree(nx,ny,1));
				}
			}
			
		}
		
	}

	private static void summer() {
		while(!deadTree.isEmpty()) {
			Tree t = deadTree.poll();
			A[t.x][t.y] += t.age/2;
		}
		
	}

	private static void spring() {
		int i = 0;
		Collections.sort(tree);
		Iterator<Tree> it = tree.iterator();
		while(it.hasNext()) {
			Tree t = it.next();
			if(A[t.x][t.y] >= t.age) {
				A[t.x][t.y] -= t.age;
				t.age += 1;

				if(t.age % 5 == 0) {
					breedTree.offer(t); 
				}
				
			}else {
				deadTree.offer(t);
				it.remove();
			}
			
		}
		
//		
//		for(Tree t : tree) {
//			if(A[t.x][t.y] >= t.age) {
//				A[t.x][t.y] -= t.age;
//				t.age++;
//				tree.set(i, t);
//
//				if(t.age % 5 == 0) {
//					breedTree.offer(new int[] {t.x,t.y}); 
//				}
//				
//			}else {
//				deadTree.offer(new int[] {t.x,t.y,t.age/2});
//			}
//			i++;
//		}
		
	}

	static class Tree implements Comparable<Tree>{
		int x,y,age;
	
		public Tree(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
		
		
		
	}

}
