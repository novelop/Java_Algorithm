package 혜지_0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4344평균은넘겠지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int c = Integer.parseInt(br.readLine());
		double[] smt = new double[c];
		for(int i=0; i<smt.length; i++) {
			int sum  = 0;
			int count = 0;
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			for(int j=0; j<arr.length; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				sum += arr[j];
			}
			double avg = sum / N; 
			for(int z=0; z<arr.length; z++) {
				if(arr[z] > avg) {
				   count++;
				}
			}
			double p = count / (double)N * 100.0; 
			smt[i] = (Math.round(p* 1000 ) / 1000.0);
		}
		
		for(int i=0; i<smt.length; i++) {
			System.out.println(String.format("%.3f", smt[i])+"%");
		}

	}

}
