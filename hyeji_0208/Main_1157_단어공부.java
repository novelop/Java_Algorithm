package hyeji_0208;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_1157_단어공부 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		str = str.toUpperCase();
		
		Map<Character,Integer> map = new HashMap<>(); 
		
		for(int i=0; i<str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
		}
		
		int max = Integer.MIN_VALUE;
		
		for(Character c : map.keySet()) {
			max = Math.max(max, map.get(c));
		}
		
		int cnt = 0;
		Character ch = ' ';
		for(Character c : map.keySet()) {
			if(max == map.get(c)) {
				cnt++;
				ch = c;
			}
		}
		
		if(cnt == 1) {
			System.out.println(ch);
		}else {
			System.out.println("?");
		}
		
		
	}

}
