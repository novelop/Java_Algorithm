package hyeji_0922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_17413 {
	
	
	static void print(Stack<Character> st) {
		while(!st.isEmpty()) {
			System.out.print(st.pop());
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> st = new Stack<>();
		
		boolean flag = false;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '<') {
				print(st);
				System.out.print(str.charAt(i));
				flag = true;
			}else if(str.charAt(i) == '>') {
				flag = false;
				System.out.print(str.charAt(i));
			}else if(flag) {
				System.out.print(str.charAt(i));
			}else {
				if(str.charAt(i) == ' ') {
					print(st);
					System.out.print(str.charAt(i));
				}else {
					st.push(str.charAt(i));
				}
			}
		}
		
		print(st);

	}

}
