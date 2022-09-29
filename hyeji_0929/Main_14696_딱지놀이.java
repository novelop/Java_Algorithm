package hyeji_0929;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14696_딱지놀이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int[] makeCard() throws Exception{
		int[] arr = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		for(int j=0; j < a; j++) {
			int input = Integer.parseInt(st.nextToken());
			arr[input-1]++;
		}
		return arr;
	}
	

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		String answer[] = new String[N];
		
		for(int i=0; i < N; i++){
			int[] arrA = makeCard();
			int[] arrB = makeCard();
			
			for(int k=3; k>=0; k--) {
				if(arrA[k] > arrB[k]) {
					answer[i] = "A";
					break;
				}else if(arrA[k] < arrB[k]) {
					answer[i] = "B";
					break;
				}else {
					answer[i] = "D";
				}
			}
			
		}
		
		for(int i=0; i<N; i++) {
			System.out.println(answer[i]);
		}
		

	}
}
