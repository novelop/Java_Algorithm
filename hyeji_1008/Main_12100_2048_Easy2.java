package hyeji_1008;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_12100_2048_Easy2 {
    /**
     * 백준 12100 2048(Easy) (https://www.acmicpc.net/problem/12100)
     */
    private static int n;
    private static int[][] map;
    private static int[][] temp;
    private static int[] direct;
    private static boolean[][] visit;

    private static int max = 0;

	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        map = new int[n][n];
        direct = new int[5];

        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(5,0);//5번
        System.out.println(max);

    }

    private static void dfs(int end, int index) {

        if (index == end) {

            //확인
            confirm();

        } else {
            for (int i=0; i<4; i++) {
                direct[index] = i;
                dfs(end, index+1);
            }
        }

    }//dfs

    private static void confirm() {

        temp = new int[n][n];

        for (int i=0; i<n; i++) {
            temp[i] = map[i].clone();
        }

        for (int d=0; d<direct.length; d++) {
            Stack<Integer> st = new Stack<>();

            if (direct[d] == 2) {//상
            	for(int i=0; i < n; i++) {//열
    				for(int j=n-1; j>=0; j--) {
    					if(temp[j][i] == 0) continue;
    					st.push(temp[j][i]);
    					temp[j][i] = 0;
    				}
    				sum(st,0,i,2);
    			}
            } else if (direct[d] == 3) {//하
            	for(int i=0; i < n; i++) {
    				for(int j=0; j<n; j++) {
    					if(temp[j][i] == 0) continue;
    					st.push(temp[j][i]);
    					temp[j][i] = 0;
    				}
    				sum(st,n-1,i,3);
    			}
            } else if (direct[d] == 0) {//우
            	for(int i=0; i < n; i++) {
    				for(int j=0; j<n; j++) {
    					if(temp[i][j] == 0) continue;
    					st.push(temp[i][j]);
    					temp[i][j] = 0;
    				}
    				sum(st,i,n-1,0);
    			}
            } else {//좌
            	for(int i=0; i < n; i++) {
    				for(int j=n-1; j>=0; j--) {
    					if(temp[i][j] == 0) continue;
    					st.push(temp[i][j]);
    					temp[i][j] = 0;
    				}
    				sum(st,i,0,1);
    			}
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (temp[i][j] > max) {
                    max = temp[i][j];
                }
            }
        }

    }//confirm

    
    
    public static void sum(Stack<Integer> st, int x, int y, int idx) {
		while(!st.isEmpty()) {
			temp[x][y] = st.pop();

			if(!st.isEmpty()) {
				int tmp = st.pop();
				
				if(temp[x][y] == 0 || temp[x][y] == tmp ) {
					temp[x][y] += tmp;
				}else {
					st.push(tmp);
				}

			}
			x += dx[idx];
			y += dy[idx];
		}

	}
 
}