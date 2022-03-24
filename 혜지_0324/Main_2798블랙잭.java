package 혜지0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2798블랙잭 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		ArrayList<Integer> arr = new ArrayList<Integer>();

		for(int i=0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		int max = 0;
		for(int i=0; i<arr.size(); i++) {
			for(int j=i+1; j<arr.size(); j++) {
				for(int z=j+1; z<arr.size(); z++) {
					int sum = arr.get(i)+arr.get(j)+arr.get(z);
					if( sum <= M  && sum > max ){
						max = sum;
					}
				}
			}
		}
		
		System.out.println(max);
		
		
	}

}
