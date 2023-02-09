package hyeji_0208;

import java.util.Scanner;

public class Main_2292_벌집 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt = 1;
		
		for(int i=2; i <= N; i+=6*(cnt-1)) {
			cnt++;
		}
		
		System.out.println(cnt);	
	}

}
