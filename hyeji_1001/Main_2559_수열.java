package hyeji_1001;

public class Main_2559_수열 {

	public static void main(String[] args) {
		int N = 10;
		int K = 5;
		
		int cnt = 0;
		int sum = 0;
		for(int i= N; i > 0; i--) {
			if(sum + i <= K) {
				sum += i;
				cnt++;
			}
		}
		if(sum != K) cnt = -1;

		System.out.println(cnt);
		
	}

}
