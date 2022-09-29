package hyeji_0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13300_방배정 {
	static int K,N;
	static int answer = 0;
	static int[][] gradeArr = new int[6][2];
	
	static void countRoom(int grade, int sex) {
		answer += (gradeArr[grade][sex] / K );
		if(gradeArr[grade][sex] % K != 0) answer++;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //학생 수
		K = Integer.parseInt(st.nextToken()); //최대 인원 수
		
		for(int i=0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			 int sex = Integer.parseInt(st.nextToken()); 
			 int grade = Integer.parseInt(st.nextToken()) - 1; 
			 gradeArr[grade][sex]++;
		}

		for(int i=0; i < 6; i++) {
			countRoom(i,0);
			countRoom(i,1);
		}
		
		System.out.println(answer);
		
	}

}
