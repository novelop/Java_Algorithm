package hyeji_1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식 {
	  static int N;
	  static int[] S,B;
	  static boolean[] isSelected;
	  static List<Integer> list = new ArrayList<Integer>();
	
  public static void main(String[] args) throws NumberFormatException, IOException  {
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  N = Integer.parseInt(br.readLine());
	  S = new int[N];
	  B = new int[N];
	  isSelected = new boolean[N];
	  
	  for(int i=0; i<N; i++) {
		  StringTokenizer st = new StringTokenizer(br.readLine());
		  S[i] = Integer.parseInt(st.nextToken());
		  B[i] = Integer.parseInt(st.nextToken());
	  }
	  combination(0);
	  Collections.sort(list);
	  System.out.println(list.get(0));
  
  }
  
  public static void combination(int cnt) {
	  if(cnt == N) {
		  int multiS = 0;
		  int sumB = 0;
		  boolean flag = false;
		  
		  for(int i=0; i<N; i++) {
			  if(isSelected[i]) {
				  if(flag) {
					  multiS *= S[i];
				  }else {
					  multiS = S[i];
				  }
				  sumB += B[i];
				  flag = true;
			  }
			  
		  }
		  int dff = Math.abs(multiS - sumB);
		  
		  if(flag) list.add(dff);

		  return;
	  }
	  
	  isSelected[cnt] = true;
	  combination(cnt+1);
	  isSelected[cnt] =	false;
	  combination(cnt+1);
	  
  }
  
  
}