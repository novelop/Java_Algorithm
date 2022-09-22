package hyeji_0922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1592_영식이와친구들 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		arr[0] = 1;
		int cnt = 0;
		int answer = 0;
		while(arr[cnt] < M) {
			if(arr[cnt] % 2 == 0) {
				if(cnt - L < 0) {
					cnt = N + (cnt-L);
					arr[cnt]++;
				}else {
					cnt -= L;
					arr[cnt]++;
				}
			}else {
				if(cnt + L >= N) {
					cnt = (cnt+L) - N;
					arr[cnt]++;
				}else {
					cnt += L;
					arr[cnt]++;
				}
			}
			answer++;
		}
		
		System.out.println(answer);
		
	}
}
