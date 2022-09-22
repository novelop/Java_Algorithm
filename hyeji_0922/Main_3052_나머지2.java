package hyeji_0922;

import java.util.HashSet;
import java.util.Scanner;

public class Main_3052_나머지2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> remainderSet = new HashSet<>();
		
		for(int i=0; i<10; i++) {
			int input = sc.nextInt();
			remainderSet.add(input%42);
		}
		System.out.println(remainderSet.size());

	}

}
