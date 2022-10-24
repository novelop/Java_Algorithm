package 합승택시요금;

public class Solution {

	public static void main(String[] args) {
		int n = 6; 
		int s = 4; 
		int a = 5;
		int b = 6;
		int[][] fares = {{2,6,6},{6,3,7},{4,6,7},{6,5,11},{2,5,12},{5,3,20},{2,4,8},{4,3,9}};
		System.out.println(solution(n,s,a,b,fares));
	}

	public static int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = Integer.MAX_VALUE;
		int cost[][] = new int[n+1][n+1];
		
		for(int i=0; i<fares.length; i++) {
			int[] fare = fares[i];
			cost[fare[0]][fare[1]] = fare[2];
			cost[fare[1]][fare[0]] = fare[2];
		}
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(i==j || cost[i][k] == 0 || cost[k][j] == 0) continue;
					if(cost[i][j]==0) cost[i][j] = cost[i][k] + cost[k][j];
					else cost[i][j] = Math.min(cost[i][j], cost[i][k]+cost[k][j]);
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			if(cost[s][i] + cost[i][a] + cost[i][b] == 0) continue;
			answer = Math.min(cost[s][i] + cost[i][a] + cost[i][b], answer);
		}
		
		
		return answer;
	}
}
