package hyeji_0208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5073_삼각형과세변 {

	public static void main(String[] args) throws Exception{
		//List<int[]> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[3];
			
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			arr[2] = Integer.parseInt(st.nextToken());
			
			if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;
			
			//Arrays.sort(arr);
			
//			if(arr[2] >= arr[0] + arr[1]) {
//				System.out.println("Invalid");
//				continue;
//			}

			else if(arr[0] == arr[1] && arr[1] == arr[2]) System.out.println("Equilateral");
			else if((arr[0] == arr[1] && arr[1] != arr[2])|| (arr[0] == arr[2] && arr[2] != arr[1]) || (arr[1] == arr[2] && arr[2] != arr[0]) ) System.out.println("Isosceles");
			else if( arr[0] != arr[1] && arr[1] != arr[2]) System.out.println("Scalene");
			
			
			//list.add(arr);

		}
		
		
//		for(int[] arr : list) {
//			if(arr[2] >= arr[0] + arr[1]) {
//				System.out.println("Invalid");
//				continue;
//			}
//
//			if(arr[0] == arr[1] && arr[1] == arr[2]) System.out.println("Equilateral");
//			else if((arr[0] == arr[1] && arr[1] != arr[2])|| (arr[0] == arr[2] && arr[2] != arr[1]) || (arr[1] == arr[2] && arr[2] != arr[0]) ) System.out.println("Isosceles");
//			else if( arr[0] != arr[1] && arr[1] != arr[2]) System.out.println("Scalene");
//			
//		}

	}

}
