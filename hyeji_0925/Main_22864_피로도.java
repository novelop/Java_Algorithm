package hyeji_0925;

import java.util.Scanner;

public class Main_22864_피로도 {

	public static void main(String[] args) {
		// 한시간 일하면 피로도 + A   일의 양 + B
		// 한시간 쉬면 피로도 - C , 피로도가 음수면 0 
		// 피로도 M을 넘지 않게 일함 
		// 하루에 최대 얼마나 일을 할 수 있는지 , 하루는 24시간 
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt(); // 피로도 증가량
		int B = sc.nextInt(); // 일양
		int C = sc.nextInt(); // 피로도 감소량
		int M = sc.nextInt(); // 최대 피로도
		
		int time = 0;
		int status = 0;
		int work = 0;
		
		while(time < 24) {
			time++;
			if(status + A <= M) {
				status += A;
				work += B;
			}else {
				status = Math.max(status - C, 0);
			}
		}
		
		System.out.println(work);
		
		
		
	}

}
