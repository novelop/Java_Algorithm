package 합승택시요금;

import java.util.ArrayList;

public class Solution2 {

	static class Node{
        int idx,cost;
        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
    
    public static int[] dist(int start, int n){
        int[] minV = new int[n+1];
        boolean[] visit = new boolean[n+1];
        
        for(int i=1; i<=n; i++){
            minV[i] = Integer.MAX_VALUE;
        }
        
        minV[start] = 0;

        for(int i=0; i<n; i++){
            int min = Integer.MAX_VALUE;
            int minVertix = 0;
            for(int j=1; j<=n; j++){
                if(!visit[j] && min > minV[j]){
                    min = minV[j];
                    minVertix = j;
                }
            }
            
            visit[minVertix] = true;
            
            for(int j=0; j<adjList.get(minVertix).size(); j++){
                Node node = adjList.get(minVertix).get(j);
                if(
                   minV[node.idx] > minV[minVertix] + node.cost){
                    minV[node.idx] = minV[minVertix] + node.cost;
                }
                    
            }
 
        }
    
        return minV;
    }
    

    static ArrayList<ArrayList<Node>> adjList;
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        adjList = new ArrayList<ArrayList<Node>>();
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }

       for(int i=0; i<fares.length; i++){
           int x = fares[i][0];
           int y = fares[i][1];
           int w = fares[i][2];
           adjList.get(x).add(new Node(y,w));
           adjList.get(y).add(new Node(x,w));
        }
        
        int[] start = dist(s,n);
        int[] startA = dist(a,n);
        int[] startB = dist(b,n);
        
        int answer = Integer.MAX_VALUE;
        
        for(int i=1; i<=n; i++){
           answer = Math.min(answer, start[i] + startA[i] + startB[i]);
        }

        return answer;
    }
	
	
	
	public static void main(String[] args) {
		int n = 6; 
		int s = 4; 
		int a = 5;
		int b = 6;
		int[][] fares = {{2,6,6},{6,3,7},{4,6,7},{6,5,11},{2,5,12},{5,3,20},{2,4,8},{4,3,9}};
		System.out.println(solution(n,s,a,b,fares));
	}

	
}
