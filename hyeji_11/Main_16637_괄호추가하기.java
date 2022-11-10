package hyeji_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16637_괄호추가하기 {

	static int N;
	static char[] math;
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		math = br.readLine().toCharArray();
		dfs(2,math[0] - '0');
		System.out.println(ans);
	}
	private static void dfs(int now , int total) {
		if(now >= N) {
			ans = Math.max(ans, total);
			return;
		}
		
		dfs(now + 2 , calculation(total, math[now] - '0', math[now-1]));
		
		if(now + 2 < N) {
			int sum = calculation(math[now] - '0', math[now+2] - '0', math[now+1]);
			int sumTotal = calculation(total, sum, math[now-1]);
			dfs(now + 4, sumTotal);
		}
		
		
	}
	private static int calculation(int total, int sum, char express) {
		if(express == '+') {
			return total + sum;
		}else if(express == '-') {
			return total - sum;
		}else {
			return total * sum;
		}
	}

}
