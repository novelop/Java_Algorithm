package hyeji_0922;

import java.util.Scanner;

public class Main_2810_컵홀더 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();
		
		boolean flag = false;
		int answer = 1;
		
		for(int i=0; i<N; i++) {
			if(str.charAt(i) == 'S') answer++;
			
			if(str.charAt(i) == 'L') {
				answer++;
				i++;
			}
		}
		
		if(answer > N) answer = N;
		
		System.out.println(answer);
		
	}
}
