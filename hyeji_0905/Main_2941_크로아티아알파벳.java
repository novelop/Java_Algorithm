package hyeji_0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main_2941_크로아티아알파벳 {

	public static void main(String[] args) throws IOException {
		String[] arr = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		
		int len = A.length();
		int cnt = 0;

		for(int i=0; i<len ; i++) {
			
			char ch = A.charAt(i);
			
			if(ch == 'c' && i < len - 1 ) {
				if(A.charAt(i+1) == '=' || A.charAt(i+1) == '-' ) {
					i++;
				}
			}
			
			if(ch == 'd' && i < len - 1) {
				if(A.charAt(i+1)=='-') {
					i++;
				}else if(A.charAt(i+1) == 'z' && i < len - 2 ) {
					if(A.charAt(i+2) == '=' ) {
						i += 2;
					}
				}
			}
			
			if(ch == 'l' && i < len - 1) {
				if(A.charAt(i+1) == 'j') {
					i++;
				}
			}
			
			if(ch == 'n' && i < len - 1) {
				if(A.charAt(i+1) == 'j') {
					i++;
				}
			}
			
			if(ch == 's' && i < len - 1) {
				if(A.charAt(i+1) == '=') {
					i++;
				}
			}
			
			if(ch == 'z' && i < len - 1) {
				if(A.charAt(i+1) == '=') {
					i++;
				}
			}
			
			cnt++;
			
		}
	   
		System.out.println(cnt); 

	}

}
