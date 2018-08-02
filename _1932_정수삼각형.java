import java.util.*;

public class _1932_Á¤¼ö»ï°¢Çü {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dp[][] = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j <= i ; j++) {
				dp[i][j] = sc.nextInt();
			}
		}
		for(int i = 1 ; i < N ; i++) {
			for(int j = 0 ; j <= i ; j++) {
				if(j == 0) dp[i][j] = dp[i-1][0] + dp[i][j];
				else if(j == i) dp[i][j] = dp[i-1][j-1] + dp[i][j];
				else dp[i][j] = Math.max(dp[i][j] + dp[i-1][j-1], dp[i][j] + dp[i-1][j]);
			}
		}
		
		int max = 0;
		for(int i = 0 ; i < N ; i++) {
			if(dp[N-1][i] > max) max = dp[N-1][i];
		}
		System.out.println(max);
		
	}

}
