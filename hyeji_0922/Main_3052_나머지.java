package hyeji_0922;

import java.util.Scanner;

public class Main_3052_나머지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		boolean[] ch = new boolean[42];
		for(int i=0; i<10; i++) {
			arr[i] = sc.nextInt() % 42;
			ch[arr[i]]  = true;
		}
		int answer = 0;
		for(int i=0; i<42; i++) {
			if(ch[i] == true) answer++;
		}
		System.out.println(answer);

	}

}
