package 혜지_0323;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_2309일곱난쟁이 {

	public static void main(String[] args) {
		int sum = 0;
		int a = 0;
		int b = 0;
		List<Integer> list = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i < 9; i++) {
			list.add(sc.nextInt());
			sum += list.get(i);
		}
		
		for(int i=0; i < list.size(); i++) {
			for(int j= i+1; j< list.size(); j++) {
				if(sum - (list.get(i)+list.get(j)) == 100) {
					a = list.get(i);
					b = list.get(j);
				}
			}
		}
	
		list.remove(Integer.valueOf(a));
		list.remove(Integer.valueOf(b));
		
		list.sort(null);
		
		
		for(int n : list) {
			System.out.println(n);
		}
		
		
		

	}

}
