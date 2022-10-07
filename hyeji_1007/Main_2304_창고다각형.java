package hyeji_1007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_2304_창고다각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Tower> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list.add(new Tower(x,y));
		}
		
		Collections.sort(list);
		
		int maxX = 0;
		
		//왼쪽에서 오른쪽
		Tower current = list.get(0);
		int ans = 0;
		
		for(int i=1; i<N; i++) {
			if(current.y <= list.get(i).y) {
				int x = list.get(i).x - current.x;
				int y = current.y;
				current = list.get(i);
				ans += (y * x);
				maxX = i;
			}
		}
		
		//오른쪽에서 왼쪽
		current = list.get(N-1);
		for(int i=N-2; i >= maxX; i--) {
			if(current.y <= list.get(i).y) {
				int x = current.x - list.get(i).x;
				int y = current.y;
				current = list.get(i);
				ans += (y * x);
			}
		}
		ans += current.y;

		System.out.println(ans);

	}

}
class Tower implements Comparable<Tower>{
	int x,y;
	
	public Tower(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Tower tower) {
		return this.x - tower.x;
	}
	
}
