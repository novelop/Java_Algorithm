package hyeji_1012;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_20055_컨테이너벨트위의로봇 {
	static int N,K,ans = 1;
	static List<Status> belt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		belt = new ArrayList<Status>();
		
		for(int i=0; i<N*2; i++) {
			belt.add(new Status(sc.nextInt())); //내구도 저장
		}
		
		while(true) {
			//벨트 회전
			belt.get(N-2).b = false; //로봇내리기
			belt.add(0,belt.get(N*2-1));
			belt.remove(N*2);
	
			//로봇 이동
			for(int i = N-2; i >=0; i--) {
				if(belt.get(i).b) {
					if(!belt.get(i+1).b && belt.get(i+1).a >= 1) {
						belt.get(i+1).b = true;
						belt.get(i+1).a--;
						belt.get(i).b = false;
					}
				}
			}
			belt.get(N-1).b = false; //로봇내리기
			
			//로봇 올리기
			if(belt.get(0).a != 0) {
				belt.get(0).b = true;
				belt.get(0).a--; //내구도 감소
			}
			//내구도 0이 K개 이상이라면 종료
			int cnt = 0;
			for(Status st : belt) {
				if(st.a == 0) cnt++;
			}
			
			if(cnt >= K) break;
			
			ans++;
		}
		System.out.println(ans);

	}

	

	static class Status{
		int a;
		boolean b = false;
		public Status(int a) {
			super();
			this.a = a;
		}
	}
}
