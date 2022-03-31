package 혜지_0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main_2577숫자의개수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int sum = A * B * C;
		int[] cnt = new int[10];
		int[] arrNum = Stream.of(String.valueOf(sum).split("")).mapToInt(Integer::parseInt).toArray();
		
		for(int i=0; i<arrNum.length; i++) {
				cnt[arrNum[i]]++;
		}
		for(int c : cnt) {
			System.out.println(c);
		}
	}

}