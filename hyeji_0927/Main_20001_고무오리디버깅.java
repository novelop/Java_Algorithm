package hyeji_0927;

import java.util.Scanner;

public class Main_20001_고무오리디버깅 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cnt = 0;
		
		if(sc.nextLine().equals("고무오리 디버깅 시작")) {
			while(true) {
				String input = sc.nextLine();
				if(input.equals("고무오리 디버깅 끝")) break; 
				
				if(input.equals("문제")) {
					cnt++;
				}
				if(input.equals("고무오리")) {
					if(cnt == 0) cnt +=2;
					else cnt--;
			
				}
				
			}
		}
		if(cnt == 0) {
			System.out.println("고무오리야 사랑해");
		}else {
			System.out.println("힝구");
		}
		
		

	}

}
